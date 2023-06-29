import java.io.*;
import java.util.*;

public class Main {

	/**
	 * @author hunglee
	 */
	public static void main(String[] args) throws IOException {

		StreamTokenizer in = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		
		in.nextToken();
		String s = in.sval;
		int l = s.length();
		int n = l - 1;
		String st, sub;
		while (n > 0) {
			for (int i = 0; i < l - n; ++i) {
				st = s.substring(i, n + i);
				sub = s.substring(i + 1);
				if (sub.indexOf(st) != -1) {
					System.out.println(n);
					System.exit(0);
				}
			}
			n--;
		}
		System.out.println(0);
	}

}
