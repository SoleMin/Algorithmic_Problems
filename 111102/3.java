
import java.io.*;
import java.util.*;

class Main {
	static long [][] str;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < t; i++) {
			String X = sc.nextLine();
			String Z = sc.nextLine();
			str = new long [X.length() + 1][Z.length() + 1];

			sub(X, Z);
		}
	}

	public static void sub (String x, String z) {
		for (int i = 0; i < x.length(); i++) {
			for (int j = 0; j < z.length(); j++) {
				if (x.charAt(i) == z.charAt(j)) {
					if (j == 0) {
						str[i + 1][j + 1] += str[i][j+1] + 1;
					} else str[i + 1][j + 1] += str[i][j + 1] + str[i][j];
				} else str[i + 1][j + 1] += str[i][j + 1];
			}
		}
		System.out.println(str[x.length()][z.length()]);
	}
}