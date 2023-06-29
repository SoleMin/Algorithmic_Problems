import java.io.*;
import java.util.*;
import java.math.*;

public class A implements Runnable {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static Random rnd;

	final long MODULO = 1000000009;

	private void solve() throws IOException {
		int moves = nextInt(), rightMoves = nextInt(), sequence = nextInt();
		long answer = solveSmart(moves, rightMoves, sequence);
		out.println(answer);
		// for (int moves = 2; moves <= 50; moves++) {
		// for (int rightMoves = 2; rightMoves <= moves; rightMoves++) {
		// for (int sequence = 2; sequence <= moves; sequence++) {
		// if (solveDumb(moves, rightMoves, sequence) != solveSmart(
		// moves, rightMoves, sequence)) {
		// out.println(moves + " " + rightMoves + " " + sequence);
		// out.flush();
		// }
		// }
		// }
		// }
	}

	// private long solveDumb(int moves, int rightMoves, int sequence) {
	// long[][][] d = new long[moves + 1][rightMoves + 1][sequence];
	// long inf = Integer.MAX_VALUE;
	// for (int i = 0; i <= moves; i++)
	// for (int j = 0; j <= rightMoves; j++)
	// Arrays.fill(d[i][j], inf);
	// d[0][0][0] = 0;
	//
	// for (int i = 0; i < moves; i++) {
	// for (int j = 0; j <= rightMoves; j++) {
	// for (int k = 0; k < sequence; k++) {
	// // right move
	// if (j < rightMoves) {
	// // last move
	// if (k + 1 == sequence) {
	// d[i + 1][j + 1][0] = Math.min(d[i + 1][j + 1][0],
	// (d[i][j][k] + 1) * 2);
	// } else {
	// d[i + 1][j + 1][k + 1] = Math.min(
	// d[i + 1][j + 1][k + 1], d[i][j][k] + 1);
	// }
	// }
	//
	// // bad move
	// d[i + 1][j][0] = Math.min(d[i + 1][j][0], d[i][j][k]);
	// }
	//
	// }
	// }
	//
	// long result = inf;
	// for (int i = 0; i < sequence; i++)
	// result = Math.min(result, d[moves][rightMoves][i]);
	// return result;
	// }

	private long solveSmart(long moves, long rightMoves, long sequence) {
		long fullSequences = moves / sequence;
		long canReset = Math.min(fullSequences, moves - rightMoves);
		long remainSequences = fullSequences - canReset;
		long answer = (rightMoves - remainSequences * sequence)
				+ getAnswerSequences(remainSequences, sequence);
		answer %= MODULO;
		return answer;
	}

	private long getAnswerSequences(long count, long length) {
		long first = (getPow(2, count + 1) - 2) % MODULO;
		long result = first * length;
		result %= MODULO;
		result += MODULO;
		result %= MODULO;
		return result;
	}

	private int getPow(int n, long p) {
		return BigInteger.valueOf(2)
				.modPow(BigInteger.valueOf(p), BigInteger.valueOf(MODULO))
				.intValue();
	}

	public static void main(String[] args) {
		new A().run();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			rnd = new Random();

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = in.readLine();

			if (line == null)
				return null;

			st = new StringTokenizer(line);
		}

		return st.nextToken();
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	private double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}