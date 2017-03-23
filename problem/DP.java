package problem;

import java.util.*;

/**
 * Created by wyy on 2/24/17.
 */
public class DP {

    public int rob(int[] nums){
        if(nums.length==0)
            return 0;
        int[] submax = new int[nums.length+1];
        submax[0]=0;
        submax[1]=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            submax[i+1]=Math.max(submax[i-1]+nums[i],submax[i]);
            if(submax[i+1]>max)
                max=submax[i+1];
        }
        return max;
    }

    public int maxSubArray(int[] nums){
        int[] dp = new int[nums.length]; // we don't really need an dp array, just record the last value
        int before = nums[0];
        int max = nums[0];
        for(int i=1;i<dp.length;i++){
            if(before>0)
                before=nums[i]+before;
            else
                before = nums[i];
            max = Math.max(max,before);
        }
        return max;
    }

    public int climbStairs(int n) {
        int[] res = new int[512];
        res[0]=1;
        res[1]=1;
        for(int i=2;i<=n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }

    // leetcode_472 Concatenated Words
    //
    public List<String> findAllConcatenatedWordsInADict(String[] words){
        List<String> res = new ArrayList<String>();
        Arrays.sort(words,new Comparator<String>(){
            public int compare(String s, String t){
                return s.length()-t.length();
            }
        });
        HashSet<String> dict = new HashSet<>();
        for(String str: words){
            if(wordInDict(str,dict))
                res.add(str);
            dict.add(str);
        }

        return res;
   }
    public boolean wordInDict(String word, HashSet<String> dict){
        if(dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length()+1];
        dp[0]=true;
        for(int i=1;i<=word.length();i++){   // i represents the num of characters in current word
            for(int j=0;j<i;j++){
                if(dp[j]==false) continue;
                if(dict.contains(word.substring(j,i)))
                    dp[i]=true;
            }
        }
        return dp[word.length()];

    }
}
