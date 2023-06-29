import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
public class G {
 	private static FastScanner fs=new FastScanner();
	public static void main(String[] args) {
		
		

			int n = fs.nextInt(),k = fs.nextInt();
			int a[] = fs.readArray(n);
			int b[] = fs.readArray(n);

			// From 1 to n-k+1 we can use technique
			// we can use it for j minutes 
			// j is from i tp i+k -1;
			// 

			long max = Integer.MIN_VALUE;
			long sol =0;
			int pre[] = new int[n+1];
			int prev =0;

			if(b[0]==0)
			{ 
				pre[1] = a[0];
				
			}

			for(int i=1;i<n;i++)
			{
				if(b[i]==0)
				{
					pre[i+1] += a[i];
					pre[i+1] +=pre[i];
				}
				else pre[i+1] = pre[i];
			}

			for(int i=n-1;i>=0;i--)
			{
				long sum =0;
					if(i-k+1>=0)
					{
						// for(int j=i;j>=(i-k+1);j--)
						// {
						// if(b[j]==0) dp[i][1] += a[j];
						// }
						sum +=(pre[i+1]-pre[i-k+1]);	
					}
					else
					{
						// for(int j=i;j>=0;j--)
						// {
						// 	if(b[j]==0) dp[i][0] +=a[j];
						// }
						sum +=(pre[i+1]-pre[0]);
					}
					
					if(sum>max) 
					{
						max = sum;
						
					}
					if(b[i]==1) sol +=a[i];
				
			}
			// System.out.println(max);
			sol += max;
			System.out.println(sol);
		}
	
 
	static final Random random=new Random();
	
	static void ruffleSort(long[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n); long temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}

	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		int [] sort(int [] arr)
		{
			List<Integer> list = new ArrayList<>();
			for(int i : arr) list.add(i);	
		
			Collections.sort(list);
			int res[] = new int[arr.length];
			for(int i=0;i<arr.length;i++) res[i] = list.get(i);
			

			return res;
		}
	}
 
	
}