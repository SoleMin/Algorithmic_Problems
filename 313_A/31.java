import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String s = n + "";
		if (n >= 0)
			System.out.println(n);
		else {
			int a = n, b = Integer.parseInt(s.substring(0, s.length() - 1)), c = Integer.parseInt(s.substring(0, s.length()-2)+s.charAt(s.length()-1));
			System.out.println(Math.max(a, Math.max(b,c)));
		}
	}
}
