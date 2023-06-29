import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			
			int n = input.nextInt();
			double money = 0;
			
			if(n == 0)
				break;
			
			double bill[] = new double[n];
			
			for(int i = 0; i < n; i++) {
				bill[i] = input.nextDouble();
				money += bill[i];
			}
			
			money /= n;
			
			for(int i = 0; i < n; i++) {
				bill[i] -= money;
				if(bill[i] < 0)
					bill[i] *= -1;
				bill[i] = Math.floor(bill[i] * 100.0) / 100.0;
			}
			
			money = 0;
			
			for(int i = 0; i < n; i++)
				money += bill[i];
			
			System.out.printf("$" + "%.2f\n", Math.floor(money * 100.0) / 200.0);
		}
		input.close();
	}
}