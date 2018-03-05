package test;

import java.util.Arrays;import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	
	
	private static String SEPERATE_DELIMITER=";";
	private static String MAPPING_DELIMITER="_";
	public static void main(String args[]){
		
		/*
		String a="tes t_b;  ;c";
		
		a=a.replaceAll(" ", "");
		
		String[] arr=a.split(";");
		
		
	
		System.out.println(a.indexOf("h"));
		
		Arrays.stream(arr).forEach(v->{
			System.out.println(v);
		});
		*/
		
		//Map map= new Test().handleCustomMapping("*_ddd;ffjj;d_h");
		
		//System.out.println(map);
		
		
		//String [] a="35=D---39=2---36=8--32=8".split("---");
		
		//System.out.println(Arrays.asList(a));
		
		
		List<String> ls=new LinkedList<String>();
		ls.add("fbc");
		ls.add("bca");
		ls.add("dcb");
		
		System.out.println(ls);
		System.out.println("-----------");
		ls=ls.stream().sorted().collect(Collectors.toList());
		System.out.println(ls);
		
		
	}
	
	
	
public Map<String, String> handleCustomMapping(String value){
		
		if(value==null || value.trim().equals(""))
			return null;
		
		Map<String,String> map=new HashMap();
		value=value.replaceAll(" ","");
		
	    String[] items=value.split(SEPERATE_DELIMITER);
	    
	    String[] pair=null;
	    for(int i=0;i<=items.length-1;i++){
	    	if("".equals(items[i].trim()))
	    		continue;
	    	if(items[i].indexOf(MAPPING_DELIMITER)==-1)
	    		continue;
	    	
	    	pair=items[i].split(MAPPING_DELIMITER);
	    	
	    	if(pair!=null && pair.length==2){
	    		if("".equals(pair[0]) || "".equals(pair[1]))
		    		continue;
	    		map.put(pair[0],pair[1]);
	    	}
	    	
	    	
	    }
		
		
		return map;
	}

}
