package deploy.fixin.mapper;

import java.util.List;

import deploy.fixin.bean.Client;

public interface ClientMapper {
	
	public int addClient(Client client);
	
	public List<Client> getClientsByClientID(String client_id);
	
	public void deleteClient(String client_id);
	
	


}
