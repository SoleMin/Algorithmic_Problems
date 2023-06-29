import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		int daysOfEnd, numOfParty, index;
		int [] holiday;
		int situation = input.nextInt();
		int [] count = new int [situation];
		
		for (int i = 0; i < situation; i++) {
			daysOfEnd = input.nextInt();
			holiday = new int[daysOfEnd + 1];
			
			numOfParty = input.nextInt();
			
			for (int j = 0; j < numOfParty; j++) {
				
				index = input.nextInt();
				
				for (int k = index; k <= daysOfEnd; k += index) {
					if (k % 7 != 6 && k % 7 != 0) {
						holiday[k]++;
					}
				}
			}
			for (int j = 1; j <= daysOfEnd; j++)
				if (holiday[j] != 0)
					count[i]++;
		}
		for (int i = 0; i < situation; i++){
			System.out.println(count[i]);
		}
		input.close();
	}
}