import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] inverseOfFn = new int[1000001];
		inverseOfFn[0] = 0;
		inverseOfFn[1] = 1;
		String line;
		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			if (n == 0)
				break;
			int mininumK = 1;
			int fn = 1;
			while (inverseOfFn[fn - 1] < n) {
				inverseOfFn[fn] = inverseOfFn[fn - 1] + mininumK;
				if (inverseOfFn[mininumK] < ++fn) {
					mininumK++;
				}
			}
			System.out.println(fn - 1);
		}
	}
}