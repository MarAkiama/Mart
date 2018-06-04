/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package undirectedgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FourthTask{
    static List<Integer>graph[];
    static List<Integer>ans[];
    static int [] mark;
    public static void main(String[] args)throws Exception{
       Scanner scan = new Scanner (System.in);
       int v = scan.nextInt();
       int e  = scan.nextInt();
       graph = new ArrayList[v];
       ans=new ArrayList[2];
       ans[0]= new ArrayList();
       ans[1]= new ArrayList();
       for(int i=0; i<graph.length;i++){
           graph[i]=new ArrayList();
       }
       mark = new int[v];
       for(int i=0; i<e; i++){
           int a = scan.nextInt()-1;
           int b = scan.nextInt()-1;
           graph[a].add(b);
           graph[b].add(a);
       }
       for(int i=0;i<v; i++){
           if(mark[i]==0){
               if(graph[i].size()==0){
                   continue;
               }
               if(dfs(i,2)==true){
                   System.out.println("-1");
                   return;
               }
           }
       }
       System.out.println(ans[0].size());
       for(int el : ans[0]){
       System.out.print((el+1)+" ");
       }
       System.out.println();
       System.out.println(ans[1].size());
       for(int el : ans[1]){
       System.out.print((el+1)+" ");
       }
       System.out.println();
    }
    private static  boolean dfs(int i, int color){
        mark[i]=color;
        ans[color-1].add(i);
        for(int v: graph[i]){
            if(mark[v]==color){
                return true;
            }
            if(mark[v]==0){
                if(dfs(v,3-color)){
                    return true;
                }
            }
        }
        return false;
    }
    
}