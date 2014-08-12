/**
 * Suppose you want to figure out the minimum distance from Node x to Node Y.
 * 
 * Brute force solution: You could compute every value, every time you wanted to calculate which one gives you minimum distance.
 * DP Solution: You do previous solution, but store already computed values. 
 * For each node use equation: dist(D) = min{ dist(nodes that point to D) + weight of edge from node to D } 
 * 
 * Running time is O(n)
 * 
 * 
 */
public class ShortesPathToNode{
    
    public void findShortestPath() {
    }

}
