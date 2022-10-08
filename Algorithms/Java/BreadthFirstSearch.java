package Graphs.Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G001BFS {
    static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean [] vis = new boolean[V+1];
        for (int i = 1; i <= V; i++) {
            if(!vis[i]){
                vis[i] = true;
                q.add(i);
                while (!q.isEmpty()){
                    int node = q.poll();

                    for(Integer adjNode : adj.get(node)){
                        if(!vis[adjNode]){
                            vis[adjNode] = true;
                            q.add(adjNode);
                        }
                    }
                    bfs.add(node);
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args) {
//        This outer arraylist can change its size.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        10 elements
        int V = 10;


//        ArrayList<> adj -> Empty arraylist.
//        But inner arraylist gives indexing to the outer one.
        for (int i = 0; i <= V; i++) {
//            Inner arraylist is to be added to give index to the outer arraylist. Arraylist size can be increased by
//            adding something, otherwise it will be initially empty always.
            adj.add(i,new ArrayList<>());
        }

//   1st component
//        1
//      2   3
//    4       5

//        Adding 1's adjacent elements
        adj.get(1).add(2);
        adj.get(1).add(3);

//        Adding 2's adjacent elements
        adj.get(2).add(1);
        adj.get(2).add(4);

//        Adding 3's adjacent elements
        adj.get(3).add(1);
        adj.get(3).add(5);

//        Adding 4's adjacent elements
        adj.get(4).add(2);

//        Adding 5's adjacent elements
        adj.get(5).add(3);

//   2nd component
//        10
//      6   7
//    8       9
//        Adding 6's adjacent elements
        adj.get(6).add(10);
        adj.get(6).add(8);

//        Adding 7's adjacent elements
        adj.get(7).add(10);
        adj.get(7).add(9);

//        Adding 8's adjacent elements
        adj.get(8).add(6);

//        Adding 9's adjacent elements
        adj.get(9).add(7);

//        Adding 10's adjacent elements
        adj.get(10).add(6);
        adj.get(10).add(7);

        System.out.println(bfsOfGraph(V,adj));
    }
}
