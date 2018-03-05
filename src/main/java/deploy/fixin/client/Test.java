package deploy.fixin.client;

import deploy.fixin.bean.OSConnection;

public class Test {

	public static void main(String[] args){
		OSConnection c=new OSConnection("BOUAT7","127.0.0.1",1000);
		System.out.println(c.genOsConn());
		
		
		String s="abdcdd--tep--ddd--tep--";
		System.out.println(s.replaceAll("--tep--", "___"));
	}
}
