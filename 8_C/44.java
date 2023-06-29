

import java.util.*;
import java.io.*;
import java.awt.Point;
import java.math.BigInteger;

import static java.lang.Math.*;

// Solution is at the bottom of code

public class ProblemC_008 implements Runnable{
	
	final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	
	BufferedReader in;
	OutputWriter out;
	StringTokenizer tok = new StringTokenizer("");
	
	public static void main(String[] args){
		new Thread(null, new ProblemC_008(), "", 128 * (1L << 20)).start();
	}
	
	/////////////////////////////////////////////////////////////////////
	
	void init() throws FileNotFoundException{
		Locale.setDefault(Locale.US);
		
		if (ONLINE_JUDGE){
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new OutputWriter(System.out);
		}else{
			in = new BufferedReader(new FileReader("input.txt"));
			out = new OutputWriter("output.txt");
		}
	}
	
	////////////////////////////////////////////////////////////////
	
	long timeBegin, timeEnd;

	void time(){
		timeEnd = System.currentTimeMillis();
		System.err.println("Time = " + (timeEnd - timeBegin));
	}
	
	void debug(Object... objects){
		if (ONLINE_JUDGE){
			for (Object o: objects){
				System.err.println(o.toString());
			}
		}
	}
	
	/////////////////////////////////////////////////////////////////////
	
	public void run(){
		try{
			timeBegin = System.currentTimeMillis();
			Locale.setDefault(Locale.US);
			
			init();
			solve();
			
			out.close();
			time();
		}catch (Exception e){
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}
	
	/////////////////////////////////////////////////////////////////////
	
	String delim = " ";
	
	String readString() throws IOException{
		while(!tok.hasMoreTokens()){
			try{
				tok = new StringTokenizer(in.readLine());
			}catch (Exception e){
				return null;
			}
		}
		
		return tok.nextToken(delim);
	}
	
	String readLine() throws IOException{
		return in.readLine();
	}
	
	/////////////////////////////////////////////////////////////////
	
	final char NOT_A_SYMBOL = '\0';
	
	char readChar() throws IOException{
		int intValue = in.read();
		
		if (intValue == -1){
			return NOT_A_SYMBOL;
		}
		
		return (char) intValue;
	}
	
	char[] readCharArray() throws IOException{
		return readLine().toCharArray();
	}
	
	/////////////////////////////////////////////////////////////////
	
	int readInt() throws IOException{
		return Integer.parseInt(readString());
	}
	
	int[] readIntArray(int size) throws IOException{
		int[] array = new int[size];
		
		for (int index = 0; index < size; ++index){
			array[index] = readInt();
		}
		
		return array;
	}
	
	///////////////////////////////////////////////////////////////////
	
	long readLong() throws IOException{
		return Long.parseLong(readString());
	}
	
	long[] readLongArray(int size) throws IOException{
		long[] array = new long[size];
		
		for (int index = 0; index < size; ++index){
			array[index] = readLong();
		}
		
		return array;
	}
	
	////////////////////////////////////////////////////////////////////
	
	double readDouble() throws IOException{
		return Double.parseDouble(readString());
	}
	
	double[] readDoubleArray(int size) throws IOException{
		double[] array = new double[size];
		
		for (int index = 0; index < size; ++index){
			array[index] = readDouble();
		}
		
		return array;
	}
	
	/////////////////////////////////////////////////////////////////////
	
	Point readPoint() throws IOException{
		return new Point(readInt(), readInt());
	}
	
	Point[] readPointArray(int size) throws IOException{
		Point[] array = new Point[size];
		
		for (int index = 0; index < size; ++index){
			array[index] = readPoint();
		}
		
		return array;
	}
	
	/////////////////////////////////////////////////////////////////////
	
	class OutputWriter extends PrintWriter{

		final int DEFAULT_PRECISION = 12;
		
		int precision;
		String format, formatWithSpace;
		
		{
			precision = DEFAULT_PRECISION;
			
			format = createFormat(precision);
			formatWithSpace = format + " ";
		}
		
		public OutputWriter(OutputStream out) {
			super(out);
		}

		public OutputWriter(String fileName) throws FileNotFoundException {
			super(fileName);
		}
		
		public int getPrecision() {
			return precision;
		}

		public void setPrecision(int precision) {
			this.precision = precision;
			
			format = createFormat(precision);
			formatWithSpace = format + " ";
		}
		
		private String createFormat(int precision){
			return "%." + precision + "f";
		}
		
		@Override
		public void print(double d){
			printf(format, d);
		}
		
		public void printWithSpace(double d){
			printf(formatWithSpace, d);
		}

		public void printAll(double...d){
			for (int i = 0; i < d.length - 1; ++i){
				printWithSpace(d[i]);
			}
			
			print(d[d.length - 1]);
		}
		
		@Override
		public void println(double d){
			printlnAll(d);
		}
		
		public void printlnAll(double... d){
			printAll(d);
			println();
		}
	}
	
	/////////////////////////////////////////////////////////////////////
	
	int[][] steps = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
	
	boolean check(int index, int lim){
		return (0 <= index && index < lim);
	}
	
	/////////////////////////////////////////////////////////////////////
	
	void solve() throws IOException{
		Point bag = readPoint();
		
		int n = readInt();
		
		Point[] points = new Point[n];
		
		for (int i = 0; i < n; ++i){
			points[i] = readPoint();
		}
		
		int[] dist = new int[n];
		for (int i = 0; i < n; ++i){
			int dx = points[i].x - bag.x;
			int dy = points[i].y - bag.y;
			
			dist[i] = dx * dx + dy * dy;
		}
		
		int[][] d = new int[n][n];
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n; ++j){
				int dx = points[i].x - points[j].x;
				int dy = points[i].y - points[j].y;
				
				d[i][j] = dx * dx + dy * dy;
				d[i][j] += dist[i] + dist[j];
			}
		}
		
		int[] singleMasks = new int[n];
		for (int i = 0; i < n; ++i){
			singleMasks[i] = (1 << i);
		}
		
		int[][] doubleMasks = new int[n][n];
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n; ++j){
				doubleMasks[i][j] = (singleMasks[i] | singleMasks[j]);
			}
		}
		
		int lim = (1 << n);
		int[] dp = new int[lim];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		int[] p = new int[lim];
		Arrays.fill(p, -1);
		
		for (int mask = 0; mask < lim; ++mask){
			if (dp[mask] == Integer.MAX_VALUE){
				continue;
			}
			
			int minBit = -1;
			
			for (int bit = 0; bit < n; ++bit){
				if (checkBit(mask, bit)) continue;
				
				if (minBit == -1 || (dist[minBit] > dist[bit])){
					minBit = bit;
				}
			}
			
			if (minBit == -1){
				continue;
			}
			
			for (int bit = 0; bit < n; ++bit){
				if (checkBit(mask, bit)) continue;
				
				int newMask = (mask | (1 << minBit) | (1 << bit));
				
				if (dp[newMask] > dp[mask] + d[minBit][bit]){
					dp[newMask] = dp[mask] + d[minBit][bit];
					p[newMask] = minBit * n + bit;
				}
			}
		}
		
		out.println(dp[lim-1]);
		
		int curMask = lim - 1;
		while (p[curMask] != -1){
			out.print("0 ");
			
			int first = p[curMask] / n;
			int second = p[curMask] % n;
			
			out.print((first + 1) + " ");
			curMask ^= (1 << first);
			
			if (first != second){
				out.print((second + 1) + " ");
				curMask ^= (1 << second);
			}
		}
		
		out.println("0");
	}

	private boolean checkBit(int mask, int bitNumber) {
		return (mask & (1 << bitNumber)) != 0;
	}
	
	boolean checkMask(int mask, int innerMask){
		return (mask & innerMask) == innerMask;
	}
}

