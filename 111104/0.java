/*
input 1
65 87
433 789
71 790
361 803
80 822
331 910

output 1
5

input 2
5 5 
10 15
1 21
8 22
9 23

output 2
4
*/

import java.io.*;
import java.util.*;

class Main {
	static final int INF = Integer.MAX_VALUE / 2;
	
	static class Pair implements Comparable<Pair> {
		int x, y;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Pair p) {
			return y - p.y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Pair> p_list = new ArrayList<>();
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p_list.add(new Pair(x, y));
		}
		Collections.sort(p_list);
		int[] dp = new int[p_list.size() + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (Pair p : p_list) {
			for (int i = dp.length - 2; i >= 0; i--) {
				if (dp[i] + p.x <= p.y) {
					dp[i + 1] = Math.min(dp[i + 1], dp[i] + p.x);
				}
			}
		}
		int ans = -1;
		for (int i = dp.length - 1; i >= 0; i--) {
			if (dp[i] != INF) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
		
		br.close();
	}
}