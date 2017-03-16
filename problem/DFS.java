package problem;
import structure.*;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by wyy on 3/15/17.
 */
public class DFS {
    //leetcode_210
    private boolean[] onstack;
    private boolean hascycle;
    public int[] findOrder(int numCourses, int[][] prerequisites){
        Graph g = new Graph(numCourses);

        for(int i=0;i<prerequisites.length;i++){
            g.addEdge(prerequisites[i][1],prerequisites[i][0]);
        }g.printEdge();
        LinkedList<Integer> res = new LinkedList<Integer>();
        //HashSet<Integer> marked = new HashSet<Integer>();
        boolean[] mark = new boolean[g.getV()];
        onstack = new boolean[g.getV()];
        hascycle = false;
        for(int i=0;i<numCourses;i++){
            if(!mark[i])
            dfsTopo(g,i,res,mark);
        }
        int[] result =null;
        if(hascycle)
        return result;
        result = new int[numCourses];
        for(int k=0;k<numCourses;k++)
            result[k]=res.remove();
        return result;
    }
    private void dfsTopo(Graph g , int v,LinkedList<Integer> res,boolean[] marked){
        if(hascycle) return;
        marked[v] = true;
        onstack[v]=true;
        List<Integer> vlist = g.adj.get(v);
        for(int n : vlist){
            if(!marked[n]){
                dfsTopo(g,n,res,marked);
            }else if(onstack[n]==true){
                hascycle=true;
            }

        }
        res.addFirst(v);
        onstack[v]=false;
    }

    //leetcode_332 Reconstruct Itinerary
    // find an Eulerian circuit with smallest lexical order in a directed graph
    public List<String> findItinerary(String[][] tickets){
        LinkedList<String> res = new LinkedList<String>();
        HashMap<String,PriorityQueue<String>> adj = new HashMap<String,PriorityQueue<String>>();
        for (String[] edge : tickets){
            adj.putIfAbsent(edge[0],new PriorityQueue<String>()); //initially allocate mem for the heap
            adj.get(edge[0]).add(edge[1]);
       }
        dfsEule(adj,"JFK",res);
        return res;
    }

    private void dfsEule(HashMap<String,PriorityQueue<String>> adj,String start,LinkedList<String> res){
        //neighbor might not be instantiated
        PriorityQueue<String> neighbor = adj.get(start);
        while(neighbor!=null && !neighbor.isEmpty()){
            dfsEule(adj,neighbor.poll(),res);
        }
        res.addFirst(start);
    }

    //leetcode_99 Recover Binary Search Tree
    private TreeNode first=null;
    private TreeNode second=null;
    private TreeNode pre=null;
    public void recoverTree(TreeNode root){
        dfsRecoverBST(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
    private void dfsRecoverBST(TreeNode root){
        if(root==null) return;
        dfsRecoverBST(root.left);
        if(pre!=null && pre.val>=root.val){
            if(first==null){
                first=pre;
            }
            if(first!=null){
              second = root;
            }
        }
        pre = root;
        dfsRecoverBST(root.right);
    }

}
