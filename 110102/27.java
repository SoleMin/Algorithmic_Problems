import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int num1, num2, count=0;
		int countField =1;
		
		while (input.hasNext()) {
			num1 = input.nextInt();
			num2 = input.nextInt();
			if (num1 == 0 && num2 == 0) {
				System.out.println();
				break;
			}
			int block[][] = new int[102][102];
			
			for (int i = 0; i < num1; i++) {
				String s = input.next();
				String array[] = s.split("");
				for (int j = 0; j < num2; j++) {
					if (array[j].equals("*")) {
						block[i+1][j+1] = 10;  
						block[i][j]++;
						block[i][j+1]++;
						block[i][j+2]++;
						block[i+1][j]++;
						block[i+1][j+2]++;
						block[i+2][j]++;
						block[i+2][j+1]++;
						block[i+2][j+2]++;
					} 
				}
			}
			
			System.out.println("Field #" + countField + ":");
			for(int i = 1; i< num1+1; i++){
				for(int j = 1; j<num2+1; j++){
					if(block[i][j] >= 10){
						System.out.print("*");
					} else {
						System.out.print(block[i][j]);
					}
				}
				System.out.println();
			}
			countField++;
			System.out.println();
	}
	}
}
