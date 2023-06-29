import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader();
		int n = in.nextInt();
		long k = in.nextInt();
		Long[] a = new Long[n];
		for(int i = 0 ; i < n;i++)a[i]=in.nextLong();
		if(k==1)System.out.println(n);
		else{
			int res = 0;
			Arrays.sort(a);
			boolean[] v = new boolean[n];
			for(int i = 0 ; i < n;i++){
				if(!v[i]){
					long cur = a[i];
					int cnt = 1;
					while(true){
						int idx = Arrays.binarySearch(a, cur*k);
						if(idx<0){
							res+= cnt/2 + cnt%2;
							break;
							}
						v[idx]=true;
						cur = a[idx];
						cnt++;
					}
				}
			}
			System.out.println(res);
		}
	}

	static class InputReader {
		BufferedReader in;
		StringTokenizer st;

		public InputReader() throws IOException {
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(in.readLine());
		}

		public String next() throws IOException {
			while (!st.hasMoreElements())
				st = new StringTokenizer(in.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}
}