package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyy on 3/2/17.
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows){
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows==0) return result;
        ArrayList<Integer> level = new ArrayList<Integer>();
        level.add(1);
        result.add(level);
        ArrayList<Integer> former=level;
        for(int i=1;i<numRows;i++){
            level = new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(j==0){
                    level.add(1);
                }
                if(j==i){
                    level.add(1);
                    result.add(level);
                    former = level;
                }
                if(j>0&&j<i){
                    level.add(former.get(j-1)+former.get(j));
                }
            }
        }
        return result;
    }
    public static void printTriangle(int num){
        List<List<Integer>> res = generate(num);
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static List<Integer> getRow(int rowIndex){
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for(int i=0;i<rowIndex;i++){
            if(i!=0)
                res.add(0);
            for(int j=i;j>0;j--)
                res.set(j,res.get(j)+res.get(j-1));
        }
        return res;
    }
}
