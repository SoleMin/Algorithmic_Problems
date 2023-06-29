import java.io.*;
import java.util.*;
import java.math.*;

public class Task15a {

	public static class House implements Comparable<House>{
		int x, s;

		public House(int x, int s) {
			super();
			this.x = x;
			this.s = s;
		}

		public int compareTo(House o) {
			return x - o.x;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt() * 2;
		House[] hs = new House[n];
		for (int i = 0; i < n; i++){
			hs[i] = new House(sc.nextInt()*2, sc.nextInt());
		}
		Arrays.sort(hs);
		int res = 2;
		for (int i = 0; i < n - 1; i++) {
			int curr = hs[i+1].x - hs[i].x - hs[i+1].s - hs[i].s;
			if (curr > t) res += 2;
			if (curr == t) res += 1;
		}
		System.out.println(res);
	}

}
