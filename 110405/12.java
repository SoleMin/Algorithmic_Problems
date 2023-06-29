import java.io.*;
import java.util.Scanner;

class Main {
	public static void sort(int ti[], int si[], int n){
		int output [] = new int[n];
		for(int i =0; i <n; i++)
			output[i] =i;
		
		for(int i =0; i < n; i ++){
			for(int j =0; j < n-1; j++){
				if(ti[output[j]]*si[output[j+1]]  > ti[output[j+1]]*si[output[j]]){
					int temp = output[j];
					output[j] = output[j+1];
					output[j+1] =temp;
				}		
			}
		}
		
		for(int i=0; i <n; i++)
			System.out.print((output[i]+1)+" ");
		System.out.println();
	}
	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		
		for(int test =0; test<testCase; test++){
			input.nextLine();
			
			int n = input.nextInt();  // 작업의 개수
			int ti [] = new int[n];
			int si [] = new int[n];
			for(int i =0; i <n; i++){
				ti[i] = input.nextInt();
				si[i] = input.nextInt();
			}
			sort(ti, si, n);
			
			System.out.println();
			/**
			for(int i=0; i <n; i++)
				System.out.println(ti[i]+" "+si[i]);
			*/
			
		}//for test
		
		input.close();
	}
}