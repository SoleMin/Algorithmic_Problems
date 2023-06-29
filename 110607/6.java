import java.io.*;
import java.util.Scanner;
class Main {
	static int C[] = new int[1000000];
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		int n, count, i, j, sum;

		while (scan.hasNextInt()) {
			n = scan.nextInt();
			if (n == 0) {
				break;
			}
			C[1] = 1;
			count = 2;
			sum = 2;
			j = 1;

			for (i = 2; i < 1000000; i++) {
				C[i] = j;
				sum += j;
				if (sum >= n) {
					break;
				}
				if (i == count) {
					j++;
					count += C[j];
				}
			}
			if (n == 1) {
				i = 1;
			}
			else if (n <= 3) {
				i = 2;
			}
			System.out.println(i);
		}
	}
}