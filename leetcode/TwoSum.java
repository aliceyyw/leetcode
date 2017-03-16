package leetcode;

public class TwoSum {
	
	 public int[] twoSum(int[] nums, int target) {
	        int[] result = new int[2];
	        int flag=0;
	        for(int i=0;i<nums.length&&flag==0;i++){
	            for(int j=i+1;j<nums.length;j++){
	            	if((nums[i]+nums[j])==target){
	            		result[0]=i+1;
	            		result[1]=j+1;
	            		flag=1;
	            		break;
	            	}
	            		
	            }
	        }
	        
	        return result;
	 }
	
	
}
