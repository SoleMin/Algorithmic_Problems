import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int caseNum = input.nextInt();
		
		for(int i = 0; i < caseNum; i++) {
			
			int wayNum = input.nextInt();
			
			int deck[][] = new int[wayNum][52];
			int deck2[][] = new int[wayNum][52];
			int temp[][] = new int[wayNum][52];
			
			for(int j = 0; j < wayNum; j++) {
				for(int k = 0; k < 52; k++) {
					deck[j][k] = input.nextInt();
				}
			}
			
			for(int j = 0; j < 52; j++)
				deck2[0][j] = j + 1;
			
			input.nextLine();
			
			while(input.hasNextLine()) {
				String s = input.nextLine();
				if(s.isEmpty())
					break;
				int l = Integer.parseInt(s);
				
				for(int k = 0; k < 52; k++)
					temp[0][k] = deck2[0][k];
				
				for(int k = 0; k < 52; k++) 
					deck2[0][k] = temp[0][deck[l - 1][k] - 1];
				
			}
			
			for(int j = 0; j < 52; j++)
				printResult(deck2[0][j]);
			
			System.out.println();
		}
		input.close();
	}
	
	public static void printResult(int n) {
		switch ((n - 1) % 13) {
			case 9 :
				System.out.print("Jack");
				break;
			case 10 :
				System.out.print("Queen");
				break;
			case 11 :
				System.out.print("King");
				break;
			case 12 :
				System.out.print("Ace");
				break;
				default :
				System.out.print((n + 1) % 13);
				break;
		}
		
		System.out.print(" of ");
		
		switch ((n - 1) / 13) {
			case 0 :
				System.out.print("Clubs");
				break;
			case 1: 
				System.out.print("Diamonds");
				break;
			case 2 :
				System.out.print("Hearts");
				break;
			case 3 :
				System.out.print("Spades");
				break;
				default :
		break;
		}
		System.out.println();
	}
}