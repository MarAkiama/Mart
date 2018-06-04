/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package undirectedgraph;

// Java program to find minimum edge
// between given two vertex of Graph
 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
 
public class SecondTask
{
    static int distbyEdges(Vector <Integer> edges[], int u, int v, int n)
    {
        Vector<Boolean> visited = new Vector<Boolean>(n);
         
        for (int i = 0; i < n; i++) {
            visited.addElement(false);
        }
      
        Vector<Integer> distance = new Vector<Integer>(n);
         
        for (int i = 0; i < n; i++) {
            distance.addElement(0);
        }
      
        Queue<Integer> Q = new LinkedList<>();
        distance.setElementAt(0, u);
      
        Q.add(u);
        visited.setElementAt(true, u);
        while (!Q.isEmpty())
        {
            int x = Q.peek();
            Q.poll();
      
            for (int i=0; i<edges[x].size(); i++)
            {
                if (visited.elementAt(edges[x].get(i)))
                    continue;
      
                distance.setElementAt(distance.get(x) + 1,edges[x].get(i));
                Q.add(edges[x].get(i));
                visited.setElementAt(true,edges[x].get(i));
            }
        }
        return distance.get(v);
    }
     
    static void addEdge(Vector<Integer> edges[], int u, int v)
    {
       edges[u].add(v);
       edges[v].add(u);
    }
 
    public static void main(String args[])
    {
        int n = 9;
        Vector <Integer> edges[] = new Vector[9];
         
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Vector<>();
        }
         
        addEdge(edges, 0, 1);
        addEdge(edges, 0, 7);
        addEdge(edges, 1, 7);
        addEdge(edges, 1, 2);
        addEdge(edges, 2, 3);
        addEdge(edges, 2, 5);
        addEdge(edges, 2, 8);
        addEdge(edges, 3, 4);
        addEdge(edges, 3, 5);
        addEdge(edges, 4, 5);
        addEdge(edges, 5, 6);
        addEdge(edges, 6, 7);
        addEdge(edges, 7, 8);
        int u = 0;
        int v = 5;
        System.out.println(distbyEdges(edges, u, v, n));
    }
}
