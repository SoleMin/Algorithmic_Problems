import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			char[] A = line.toCharArray();
			char[] B = br.readLine().toCharArray();
			int[] freq_A = new int[26];
			int[] freq_B = new int[26];
			for (int i = 0; i < A.length; i++) {
				freq_A[A[i] - 97]++;
			}
			for (int i = 0; i < B.length; i++) {
				freq_B[B[i] - 97]++;
			}
			for (int i = 0; i < 26; i++) {
				int cnt = Math.min(freq_A[i], freq_B[i]);
				while (cnt-- > 0) {
					out.append((char)(i + 97));
				}
			}
			out.append('\n');
		}
		
		System.out.print(out);
		
		br.close();
	}
}