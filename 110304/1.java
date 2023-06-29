import java.io.*;
import java.util.*;

class Main {
	static final char[] fox = "the quick brown fox jumps over the lazy dog".toCharArray();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		br.readLine();
		while (T-- > 0) {
			List<char[]> s_list = new ArrayList<>();
			while (true) {
				String line = br.readLine();
				if (line == null || line.length() == 0) {
					break;
				}
				s_list.add(line.toCharArray());
			}
			Map<Character, Character> map1 = new HashMap<>();
			Map<Character, Character> map2 = new HashMap<>();
			for (char[] S : s_list) {
				if (S.length != fox.length) {
					continue;
				}
				map1.put(' ', ' ');
				map2.put(' ', ' ');
				boolean flag = true;
				for (int i = 0; i < S.length; i++) {
					if ((!map1.containsKey(S[i]) && !map2.containsKey(fox[i])) || (map1.containsKey(S[i]) && map2.containsKey(fox[i]) && map1.get(S[i]) == fox[i] && map2.get(fox[i]) == S[i])) {
						map1.put(S[i], fox[i]);
						map2.put(fox[i], S[i]);
					} else {
						flag = false;
						break;
					}
				}
				if (flag) {
					break;
				}
				map1.clear();
				map2.clear();
			}
			if (map1.isEmpty()) {
				out.append("No solution.\n\n");
				continue;
			}
			for (char[] S : s_list) {
				for (int i = 0; i < S.length; i++) {
					out.append(map1.get(S[i]));
				}
				out.append('\n');
			}
			out.append('\n');
		}
		out.deleteCharAt(out.length() - 1);
		
		System.out.print(out);
		
		br.close();
	}
}