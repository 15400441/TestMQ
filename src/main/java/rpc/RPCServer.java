package rpc;

import java.io.IOException;
import com.rabbitmq.client.*;

public class RPCServer {
	private static final String RPC_QUEUE_NAME = "rpc_queue";

	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		Connection connection = null;
		try {
			connection = factory.newConnection();
			final Channel channel = connection.createChannel();

			channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);

			channel.basicQos(1);

			System.out.println(" [x] Awaiting RPC requests");

			Consumer consumer = new DefaultConsumer(channel) {
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
						byte[] body) throws IOException {
					AMQP.BasicProperties replyProps = new AMQP.BasicProperties().builder()
							.correlationId(properties.getCorrelationId()).build();
					String response = "";

					try {
						String message = new String(body, "UTF-8");
						int n = Integer.parseInt(message);

						System.out.println(" [.] fib(" + message + ")");
						response += fib(n);
					} catch (RuntimeException e) {
						System.out.println(" [.] " + e.toString());
					} finally {
						
						System.out.println("response:"+properties.getReplyTo()+"=>"+response);
						
						try{
							channel.basicPublish("", properties.getReplyTo(), replyProps, response.getBytes("UTF-8"));
						}catch (Exception e) {
							System.out.println(e);
						}
						
						//if do not handle the exception
                        //when exception occurs, the ack were not send out, so the first call will not be removed from the queue
						channel.basicAck(envelope.getDeliveryTag(), false);
					}
				}

			};

			channel.basicConsume(RPC_QUEUE_NAME, false, consumer);

			while (true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException _ignore) {
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			if (connection != null)
				try {
					connection.close();
				} catch (IOException _ignore) {
				}
		}

	}
	
	
	private static int fib(int n) {
	    if (n ==0) return 0;
	    if (n == 1) return 1;
	    return fib(n-1) + fib(n-2);
	  }

}
