import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int j = 0; j < t; j++) {
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int n = arr[0];
			arr = Arrays.copyOfRange(arr, 1, arr.length);
			Arrays.sort(arr);
			int house = arr[arr.length / 2];
			int res1 = 0;
			for (int i: arr) {
				res1 += Math.abs(house - i);
			}
			int res2 = 2147483647;
			if (arr.length > 2 && (arr.length & 1) == 0) {
				res2 = 0;
				house = arr[arr.length/2 + 1];
				for (int i: arr) {
					res2 += Math.abs(house - i);
				}
			}
			System.out.println(res1 < res2 ? res1 : res2);
		}
	}
}
