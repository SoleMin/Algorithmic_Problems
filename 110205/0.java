import java.io.*;
import java.util.*;

class Main {
	static String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static String[] rank = { "Jack", "Queen", "King", "Ace" };
	
	public static String intToCard(int x) {
		StringBuilder sb = new StringBuilder();
		sb.append(x % 20 < 11 ? x % 20 : rank[x % 20 - 11]).append(" of ").append(suit[x / 20]);
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		br.readLine();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] A = new int[N][52];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 52; j++) {
					while (!st.hasMoreTokens()) {
						st = new StringTokenizer(br.readLine());
					}
					A[i][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
			int[] B = new int[52];
			int[] C = new int[52];
			for (int i = 0; i < 4; i++) {
				for (int j = 2; j < 15; j++) {
					B[i * 13 + j - 2] = i * 20 + j;
				}
			}
			while (true) {
				String line = br.readLine();
				if (line == null || line.length() == 0) {
					break;
				}
				int K = Integer.parseInt(line) - 1;
				for (int i = 0; i < 52; i++) {
					C[i] = B[A[K][i]];
				}
				System.arraycopy(C, 0, B, 0, 52);
			}
			for (int i = 0; i < 52; i++) {
				out.append(intToCard(B[i])).append('\n');
			}
			out.append('\n');
		}
		out.deleteCharAt(out.length() - 1);
		
		System.out.print(out);
		br.close();
	}
}