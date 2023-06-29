import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			int n = input.nextInt();
			if(n == 0)
				break;
			int[] array = new int[n];
			int sum=0, ave=0, result=0;
			int count=0;
			
			for(int i = 0; i < n; i++){
				double d = input.nextDouble();
				if(d*100-(int)(d*100)>0.9){
					array[i] = (int)(d*100+1);
				}
				else
					array[i] = (int)(d*100);
				
				sum += array[i];
			}
			ave = (int)sum/n;
			for(int i = 0; i < n; i++){
				if(array[i] > ave){
					result += array[i] - ave;
					count++;
				}
			}
			if ((sum%n) >= count)
				System.out.println("$"+String.format("%.2f", (result-count)/100.0));
			else
				System.out.println("$"+String.format("%.2f", ((result-sum%n)/100.0)));
		}
	}
}