public class DepthFirstSearch{
	private boolean[] marked;
	private int[] edgeTo;
	private int s;  	//source vertex
	
	public DepthFirstSearch(Graph g, int s){
		this.s = s;
		marked = new boolean[g.v];
		edgeTo = new int[g.v];
		dfs(G,s);
	}
	
	public void dfs(Graph g, int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){	//it's about the first route somewhere, nothing more
				edgeTo[w] = v;
				dfs(G,w);
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != s; x = edgeTo[x]){
			path.push(x);
		}
		
		return path;
		
	}
	
}