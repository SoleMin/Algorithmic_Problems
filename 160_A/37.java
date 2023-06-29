import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AA implements Runnable {
	public static void main(String[] args) {
		new Thread(new AA()).run();

	}

	static class Utils {

		private Utils() {
		}

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

		private static void merge(int[] a, int leftIndex, int middleIndex,
				int rightIndex) {
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
					a[k] = leftArray[i] <= rightArray[j] ? leftArray[i++]
							: rightArray[j++];
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

	BufferedReader br;
	StringTokenizer str = new StringTokenizer("");
	PrintWriter pw;

	public Integer ni() {
		return Integer.parseInt(nextToken());
	}

	public Double nd() {
		return Double.parseDouble(nextToken());
	}

	public Long nl() {
		return Long.parseLong(nextToken());
	}

	public boolean EOF() {
		try {
			if (!br.ready() && !str.hasMoreTokens()) {
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public String nextToken() {
		while (!str.hasMoreTokens())
			try {
				str = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return str.nextToken();

	}

	@Override
	public void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new OutputStreamWriter(System.out));
		// try {
		// br = new BufferedReader(new FileReader("input.txt"));
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
		// try {
		// pw = new PrintWriter(new FileWriter("output.txt"));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		solve();
		pw.close();
	}

	public void solve() {

		int n = ni();
		int[] a = new int[n];
		int total = 0;
		for (int i = 0; i < n; i++) {
			a[i] = ni();
			total+=a[i];
		}
		Arrays.sort(a);
		int c =0;
		int left=0;
		for(int i=n-1; i>=0;i--){
			if (left<=total){
				c++;
				left+=a[i];
				total-=a[i];
			}
		}
		pw.print(c);
	}
}