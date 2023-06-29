

import java.util.*;
import java.io.*;
import java.awt.Point;
import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Math.*;

// Solution is at the bottom of code

public class _____A implements Runnable{
	
	final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	
	BufferedReader in;
	OutputWriter out;
	StringTokenizer tok = new StringTokenizer("");
	
	public static void main(String[] args){
		new Thread(null, new _____A(), "", 128 * (1L << 20)).start();
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
		int x = readInt();
		int y = readInt();
		return new Point(x, y);
	}
	
	Point[] readPointArray(int size) throws IOException{
		Point[] array = new Point[size];
		
		for (int index = 0; index < size; ++index){
			array[index] = readPoint();
		}
		
		return array;
	}
	
	/////////////////////////////////////////////////////////////////////
	
	List<Integer>[] readGraph(int vertexNumber, int edgeNumber)
	throws IOException{
		List<Integer>[] graph = new List[vertexNumber];
		
		for (int index = 0; index < vertexNumber; ++index){
			graph[index] = new ArrayList<Integer>();
		}
		
		while (edgeNumber-- > 0){
			int from = readInt() - 1;
			int to = readInt() - 1;
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		return graph;
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
	int[][] steps8 = {
			{-1, 0}, {1, 0}, {0, -1}, {0, 1},
			{-1, -1}, {1, 1}, {1, -1}, {-1, 1}
	};
	
	boolean check(int index, int lim){
		return (0 <= index && index < lim);
	}
	
	/////////////////////////////////////////////////////////////////////
	
	boolean checkBit(int mask, int bitNumber){
		return (mask & (1 << bitNumber)) != 0;
	}
	
	/////////////////////////////////////////////////////////////////////
	
	long md = (1000 * 1000 * 1000 + 9);
	
	void solve() throws IOException{
		int n = readInt();
		int m = readInt();
		int k = readInt();
		
		long count = n / k;
		long mod = n % k;
		
		long maxM = count * (k - 1) + mod;
		if (maxM >= m) {
			out.println(m % md);
			return;
		}
		
		long d = m - maxM;
		long mul = (binpow(2, d) - 1 + md) % md * 2 % md;
		
		long ans = (mul * k) % md;
		ans = (ans + ((count - d) * (k - 1) % md + md) % md + mod) % md;
		
		out.println(ans);
	}
	
	long binpow(long a, long n) {
		if (n == 0) return 1;
		if ((n & 1) == 0) {
			long b = binpow(a, n >> 1);
			return (b * b) % md;
		} else {
			return binpow(a, n - 1) * a % md;
		}
	}
}

