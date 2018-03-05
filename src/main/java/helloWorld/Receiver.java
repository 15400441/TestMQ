package helloWorld;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.*;
import java.io.IOException;

import com.rabbitmq.client.AMQP.Basic.Consume;

public class Receiver {
	private final static String QN="hello";
	
    public static void main(String[] args) {
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		try {
			Connection connection=factory.newConnection();
		    Channel channel=connection.createChannel();
		    channel.queueDeclare(QN, false, false, false, null);
		    
		    
		    
		   
		    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		    System.out.println("start consume...");
		    Consumer consumer=new DefaultConsumer(channel){
		    	 @Override
		         public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
		             throws IOException {
		           String message = new String(body, "UTF-8");
		           System.out.println(" [x] Received '" + message + "'");
		         }
		    	
		    };
		    
		    
		    //channel.basicConsume(queue, autoAck, callback)
		    channel.basicConsume(QN, true, consumer);
		    
		    

		 
		    
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

}
