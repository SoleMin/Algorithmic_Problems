

import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.lang.Character.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class B {
	static final int[] num = new int[7];
	static {
		for(int i = 1, c = 1; i <= 6; i++, c *= 26)
			num[i] = num[i-1] + c;
	}
	public void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-- > 0) {
			String s = sc.next();
			System.out.println(s.matches("R[0-9]+C[0-9]+") ? toABdd(s) : toRC(s));
		}
	}

	String toRC(String s) {
		String ss = s.split("[0-9]+")[0];
		String sn = s.split("[A-Z]+")[1];
		int r = 0;
		for(char c : ss.toCharArray())
			r = r * 26 + c - 'A';
		r += num[ss.length()];
		int c = Integer.parseInt(sn);
		return "R" + c + "C" + r;
	}

	String toABdd(String s) {
		String[] ss = s.split("[RC]");
		int c = Integer.parseInt(ss[1]);
		int r = Integer.parseInt(ss[2]);
		int a = 0;
		while(r > num[++a]);
		a--;
		r -= num[a];
		char[] cs = new char[a];
		for(int i = 0; i < a; i++, r /= 26)
			cs[a-i-1] = (char) (r % 26 + 'A');
		return new String(cs) + c;
	}

	void debug(Object... os) {
		System.err.println(Arrays.deepToString(os));
	}

	public static void main(String...args) {
		new B().run();
	}
}
