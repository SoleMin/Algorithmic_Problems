import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int numCase = input.nextInt();
		
		for(int i = 0; i < numCase; i++){
			int day = input.nextInt();
			int party = input.nextInt();
			int[] h = new int[party];
			int count = 0;
			
			for(int j = 0; j < party; j++)
				h[j] = input.nextInt();
			
			for(int k = 1; k <= day; k++){
				if((k - 1) % 7 < 5){
					for(int m = 0; m < party; m++){
						if(k % h[m] == 0){
							count++;
							break;
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}