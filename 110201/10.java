import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

class Main{
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			int input[] = new int[n];
			int output[] = new int[n-1];
			
			for(int i =0;i<n;i++){
				input[i] = scanner.nextInt();
				if(i>0)
					output[i-1]=Math.abs(input[i]-input[i-1]);
			}
			
			Arrays.sort(output);
			String jollystr = "Jolly";
			
			for(int i=0; i<n-1; i++){
				if(output[i]!=i+1)
					jollystr = "Not jolly";	
			}
			System.out.println(jollystr);
			
			
		}
	}
}