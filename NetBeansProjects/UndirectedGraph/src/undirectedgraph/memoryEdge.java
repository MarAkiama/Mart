/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package undirectedgraph;

import edu.princeton.cs.algs4.EdgeWeightedGraph;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marzan
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mary Laptop
 */
/** 
 * Edge
* object overhead -> 16 bytes
* int value (vertex1) -> 4 bytes
* int value (vertex2) -> 4 bytes
* double value (weight) -> 8 bytes
Amount of memory needed: 16 + 4 + 4 + 8 = 32 bytes

Node
* object overhead -> 16 bytes
* extra overhead for reference to the enclosing instance -> 8 bytes
* Item reference (item) -> 8 bytes
* Node reference (next) -> 8 bytes
Amount of memory needed: 16 + 8 + 8 + 8 = 40 bytes

Bag
* object overhead -> 16 bytes
* Node reference (first) -> 8 bytes
* N Nodes -> 40N bytes (there will be 2 Nodes per Edge when computing the EdgeWeightedGraph memory, so this will become 80N)
* Edge (item) -> 32N bytes
Amount of memory needed: 16 + 8 + 40N + 32N = 72N + 24 bytes

EdgeWeightedGraph
* object overhead -> 16 bytes
* int value (V) -> 4 bytes
* int value (E) -> 4 bytes
* Bag<Edge>[] reference (adj) -> 8 bytes
* Bag<Edge>[] (adj)
   object overhead -> 16 bytes
   int value (length) -> 4 bytes
   int value (padding) -> 4 bytes
   Bag references -> 8V -> (Resizing array): 8V * 2 = 16V
   Bag -> 72E + 24 bytes -> There are V Bags in total, and they have 2E nodes (so we double the 40N bytes from the Nodes memory in Bag) -> 72E + 24V + 40E -> 112E + 24V
Amount of memory needed: 16 + 4 + 4 + 8 + 16 + 4 + 4 + 16V + 112E + 24V = 112E + 40V + 56 bytes **/
public class memoryEdge{
    private static final long MEGABYTE = 1024L * 1024L;
    final static int Ve = 40;
    final static int Ev = 112;
    
    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void main(String[] args) {
        // I assume you will know how to create a object Person yourself...
        List<EdgeWeightedGraph> list = new ArrayList<EdgeWeightedGraph>();
        for (int i = 0; i <= 1; i++) {
            list.add(new EdgeWeightedGraph(5));
        }
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(Ev + "E + " + Ve + "V + " + "56");
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory));
        
    }
}
//        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(5);
//        edgeWeightedGraph.addEdge(new Edge(0, 1, 0.42));
//        edgeWeightedGraph.addEdge(new Edge(0, 3, 0.5));
//        edgeWeightedGraph.addEdge(new Edge(1, 2, 0.12));
//        edgeWeightedGraph.addEdge(new Edge(1, 4, 0.91));
//        edgeWeightedGraph.addEdge(new Edge(2, 3, 0.72));
//        edgeWeightedGraph.addEdge(new Edge(3, 4, 0.8));
//        edgeWeightedGraph.addEdge(new Edge(3, 4, 0.82));
//        edgeWeightedGraph.addEdge(new Edge(4, 4, 0.1));
//        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//        long actualMemUsed= afterUsedMem - beforeUsedMem;
