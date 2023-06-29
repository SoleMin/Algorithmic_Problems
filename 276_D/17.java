import java.util.*;

public class Dj {

	public static long run(long l, long r) {
		if(l == r) {
			return 0;
		}

		long[] sq2 = new long[62];
		sq2[0] = 1;
		for(int i = 1; i < 62; i++) sq2[i] = sq2[i-1]*2;

		//System.out.println(sq2[61]);

		for(int i = sq2.length - 1; i >= 0; i--) {
			//log("L = " + l + " R = " + r + " 2^" + i + "=" + sq2[i]);
			if(l >= sq2[i] && r >= sq2[i]) {
				l -= sq2[i];
				r -= sq2[i];
			} else if(l < sq2[i] && sq2[i] <= r) {
				break;
			}
		}
		for(int i = sq2.length - 1; i >= 0; i--) {
			//log("L = " + l + " R = " + r + " 2^" + i + "=" + sq2[i]);
			if(l < sq2[i] && sq2[i] <= r) {
				return sq2[i+1]-1;
			}
		}
		return -1;
	}

	public static void log(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long l = sc.nextLong();
		long r = sc.nextLong();

		System.out.println(run(l, r));
		//System.out.println(run(9999999999998l, 9999999999999l));

	}
}