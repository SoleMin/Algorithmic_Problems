import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		double[] arr;
		String s =input.nextLine();
		
		while(input.hasNextLine() && s != "0") {
			int num = Integer.parseInt(s);
			arr = new double[num];
			double tot = 0;	
			for(int i=0; i<num; i++) {
				arr[i] = Double.parseDouble(input.nextLine());
				tot += arr[i];
			}
			
			double avg = tot/num;
			
			double res = 0;
			for(int j=0; j<num; j++) {
				if(arr[j] > avg) {
				res += Math.floor((arr[j] - avg)*100)/100;
				}
			}
			
			System.out.printf("$%.2f\n" ,res);
			s = input.nextLine();
		}
	}
}