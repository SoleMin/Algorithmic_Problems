import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		List<String> in = new ArrayList<>();
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			if (line.length() > 0 && line.charAt(0) != ' ' && !in.isEmpty()
					&& (in.size() == 1 || !in.get(in.size() - 2).equals("\n"))) {
				in.set(in.size() - 1, " ");
			}
			StringBuilder word = new StringBuilder();
			StringBuilder space = new StringBuilder();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				StringBuilder sb1 = c == ' ' ? word : space;
				StringBuilder sb2 = c == ' ' ? space : word;
				if (sb1.length() > 0) {
					in.add(sb1.toString());
					sb1.delete(0, sb1.length());
				}
				sb2.append(c);
			}
			if (word.length() > 0) {
				in.add(word.toString());
			}
			if (space.length() > 0) {
				in.add(space.toString());
			}
			in.add("\n");
		}
		StringBuilder line = new StringBuilder();
		for (String str : in) {
			if (str.equals("\n")) {
				out.append(line).append('\n');
				line.delete(0, line.length());
				continue;
			}
			if (line.length() + str.length() > 72) {
				if (line.length() > 0) {
					while (line.length() > 0 && line.charAt(line.length() - 1) == ' ') {
						line.deleteCharAt(line.length() - 1);
					}
					out.append(line).append('\n');
					line.delete(0, line.length());
				}
				if (str.charAt(0) != ' ') {
					line.append(str);
				}
			} else {
				line.append(str);
			}
		}
		if (line.length() > 0) {
			out.append(line).append('\n');
		}
		
		System.out.print(out);
		
		br.close();
	}
}