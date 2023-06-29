import java.io.*;

import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			
			int peopleNumber = 1;
			double minusTotal = 0;
			double total = 0;
			double answer_1 = 0;
			double answer_2 = 0;
			double answer = 0;
			double[] cost = new double[1001];
			
			peopleNumber = input.nextInt();
			if(peopleNumber == 0) {break;}
			
			for(int i = 0; i < peopleNumber; i++) {
				cost[i] = input.nextDouble();
				total += cost[i];
			}
			
			double average = total / peopleNumber;
			
			average = Math.round(average*1000)/1000.0;
			average = Math.round(average*100)/100.0;
			
			for(int i = 0; i < peopleNumber; i++) {
				if(cost[i] > average) {answer_1 += (cost[i] - average);}
				else if(cost[i] < average) {answer_2 += (average - cost[i]);}
				if(answer_1 >= answer_2) {answer = answer_2;}
				else if (answer_1 <= answer_2) {answer = answer_1;}
				
			}
			
			System.out.printf("$" +  "%.2f\n", answer);
			
		}
	}
}