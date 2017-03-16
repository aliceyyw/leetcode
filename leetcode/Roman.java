package leetcode;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Roman {
	private Map<Character,Integer> dict ;
	private int[] map;
	
	private String s;
	public Roman(String s){
		this.s = s;
		/* dict = new HashMap<Character,Integer>();
		    dict.put('I',1);
		    dict.put('V',5);
		    dict.put('X',10);
		    dict.put('L',50);
		    dict.put('C',100);
		    dict.put('D',500);
		    dict.put('M',1000);*/
		map = new int[26];
		map['I'-'A']=1;
		map['V'-'A']=5;
		map['X'-'A']=10;
		map['L'-'A']=50;
		map['C'-'A']=100;
		map['D'-'A']=500;
		map['M'-'A']=1000;
	}
	public int romanToInt(){
		char[] nums = s.toCharArray();
		int i=0; int val=0;
		for(int j=1;j<nums.length;j++){
			int pre=map[nums[i]-'A'];
		    int post=map[nums[j]-'A'];
			if(pre>=post){
				System.out.println("val="+val+"+ "+pre);
				val+=pre;
			}
			else{
				System.out.println("val="+val+"- "+pre);
				val-=pre;
			}
			i++;
		}
		return val+map[nums[i]-'A'];
	}
}
