import java.io.*;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextInt()){
			
			int n = input.nextInt();
			int arrInput[] = new int[n];
			int arrSub[] = new int[n-1];
			
			for(int i = 0; i<n; i++){
				arrInput[i]=input.nextInt();
			}
			
			for(int i = 0; i<n-1; i++){
				arrSub[i]=Math.abs(arrInput[i+1]-arrInput[i]);
			}
			
			Arrays.sort(arrSub);
			String result = "Jolly";
				
			for(int i = 0; i<n-1; i++){
				if(arrSub[i] != i+1){
					result="Not jolly";
				}
			}
			System.out.println(result);
		}
	}
}