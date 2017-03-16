package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by wyy on 2/8/17.
 */
public class NextGreater {
    private int[] findNums;
    private int[] nums;

    public NextGreater(int[] nums1, int[] nums2){
        findNums = new int[nums1.length];
        nums = new int[nums2.length];
        for(int i=0;i<nums1.length;i++){
            findNums[i] = nums1[i];
        }
        for(int j=0;j<nums2.length;j++){
            nums[j] = nums2[j];
        }
    }

    public int[] nextGreaterElement() {
        int[] result = new int[findNums.length];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        // handle every element of nums
        for(int k=0;k<nums.length;k++){
            while(!stack.isEmpty()&&stack.peek()<nums[k]){
                map.put(stack.pop(),nums[k]);
            }
            stack.push(nums[k]);
        }

        for( int i=0;i<findNums.length;i++){
            result[i]=map.getOrDefault(findNums[i],-1);
        }



       /* for(int i=0;i<findNums.length;i++) {
            int start=-1,end=-1;
            for(int j=0;j<nums.length;j++){
                if(start>=0 && end==-1){
                    if(nums[j]>findNums[i])
                        end=nums[j];
                }
                else if(start==-1) {
                    if(findNums[i]==nums[j])
                        start=j;
                }
            }
            result[i]=end;
        }  */

        return result;
    }
}
