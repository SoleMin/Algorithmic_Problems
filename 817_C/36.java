import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;

public class C{
	
	static long s;
	public static void main(String[] args)throws IOException {
		Reader.init(System.in);
		long n=Reader.nextLong();
		s=Reader.nextLong();
		long lo=1,hi=n,mid;
		while(lo<hi){
			mid=(lo+hi)/2;
			if(diff(mid)>=s)
				hi=mid;
			else
				lo=mid+1;
		}
		if(diff(lo)>=s)
			System.out.println(n-lo+1);
		else
			System.out.println(0);
	}
	
	static long diff(long n){
		String s=String.valueOf(n);
		int sum=0;
		
		for(int i=0;i<s.length();i++){
			
			sum+=Integer.parseInt(s.valueOf(s.charAt(i)));
		}
		return (n-sum);
	}
		
		
}


		
/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
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