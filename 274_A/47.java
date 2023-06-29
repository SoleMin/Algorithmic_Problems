
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

//basically tried to understand ping's greedy alg
public class kMultRedo {
	static int n;
	static int k;
	public static void main(String[] args){
		Set<Integer> set = new TreeSet<Integer>();
		FastScanner s = new FastScanner();
		n = s.nextInt();
		k = s.nextInt();
		
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = s.nextInt();
		}
		Arrays.sort(a);
		
		for(int i=0; i<n; i++){
			if(a[i]%k !=0){
				set.add(a[i]);
			}else{
				if(!set.contains(a[i]/k)){
					set.add(a[i]);
				}
			}
		}
		
		System.out.println(set.size());
	}
	
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}
	}
}
