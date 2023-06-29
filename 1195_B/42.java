import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
 
 
public class q5 {
	
	
	
    
  
	
 
	public static void main(String[] args) throws IOException {
	
	Reader.init(System.in);
	PrintWriter out=new PrintWriter(System.out);
	long n=Reader.nextInt();
	long k=Reader.nextLong();
	long v=8*n+8*k+4;
	long v2=(long) Math.sqrt(v);
	long v3=2*n+2;
	//long v4=(v3+v2)/2;
	long v5=(v3-v2)/2;
	out.println(v5);
	
	
	
	
	
	out.flush();
	}
}




 
 
 
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    /** call this method to initialize reader for InputStream */
    static void init() throws IOException {
    	 reader = new BufferedReader(
                 new FileReader("detect.in"));
    tokenizer = new StringTokenizer("");
    }
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
    /** get next word */
    static String nextLine() throws IOException{
    	return reader.readLine();
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}