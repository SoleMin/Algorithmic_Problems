import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String test = scanner.nextLine();
		int test_case = Integer.parseInt(test);
		int hartal[] = new int[100];
		int loss_day = 0, day = 0, party = 0;
		for (int i=0; i<test_case; i++) {
			loss_day = 0;
			String simul_day = scanner.nextLine();
			day = Integer.parseInt(simul_day);
			String simul_party = scanner.nextLine();
			party = Integer.parseInt(simul_party);
			for (int n = 0; n<party; n++) {
				String simul_hartal = scanner.nextLine();
				int temp = Integer.parseInt(simul_hartal);
				hartal[n] = temp;
			}
			for (int j=1; j<=day; j++) {
				if (((j-1)%7)<5) {
					for (int m = 0; m<party; m++)
						if (j%hartal[m]==0) {
							loss_day++;
							break;
						}
				}
			}
			System.out.println(loss_day);
		}
	}
}