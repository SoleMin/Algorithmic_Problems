import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String t = scanner.nextLine();
		String p = scanner.nextLine();
		int i, j, count = 0;
		int n = t.length(), m = p.length();
		int[] pi = new int[m];
		
		for(i = 1, j = 0; i < m; i++) {
			while(j > 0 && p.charAt(i) != p.charAt(j))
				j = pi[j - 1];
			if (p.charAt(i) == p.charAt(j))
				pi[i] = ++j;
		}
		
		for(i = j = 0; i < n; i++) {
			while(j > 0 && t.charAt(i) != p.charAt(j))
				j = pi[j - 1];
			if(t.charAt(i) == p.charAt(j)) {
				if (j++ == m - 1) {
					count++;
					sb.append(i - m + 2 + " ");
					j = pi[j - 1];
				}
			}
		}
		System.out.print(count + "\n" + sb.toString());
	}
}