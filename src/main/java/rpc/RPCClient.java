package rpc;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

public class RPCClient {
	private Connection connection;
	private Channel channel;
	private String requestQueueName = "rpc_queue";
	private String replyQueueName;
	

	public RPCClient() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		connection = factory.newConnection();
		channel = connection.createChannel();

		replyQueueName = channel.queueDeclare().getQueue();
	}

	public String call(String message) throws UnsupportedEncodingException, IOException, InterruptedException {
		final String corrID = UUID.randomUUID().toString();

		AMQP.BasicProperties props = new AMQP.BasicProperties().builder().correlationId(corrID).replyTo(replyQueueName).build();
		final BlockingQueue<String> response = new ArrayBlockingQueue<String>(1);
		channel.basicPublish("", requestQueueName, props, message.getBytes("UTF-8"));

	     

		channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				System.out.println("receive result:"+ new String(body, "UTF-8"));
				if (properties.getCorrelationId().equals(corrID)) {
					response.offer(new String(body, "UTF-8"));
				}
			}
		});

		return response.take();

	}

	public void close() throws IOException {
		connection.close();
	}

	public static void main(String[] argv) {
		RPCClient fibonacciRpc = null;
		String response = null;
		try {
			fibonacciRpc = new RPCClient();

			System.out.println(" [x] Requesting fib(2)");
			response = fibonacciRpc.call("2");
			System.out.println(" [.] Got '" + response + "'");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fibonacciRpc != null) {
				try {
					fibonacciRpc.close();
				} catch (IOException _ignore) {
				}
			}
		}
	}

}
