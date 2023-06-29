import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextLine()) {
			
			String input = scanner.nextLine();
			String[] numbers = input.split(" ");
			int num = Integer.parseInt(numbers[0]);
			int[] array = new int[num];
			int[] cal = new int[num-1];
			boolean check = true;
			int[] jolly = new int[3000];
		
			for (int i=0; i<num; i++) {
				int temp = Integer.parseInt(numbers[i+1]);
				array[i] = temp;
			}
			
			for (int i=1; i<=num; i++) {
				jolly[i]=0;
			}
			
			for (int i=0; i<num-1; i++) {
				int calculate = Math.abs(array[i]-array[i+1]);
				cal[i] = calculate;
				jolly[calculate]++;
				if (calculate >= num)
					check = false;
			}
			
			if (check) {
				for (int i=1; i<num; i++) {
					if (jolly[i]!=1)
						check = false;
				}
			}
			
			if (check)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
		}
	}
}