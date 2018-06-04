/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainui.graphnetwork.jgrapht.graph;


public class DefaultWeightedEdge
        extends org.jgrapht.graph.DefaultWeightedEdge {
    private float weight; /* the weight value of the edge */
    
    /**
     * Sets the weight value of the DefaultWeightedEdge
     *
     * @param w the value of the weight to be set
     */
    public void setWeight(float w) {
        weight = w;
    }
    
    /**
     * Returns the weight value of the DefaultWeightedEdge
     *
     * @return the value of the weight of this edge
     */
    public float getWeight() {
        return weight;
    }
    
    /**
     * Overrides the toString method of DefaultWeightedEdge
     * to return just a String representation of the weight
     * of the edge + the superclass toString.
     *
     *
     * @return a string representation of the weight value
     */
    public java.lang.String toString() {
        return super.toString() + " = " + weight;
    }
}