import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class CF113_Div2_A implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok;
	
	final boolean ONLINE_JUDGE = (System.getProperty("ONLINE_JUDGE") != null);

	public static void main(String[] args) {
		new Thread(null, new CF113_Div2_A(), "", 256 * (1L << 20)).start();
	}

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
			Locale.setDefault(Locale.US);
			tok = new StringTokenizer("");
			solve();
			in.close();
			out.close();
			long endTime = System.currentTimeMillis();
			System.err.println("Time = " + (endTime - startTime));
			long freeMemory = Runtime.getRuntime().freeMemory();
			long totalMemory = Runtime.getRuntime().totalMemory();
			System.err.println("Memory = " + ((totalMemory - freeMemory) >> 10));
		} catch (Throwable t) {
			t.printStackTrace(System.err);
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

	/** http://pastebin.com/j0xdUjDn */
	static class Utils {

		private Utils() {}

		public static void mergeSort(int[] a) {
			mergeSort(a, 0, a.length - 1);
		}

		private static final int MAGIC_VALUE = 50;

		private static void mergeSort(int[] a, int leftIndex, int rightIndex) {
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
	
	void debug(Object... o) {
		if (!ONLINE_JUDGE) {
			System.err.println(Arrays.deepToString(o));
		}
	}

	// solution

	class Team implements Comparable<Team>{
		int cnt, time;

		public Team(int cnt, int time) {
			this.cnt = cnt;
			this.time = time;
		}

		@Override
		public int compareTo(Team x) {
			if (cnt == x.cnt) return time - x.time;
			return x.cnt - cnt;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + cnt;
			result = prime * result + time;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Team other = (Team) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (cnt != other.cnt)
				return false;
			if (time != other.time)
				return false;
			return true;
		}

		private CF113_Div2_A getOuterType() {
			return CF113_Div2_A.this;
		}
		
		
		
	}
	
	void solve() throws IOException {
		int n = readInt();
		int k = readInt();
		k--;
		Team[] a = new Team[n];
		for (int i =0 ; i < n; i++) {
			a[i] = new Team(readInt(), readInt());
		}
		Arrays.sort(a);
		int res = 1;
		for (int i = k-1; i >= 0; i--) {
			if (a[k].equals(a[i])) res++;
		}
		for (int i = k+1; i < n; i++) {
			if (a[k].equals(a[i])) res++;
		}
		out.print(res);
		
	}

}