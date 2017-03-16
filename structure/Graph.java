package structure;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by wyy on 3/13/17.
 */
public class Graph {
        private int V;
        public void setV(int v){
            V=v;
        }
        public int getV(){
            return V;
        }
        private int E;
        public int getE(){
            return E;
        }
        public List<List<Integer>> adj;
        //public List<List<Integer>> getAdj(){
          //  return adj;
       // }

        public Graph(int v){
            V=v;
            E=0;
            adj = new ArrayList<List<Integer>>(); //only the list of vertices
            for(int i=0;i<v;i++)
                adj.add(new LinkedList<Integer>());
        }

        public void addEdge(int w, int v){
            List<Integer> vlist = adj.get(w);
            vlist.add(v);
            E++;
        }

        public void printEdge(){
            System.out.println("total "+E+" edges");
            for(int i=0;i<V;i++){
                List<Integer> vlist = adj.get(i);
                System.out.print("vertice "+i+" :");
                for(int n : vlist){

                    System.out.print(n+" ");}
                System.out.println();
            }
        }

}
