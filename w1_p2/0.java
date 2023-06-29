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
			if (line.startsWith("0x")) {
				int x = Integer.parseInt(line.substring(2), 16);
				out.append(x).append('\n');
			} else {
				int x = Integer.parseInt(line);
				out.append("0x").append(Integer.toString(x, 16).toUpperCase()).append('\n');
			}
		}
		
		System.out.print(out);
		br.close();
	}
}