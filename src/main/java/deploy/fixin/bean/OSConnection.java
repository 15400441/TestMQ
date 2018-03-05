package deploy.fixin.bean;

import java.nio.file.Path;

public class OSConnection {
	private String name;
	private String ip;
	private int port;
	public OSConnection(String name, String ip, int port) {
		super();
		this.name = name;
		this.ip = ip;
		this.port = port;
	}
	
	public OSConnection(){
		super();
	}
	
	public OSConnection(Path path) {
		super();
		this.name = name;
		this.ip = ip;
		this.port = port;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	
	public String genOsConn(){
		StringBuilder builder=new StringBuilder();
		builder.append("\n");
		builder.append(name+".BrokerCompID="+name).append("\n");
		builder.append(name+".BrokerExecID="+name).append("\n");
		builder.append(name+".IP="+ip).append("\n");
		builder.append(name+".Port="+port).append("\n");
		builder.append(name+".HeartBeatInterval=30000").append("\n");
		builder.append(name+".ReconnectInterval=5000").append("\n").append("\n");
		return builder.toString();
	}
	
	
	public String genOsHealthCheck(){
		StringBuilder builder=new StringBuilder();
		builder.append("\n");
		builder.append("HealthCheck.SellSide."+name+".Check=true").append("\n");
		builder.append("HealthCheck.SellSide."+name+".StartTime=0700").append("\n");
		builder.append("HealthCheck.SellSide."+name+".EndTime=1900").append("\n");
		return builder.toString();
	}

	@Override
	public String toString() {
		return "OSConnection [name=" + name + ", ip=" + ip + ", port=" + port + "]";
	}
	
	

}
