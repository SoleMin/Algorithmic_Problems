import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		sc.nextLine();
		while (cases-- > 0) {
			int sum = 0;
			int n = sc.nextInt();
			int m = n;

			int a[] = new int[n];
		
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			Arrays.sort(a);
		
			if (n == 1)
				sum = a[0];
			else {
				if (m % 2 == 0) {
					while (m > 2) {
						if (2*a[1] < a[0] + a[m-2])
							sum = sum + a[m-1] + a[0] + 2*a[1];
						else
							sum = sum + 2*a[0] + a[m-2]+ a[m-1];
						m -= 2;
					}
					sum += a[1];
				}
				else if (m % 2 != 0){
					while (m > 3) {
						if (2*a[1] < a[0] + a[m-2])
							sum = sum + a[m-1] + a[0] + 2*a[1];
						else
							sum = sum + 2*a[0] + a[m-2] + a[m-1];
						m -= 2;
					}
					sum = sum + a[0] + a[1] + a[2];
				}
			}
			System.out.println(sum+"\n");
		}
		sc.close();
	}
}