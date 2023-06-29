import java.io.*;
import java.util.*;

class Main {
	static class Tuple implements Comparable<Tuple> {
		int x, y, idx;
		
		Tuple(int x, int y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
		
		public int compareTo(Tuple t) {
			return t.x - x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		List<Tuple> t_list = new ArrayList<>();
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			t_list.add(new Tuple(x, y, t_list.size() + 1));
		}
		Collections.sort(t_list);
		int[] dp = new int[t_list.size()];
		int[] dp2 = new int[t_list.size()];
		Arrays.fill(dp, 1);
		Arrays.fill(dp2, -1);
		for (int i = 1; i < t_list.size(); i++) {
			Tuple ti = t_list.get(i);
			for (int j = 0; j < i; j++) {
				Tuple tj = t_list.get(j);
				if (tj.x > ti.x && tj.y < ti.y) {
					if (dp[i] < dp[j] + 1 || (dp[i] == dp[j] + 1 && t_list.get(dp2[i]).idx > tj.idx)) {
						dp[i] = dp[j] + 1;
						dp2[i] = j;
					}
				}
			}
		}
		int max = -1;
		for (int i = dp.length - 1; i >= 0; i--) {
			if (max == -1 || dp[max] < dp[i]) {
				max = i;
			}
		}
		List<Integer> ans = new ArrayList<>();
		while (max != -1) {
			ans.add(t_list.get(max).idx);
			max = dp2[max];
		}
		out.append(ans.size()).append('\n');
		for (int x : ans) {
			out.append(x).append('\n');
		}
		
		System.out.print(out);
		
		br.close();
	}
}