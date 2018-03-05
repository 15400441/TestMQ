package deploy.fixin.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import deploy.fixin.bean.ConfigAttributes;
import deploy.fixin.bean.ConfigBean;

public class ConfigGenerator {

	private ConfigBean configBean;
	private static final String RESULT_PATH = "result";
	private static final String CONFIG_FILE_NAME = "config.properties";
	private static final String QUICKFIX_FILE_NAME = "quickfix.properties";
	private static final String mainInfoPath="sample_config"+File.separator+"main_info.json";
	
	
	public static void main(String args[]){
		ObjectMapper mapper = new ObjectMapper();
		try {
			ConfigBean bean=mapper.readValue(new File(mainInfoPath),ConfigBean.class);
			
			ConfigGenerator generator=new ConfigGenerator(bean);
			//generator.genFixINBLP();
			
			generator.genFixINCommon();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public void genFixINCommon(){
		this.configBean.setConnectionType("acceptor");
		genFiles(false);
	}
	
	
	
	public void genFixINBLP(){
		this.configBean.setConnectionType("initiator");
		genFiles(true);
	}
	
	
	
	
	
	public void genFiles(boolean isBLP){
	
			genConfigProperties();
			
			System.out.println("------------------------------------------------------------------------------");
			
			genQuickfixProperties(isBLP);
			
	
	}
	
	
	
	

	public ConfigGenerator(ConfigBean configBean) {
		
		this.configBean = configBean;
	}
	
	
	
	
	
	
	

	public void genConfigProperties() {
		
		
		
		
		Path path=Paths.get("sample_config" + File.separator + "fixin_config_template.properties");
		Path resultPath=Paths.get(RESULT_PATH + File.separator + CONFIG_FILE_NAME);

		try{
              
			String configStr=new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
			String osNames=this.configBean.genOsNames();
			String osConnInfo=this.configBean.genSellSidesBlock();
			String sellSidesHealthCheckInfo=configBean.genHealthCheckSellsSideBlock();
			
			
		
			configStr=configStr.replaceAll(ConfigAttributes.BUYSIDES.attr(), configBean.getBuySides());
			configStr=configStr.replaceAll(ConfigAttributes.FIX2BSS_IP.attr(), configBean.getFix2bss_ip());
			configStr=configStr.replaceAll(ConfigAttributes.FIX2BSS_SID.attr(), configBean.getFix2bss_sid());
			configStr=configStr.replaceAll(ConfigAttributes.FIXINID.attr(), configBean.getFixinID());
			configStr=configStr.replaceAll(ConfigAttributes.HEALTHCHECKPORT.attr(), configBean.getHcPort()+"");
			configStr=configStr.replaceAll(ConfigAttributes.JMXRegistryPort.attr(), configBean.getJmxRegistryPort()+"");
			configStr=configStr.replaceAll(ConfigAttributes.JMXServerPort.attr(), configBean.getJxmServerPort()+"");
			configStr=configStr.replaceAll(ConfigAttributes.OS_CONNECTION_CONTENTS.attr(), osConnInfo);
			configStr=configStr.replaceAll(ConfigAttributes.OSNAMES.attr(), osNames);
			configStr=configStr.replaceAll(ConfigAttributes.SELLSIDE_HEALTHCHECK_CONTENT.attr(), sellSidesHealthCheckInfo);
			configStr=configStr.replaceAll(ConfigAttributes.SENDER_COMP_ID.attr(), configBean.getSender());
			configStr=configStr.replaceAll(ConfigAttributes.TARGET_COMP_ID.attr(), configBean.getTarget());
			configStr=configStr.replaceAll(ConfigAttributes.ConnectionType.attr(), configBean.getConnectionType());
			
			System.out.println(configStr);
			
			Files.write(resultPath, configStr.getBytes("UTF-8"));
			
			
			
			
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		
		
	}
	
	
	
	public void genQuickfixProperties(boolean isBLP) {
		
		
		Path path=Paths.get("sample_config" + File.separator + "quickfix_template.properties");
		
		if(isBLP){
			path=Paths.get("sample_config" + File.separator + "quickfix_template_blp.properties");
		}
		
		Path resultPath=Paths.get(RESULT_PATH + File.separator + QUICKFIX_FILE_NAME);

		try{
              
			String configStr=new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
			
			
			configStr=configStr.replaceAll(ConfigAttributes.RootFolderName.attr(), configBean.getRootFolderName());
			configStr=configStr.replaceAll(ConfigAttributes.GofixinDBName.attr(), configBean.getGofixinDBName());
			configStr=configStr.replaceAll(ConfigAttributes.SocketAcceptPort.attr(), configBean.getSocketAcceptPort()+"");
			configStr=configStr.replaceAll(ConfigAttributes.SENDER_COMP_ID.attr(), configBean.getSender());
			configStr=configStr.replaceAll(ConfigAttributes.TARGET_COMP_ID.attr(), configBean.getTarget());
			configStr=configStr.replaceAll(ConfigAttributes.FIX2BSS_IP.attr(), configBean.getFix2bss_ip());
			configStr=configStr.replaceAll(ConfigAttributes.ConnectionType.attr(), configBean.getConnectionType());
			
			//blp part
			configStr=configStr.replaceAll(ConfigAttributes.SocketConnectHost.attr(), configBean.getSocketConnectHost());
			configStr=configStr.replaceAll(ConfigAttributes.SocketConnectPort.attr(), configBean.getSocketConnectPort()+"");
			configStr=configStr.replaceAll(ConfigAttributes.SocketKeyStorePassword.attr(), configBean.getSocketKeyStorePassword());
			
			
			System.out.println(configStr);
			
			Files.write(resultPath, configStr.getBytes("UTF-8"));
			
			
			
			
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		
		
		
	}
	
	

}
