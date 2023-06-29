import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class CF268_TwoSets {

	public static void main(String[] args) {

		MyScanner in = new MyScanner();

		int N = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();

		int[] vals = new int[N];
		HashMap<Integer, Integer> val2Ind = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			vals[i] = in.nextInt();
			val2Ind.put(vals[i], i);
		}

		int[] setAssignment = new int[N];
		int[] friendA = new int[N];
		int[] friendB = new int[N];
		Arrays.fill(setAssignment, -1);
		Arrays.fill(friendA, -1);
		Arrays.fill(friendB, -1);

		// Mark partners
		for (int i = 0; i < N; i++) {
			Integer friendAInd = val2Ind.get(a - vals[i]);
			if (friendAInd != null) {
				friendA[i] = friendAInd;
			}

			Integer friendBInd = val2Ind.get(b - vals[i]);
			if (friendBInd != null) {
				friendB[i] = friendBInd;
			}
		}

		// Find those with only one friend
		Queue<Integer> toProc = new ArrayDeque<Integer>();
		for (int i = 0; i < N; i++) {
			int friends = 0;
			if (friendA[i] != -1) {
				friends++;
			}
			if (friendB[i] != -1) {
				friends++;
			}
			if (friends == 1) {
				toProc.add(i);
			}
		}

		// Process the one frienders
		while (!toProc.isEmpty()) {

			int ind = toProc.poll();

			if (setAssignment[ind] != -1) {
				continue;
			}

			if (friendA[ind] != -1) {

				int other = friendA[ind];
				if (setAssignment[other] == -1) {
					setAssignment[ind] = 0;
					setAssignment[other] = 0;
					// Check other's friend
					if (friendB[other] != -1) {
						int otherOther = friendB[other];
						friendB[otherOther] = -1;
						toProc.add(otherOther);
					}
				} else {
					System.out.println("NO");
					return;
				}

			}

			else if (friendB[ind] != -1) {

				int other = friendB[ind];
				if (setAssignment[other] == -1) {
					setAssignment[ind] = 1;
					setAssignment[other] = 1;
					// Check other's friend
					if (friendA[other] != -1) {
						int otherOther = friendA[other];
						friendA[otherOther] = -1;
						toProc.add(otherOther);
					}
				} else {
					System.out.println("NO");
					return;
				}

			}

			else {
				System.out.println("NO");
				return;
			}

		}
		
		
		// Process those with two friends
		for(int i = 0; i < N; i++) {
			
			if(setAssignment[i] != -1) {
				continue;
			}
			
			if(friendA[i] == -1 && friendB[i] == -1) {
				System.out.println("NO");
				return;
			}
			
			// Only possibility should now be that both friends are possible
			setAssignment[i] = 0;
			setAssignment[friendA[i]] = 0;
		}
		
		// Print the result
		System.out.println("YES");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(setAssignment[i]);
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

}
