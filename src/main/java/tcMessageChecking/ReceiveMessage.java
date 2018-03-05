package tcMessageChecking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;


public class ReceiveMessage {

private Connection connection;
private static ReceiveMessage instance=new ReceiveMessage();


public static void main(String[] args) throws IOException {
	ReceiveMessage.getInstance().subExchange("MFTST.PUB");
	
}


public static ReceiveMessage getInstance(){
	return instance;
}


private ReceiveMessage() {
	
	ConnectionFactory factory = new ConnectionFactory();
	Properties properties=null;
	InputStream inputStream=null;
	
	try{
		inputStream=new FileInputStream("resources"+File.separator+"config.properties");
		
		System.out.println("-----------------------here");
		
		properties=new Properties();
		properties.load(inputStream);
		
		factory.setHost(properties.getProperty("MQ.host"));
		System.out.println(properties.getProperty("MQ.host"));
		factory.setPort(Integer.parseInt(properties.getProperty("MQ.port")));
		factory.setUsername(properties.getProperty("MQ.username"));
		factory.setPassword(properties.getProperty("MQ.password"));
		factory.setVirtualHost(properties.getProperty("MQ.virtualHost"));
		
		connection=factory.newConnection();
		
	}catch (Exception e) {
		
	}finally {
		try {
			inputStream.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
}



void subExchange(String name) throws IOException{
	  Channel channel = connection.createChannel();
	  
	  channel.exchangeDeclare(name, BuiltinExchangeType.DIRECT);
	    
	    //In the Java client, when we supply no parameters to queueDeclare() we create a non-durable, exclusive, 
	    //autodelete queue with a generated name
	    String queueName=channel.queueDeclare().getQueue();
	    
	    channel.queueBind(queueName, name, "");
	    
	    
	    System.out.println(" [*] Waiting for messages");

	    Consumer consumer = new DefaultConsumer(channel) {
	      @Override
	      public void handleDelivery(String consumerTag, Envelope envelope,
	                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
	        String message = new String(body, "UTF-8");
	        System.out.println(" message received: '" + message + "'");
	      }
	    };
	    channel.basicConsume(queueName, true, consumer);
	  
}
	
	


}
