package deploy.fixin.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class ConfigBean {
	private String fix2bss_ip;
	private String fix2bss_sid;
	private String fixinID;
	private String sender;
	private String target;
	private String buySides;
	private int hcPort;
	private int jmxRegistryPort;
	private int jxmServerPort;
	private List<OSConnection> list;
	
	//for quickfix.properties
	private int socketAcceptPort;
	private String gofixinDBName;
	private String rootFolderName;
	private String connectionType;
	
	//blp ssl need
	private int socketConnectPort;
	private String socketConnectHost;
	private String socketKeyStorePassword;

	
	
	public ConfigBean(){
		/*
		System.out.println("init configBean from:"+mainInfoPath);
		try(FileInputStream fis=new FileInputStream(mainInfoPath)){
			
			Properties prop=new Properties();
			prop.load(fis);
			
			this.fix2bss_ip=prop.getProperty(ConfigAttributes.FIX2BSS_IP.attr());
			this.fix2bss_sid=prop.getProperty(ConfigAttributes.FIX2BSS_SID.attr());
			this.fixinID=prop.getProperty(ConfigAttributes.FIXINID.attr());
			this.sender=prop.getProperty(ConfigAttributes.SENDER_COMP_ID.attr());
			this.target=prop.getProperty(ConfigAttributes.TARGET_COMP_ID.attr());
			this.buySides=prop.getProperty(ConfigAttributes.BUYSIDES.attr());
			this.hcPort= Integer.valueOf( prop.getProperty( ConfigAttributes.HEALTHCHECKPORT.attr()));
			this.jmxRegistryPort= Integer.valueOf( prop.getProperty( ConfigAttributes.JMXRegistryPort.attr()));
			this.jxmServerPort= Integer.valueOf( prop.getProperty( ConfigAttributes.JMXServerPort.attr()));
			
			
			
		}catch(IOException e){
			
		};
		*/
	}
	
	

	public ConfigBean(String fix2bss_ip, String fix2bss_sid, String fixinID, String sender, String target,
			String buySides, int hcPort, int jmxRegistryPort, int jxmServerPort, List<OSConnection> list,
			int socketAcceptPort, String gofixinDBName, String rootFolderName, String connectionType,
			int socketConnectPort, String socketConnectHost, String socketKeyStorePassword) {
		super();
		this.fix2bss_ip = fix2bss_ip;
		this.fix2bss_sid = fix2bss_sid;
		this.fixinID = fixinID;
		this.sender = sender;
		this.target = target;
		this.buySides = buySides;
		this.hcPort = hcPort;
		this.jmxRegistryPort = jmxRegistryPort;
		this.jxmServerPort = jxmServerPort;
		this.list = list;
		this.socketAcceptPort = socketAcceptPort;
		this.gofixinDBName = gofixinDBName;
		this.rootFolderName = rootFolderName;
		this.connectionType = connectionType;
		this.socketConnectPort = socketConnectPort;
		this.socketConnectHost = socketConnectHost;
		this.socketKeyStorePassword = socketKeyStorePassword;
	}



	public String getFix2bss_ip() {
		return fix2bss_ip;
	}



	public void setFix2bss_ip(String fix2bss_ip) {
		this.fix2bss_ip = fix2bss_ip;
	}



	public String getFix2bss_sid() {
		return fix2bss_sid;
	}



	public void setFix2bss_sid(String fix2bss_sid) {
		this.fix2bss_sid = fix2bss_sid;
	}



	public String getFixinID() {
		return fixinID;
	}



	public void setFixinID(String fixinID) {
		this.fixinID = fixinID;
	}



	public String getSender() {
		return sender;
	}



	public void setSender(String sender) {
		this.sender = sender;
	}



	public String getTarget() {
		return target;
	}



	public void setTarget(String target) {
		this.target = target;
	}



	public String getBuySides() {
		return buySides;
	}



	public void setBuySides(String buySides) {
		this.buySides = buySides;
	}



	public int getHcPort() {
		return hcPort;
	}



	public void setHcPort(int hcPort) {
		this.hcPort = hcPort;
	}



	public int getJmxRegistryPort() {
		return jmxRegistryPort;
	}



	public void setJmxRegistryPort(int jmxRegistryPort) {
		this.jmxRegistryPort = jmxRegistryPort;
	}



	public int getJxmServerPort() {
		return jxmServerPort;
	}



	public void setJxmServerPort(int jxmServerPort) {
		this.jxmServerPort = jxmServerPort;
	}



	public List<OSConnection> getList() {
		return list;
	}



	public void setList(List<OSConnection> list) {
		this.list = list;
	}



	public int getSocketAcceptPort() {
		return socketAcceptPort;
	}



	public void setSocketAcceptPort(int socketAcceptPort) {
		this.socketAcceptPort = socketAcceptPort;
	}



	public String getGofixinDBName() {
		return gofixinDBName;
	}



	public void setGofixinDBName(String gofixinDBName) {
		this.gofixinDBName = gofixinDBName;
	}



	public String getRootFolderName() {
		return rootFolderName;
	}



	public void setRootFolderName(String rootFolderName) {
		this.rootFolderName = rootFolderName;
	}



	public String getConnectionType() {
		return connectionType;
	}



	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}



	public int getSocketConnectPort() {
		return socketConnectPort;
	}



	public void setSocketConnectPort(int socketConnectPort) {
		this.socketConnectPort = socketConnectPort;
	}



	public String getSocketConnectHost() {
		return socketConnectHost;
	}



	public void setSocketConnectHost(String socketConnectHost) {
		this.socketConnectHost = socketConnectHost;
	}



	public String getSocketKeyStorePassword() {
		return socketKeyStorePassword;
	}



	public void setSocketKeyStorePassword(String socketKeyStorePassword) {
		this.socketKeyStorePassword = socketKeyStorePassword;
	}



	@Override
	public String toString() {
		return "ConfigBean [fix2bss_ip=" + fix2bss_ip + ", fix2bss_sid=" + fix2bss_sid + ", fixinID=" + fixinID
				+ ", sender=" + sender + ", target=" + target + ", buySides=" + buySides + ", hcPort=" + hcPort
				+ ", jmxRegistryPort=" + jmxRegistryPort + ", jxmServerPort=" + jxmServerPort + ", list=" + list
				+ ", socketAcceptPort=" + socketAcceptPort + ", gofixinDBName=" + gofixinDBName + ", rootFolderName="
				+ rootFolderName + ", connectionType=" + connectionType + ", socketConnectPort=" + socketConnectPort
				+ ", socketConnectHost=" + socketConnectHost + ", socketKeyStorePassword=" + socketKeyStorePassword
				+ ", getFix2bss_ip()=" + getFix2bss_ip() + ", getFix2bss_sid()=" + getFix2bss_sid() + ", getFixinID()="
				+ getFixinID() + ", getSender()=" + getSender() + ", getTarget()=" + getTarget() + ", getBuySides()="
				+ getBuySides() + ", getHcPort()=" + getHcPort() + ", getJmxRegistryPort()=" + getJmxRegistryPort()
				+ ", getJxmServerPort()=" + getJxmServerPort() + ", getList()=" + getList() + ", getSocketAcceptPort()="
				+ getSocketAcceptPort() + ", getGofixinDBName()=" + getGofixinDBName() + ", getRootFolderName()="
				+ getRootFolderName() + ", getConnectionType()=" + getConnectionType() + ", getSocketConnectPort()="
				+ getSocketConnectPort() + ", getSocketConnectHost()=" + getSocketConnectHost()
				+ ", getSocketKeyStorePassword()=" + getSocketKeyStorePassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	




	public String genOsNames(){
		StringBuilder builder=new StringBuilder();
		list.stream().forEach(osConn->{
			builder.append(osConn.getName()+" ");
		});
		
		return builder.substring(0, builder.length()-1).toString();
	
	}
	
	public String genSellSidesBlock(){
		
		StringBuilder builder=new StringBuilder();
		list.stream().forEach(osConn->{
			builder.append(osConn.genOsConn());
		});
		return builder.toString();
	}
	
	
	public String genHealthCheckSellsSideBlock(){
		StringBuilder builder=new StringBuilder();
		list.stream().forEach(osConn->{
			builder.append(osConn.genOsHealthCheck());
		});
		return builder.toString();
	}



}
