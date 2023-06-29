import java.io.*;
public class Main {
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		do {
			int n = Integer.parseInt (br.readLine ());
			//args;
			int [] ns = new int [(args = br.readLine ().split (" ")).length];
			int evenCount = 0, oddCount = 0, evI = 1, oddI = 1;
			for (int i = 0; i < ns.length; i++) {
				if ((ns [i] = Integer.parseInt (args [i])) % 2 == 0) {
					evenCount ++;
					evI = i;
					
				} else {
					oddCount ++;
					oddI = i;
				}
			}
			if (evenCount == 1) System.out.println (evI + 1);
			else System.out.println (oddI + 1);
		} while (br.ready ());
	}
}