import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int student;
		double [] value;
		
		while(scan.hasNextInt()) {
			student = scan.nextInt();
			double average = 0;
			double sum = 0;
			double sumOfValue = 0;
			value = new double[student];
			if(student==0) break;
			for(int i = 0; i <student; i++) {
				double cost = scan.nextDouble();
				value[i] = cost;
				scan.nextLine();
			}
			
			if(student == 1) {
				scan.nextInt();
				scan.nextLine();
				System.out.printf("$%.2f", sumOfValue);
				System.out.println();
				continue;
			}
			
			for(int i = 0; i < student; i++) {
				sum += value[i];
			}
			
			average = sum / student;
			average = Math.round(average * 1000) / 1000.0;
			
			for(int i = 0; i < student; i++)  {
				if(value[i] > average) {
					sumOfValue += value[i] - average;
				}
			}
			sumOfValue = Math.floor(sumOfValue * 100) / 100;
			
			System.out.printf("$%.2f", sumOfValue);
			System.out.println();
		}
	}
}