import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		float[] payArr = new float[1];
		float sum = 0, average = 0;
		int student = 0;
		
		while(input.hasNext()) {			
			if(input.hasNextInt()) {
				student = input.nextInt();
				if(student == 0) break;
				
				payArr = new float[student];
				sum = 0;
				average = 0;
			}
			else {
				// 평균
				for(int i=0; i<student; i++) {
					payArr[i] = Float.parseFloat(input.next());
					sum += payArr[i];
				}
				average = sum/student;
				sum = 0;
				
				// 편차
				for(int i=0; i<student; i++) {
					if(payArr[i] <= average)
						sum += Math.floor((average - payArr[i])*100)/100.0f;
					else
						sum += Math.floor((payArr[i]-average)*100)/100.0f;
				}
				float cost = Math.round((sum/2)*100)/100.0f;
				
				System.out.println("$" + String.format("%.2f",cost));
			}
		}
		input.close();
	}
}