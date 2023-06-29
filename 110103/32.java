import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		while(true) {
			int student = scan.nextInt();
			if(student == 0) break;
			float sum = 0; float pSum = 0; float nSum = 0;
			float[] ep = new float[student];
			
			for(int i = 0; i < student; i++){
				ep[i] = scan.nextFloat();
				sum += ep[i];
			}
			
			double avg = Math.floor((sum/student)*(double)100.0 + 0.5) / (double)100.0;

			for(int j = 0; j < student; j++) {
				if(ep[j] > avg)
					pSum += ep[j] - avg;
				else if(ep[j] < avg)
					nSum += avg - ep[j];
			}
			
			if(pSum > nSum) sum = nSum;
			else sum = pSum;
			
			System.out.println(String.format("$%.2f", sum));
		}
	}
}