import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n;
		while(true) {
			n = input.nextInt();
			if(n == 0)
				break;
			
			Double[] payList = new Double[n];
			double average=0, sum=0;
			for(int i=0; i<n; i++) {
				payList[i] = input.nextDouble();
				average += payList[i]*100;
			}
			average /= n;
			average = Math.ceil(average)/100.0;
			for(int i=0; i<n; i++)
				if(payList[i] > average)
					sum += (payList[i] - average);
			System.out.printf("$%.2f\n", sum);
		}
		input.close();
	}
}