
package undirectedgraph;
import java.util.*;
import java.util.LinkedList;
 

public class FifthTask
{
    private int V;   
    private LinkedList<Integer> adj[];
    private int in[];          
 
    
    FifthTask(int v)
    {
        V = v;
        adj = new LinkedList[v];
        in = new int[V];
        for (int i=0; i<v; ++i)
        {
            adj[i] = new LinkedList();
            in[i]  = 0;
        }
    }
 
   
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        in[w]++;
    }
 
    
    void DFSUtil(int v,Boolean visited[])
    {
        
        visited[v] = true;
 
        int n;
 
        
        Iterator<Integer> i =adj[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }
 
    
    FifthTask getTranspose()
    {
        FifthTask g = new FifthTask(V);
        for (int v = 0; v < V; v++)
        {
            
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {
                g.adj[i.next()].add(v);
                (g.in[v])++;
            }
        }
        return g;
    }
 
    
    Boolean isSC()
    {
        
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        
        DFSUtil(0, visited);
 
      
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                return false;
 
        
        FifthTask gr = getTranspose();
 
        
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        
        gr.DFSUtil(0, visited);
 
        
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                return false;
 
        return true;
    }
 
    
    Boolean isEulerianCycle()
    {
        
        if (isSC() == false)
            return false;
 
        
        for (int i = 0; i < V; i++)
            if (adj[i].size() != in[i])
                return false;
 
        return true;
    }
 
    public static void main (String[] args) throws java.lang.Exception
    {
        FifthTask g = new FifthTask(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
 
        if (g.isEulerianCycle())
            System.out.println("Given directed graph is eulerian ");
        else
            System.out.println("Given directed graph is NOT eulerian ");
    }
}

