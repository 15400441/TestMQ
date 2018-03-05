package fanout;
import com.rabbitmq.client.*;

import java.io.IOException;


public class ReceiveLogs {
	private static final String EXCHANGE_NAME="logs";
	
	public static void main(String[] args) {
		
		try {
			 ConnectionFactory factory = new ConnectionFactory();
			    factory.setHost("localhost");
			    Connection connection = factory.newConnection();
			    Channel channel = connection.createChannel();
			    
			    channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
			    
			    //In the Java client, when we supply no parameters to queueDeclare() we create a non-durable, exclusive, 
			    //autodelete queue with a generated name
			    String queueName=channel.queueDeclare().getQueue();
			    
			    channel.queueBind(queueName, EXCHANGE_NAME, "");
			    
			   
			    
			    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

			    Consumer consumer = new DefaultConsumer(channel) {
			      @Override
			      public void handleDelivery(String consumerTag, Envelope envelope,
			                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
			        String message = new String(body, "UTF-8");
			        System.out.println(" [x] Received '" + message + "'");
			      }
			    };
			    channel.basicConsume(queueName, true, consumer);
			  
			    
			    
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		    
		
	}

}
