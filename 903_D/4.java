import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class D {
	
	public static class BIT {
		long[] dat;
		
		public BIT(int n){
			dat = new long[n + 1];
		}
		
		public void add(int k, long a){ // k : 0-indexed
			for(int i = k + 1; i < dat.length; i += i & -i){
				dat[i] += a;	
			}
		}
		
		public long sum(int s, int t){ // [s, t)
			if(s > 0) return sum(0, t) - sum(0, s);
			
			long ret = 0;
			for(int i = t; i > 0; i -= i & -i) {
				ret += dat[i];
			}
			return ret;
		}
	}
	
	public static void main(String[] args) {
		try (final Scanner sc = new Scanner(System.in)) {
			final int n = sc.nextInt();
			
			long[] array = new long[n];
			for(int i = 0; i < n; i++){ array[i] = sc.nextLong(); }
			
			TreeSet<Long> value_set = new TreeSet<Long>();
			for(int i = 0; i < n; i++){ value_set.add(array[i]); }
			ArrayList<Long> value_list = new ArrayList<Long>(value_set);
			
			BigInteger answer = BigInteger.ZERO;
			final int bit_n = value_list.size();
			BIT cnt_bit = new BIT(bit_n);
			BIT val_bit = new BIT(bit_n);
			
			for(int i = n - 1; i >= 0; i--){
				final long value = array[i];
				final int value_index = Collections.binarySearch(value_list, value);
				
				int upper_pos = Collections.binarySearch(value_list, value + 2);
				if(upper_pos < 0){ upper_pos = (-upper_pos) - 1; }
				if(0 <= upper_pos && upper_pos < bit_n){
					final long upper_sum = val_bit.sum(upper_pos, bit_n) - cnt_bit.sum(upper_pos, bit_n) * value;
					answer = answer.add(BigInteger.valueOf(upper_sum));
				}
				
				int lower_pos = Collections.binarySearch(value_list, value - 2);
				if(lower_pos < 0){ lower_pos = (-lower_pos) - 2; }
				if(0 <= lower_pos && lower_pos < bit_n){
					final long lower_sum = val_bit.sum(0, lower_pos + 1) - cnt_bit.sum(0, lower_pos + 1) * value;
					answer = answer.add(BigInteger.valueOf(lower_sum));
				}
				
				cnt_bit.add(value_index, 1);
				val_bit.add(value_index, value);
				//System.out.println(answer);
			}
			
			System.out.println(answer);
		}
	}
	
	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;

		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		private void getLine() {
			try {
				while (!hasNext()) {
					tok = new StringTokenizer(br.readLine());
				}
			} catch (IOException e) { /* ignore */
			}
		}

		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}

		public String next() {
			getLine();
			return tok.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}

		public void close() {
			try {
				br.close();
			} catch (IOException e) { /* ignore */
			}
		}
	}
}
