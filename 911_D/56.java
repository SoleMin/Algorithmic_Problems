
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int parity = 0;
		for(int i = 0; i < n; i++) {
			int count = 0;
			for(int j = i + 1; j < n; j++) {
				if(arr[j] < arr[i]) {
					parity ^= 1;
				}			
			}
		}
		int m = s.nextInt();
		for(int i = 0; i < m; i++) {
			int l = s.nextInt(), r = s.nextInt();
			if(((r - l + 1) / 2) % 2 == 1) {
				parity ^= 1;
			}
			System.out.println(parity == 1 ? "odd" : "even");
		}
	}

}
