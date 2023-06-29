import java.io.*;
import java.util.*;

public class SuitAndTie {

	public static void main(String[] args) throws Exception{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(f.readLine());
		int[] a = new int[2*n];
		int[] first = new int[n];
		int[] second = new int[n];
		Pair[] p = new Pair[n];
		Arrays.fill(first, -1);
		StringTokenizer st = new StringTokenizer(f.readLine());
		for(int i = 0; i < 2*n; i ++) {
			a[i] = Integer.parseInt(st.nextToken());
			if(first[a[i] - 1] == -1) {
				first[a[i] - 1] = i;
			}
			else {
				second[a[i] - 1] = i;
			}
		}
		
		for(int i = 0; i < n; i ++) {
			p[i] = new Pair(first[i],second[i]);
		}
		
		Arrays.sort(p);
		
		boolean[] vis = new boolean[2*n];
		int ans = 0;
		for(int i = 0; i < n; i ++) {
			for(int j = p[i].x + 1; j < p[i].y; j ++) {
				if(!vis[j]) ans ++;
			}
			vis[p[i].x] = true;
			vis[p[i].y] = true;
		}
		System.out.println(ans);

	}
	static class Pair implements Comparable<Pair>{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair arg0) {
			return x - arg0.x;
		}
	}

}
