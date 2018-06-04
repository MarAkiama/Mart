/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainui.graphnetwork.util;
public class Random {
    
    
    /**
     * Returns a random positive number between 1 and a
     * maximum value given by the user
     * @param n the maximum value to return
     * @return the random value between 1 and n
     */ 
    public static int getRandomPositiveInteger(int n) {
        return (int)(Math.random() * n) + 1;
    }
    
    /**
     * Returns a random positive float between
     * a minimum and a maximum value given by the user
     * @param min the minimum value to return
     * @param max the maximum value to return
     * @return a float value between min and max
     */ 
    public static float getRandomPositiveFloatLim(float min, float max) {
        return (float)((Math.random() * (max-min))) + min;
    }
    
    /**
     * Returns a random positive int between
     * a minimum and a maximum value given by the user
     * @param min the minimum value to return
     * @param max the minimum value to return
     * @return an integer value between min and max
     */ 
    public static int getRandomPositiveIntegerLim(int min, int max) {
        return (int)((Math.random() * (max-min))) + min;
    }   
}