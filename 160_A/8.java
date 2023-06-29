import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class AAA {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
			sum += array[i];
		}

		int counter = 0;
		Arrays.sort(array);
		int first = 0;
		for (int j = n - 1; j >= 0; j--) {
			first += array[j];
			sum -= array[j];
			counter++;
			if (first > sum) {
				break;
			}
		}
		System.out.println(counter);
	}
}