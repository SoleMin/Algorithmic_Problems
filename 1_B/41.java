import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int nc = sc.nextInt();
		while (nc-- > 0) {
			String s = sc.next();
			StringTokenizer st = new StringTokenizer(s, "0123456789");
			if (st.countTokens() > 1) {
				int k = s.indexOf('C');
				int r = Integer.parseInt(s.substring(1, k));
				int c = Integer.parseInt(s.substring(k + 1));
				int len = 1;
				int p = 26;
				while (c > p) {
					c -= p;
					len++;
					p *= 26;
				}
				String col = Integer.toString(--c, 26).toUpperCase();
				while (col.length() < len)
					col = "0" + col;
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < col.length(); i++) {
					if (col.charAt(i) < 'A') {
						sb.append((char) (col.charAt(i) - '0' + 'A'));
					} else {
						sb.append((char) (col.charAt(i) + 10));
					}
				}
				System.out.printf("%s%d\n", sb.toString(), r);
			} else {
				int k = 0;
				while (s.charAt(k) > '9')
					k++;
				char[] col = s.substring(0, k).toCharArray();
				int r = Integer.parseInt(s.substring(k));
				int c = 1;
				int p = 26;
				int cnt = 1;
				while (cnt++ < col.length) {
					c += p;
					p *= 26;
				}
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < col.length; i++) {
					if (s.charAt(i) < 'K') {
						sb.append((char) ('0' + col[i] - 'A'));
					} else {
						sb.append((char) (col[i] - 10));
					}
				}
				c += Integer.parseInt(sb.toString(), 26);
				System.out.printf("R%dC%d\n", r, c);
			}
		}
		System.out.close();
	}

}
