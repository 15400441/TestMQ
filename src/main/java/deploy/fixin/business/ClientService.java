package deploy.fixin.business;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import deploy.fixin.bean.Client;
import deploy.fixin.mapper.ClientMapper;
import deploy.fixin.utils.MyBatisUtils;

public class ClientService {
	
	public void insertClient(Client client){
		SqlSession session=MyBatisUtils.getSqlSession();
		
		try{
			ClientMapper clientMapper=session.getMapper(ClientMapper.class);
			clientMapper.addClient(client);
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
	
	
	
	
	public void deleteClient(String client_id){
		SqlSession session=MyBatisUtils.getSqlSession();
		try{
			ClientMapper clientMapper=session.getMapper(ClientMapper.class);
			clientMapper.deleteClient(client_id);
			session.commit();
			
		}finally{
			session.close();
		}
		
		
	}
	
	
	
	
	public List<Client> getClientsByClientID(String client_id){
		SqlSession session=MyBatisUtils.getSqlSession();
		List<Client> list=null;
		
		try{
			ClientMapper clientMapper=session.getMapper(ClientMapper.class);
			list=clientMapper.getClientsByClientID(client_id);
			session.commit();
			
		}finally{
			session.close();
		}
		
		return list;
		
	}

}
