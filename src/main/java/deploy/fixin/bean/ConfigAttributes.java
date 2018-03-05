package deploy.fixin.bean;

public enum ConfigAttributes {
	
	//config.properties
	FIX2BSS_IP ("--FIX2BSS_IP--"),
	FIX2BSS_SID ("--FIX2BSS_SID--"),
	OSNAMES ("--OsNames--"),
	OS_CONNECTION_CONTENTS("--OSConnectionContents--"),
	BUYSIDES ("--fix.BuySides--"),
	AGENTNAME ("--HealthCheck.AgentName--"),
	SENDER_COMP_ID ("--SenderCompID--"),
	TARGET_COMP_ID ("--TargetCompID--"),
	FIXINID ("--FixINID--"),
	HEALTHCHECKPORT ("--HealthCheck.Port--"),
	SELLSIDE_HEALTHCHECK_CONTENT("--SellSidesHealthCheckContent--"),
	JMXRegistryPort ("--JMX.RMIRegistryPort--"),
	JMXServerPort ("--JMX.RMIServerPort--"),
	
	//quickfix.properties
	SocketAcceptPort("--SocketAcceptPort--"),
	GofixinDBName("--GofixinDBName--"),
	ConnectionType("--ConnectionType--"),
	
	//blp ssl 
	SocketConnectHost("--SocketConnectHost--"),
	SocketConnectPort("--SocketConnectPort--"),
	SocketKeyStorePassword("--SocketKeyStorePassword--"),
	
	
	
	RootFolderName("--RootFolderName--");
	

	private String attr;
	ConfigAttributes(String attr){
		this.attr=attr;
	}
	
	public String attr(){return attr;};

}
