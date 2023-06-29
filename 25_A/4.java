import java.io.BufferedReader;
import java.io.InputStreamReader;


public class A25 {

	
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(in.readLine().trim());
			String[] toks = in.readLine().trim().split("[ ]+");
			int counter = 0;
			boolean even = true;
			int e = -1, o = -1;
			int ec = 0, oc = 0;
			for (int i = 0; i < toks.length; i++) {
				int x = Integer.parseInt(toks[i]);
				if (x % 2 == 0) {
					ec ++;
					if (e == -1) {
						e = i+1;
					}
				}
				else {
					oc ++;
					if (o == -1) {
						o = i+1;
					}
				}
			}
			if (ec == 1) {
				System.out.println(e);
			}
			else if (oc == 1) {
				System.out.println(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new A25().run();
	}
}
