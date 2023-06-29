import java.io.*;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       long n =   scanner.nextLong();
       long s =   scanner.nextLong();
       long myLong = s;
       long count =0;
      while(true){
    	  if(myLong>n){
    		  break;
    	  }
    	  char[] num = (""+myLong).toCharArray();
		int sum = 0;
			for (int j = 0; j < num.length; j++)
				sum += num[j] - '0';
    	
    	  if(myLong- sum>=s){
    		  //count++;
    		  break;
    	  }
    	  
    	  myLong++;
      }
      System.out.println(Math.max(n-myLong+1,0));
        scanner.close();
    }
}