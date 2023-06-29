import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(true){
			int num = input.nextInt();
			if (num == 0)
				break;
			
			double arr[] = new double[num];

			for(int i = 0 ; i< num; i++){
				arr[i] = input.nextDouble();
			}

			double sum = 0;
			double avg = 0;

			for(int i = 0 ; i<num; i++){
				sum += arr[i];
			}
			avg = Math.ceil((sum/num)*100) / 100;

			double sub[] = new double[num];

			for(int i = 0; i<num; i++){
				if(arr[i] >= avg){
					sub[i] = arr[i] - avg;
				}
			}

			double result = 0;
			for(int i = 0; i<sub.length ; i++){
				result += sub[i];
			}

			System.out.println(String.format("$%.2f", result));
		}
	}
}