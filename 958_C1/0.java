import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.*;

public class t
{
	static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;
		public FastReader(){
			br = new BufferedReader(new
			InputStreamReader(System.in));
		}
		String next(){
			while (st == null || !st.hasMoreElements()){
				try{
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt(){
			return Integer.parseInt(next());
		}
		long nextLong(){
			return Long.parseLong(next());
		}
		double nextDouble(){
			return Double.parseDouble(next());
		}
		String nextLine()
		{
			String str = "";
			try{
				str = br.readLine();
			}
			catch (IOException e){
				e.printStackTrace();
			}
			return str;
		}
	}
	
	public static void main(String[] args){
		FastReader in=new FastReader();
		

		int n = in.nextInt();
		int p = in.nextInt();
		int[] ar = new int[n];
		int i;
		long sum=0;
		for(i=0;i<n;i++) {
			ar[i]=in.nextInt();
			sum+=ar[i];
		}
		long ans = 0;
		for(i=0;i<n;i++) {
			long nu = ar[i];
			long nn = (sum-nu);
			long an = (nu%p)+(nn%p);
			ans=Math.max(ans, an);
		}
		System.out.println(ans);

        
	}
	
}