

import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.*;

public class A implements Runnable{
	
	final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");
	
	void init() throws FileNotFoundException{
		if (ONLINE_JUDGE){
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		}else{
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
		}
	}
	
	String readString() throws IOException{
		while(!tok.hasMoreTokens()){
			try{
				tok = new StringTokenizer(in.readLine());
			}catch (Exception e){
				return null;
			}
		}
		return tok.nextToken();
	}
	
	int readInt() throws IOException{
		return Integer.parseInt(readString());
	}
	
	long readLong() throws IOException{
		return Long.parseLong(readString());
	}
	
	double readDouble() throws IOException{
		return Double.parseDouble(readString());
	}
	
	public static void main(String[] args){
		new Thread(null, new A(), "", 128 * (1L << 20)).start();
	}
	
	long timeBegin, timeEnd;

	void time(){
		timeEnd = System.currentTimeMillis();
		System.err.println("Time = " + (timeEnd - timeBegin));
	}
	
	long memoryTotal, memoryFree;
	

	void memory(){
		memoryFree = Runtime.getRuntime().freeMemory();
		System.err.println("Memory = " + ((memoryTotal - memoryFree) >> 10) + " KB");
	}
	
	void debug(Object... objects){
		if (DEBUG){
			for (Object o: objects){
				System.err.println(o.toString());
			}
		}
	}
	
	public void run(){
		try{
			timeBegin = System.currentTimeMillis();
			memoryTotal = Runtime.getRuntime().freeMemory();
			init();
			solve();
			out.close();
			time();
			memory();
		}catch (Exception e){
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}
	
	boolean DEBUG = false;
	
	void solve() throws IOException{
		int n = readInt();
		
		int[] a = new int[n];
		Integer[] b = new Integer[n];
		for (int i = 0; i < n; ++i){
			a[i] = readInt();
			b[i] = a[i];
		}
		
		Arrays.sort(b);
		int count = 0;
		for (int i = 0; i < n; ++i){
			if (a[i] != b[i]){
				count++;
			}
		}
		
		if (count == 2 || count == 0){
			out.println("YES");
		}else{
			out.println("NO");
		}
	}
}

