/**
 * Created by rsr37 on 1/13/2018.
 */
import java.util.*;

class Graph{

    private int v; // no of vertices
    private LinkedList<Integer> adj[]; // adjacency list

    // constructor
    Graph(int n){
        v = n;
        adj = new LinkedList[v];
        for(int i =0; i < v;i++)
            adj[i] = new LinkedList<Integer>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }
// Using DFS
    boolean hasRoute(int s, int d){
        Queue<Integer> q = new LinkedList<Integer>();
        boolean visited[] = new boolean[v];

        visited[s] = true;
        q.add(s);

        Iterator<Integer> i; // Iterator to store all adjacent vertices of a vertex
        while(q.size() != 0){
            s = q.poll();
            int n;
            i = adj[s].listIterator();
            while(i.hasNext()){
                n = i.next();

                if(n == d)
                    return true;
                if(!visited[n]){
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
        return false;
    }
}
public class RouteBetweenTwoNodes {
public static void main(String[] args){
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    int u = 1;
    int v = 3;
    if (g.hasRoute(u, v))
        System.out.println("There is a path from " + u +" to " + v);
    else
        System.out.println("There is no path from " + u +" to " + v);;

    u = 3;
    v = 1;
    if (g.hasRoute(u, v))
        System.out.println("There is a path from " + u +" to " + v);
    else
        System.out.println("There is no path from " + u +" to " + v);;

}


}
