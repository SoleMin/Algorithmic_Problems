import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int casenum = input.nextInt();
		input.nextLine();
		
		while(input.hasNext()){	
			int num = input.nextInt(); 
			int[] arr = new int[num];
			
			for(int i = 0; i<num; i++)
				arr[i] = input.nextInt();
			
			
			Arrays.sort(arr);
			
			int mid = arr.length / 2;
			int sum = 0;
			
			for(int i = 0; i<arr.length; i++)
				sum += Math.abs(arr[i] - arr[mid]);
			
			System.out.println(sum);
		
		}
	}
}