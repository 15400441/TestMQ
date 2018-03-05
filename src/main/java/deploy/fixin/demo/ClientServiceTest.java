package deploy.fixin.demo;



public class ClientServiceTest {
	
	/*
	private static ClientService clientService;
	
	@BeforeClass
	public static void setup(){
		clientService=new ClientService();
	}
	
	
	@AfterClass
	public static void teardown(){
		clientService=null;
	}
	
	
	
	
	@Test
	public void testInsertClient(){
		Client client=Client.genTemplateClient();
		client.setClient_id("TEST");
		client.setClient_sub_id(1);
		client.setSender_comp_id("TestSender");
		client.setTarget_comp_id("TestTarget");
		
		long startTime1=System.nanoTime();
		clientService.insertClient(client);
	    long endTime1=System.nanoTime();
		
		System.out.println("insert consuming Time:"+(endTime1-startTime1)/1000000);
		
		long startTime=System.nanoTime();
		List<Client> list=clientService.getClientsByClientID(client.getClient_id());
		long endTime=System.nanoTime();
		
		System.out.println("get consuming Time:"+(endTime-startTime)/1000000);
		Assert.assertEquals(1, list.size());
	}
	
	
	@Test
	public void testDeleteClient(){
		String client_id="TEST";
		clientService.deleteClient(client_id);
	}
	
	

	
	
	@Test
	public void testGetClientsByClientID(){
		String client_id="DYLAN";
		long startTime=System.nanoTime();
		List<Client> list=clientService.getClientsByClientID(client_id);
		long endTime=System.nanoTime();
		System.out.println("Consuming Time:"+(endTime-startTime)/1000000);
		System.out.println(list);
		
	}
	*/

}
