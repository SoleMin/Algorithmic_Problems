import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			int n = input.nextInt();
			if(n == 0)
				break;
			double[] students = new double[n];
			for(int i = 0; i < n; i++){
				students[i] = input.nextDouble();
			}
			double sum = 0;
			for(int i = 0; i < n; i++){
				sum += students[i];
			}
			double each = sum/n;
			double result = 0;
			for(int i = 0; i < n; i++){
				if(students[i] < each)
					result = result + (each - students[i]);
			}
			System.out.printf("$%.2f\n", Math.floor(result*100)/100.0);
		}
		
	}
}