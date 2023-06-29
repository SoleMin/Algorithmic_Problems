import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			int n = input.nextInt();
			int arr1[] = new int[n + 2];
			int arr2[] = new int[n + 2];
			boolean check = false;
			
			for(int i = 1; i < n + 1; i++)
				arr1[i] = input.nextInt();
			
			input.nextLine();
			
			for(int i = 1; i < n; i++)
				arr2[i] = i;
			
			for(int i = 1; i < n + 1; i++) {
				for(int j = 1; j < n + 1; j++) {
					if(Math.abs(arr1[i] - arr1[i - 1]) == arr2[j] || Math.abs(arr1[i] - arr1[i + 1]) == arr2[j])
						arr2[j] = 0;
				}
			}
			for(int i = 1; i < n + 1; i++) {
				if(arr2[i] != 0) {
					check = true;
					break;
				}
			}
			if(check)
				System.out.println("Not jolly");
			else
				System.out.println("Jolly");	
		}
	}
}