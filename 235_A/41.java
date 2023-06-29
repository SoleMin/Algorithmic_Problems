import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////  SOLUTION ///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




public  class Solution{ 
	//      main();   
	public static void main(String[] args) throws IOException{
		///input
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  String[] str=br.readLine().split(" ");
	      long n=Long.parseLong(str[0]);
	      if(n<3)
			System.out.println(n);
			else if(n%2==1)
			System.out.println(n*(n-1)*(n-2));
			else
			{
				if(n%3!=0)
				System.out.println(n*(n-1)*(n-3));
				else
				System.out.println((n-1)*(n-2)*(n-3));
		     }
	      
		
}//void main
	   
}//class main




