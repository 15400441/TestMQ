package manageData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataManager {
	
	
	Set<String> source=new HashSet<String>();
	
	public static void main(String[] args) {
		new DataManager().test();
	}
	
	public  void test(){
		
		List<String> data=null;
		
		List<String> transferData=new ArrayList<String> ();
	
		
		try {
			data=Files.readAllLines(Paths.get("file"+File.separator+"pg.txt"));
			System.out.println(data.size());
			System.out.println(data);
			
			data.stream().forEach((str)->{
			
				if(str.substring(7, 9).equals("00")){
					str=str.substring(0,7)+"01"+str.substring(9);
					
					
					
					transferData.add(str);
				}else{
					
					if(str.substring(7, 9).equals("01")){
						str=str.substring(0,7)+"00"+str.substring(9);
						transferData.add(str);
					}
					
				}
				
				
				
				
			});
			
			
			Files.write(Paths.get("file"+File.separator+"pg_new.txt"), transferData);
			
			System.out.println(transferData.size());
			System.out.println(transferData);
			
			initSorce();
			
			
			//find account not in oracle
			System.out.println("Start comparing....");
			transferData.forEach(td->{
				
				if(!source.contains(td))
					System.out.println(td);
				
			});
			
			
			System.out.println("End comparing");
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

		
	
	
	}
	
	
	
	public void initSorce() throws IOException{
		List<String> rs=Files.readAllLines(Paths.get("file"+File.separator+"or.txt"));
		
		rs.stream().forEach((str)->{
			source.add(str);
		});
		
		System.out.println("init source done, size:"+rs.size());
		
	}

}


