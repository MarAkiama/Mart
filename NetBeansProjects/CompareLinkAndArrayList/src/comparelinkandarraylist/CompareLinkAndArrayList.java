
package comparelinkandarraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author marzhan nurdauletova
 */
public class CompareLinkAndArrayList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long st = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = scan.nextInt();
        int min;
        for(int i=0; i<n;i++){
            list.add(scan.nextInt());
        }
        
        for(int i=0; i<n-1; i++){
            min =i;
            for(int j=i+1; j<n; j++){
                if(list.get(j)<list.get(min)){
                    min=j;
                }
            }
            if(min !=i){
                int swap = list.get(i);
                list.set(i,list.get(min));
                list.set(min, swap);
            }
        }
        System.out.println(list);
        long  en = System.currentTimeMillis();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
System.out.println("Total time for arrayList code "+(en - st));

long st1 = System.currentTimeMillis();
LinkedList<Integer> list1 = new LinkedList<Integer>();
int min1;
int m =scan.nextInt();
        for(int i=0; i<m; i++){
        list1.add(scan.nextInt());
    }
       for(int i=0; i<m-1; i++){
            min1 =i;
            for(int j=i+1; j<m; j++){
                if(list1.get(j)<list1.get(min1)){
                    min1=j;
                }
            }
            if(min1 !=i){
                int swap = list1.get(i);
                list1.set(i,list1.get(min1));
                list1.set(min1, swap);
            }
        }
        System.out.println(list1);
        long  en1 = System.currentTimeMillis();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
System.out.println("Total time for linkedList code "+(en1 - st1));
    }
    
}
