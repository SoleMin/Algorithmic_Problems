
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int nums[] = new int[n];
		StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		Arrays.sort(nums);
		int min = nums[0];
		int so = -200;
		for (int i = 1; i < n; i++) {
			if(nums[i] != min) {
				so = nums[i];
				break;
			}
		}
		if(so != -200)
		System.out.println(so);
		else
			System.out.println("NO");
	}
}
