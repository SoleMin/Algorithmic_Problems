import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		sc.nextLine();
		while (cases-- > 0) {
			int n = sc.nextInt();
			double a[][] = new double[n][3];
			int i = 0;
			while (i < n) {
				a[i][1] = sc.nextInt();
				a[i][0] = sc.nextInt();
				a[i][2] = i+1;
				a[i][0] /= a[i][1];
				i++;
			}
			
			if (false)
			for (i = 0; i < n; i++) {
				System.out.println(a[i][0] + " " + a[i][1]);		
			}
			
			Arrays.sort(a, (x, y) -> {
				if (y[0] == x[0]) {
					return Double.compare(x[1], y[1]);
				}
				else {		
					return Double.compare(y[0], x[0]);
				}
			});
					if (false) {
					for (int q = 0; q < n; q++)
					{
						for (int w = 0; w < 3; w++)
							System.out.print(a[q][w] + " " );
						System.out.println();
					}
					}
			for (i = 0; i < n; i++)
				System.out.print((int)a[i][2] + " ");
			if (cases > 0)
				System.out.println("\n");
		}
	}
}