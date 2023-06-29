import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		for (int k = 0; k < c; k++) {
			int dc = Integer.parseInt(br.readLine());
			int pc = Integer.parseInt(br.readLine());
			int[] dh = new int[pc];
			boolean[] dhi = new boolean[dc];
			
			for (int i = 0; i < dh.length; i++) {
				dh[i] = Integer.parseInt(br.readLine());
			}
			
			
			for (int i = 0; i < dh.length; i++) {
				for (int j = dh[i] - 1; j < dhi.length; j += dh[i]) {
					dhi[j] = true;
				}
			}
			
			
			for (int i = 5; i < dhi.length; i += 7) {
				dhi[i] = false;
			}
			for (int i = 6; i < dhi.length; i += 7) {
				dhi[i] = false;
			}
			int n = 0;
			for (boolean a: dhi) {
				if (a) {
					n++;
				}
			}
			System.out.println(n);
		}
	}
}