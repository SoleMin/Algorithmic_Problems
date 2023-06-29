/*
 * Code Author: Sanket Udgirkar.
 * DA-IICT
 */
import java.util.*;
import java.io.*;
public class Tester
{
	public static long mod=(long)1e9+7;
	
	public static void main(String[] args) 
	{
		InputReader s=new InputReader(System.in);
        OutputStream outputStream = System.out;
        //PrintWriter out=new PrintWriter(outputStream);
        
       String str=s.nextLine();
       System.out.println("25");
        
        
        //out.close();
	}   
	
	static long gcd(long a,long b)
	{
		if(b==0)
			return a;
		a%=b;
		return gcd(b,a);
	}
	
	static long exp(long a, long b)
	{
		if(b==0)
			return 1;
		if(b==1)
			return a;
		if(b==2)
			return a*a;
		
		if(b%2==0)
			return exp(exp(a,b/2),2);
		else
			return a*exp(exp(a,(b-1)/2),2);
	}
	
	static class Pair implements Comparable<Pair>
	{
		long x,f;
		Pair(long ii, long cc)
		{
			x=ii;
			f=cc;
		}
		
		public int compareTo(Pair o) 
		{
			return Long.compare(this.x, o.x);
		}
		
	}

    public static class InputReader 
    {
    	public BufferedReader reader;
    	public StringTokenizer tokenizer;
     
    	public InputReader(InputStream inputstream) 
    	{
    	      reader = new BufferedReader(new InputStreamReader(inputstream));
    	      tokenizer = null;
    	}
    	    
    	public String nextLine()
    	{
    	    String fullLine=null;
    	    while (tokenizer == null || !tokenizer.hasMoreTokens()) 
    	    {
    	        try {
    	              fullLine=reader.readLine();
    	            } 
    	        catch (IOException e) 
    	        {
    	              throw new RuntimeException(e);
    	        }
    	        return fullLine;
    	     }
    	     return fullLine;
    	}
    		public String next() 
    		{
    	      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
    	        try {
    	          tokenizer = new StringTokenizer(reader.readLine());
    	        } catch (IOException e) {
    	          throw new RuntimeException(e);
    	        }
    	      }
    	      return tokenizer.nextToken();
    	    }
    		public long nextLong() {
    		      return Long.parseLong(next());
    		    }
    	    public int nextInt() {
    	      return Integer.parseInt(next());
    	    }
    	  }
 
}