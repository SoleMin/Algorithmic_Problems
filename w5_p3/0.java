import java.io.*;
import java.util.*;

class Main {
	public static int[] get_pi(char[] P) {
		int[] pi = new int[P.length];
		int j = 0;
		for (int i = 1; i < P.length; i++) {
			while (j > 0 && P[i] != P[j]) {
				j = pi[j - 1];
			}
			if (P[i] == P[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		int[] pi = get_pi(P);
		List<Integer> idx = new ArrayList<>();
		int j = 0;
		for (int i = 0; i < T.length; i++) {
			while (j > 0 && T[i] != P[j]) {
				j = pi[j - 1];
			}
			if (T[i] == P[j]) {
				if (++j == P.length) {
					idx.add(i - P.length + 2);
					j = pi[j - 1];
				}
			}
		}
		out.append(idx.size()).append('\n');
		for (int x : idx) {
			out.append(x).append(' ');
		}
		out.setCharAt(out.length() - 1, '\n');
		
		System.out.print(out);
		
		br.close();
	}
}