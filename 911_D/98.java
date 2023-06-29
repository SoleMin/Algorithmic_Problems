import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.InputStream;

public class BuildIn {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }
    public static void solve(InputReader in, PrintWriter out) throws IOException
    {
    	int n = in.nextInt();
    	int[] list = new int[n];
    	for(int i = 0; i < n; i++)
    	{
    		list[i]=in.nextInt();
    	}
    	
    	int count = 0;
    	for(int i = 0; i < n-1; i++)
    	{
    		for(int j = i+1; j < n; j++)
    		{
    			if(list[j]<list[i])
    			{
    				count++;
    			}
    		}
    	}
    	
    	boolean sta = true;
    	if(count%2==1) sta = false;
    	
    	int m =  in.nextInt();
    	for(int i = 0; i <m; i++)
    	{
    		int a = in.nextInt();
    		int b = in.nextInt();
    		if((b-a)%4==2) sta = !sta;
    		if((b-a)%4==1) sta = !sta;    		
    		if(sta) out.println("even");
    		else out.println("odd");
    	}
	}

	static class InputReader {
	        public BufferedReader reader;
	        public StringTokenizer tokenizer;

	        public InputReader(InputStream stream) {
	            reader = new BufferedReader(new InputStreamReader(stream), 32768);
	            tokenizer = null;
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

	        public int nextInt() {
	            return Integer.parseInt(next());
	        }
	        
	        public long nextLong() {
	        	return Long.parseLong(next());
	        }

	    }
}
