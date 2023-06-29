import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), sum = 0;
		
		Integer[] A = new Integer[n];
		
		for (int i = 0 ; i < n ; i++) {
			A[i] = sc.nextInt();
			sum += A[i];
		}
		
		Arrays.sort(A, Collections.reverseOrder());
		
		int c = 0, ans = 0;
		
		while (ans <= sum) {
			ans += A[c];
			sum -= A[c];
			c++;
		}
		
		System.out.println(c);
	}
}
