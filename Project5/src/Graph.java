/* Name: David Kopp
*  Date: 11-18-14
*  Project: 5 -  Graph using an adjacency matrix
*  Description: This program creates a graph using an adjacency matrix from
*               a txt file.(First line is the size of matrix and edges are
*               ints in pairs.)     
*/

// Imports
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;

public class Graph
{

// public variables or objects
   File file;

// private data structures
   private int[][] adjMatrix;
   private int[] visited;
   private int[] paths;

// private variables
   private int edges;
   private int vertices;
      
// public methods
// Graph constructor initializes the File object and calls the private readInputData method
   public Graph(String inputFileName)  
   {
      file = new File(inputFileName);
      readInputData();  
   } // End of Graph Constructor

// Prints out the adjMatrix as a matrix with labels
   public void printGraph()  
   {
      System.out.println("\n\nGraph Matrix Printout:");
      for (int i = 0; i < vertices; i++)
      {
         System.out.print("  " +i);
      } // End of For Loop
      System.out.println();
      for (int i = 0; i < vertices; i++)
      {
         System.out.print(i);
         for (int j = 0; j < vertices; j++)
         {
            System.out.print(" " +adjMatrix[i][j] +" "); 
         } // End of inner For loop
         System.out.println();
      } // End of outer For loop
      System.out.println("Number of vertices are: " +vertices);
      System.out.println("Number of edges are: " +edges);   
   } // End of printGraph method

// BFS Traversal with a queue
   public void bfsTraversal(int vertex)       
   {
      Queue<Integer> q = new LinkedList<Integer>();
      System.out.print("\nBFS Traversal Printout: ");
      q.add(vertex);
      visited[vertex] = 1;
      System.out.print(vertex +" ");
      while (!q.isEmpty())
      {
         int d = q.remove();
         for (int i = 0; i < vertices; i++)
         {
            if (adjMatrix[d][i] == 1)
            {
               if (visited[i] != 1)
               {
                  visited[i] = 1;
                  System.out.print(i +" ");
                  q.add(i);
               } // End of inner If
            } // End of outer If
         } // End of For loop
      } // End of While loop
      resetArray(visited);
   } // End of method bfsTraversal

// DFS Traversal with recursion
   public void dfsTraversal(int vertex)         
   {
      resetArray(visited);
      System.out.print("\nDFS Traversal Printout: ");
      rdfsTraversal(vertex); // recursive method call
   } // End of method dfsTraversal 

// Returns an array with all the shortest paths from vertex to any connected vertices
// Uses a BFS algorithm with queue
   public int[] findShortestPaths(int vertex)  
   {
      Queue<Integer> q = new LinkedList<Integer>();
      resetArray(paths);
      q.add(vertex);
      visited[vertex] = 1;
      while (!q.isEmpty())
      {
         int d = q.remove();
         for (int i = 0; i < vertices; i++)
         {
            if (adjMatrix[d][i] == 1)
            {
               if (visited[i] != 1)
               {
                  visited[i] = 1;
                  paths[i] = d;
                  q.add(i);
               } // End of inner If
            } // End of outer If
         } // End of For loop
      } // End of While loop
      resetArray(visited);
      return paths;
   } // End of method findShortestPaths

// Prints out all shortest paths from vertex to all connected vertices
   public void printShortestPaths(int vertex)
   {
      resetArray(paths);
      int[] parent = findShortestPaths(vertex);
      System.out.println("Shortest Paths from: " +vertex);
      for (int i = 0; i < parent.length; i++)
      {
         StringBuilder sb = new StringBuilder(parent.length);
         if (i != vertex && parent[i] == -1)
         {
            System.out.println("To: " +i +" no path exists.");
            i++;
         } // End of If
         int z = i;
      
         while (z != -1)
         {
            sb.append(z +" ");
            z = parent[z];
         } // End of While loop
         System.out.println("To: " +i +" is " +sb.reverse());
      } // End of For loop 
   } // End of method printShortestPaths

// Returns true or false depending if there exists a path between x and y
// Uses Recursion
   public boolean existsPath(int x, int y)        
   {
      return rexistsPath(x,y); // recursive call
   } // End of method existsPath

// Checks to see if a Triangle exists in a graph. Returns true or false
// and if true prints out the path from start to end (the end is the starting
// vertex.
   public boolean existsTriangle()               
   {
      int x = 0;
      for (int i = 0; i < vertices; i++)
      {
         if (adjMatrix[x][i] == 1)
         {
            for (int j = 0; j < vertices; j++)
            {
               if (adjMatrix[i][j] == 1 && adjMatrix[j][x] == 1)
               {
                  System.out.println("\nA Triangle exists in the graph at points: " +x +" " +i +" " +j +" " +x);
                  return true;
               } // End of inner If
            } // End of inner For Loop
         } // End of outer If
         else if (x < vertices &&  i == vertices - 1)
         {
            x++;
            i = 0;
         } // End of Else If
         else if (x == vertices - 1 && i == vertices - 1)
         {
            break;
         } // End of Else If
      } // End of outer For Loop
      return false;  
   } // End of method existsTriangle 

// private methods
// This reads in the txt file and sets up the adjMatrix, edges, and vertices 
// data structure / variables
   private void  readInputData()  
   {
      edges = 0;
      try 
      {
         Scanner input = new Scanner(file);
         vertices = input.nextInt();
         adjMatrix = new int[vertices][vertices];
         visited = new int[vertices];
         paths = new int[vertices];
         resetArray(visited);
         resetArray(paths);
         while (input.hasNextInt())
         {
            adjMatrix[input.nextInt()][input.nextInt()] = 1;
            edges++;
         } // End of While loop
         input.close();
      } // End of Try
      catch (FileNotFoundException e)
      {
         System.out.println(e);
         System.exit(1);
      } // End of Catch  
   } // End of method readInputData

// Private method to reset the array with the values -1.
   private void resetArray(int[] a)
   {
      for (int i = 0; i < a.length; i++)
      {
         a[i] = -1;
      } // End of For loop
   } // End of method resetArray

// Recursion method for DFS Traversal
   private void rdfsTraversal(int vertex)
   {
      visited[vertex] = 1;
      System.out.print(vertex + " ");
      for (int i = 0; i < vertices; i++)
      {
         if (adjMatrix[vertex][i] == 1 && visited[i] == -1)
         {
            rdfsTraversal(i);
         } // End of If
      } // End of For loop
      resetArray(visited);
   } // End of method rdfsTraversal

// Recursion method for existsPath
   private boolean rexistsPath(int x, int y)        
   {
      visited[x] = 1;
      if (x == y)
      {
         resetArray(visited);
         return true;
      } // End of If
      else
      {
         for (int i = 0; i < vertices; i++)
         {
            if (adjMatrix[x][i] == 1 && visited[i] == -1)
            {
               if (rexistsPath(i, y))
               {
                  resetArray(visited);
                  return true;
               } // End of second If
            } // End of first If
         } // End of For loop
      } // End of Else
      resetArray(visited);
      return false;
   } // End of method rexistsPath
} // End of class Graph