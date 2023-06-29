import java.io.*;
import java.util.Scanner;

class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		hartal();
	}
	
	static void hartal() {
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int days = sc.nextInt();
			int p = sc.nextInt();
			int[] hartals = new int[p];
			
			for (int j = 0; j < p; j++) {
				hartals[j] = sc.nextInt();
			}
			
			int cnt = 0;
			
			for (int j = 1; j <= days; j++) {
				if (j % 7 == 6 || j % 7 == 0) {
					continue;
				}
				for (int k = 0; k < hartals.length; k++) {
					if (j % hartals[k] == 0) {
						cnt++;
						break;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}