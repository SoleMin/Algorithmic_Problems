import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int j = 0; j < t; j++) {
			br.readLine();
			int n = Integer.parseInt(br.readLine());
			int[] d = new int[n];
			int[] c = new int[n];
			for (int i = 0; i < n; i++) {
				String[] tmp = br.readLine().split(" ");
				d[i] = Integer.parseInt(tmp[0]);
				c[i] = Integer.parseInt(tmp[1]);
			}

			float[] co = new float[n];
			for (int i = 0; i < n; i++) {
				co[i] = ((float) d[i]/c[i]);
			}
			float[] cp = new float[n];
			System.arraycopy(co, 0, cp, 0, n);
			Arrays.sort(cp);
			for (int i = 0; i < n; i++) {
				int in;
				for (int k = 0; k < co.length; k++) {
					if (co[k] == cp[i]) {
						in = k;
						co[k] = -1;
						System.out.print((in + 1) + " ");
						break;
					}
				}
			}
			System.out.println("\n");
			
		}
	}
}
