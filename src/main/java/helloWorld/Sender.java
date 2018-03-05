package helloWorld;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class Sender {
	private final static String QN="hello";
	
    public static void main(String[] args) {
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		try {
			Connection connection=factory.newConnection();
		    Channel channel=connection.createChannel();
		    channel.queueDeclare(QN, false, false, false, null);
		    
		    String message="Hello client";
		    
		    //channel.basicPublish(exchange, routingKey, props, body);
		    channel.basicPublish("", QN, null, message.getBytes("UTF-8"));
		    
		    
		    
		    
		    
		    System.out.println(" [x] Sent '" + message + "'");

		    channel.close();
		    connection.close();
		    
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

}
