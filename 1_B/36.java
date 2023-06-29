import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ProbB implements Runnable {
	private boolean _ReadFromFile = false;
	private boolean _WriteToFile = false;
	static final String TASK_ID = "in";
	static final String IN_FILE = TASK_ID + ".in";
	static final String OUT_FILE = TASK_ID + ".out";
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static PrintWriter writer;
	private static String alphabet;
	
	private static void core() throws Exception {
		int n = nextInt();
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int test = 0; test < n; test++) {
			String input = reader.readLine();
			StringTokenizer st = new StringTokenizer(input, alphabet);
			
			ArrayList<Integer> have = new ArrayList<Integer>();
			while (st.hasMoreElements()) {
				String kString = st.nextToken();
				have.add(Integer.parseInt(kString));
			}
			if (have.size() == 2)
				writer.println(twoInts(have.get(0), have.get(1)));
			else {
				String row = "";
				int col = 0;
				for (int i = 0; i < input.length(); i++) {
					if (Character.isDigit(input.charAt(i))) {
						row = input.substring(0, i);
						col = Integer.parseInt(input.substring(i));
						break;
					}
				}
				writer.println(oneInt(row, col));
			}
		}
	}
	private static String oneInt(String row, int col) {
		return "R" + col + "C" + toNum(row);
	}
	private static int toNum(String row) {
		int res = 0;
		for (int i = 0; i < row.length(); i++) {
			res = res * 26 + row.charAt(i) - 'A' + 1;
		}
		return res;
	}
	private static String twoInts(Integer row, Integer col) {
		return toAlpha(col) + row;
	}
	private static String toAlpha(Integer col) {
		String res = "";
		while (col > 0) {
			if (col % 26 > 0) {
				res = alphabet.charAt(col % 26 - 1) + res;
				col /= 26;
			}
			else {
				res = "Z" + res;
				col -= 26;
				col /= 26;
			}
		}
		return res;
	}
	void debug(Object...os) {
		System.out.println(Arrays.deepToString(os));
	}
	//--------------------- IO stuffs ---------------------
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ProbB());
        thread.start();
        thread.join();
    }
	public void run() {
        try {
        	reader = _ReadFromFile ? new BufferedReader(new FileReader(IN_FILE)) : new BufferedReader(new InputStreamReader(System.in));
        	writer = _WriteToFile ? new PrintWriter(OUT_FILE) : new PrintWriter(new BufferedOutputStream(System.out));
            tokenizer = null;
            core();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
	static int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }
	static long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }
	static double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
	static String nextToken() throws Exception {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
