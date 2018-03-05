package fanout;


import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.ConnectionFactory;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.apache.logging.log4j.*;
public class EmitLog {
	private static final Logger logger = LogManager.getLogger();
	
	private static final String EXCHANGE_NAME="logs";
	public static void main(String[] args) {
		try {
			ConnectionFactory factory=new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection=factory.newConnection();
			Channel channel =connection.createChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
			
			String message=getMessage(args);
			
			//channel.basicPublish(exchange, routingKey, props, body);
			channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
			
			System.out.println(" [x] Sent '" + message + "'!");
			logger.info(" [x] Sent '" + message + "'");
			logger.debug(" [x] Sent '" + message + "'");
			logger.error(" [x] Sent '" + message + "'");

		    channel.close();
		    connection.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	 private static String getMessage(String[] strings){
		    if (strings.length < 1)
		    	    return "info: Hello World!";
		    return joinStrings(strings, " ");
		  }

		  private static String joinStrings(String[] strings, String delimiter) {
		    int length = strings.length;
		    if (length == 0) return "";
		    StringBuilder words = new StringBuilder(strings[0]);
		    for (int i = 1; i < length; i++) {
		        words.append(delimiter).append(strings[i]);
		    }
		    return words.toString();
		  }

}
