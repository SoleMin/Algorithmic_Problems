import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Works good for CF
 * 
 * @author cykeltillsalu
 */
public class A111_div2 {

	// some local config
	static boolean test = false;
	static String testDataFile = "testdata.txt";
	static String feedFile = "feed.txt";
	CompetitionType type = CompetitionType.CF;
	private static String ENDL = "\n";

	// solution
	private void solve() throws Throwable {

		int n = iread();
		
		int[] vals = new int[n];
		double tot = 0;
		for (int i = 0; i < n; i++) {
			int value = iread();
			vals[i] = value;
			tot += value;
		}
		
		Arrays.sort(vals);
		int pick = 0;
		int worth = 0;
		for (int i = vals.length - 1; i >= 0; i--) {
			worth += vals[i];
			pick ++;
			if(worth > tot/2.0d){
				break;
			}
		}
		
		out.write(pick + ENDL);
		out.flush();
	}

	public int iread() throws Exception {
		return Integer.parseInt(wread());
	}

	public double dread() throws Exception {
		return Double.parseDouble(wread());
	}

	public long lread() throws Exception {
		return Long.parseLong(wread());
	}

	public String wread() throws IOException {
		StringBuilder b = new StringBuilder();
		int c;
		c = in.read();
		while (c >= 0 && c <= ' ')
			c = in.read();
		if (c < 0)
			return "";
		while (c > ' ') {
			b.append((char) c);
			c = in.read();
		}
		return b.toString();
	}

	public static void main(String[] args) throws Throwable {

		if (test) { // run all cases from testfile:
			BufferedReader testdataReader = new BufferedReader(new FileReader(testDataFile));
			String readLine = testdataReader.readLine();
			int casenr = 0;
			out: while (true) {
				BufferedWriter w = new BufferedWriter(new FileWriter(feedFile));
				if (!readLine.equals("input")) {
					break;
				}
				while (true) {
					readLine = testdataReader.readLine();
					if (readLine.equals("output")) {
						break;
					}
					w.write(readLine + "\n");
				}
				w.close();
				System.out.println("Answer on case " + (++casenr) + ": ");

				new A111_div2().solve();
				System.out.println("Expected answer: ");

				while (true) {
					readLine = testdataReader.readLine();

					if (readLine == null) {
						break out;
					}
					if (readLine.equals("input")) {
						break;
					}
					System.out.println(readLine);
				}
				System.out.println("----------------");
			}
			testdataReader.close();
		} else { // run on server
			new A111_div2().solve();
		}
		out.close();
	}

	public A111_div2() throws Throwable {
		if (test) {
			in = new BufferedReader(new FileReader(new File(feedFile)));
		}
	}

	InputStreamReader inp = new InputStreamReader(System.in);
	BufferedReader in = new BufferedReader(inp);
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	enum CompetitionType {
		CF, OTHER
	};
}