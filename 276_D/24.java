/* Codeforces Template */

import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.fill;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class Main {
	
	static long initTime;
	static final Random rnd = new Random(7777L);
	static boolean writeLog = false;
	
	public static void main(String[] args) throws IOException {
		initTime = System.currentTimeMillis();
		try {
			writeLog = "true".equals(System.getProperty("LOCAL_RUN_7777"));
		} catch (SecurityException e) {}
		new Thread(null, new Runnable() {
			public void run() {
				try {
					try {
						if (new File("input.txt").exists())
							System.setIn(new FileInputStream("input.txt"));
					} catch (SecurityException e) {}
					long prevTime = System.currentTimeMillis();
					new Main().run();
					log("Total time: " + (System.currentTimeMillis() - prevTime) + " ms");
					log("Memory status: " + memoryStatus());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "1", 1L << 24).start(); 
	}

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
		in.close();
	}
	
	/*************************************************************** 
	 * Solution
	 **************************************************************/

	void solve() throws IOException  {
		
		long leftBorder = nextLong();
		long rightBorder = nextLong();

		long[][][][][] dp = new long [64][2][2][2][2];
		for (long[][][][] a : dp) for (long[][][] b : a) for (long[][] c : b) for (long[] d : c) fill(d, -1L);
		
		dp[63][0][0][0][0] = 0L;
		
		for (int lastBit = 63; lastBit > 0; lastBit--) {
			
			int curBit = lastBit - 1;
			
			int leftBit = (int) ((leftBorder >> curBit) & 1L);
			int rightBit = (int) ((rightBorder >> curBit) & 1L);
			
			for (int agl = 0; agl < 2; agl++) {
				
				for (int alr = 0; alr < 2; alr++) {
						
					for (int bgl = 0; bgl < 2; bgl++) {
					
						for (int blr = 0; blr < 2; blr++) {
							
							long prvXor = dp[lastBit][agl][alr][bgl][blr];
							if (prvXor < 0L) continue;
							
							for (int ab = 0; ab < 2; ab++) {
								
								int nagl = left(agl, leftBit, ab);
								int nalr = right(alr, rightBit, ab);
								if (nagl < 0 || nalr < 0) continue;
								
								for (int bb = 0; bb < 2; bb++) {
									
									int nbgl = left(bgl, leftBit, bb);
									int nblr = right(blr, rightBit, bb);
									if (nbgl < 0 || nblr < 0) continue;
									
									long setBit = ab ^ bb;
									dp[curBit][nagl][nalr][nbgl][nblr] = max(dp[curBit][nagl][nalr][nbgl][nblr], prvXor | (setBit << curBit));
									
								}
								
							}							
							
						}
						
					}
					
				}
				
			}
			
		}
	
		long answer = -1L;
		
		for (int agl = 0; agl < 2; agl++) {
			
			for (int alr = 0; alr < 2; alr++) {
					
				for (int bgl = 0; bgl < 2; bgl++) {
				
					for (int blr = 0; blr < 2; blr++) {
						
						answer = max(answer, dp[0][agl][alr][bgl][blr]);
						
					}
				}
			}
		}
		
//		System.err.println(Long.toBinaryString(leftBorder));
//		System.err.println(Long.toBinaryString(rightBorder));
//		System.err.println(Long.toBinaryString(answer));
		
		out.println(answer);
	}

	int left(int gl, int leftBit, int b) {
		
		if (gl == 0) {
			
			if (b < leftBit) return -1;
			if (b == leftBit) return 0;
			if (b > leftBit) return 1;
			
		}
		
		return 1;
	}
	
	int right(int lr, int rightBit, int b) {
		
		if (lr == 0) {
			if (b < rightBit) return 1;
			if (b == rightBit) return 0;
			if (b > rightBit) return -1;
		}
		
		return 1;
	}

	/*************************************************************** 
	 * Input 
	 **************************************************************/
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	int[] nextIntArray(int size) throws IOException {
		int[] ret = new int [size];
		for (int i = 0; i < size; i++)
			ret[i] = nextInt();
		return ret;
	}
	
	long[] nextLongArray(int size) throws IOException {
		long[] ret = new long [size];
		for (int i = 0; i < size; i++)
			ret[i] = nextLong();
		return ret;
	}
	
	double[] nextDoubleArray(int size) throws IOException {
		double[] ret = new double [size];
		for (int i = 0; i < size; i++)
			ret[i] = nextDouble();
		return ret;
	}
	
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
	
	/*************************************************************** 
	 * Output 
	 **************************************************************/
	void printRepeat(String s, int count) {
		for (int i = 0; i < count; i++)
			out.print(s);
	}
	
	void printArray(int[] array) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}
	
	void printArray(long[] array) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}
	
	void printArray(double[] array) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}
	
	void printArray(double[] array, String spec) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.printf(Locale.US, spec, array[i]);
		}
		out.println();
	}
	
	void printArray(Object[] array) {
		if (array == null || array.length == 0)
			return;
		boolean blank = false;
		for (Object x : array) {
			if (blank) out.print(' '); else blank = true;
			out.print(x);
		}
		out.println();
	}
	
	@SuppressWarnings("rawtypes")
	void printCollection(Collection collection) {
		if (collection == null || collection.isEmpty())
			return;
		boolean blank = false;
		for (Object x : collection) {
			if (blank) out.print(' '); else blank = true;
			out.print(x);
		}
		out.println();
	}
	
	/*************************************************************** 
	 * Utility
	 **************************************************************/
	static String memoryStatus() {
		return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >> 20) + "/" + (Runtime.getRuntime().totalMemory() >> 20) + " MB";
	}
	
	static void checkMemory() {
		System.err.println(memoryStatus());
	}
	
	static long prevTimeStamp = Long.MIN_VALUE;
	
	static void updateTimer() {
		prevTimeStamp = System.currentTimeMillis();
	}
	
	static long elapsedTime() {
		return (System.currentTimeMillis() - prevTimeStamp);
	}
	
	static void checkTimer() {
		System.err.println(elapsedTime() + " ms");
	}
	
	static void chk(boolean f) {
		if (!f) throw new RuntimeException("Assert failed");
	}
	
	static void chk(boolean f, String format, Object ... args) {
		if (!f) throw new RuntimeException(String.format(format, args));
	}
	
	static void log(String format, Object ... args) {
		if (writeLog) System.err.println(String.format(Locale.US, format, args));
	}
}
