import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = br.readLine()) != null) {
		int n = Integer.parseInt(input);
			if (n == 0) {
				break;
			} else {
				float[] arr = new float[n];
				for (int i = 0; i < n; i++) {
					arr[i] = Float.parseFloat(br.readLine());
				}
				float ave = 0;
				for (int i = 0; i < n; i++) {
					ave += arr[i];
				}
				ave /= n;
				ave *= 100;
				ave = (float)Math.round(ave);
				ave /= 100;
				float res1 = 0;
				float res2 = 0;
				for (int i = 0; i < n; i++) {
					if (arr[i] < ave) {
						res1 += ave - arr[i];
					} else {
						res2 += arr[i] - ave;
					}
				}
				System.out.printf("$%.2f\n", res1 < res2 ? res1 : res2);
			}
		}
	}
}