import java.io.*;
import java.util.*;

public class Main {
    Scanner cin = new Scanner(new BufferedInputStream(System.in));
    long n;
    long maxlcm;
    
    void run(){
    	n = cin.nextInt();
    	if(n == 1 || n ==2)
    		maxlcm = n;
    	else if(n >= 3){
            	if(n % 2 != 0){
    	           	maxlcm = n * (n-1) * (n - 2);
    	        }
            	else if(n%3 != 0)
            		maxlcm = n * (n - 1) * (n - 3);
            	else maxlcm = (n - 1) * (n - 2) * (n - 3);
    	}  
    	System.out.println(maxlcm);
    }

	public static void main(String[] args) {
		new Main().run();

	}
}

		  				 	  	  		 	 	     	