package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Anagram {
	
	private String s,t;
	Anagram(String s, String t){
		this.s=s;
		this.t=t;

        
	}
	
	 public boolean isAnagram( ) {
		  Map<Character,Integer> map = new HashMap<Character,Integer>();
		  if(s.length()!=t.length())return false;
	        for(int i=0;i<s.length();i++){
	            if(map.containsKey(s.charAt(i))){
	            	map.computeIfPresent(s.charAt(i), (k,v)-> v+1);
	            }
	            else map.put(s.charAt(i),1);
	            System.out.println(s.charAt(i)+": "+map.get(s.charAt(i)));
	        }
	        
	        for(int j=0;j<t.length();j++){
	        	if(map.containsKey(t.charAt(j))){
	        		map.computeIfPresent(t.charAt(j), (k,v)-> v-1);
	        		//���<0��ֱ�Ӿ�remove��
					System.out.println(t.charAt(j)+": "+map.get(t.charAt(j)));
	        		if(map.get(t.charAt(j))<0) return false;
	        	}
	        	else return false;
	        }
	        
	        
	        return true;

	    }
	
	 


}
