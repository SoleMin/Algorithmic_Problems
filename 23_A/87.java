import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		new A().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		
		int res = 0;
		for (int i = 0; i < s.length(); i++)
			for (int j = i + 1; j <= s.length(); j++) {
				String sub = s.substring(i, j);
				int c = count(s, sub);
				if (c >= 2)
					res = Math.max(res, sub.length());
			}
		System.out.println(res);
	}

	private int count(String s, String sub) {
		int res = 0;
		while (s.length() > 0) {
			if (s.startsWith(sub))
				res++;
			s = s.substring(1);
		}
		return res;
	}

}
