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
			char[] S = line.toCharArray();
			int x, y;
			x = y = 0;
			for (int i = 0; i < S.length; i++) {
				if (S[i] != ' ' && S[i] != '\t') {
					x++;
					if (i == 0 || S[i - 1] == ' ' || S[i - 1] == '\t') {
						y++;
					}
				}
			}
			out.append(x).append(' ').append(y).append('\n');
		}
		
		System.out.print(out);
		br.close();
	}
}