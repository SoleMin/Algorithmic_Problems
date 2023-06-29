import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Round1B {

	public static void main(String[] args) throws Exception {
		new Round1B().run();
	}

	private void run() throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(sc.nextLine().trim());
		while (tc > 0) {
			String s = sc.nextLine().trim();
			if (s.matches("R[0-9]+C[0-9]+")) {
				Pattern p = Pattern.compile("R([0-9]+)C([0-9]+)");
				Matcher m = p.matcher(s);
				if (m.matches()) {
					int rows = Integer.parseInt(m.group(1));
					int cols = Integer.parseInt(m.group(2));
					String col = "";
					while (cols > 0) {
						int mod = (cols - 1) % 26;
						col = (char)('A' + mod) + col;
						cols = (cols - 1) / 26;
					}
					System.out.println(col + rows);
				} else {
					throw new Exception();
				}
			} else {
				Pattern p = Pattern.compile("([A-Z]+)([0-9]+)");
				Matcher m = p.matcher(s);
				if (m.matches()) {					
					int rows = Integer.parseInt(m.group(2));
					int cols = 0;
					int mul = 1;
					for (int i = m.group(1).length() - 1; i >= 0; i--) {
						cols += mul * (m.group(1).charAt(i) - 'A' + 1);
						mul *= 26;
					}
					System.out.printf("R%dC%d\n", rows, cols);
				}
				else {
					throw new Exception();
				}
			} 
			tc--;
		}
		sc.close();
	}

}
