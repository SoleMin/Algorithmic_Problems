import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		String[] num;
		while (t-- > 0) {
			br.readLine();
			num = br.readLine().split(" ");
			String start = num[0] + num[1] + num[2] + num[3];
			num = br.readLine().split(" ");
			String end = num[0] + num[1] + num[2] + num[3];;

			int n = Integer.parseInt(br.readLine());
			ArrayList<String> forbidden = new ArrayList<String>();
			for (int i = 0; i < n; ++i) {
				num = br.readLine().split(" ");
				forbidden.add(num[0] + num[1] + num[2] + num[3]);
			}

			Map<String, Integer> count = bfs(start, forbidden);
			if (count.containsKey(end))
				System.out.println(count.get(end));
			else
				System.out.println(-1);
		}
	}

	private static Map<String, Integer> bfs(String s, ArrayList<String> forbidden) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		Set<String> visited = new HashSet<String>();
		Deque<String> q = new LinkedList<String>();

		visited.add(s);
		count.put(s, 0);
		q.add(s);

		while (!q.isEmpty()) {
			String v = q.poll();

			for (int i = 0; i < 4; ++i) {
				char[] num = v.toCharArray();
				num[i] = num[i] > '0' ? (char) (num[i] - 1) : '9';
				String w = String.valueOf(num);

				if (!forbidden.contains(w) && !visited.contains(w)) {
					visited.add(w);
					int currcnt = count.get(v) + 1;
					count.put(w, currcnt);
					q.add(w);
				}

				num = v.toCharArray();
				num[i] = num[i] < '9' ? (char) (num[i] + 1) : '0';
				w = String.valueOf(num);

				if (!forbidden.contains(w) && !visited.contains(w)) {
					visited.add(w);
					int currcnt = count.get(v) + 1;
					count.put(w, currcnt);
					q.add(w);
				}
			}
		}
		return count;
	}
}