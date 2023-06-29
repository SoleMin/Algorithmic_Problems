
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
import java.util.*;
 
 
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
 
public class Ideone {
    public static void main(String args[] ) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n,i,j,k,temp ;
       n = ni(br.readLine());
       int[] a = nia(br);
       Arrays.sort(a);
       int c = 0;
       for( i = 0; i< n ; i++) {
    	   if(a[i] > 0) {
    		   c++;
    		   temp = a[i];
    		   for(j = i+1; j< n; j++) {
    			   if(a[j] % temp == 0)
    				    a[j] = 0;
    		   }
    	   }
       }
       
       
       System.out.println(c);
	
    }
    static Integer[] nIa(BufferedReader br) throws Exception{
        String sa[]=br.readLine().split(" ");
        Integer [] a = new Integer [sa.length];
        for(int i = 0; i< sa.length; i++){
            a[i]= ni(sa[i]);
        }
        return a;
   }
    static int[] nia(BufferedReader br) throws Exception{
        String sa[]=br.readLine().split(" ");
        int [] a = new int [sa.length];
        for(int i = 0; i< sa.length; i++){
            a[i]= ni(sa[i]);
        }
        return a;
   }
    
    static int ni(String s){
        return Integer.parseInt(s);
    }
    static float nf(String s){
        return Float.parseFloat(s);
    }
    static double nd(String s){
        return Double.parseDouble(s);
    }

  
}
