/*
     * Code Author: Akshay Miterani
     * DA-IICT
     */
    import java.io.*;
    import java.util.*;
    
     
    public class MainY {
     
    	static double eps=(double)1e-6;
    	static long mod=(int)1e9+7;
    	static boolean f=true;
    	public static void main(String args[]){
    		InputReader in = new InputReader(System.in);
    		OutputStream outputStream = System.out;
    		PrintWriter out = new PrintWriter(outputStream);
    		//----------My Code Starts Here----------
    		long n=in.nextLong();
    		if(n==1){
    			System.out.println("5");
    		}
    		else{
    			System.out.println("25");
    		}
    		out.close();
    		//---------------The End------------------
    	}
    	
    	static class Pair implements Comparable<Pair>{
    		int r1=-1;
    		int r2=-1;
    		int extra=0;
			@Override
			public int compareTo(Pair arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
    	}
    	
    	static class InputReader {
    	    public BufferedReader reader;
    	    public StringTokenizer tokenizer;
     
    	    public InputReader(InputStream inputstream) {
    	      reader = new BufferedReader(new InputStreamReader(inputstream));
    	      tokenizer = null;
    	    }
    	    
    	    public String nextLine(){
    	    	String fullLine=null;
    	    	while (tokenizer == null || !tokenizer.hasMoreTokens()) {
    	            try {
    	              fullLine=reader.readLine();
    	            } catch (IOException e) {
    	              throw new RuntimeException(e);
    	            }
    	            return fullLine;
    	          }
    	          return fullLine;
    	    }
    		public String next() {
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