import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = br.readLine()) != null) {
			String[] nums = input.split(" ");
			int ii = Integer.parseInt(nums[0]);
			int ij = Integer.parseInt(nums[1]);
			int pi, pj;
			if (ii > ij) {
				pi = ij;
				pj = ii;
			} else {
				pi = ii;
				pj = ij;
			}
			long res = 0;
			long cnt;
			for (int i = pi; i <= pj; i++) {
				long ci = i;
				cnt = 1;
				while (ci != 1) {
					if ((ci & 1) == 1) {
						ci = ci * 3 + 1;
						cnt++;
					}
					while ((ci & 1) != 1) {
						ci >>= 1;
						cnt++;
					}
				}
				if (res < cnt) {
					res = cnt;
				}
			}
			System.out.println(ii + " " + ij + " " + res);
		}
	}
}