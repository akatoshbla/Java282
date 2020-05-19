/* Name: David Kopp
*  Date: 11-18-14
*  Project: 5 -  Graph using an adjacency matrix
*  Description: This is the main test case for the graph object. 
*               Uses multiple graphs and tests every case.     
*/

public class TestGraph
{

public static void printPaths(int[] a)
{
System.out.print("\nShortest path array: ");
for (int i = 0; i < a.length; i++)
{
System.out.print(a[i] +" ");
}
}

public static void main(String[] args)
{
Graph g = new Graph("edges.txt");
Graph dfs = new Graph("dfstest.txt");
Graph bfs = new Graph("bfstest.txt");
Graph notri = new Graph("notri.txt");
int w = 2;
int x = 0;
int y = 1;
int z = 5;
g.printGraph();
g.bfsTraversal(y);
g.bfsTraversal(y);
dfs.printGraph();
dfs.dfsTraversal(x);
bfs.printGraph();
bfs.bfsTraversal(z);
System.out.println("\nIs there a path from " +x +" to " +w +"? " +g.existsPath(x, w));

int[] thePaths = bfs.findShortestPaths(x);
printPaths(thePaths);
System.out.print("\nTesting existsTriangle with an one vertex graph(should be false): " +notri.existsTriangle());
bfs.existsTriangle();
bfs.printShortestPaths(x);
}
}