// No sorceries shall previal. //
         
import java.util.Scanner; 
import java.io.PrintWriter;
import java.util.*;
import java.util.Arrays;
     
public class InVoker {
  
   public static void main(String args[]) {
    		
    	Scanner inp = new Scanner(System.in);
    	PrintWriter out= new PrintWriter(System.out);
    	
    	int n=inp.nextInt();
    	int a[]=new int[n];
    	for(int i=0;i<n;i++)
    		a[i]=inp.nextInt();
    	Arrays.sort(a);
    	int gg=0;
    	for(int i=0;i<n;i++) {
    		if(a[i]==0)
    			continue;
    		gg++;
    		for(int j=i+1;j<n;j++) {
    			if(a[j]%a[i]==0) {
    				a[j]=0;
    			}
    		}
    	}
    	out.println(gg);
    	out.close();
    	inp.close();
    				
    }
    		
}