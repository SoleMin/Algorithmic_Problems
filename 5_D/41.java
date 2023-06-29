import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	public void run() {
		Locale.setDefault(Locale.US);
		try {
			run1();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	int nextInt(StreamTokenizer st) throws IOException {
		st.nextToken();
		return (int) st.nval;
	}

	double nextDouble(StreamTokenizer st) throws IOException {
		st.nextToken();
		return st.nval;
	}

	String nextLine(StreamTokenizer st) throws IOException {
		st.nextToken();
		return st.sval;
	}

	Map<String, BigInteger> map = new HashMap<String, BigInteger>();

	public void run1() throws IOException {
		Locale.setDefault(Locale.US);
		// long time = -System.currentTimeMillis();
		 Scanner sc = new Scanner(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
//		Scanner sc = new Scanner(new File("input.txt"));
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		// PrintStream ps = System.out;// new PrintStream(new
		// File("output.txt"));
		// gopa(br, ps);
		double a = sc.nextDouble();
		double vmax = sc.nextDouble();
		double l2 = sc.nextDouble();
		double l1 = sc.nextDouble();
		l2 -= l1;
		double boundv = sc.nextDouble();
		if (boundv >= vmax || boundv * boundv / a / 2 > l1) {
			System.out.print(get(0, a, vmax, l1 + l2));
			System.exit(0);
		}
		double tmplen = vmax * vmax / a / 2 + (vmax + boundv) / 2
				* (vmax - boundv) / a;
		if (tmplen < l1) {
			System.out.print(get(boundv, a, vmax, l2) + vmax
					/ a + (vmax - boundv) / a + (l1 - tmplen) / vmax);
			System.exit(0);
		}
		double v = Math.sqrt(l1 * a + boundv * boundv / 2);
		System.out.print(get(boundv, a, vmax, l2) + v / a
				+ (v - boundv) / a);
	}

	double get(double v0, double a, double vmax, double l) {
		double tmplen = (vmax + v0) / 2 * (vmax - v0) / a;
		// System.out.println(tmplen);
		if (l >= tmplen) {
			return (vmax - v0) / a + (l - tmplen) / vmax;
		}
		return (-v0 + Math.sqrt(v0 * v0 + 2 * a * l)) / a;
	}
}