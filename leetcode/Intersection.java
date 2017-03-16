package leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
/**
 * Created by wyy on 6/29/16.
 */
public class Intersection {
    private int[] a,b;
    public Intersection(int[]a, int[]b){
        this.a =a;
        this.b =b;
    }
    public boolean f(boolean s){
        return true;
    }
    public void printIntersection(){

        Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        for(int i=0;i<a.length;i++){
          if(map.containsKey(a[i])==false)
              map.put(a[i],true);
        }
        Set<Integer> result = new HashSet<Integer>();

        for(int j=0;j<b.length;j++){
            if(map.containsKey(b[j]))
                result.add(b[j]);
        }

        int[] res = new int[result.size()];
        int temp=0;
        for(Integer item:result){
            res[temp++]=item;
        }
        for(int num:res)
        System.out.println(num);


    }



}
