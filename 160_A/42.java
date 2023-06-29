import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class A implements Runnable {
	
	final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok;
	
	@Override
	public void run() {
		try {
			long startTime = System.currentTimeMillis();
			if (ONLINE_JUDGE) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			} else {
				in = new BufferedReader(new FileReader("input.txt"));
				out = new PrintWriter("output.txt");
			}
			tok = new StringTokenizer("");
			Locale.setDefault(Locale.US);
			solve();
			in.close();
			out.close();
			long endTime = System.currentTimeMillis();
			long totalMemory = Runtime.getRuntime().totalMemory();
			long freeMemory = Runtime.getRuntime().freeMemory();
			System.err.println("Time = " + (endTime - startTime) + " ms");
			System.err.println("Memory = " + ((totalMemory - freeMemory) / 1024) + " KB");
		} catch (Throwable e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}
	
	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}
	
	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}
	
	long readLong() throws IOException {
		return Long.parseLong(readString());
	}
	
	double readDouble() throws IOException {
		return Double.parseDouble(readString());
	}
	
	void debug(Object... o) {
		if (!ONLINE_JUDGE) {
			System.err.println(Arrays.deepToString(o));
		}
	}
	
	public static void main(String[] args) {
		new Thread(null, new A(), "", 256 * 1024 * 1024).start();
	}

	static class Utils {

		private Utils() {}

		public static void mergeSort(int[] a) {
			mergeSort(a, 0, a.length - 1);
		}

		private static void mergeSort(int[] a, int leftIndex, int rightIndex) {
			final int MAGIC_VALUE = 50;
			if (leftIndex < rightIndex) {
				if (rightIndex - leftIndex <= MAGIC_VALUE) {
					insertionSort(a, leftIndex, rightIndex);
				} else {
					int middleIndex = (leftIndex + rightIndex) / 2;
					mergeSort(a, leftIndex, middleIndex);
					mergeSort(a, middleIndex + 1, rightIndex);
					merge(a, leftIndex, middleIndex, rightIndex);
				}
			}
		}

		private static void merge(int[] a, int leftIndex, int middleIndex, int rightIndex) {
			int length1 = middleIndex - leftIndex + 1;
			int length2 = rightIndex - middleIndex;
			int[] leftArray = new int[length1];
			int[] rightArray = new int[length2];
			System.arraycopy(a, leftIndex, leftArray, 0, length1);
			System.arraycopy(a, middleIndex + 1, rightArray, 0, length2);
			for (int k = leftIndex, i = 0, j = 0; k <= rightIndex; k++) {
				if (i == length1) {
					a[k] = rightArray[j++];
				} else if (j == length2) {
					a[k] = leftArray[i++];
				} else {
					a[k] = leftArray[i] <= rightArray[j] ? leftArray[i++] : rightArray[j++];
				}
			}
		}

		private static void insertionSort(int[] a, int leftIndex, int rightIndex) {
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				int current = a[i];
				int j = i - 1;
				while (j >= leftIndex && a[j] > current) {
					a[j + 1] = a[j];
					j--;
				}
				a[j + 1] = current;
			}
		}

	}
	
//------------------------------------------------------------------------------
	
	void solve() throws IOException {
		int n = readInt();
		int[] a = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
			sum += a[i];
		}
		Utils.mergeSort(a);
		int s = 0, c = 0;
		for (int i = n-1; i >= 0; i--) {
			s += a[i];
			c++;
			if (2 * s > sum) {
				break;
			}
		}
		out.println(c);
		
	}
	
}
