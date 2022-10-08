package Graphs.Practice;

import java.util.ArrayList;

public class G002DFS {
    static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean [] vis = new boolean[V+1];
        for (int i = 1; i <= V; i++) {
            if(!vis[i]){
                dfsList(i,vis,adj,dfs);
            }
        }
        return dfs;
    }

    static void dfsList(int node, boolean [] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs){
        vis[node] = true;
        dfs.add(node);
        for(Integer adjacent : adj.get(node)){
            if(!vis[adjacent]){
                dfsList(adjacent,vis,adj,dfs);
            }
        }
    }
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

//        1st component
//       1
//     3   5
//   6       7

//        2nd component
//        2 -- 4

        int V = 7;
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(3);
        adj.get(1).add(5);

        adj.get(3).add(1);
        adj.get(3).add(6);

        adj.get(5).add(1);
        adj.get(5).add(7);

        adj.get(6).add(3);

        adj.get(7).add(5);

        adj.get(2).add(4);

        adj.get(4).add(2);



        System.out.println(dfsOfGraph(V,adj));
    }
}
