import java.util.*;
import java.util.Iterator;
public class Graph{

	private final int v; //Variable that keeps track of the number of vertices in graph
	private Bag<Integer>[] adj;

	public Graph(int V){
		this.v = V;
		adj = (Bag<Integer>[])new Bag[v];
		for(int i = 0; i < V; i++){
			adj[i] = new Bag<Integer>();
		}
	}

	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}

	public Iterable<Integer> adj(int v){
		return adj[v];
	}

}
