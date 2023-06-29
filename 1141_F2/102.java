import java.util.*;
import java.io.*;

public class SameSumBlock {
	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = nextInt();
		int[] arr = new int[n];
		int[] pSum = new int[n];
		for(int i = 0; i< n; i++) {
			arr[i] = nextInt();
			if(i != 0)
				pSum[i] += pSum[i - 1];
			pSum[i] += arr[i];
		}
		ArrayList<Interval> sorted = new ArrayList<Interval>();
		for(int i = 0; i < n; i++)
			sorted.add(new Interval(pSum[i],0, i));
		for(int i = 1; i < n; i++) {
			for(int j = i; j < n; j++) {
				sorted.add(new Interval(pSum[j] - pSum[i - 1], i, j));
			}
		}
		sorted.sort(null);
		int i = 0;
		int max = 0, idx = 0, end = 0;
		while(i < sorted.size()) {
			int last = i;
			int curr = 1;
			int start = i;
			sorted.get(i).marked = true;
			while(i < sorted.size() - 1 && sorted.get(i).val == sorted.get(i + 1).val) {
				i++;
				if(sorted.get(i).l > sorted.get(last).r) {
					sorted.get(i).marked = true;
					curr++;
					last = i;
				}
			}
			if(curr > max) {
				max = curr;
				idx = start;
				end = i;
			}
			i++;
		}
		System.out.println(max);
		for(int j = idx; j <= end; j++) {
			if(sorted.get(j).marked)
				System.out.println(sorted.get(j).l + 1 + " " + (sorted.get(j).r + 1));
		}
	}

	public static String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				throw new IOException();
			tokenizer = new StringTokenizer(line);
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}
class Interval implements Comparable<Interval> {
	int val, l, r;
	boolean marked;
	public Interval(int val, int l, int r) {
		super();
		this.val = val;
		this.l = l;
		this.r = r;
	}

	@Override
	public int compareTo(Interval o) {
		if(val != o.val)
			return val - o.val;
		return r - o.r;
	}
	
}