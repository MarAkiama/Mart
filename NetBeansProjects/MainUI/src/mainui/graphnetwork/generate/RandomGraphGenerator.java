/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainui.graphnetwork.generate;

import org.jgrapht.*;
import org.jgrapht.ext.IntegerNameProvider;
import org.jgrapht.graph.ListenableUndirectedWeightedGraph;

/* my classes */
import mainui.graphnetwork.jgrapht.graph.DefaultWeightedEdge;

/**
 *
 * @author faif
 */
public class RandomGraphGenerator implements
        mainui.graphnetwork.common.Constants {
    
    /** Creates a graph with a random number
     * of edges and vertices
     * @param numOfVertices the maximum number of vertices
     * @param numOfEdges the maximum number of edges
     * @param minWeight the minimum weight value
     * @param maxWeight the maximum weight value
     */
    public RandomGraphGenerator(ListenableUndirectedWeightedGraph g,
            int numOfVertices, int numOfEdges, float minWeight,
            float maxWeight) {
        
        /* call the method which adds one edge per vertex */
        Object vertices[] = addOneEdgePerVertex(g, numOfVertices, numOfEdges,
                minWeight, maxWeight);
        
        generateRestGraph(g, vertices, (numOfEdges - 1), minWeight, maxWeight);
    }
    
    /** Creates a graph with a random number of edges
     * per vertex
     * @param numOfVertices the maximum number of vertices
     * @param numOfEdges the maximum number of edges
     * @param minWeight the minimum weight value
     * @param maxWeight the maximum weight value
     */
    private void generateRestGraph(ListenableUndirectedWeightedGraph g,
            Object v[], int numOfEdges, float minWeight,
            float maxWeight) {
        
        for (int i = 0; i < v.length; i++) {
            /* get a random number of edges */
            int rEdges =
                    mainui.graphnetwork.util.
                    Random.getRandomPositiveInteger(numOfEdges);
            
            /* add a random number of edges between the current and a random
              vertex */
            for (int j=0; j<rEdges; j++) {
                /* get a random vertex */
                int rVertex =
                        mainui.graphnetwork.util.Random.getRandomPositiveIntegerLim(i,
                        v.length);
                try {
                    /* add to the edge a random weight between MINW and MAXW */
                    float randWeight =
                            mainui.graphnetwork.util.Random.getRandomPositiveFloatLim(
                            minWeight, maxWeight);
                    Object e = g.addEdge(v[i], v[rVertex]);
                    if (e instanceof DefaultWeightedEdge) {
                        ((DefaultWeightedEdge)e).setWeight(randWeight);
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            }
        }
    }
    
    /** Creates a graph with one edge per vertex
     * of edges and vertices
     * @param numOfVertices the maximum number of vertices
     * @param numOfEdges the maximum number of edges
     * @param minWeight the minimum weight value
     * @param maxWeight the maximum weight value
     */
    private Object[] addOneEdgePerVertex(ListenableUndirectedWeightedGraph g,
            int numOfVertices, int numOfEdges, float minWeight,
            float maxWeight) {
        
        /* the name provider of the vertices */
        /* IntegerNameProvider provides names 1, 2, 3, etc. */
        IntegerNameProvider i=new IntegerNameProvider();
        
        Object v[] = new String[numOfVertices];
        
        /* previous and current vertex (to add the edge) */
        java.lang.String prev = EMPTY;
        java.lang.String curr = EMPTY;
        
        prev = i.getVertexName(prev);
        g.addVertex(prev);
        v[0] = prev;
        
        /* add the vertices to the graph */
        for (int j = 0; j < numOfVertices; j++) {
            curr = i.getVertexName(curr);
            g.addVertex(curr);
            v[j] = curr;
            
            float randWeight = 0f;
            
            try {
                /* add one edge per vertex */
                Object e =
                        g.addEdge(prev, curr);
                
                /* add to the edge a random weight between MINW and MAXW */
                randWeight =
                        mainui.graphnetwork.util.Random.getRandomPositiveFloatLim(
                        minWeight, maxWeight);
                
                if (e instanceof DefaultWeightedEdge) {
                    ((DefaultWeightedEdge)e).setWeight(randWeight);
                }
            } catch (Exception e) {
//                System.out.println("loop...");
            }
            prev = curr;
        }
        return v;
    }
    
}
