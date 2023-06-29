import java.io.*;
import java.util.*;


public class encryption {
		public static void main (String [] args) throws IOException{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(System.out);
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt((st.nextToken()));
			int p = Integer.parseInt(st.nextToken());
			int [] nums = new int [100000];
			long ans = 0;
			long fulltotal = 0;
			long total = 0;
			int currentTotal = 0;
			st = new StringTokenizer(f.readLine());
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				total += nums[i];
			}
			for (int i = 0; i < n - 1;i++) {
				int newnum = nums[i];
				currentTotal += newnum;
				fulltotal = (((total - currentTotal) % p) + (currentTotal % p));
				ans = Math.max(ans, fulltotal);
				
			}
			out.println(ans);
			out.close();
		}

}
