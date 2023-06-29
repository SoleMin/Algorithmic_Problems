
import java.io.*;
import java.util.*;

public class Main {

	public static final int FMT = 72;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		int len = 0;
		while ((line = br.readLine()) != null) {
			if (line.length() == 0) {
				sb.append("\n");
				if (len > 0) {
					sb.append("\n");
					len = 0;
				}
				continue;
			}
			StringTokenizer st = new StringTokenizer(line);
			String prev = "";
			String prevLine = line;
			boolean first = true;
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				if (first) {
					sb.append(line.substring(0, line.indexOf(word)));
					len += line.indexOf(word);
					prev = word;
					first = false;
				} else {
					prevLine = prevLine.substring((prevLine.indexOf(prev) + prev.length()));
					sb.append(prevLine.substring(0, prevLine.indexOf(word)));
					len += prevLine.indexOf(word);
					prev = word;
				 }
				if (len + word.length() >FMT && len != 0) {
					sb.append("\n");
					len = 0;
				}
				sb.append(word);
				len += word.length();
			}
			if (len < FMT) {
				sb.append(" ");
				len++;
			}
		}
		if(len > 0)
			sb.append("\n");
		System.out.print(sb);
	}
}