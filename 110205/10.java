import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		int[][] array = new int[101][53];
		int[] cards = new int[53];
		int[] tmp_cards = new int[53];
		
		Scanner scanner = new Scanner(System.in);
		String test = scanner.nextLine();
		int test_case = Integer.parseInt(test);
		String skip = scanner.nextLine();
		
		for (int i=0; i<test_case; i++) {
			String shuffle = scanner.nextLine();
			int num = Integer.parseInt(shuffle);
			
			for (int j=1; j<=num; j++) {
				String shuffles = scanner.nextLine();
				String[] temp = shuffles.split(" ");
				if (temp.length==52) {
					for (int k=1; k<=52; k++) {
						int tmp = Integer.parseInt(temp[k-1]);
						array[j][k] = tmp;
					}
				}
				else {
					for (int k=1; k<=26; k++) {
						int tmp = Integer.parseInt(temp[k-1]);
						array[j][k] = tmp;
					}
					String shuffles2 = scanner.nextLine();
					String[] temp2 = shuffles2.split(" ");
					for (int k=1; k<=26; k++) {
						int tmp = Integer.parseInt(temp2[k-1]);
						array[j][k+26] = tmp;
					}
				}
			}
			
			for (int j=1; j<=52; j++) {
				cards[j] = j;
			}
			
			while(scanner.hasNextLine()) {
				String input = scanner.nextLine();
				if (input.equalsIgnoreCase(""))
					break;
				int number = Integer.parseInt(input);
				for (int j=1; j<=52; j++)
					tmp_cards[j] = cards[j];
				for (int j=1; j<=52; j++)
					cards[j] = tmp_cards[array[number][j]];
			}
			
			if (i>0)
				System.out.println();
			
			for (int j=1; j<=52; j++) {
				int value = (cards[j]-1)%13;
				int shape = (cards[j]-1)/13;
				switch(value) {
					case 9 :
						System.out.print("Jack ");
						break;
					case 10 :
						System.out.print("Queen ");
						break;
					case 11 :
						System.out.print("King ");
						break;
					case 12:
						System.out.print("Ace ");
						break;
					default :
						value = value + 2;
						System.out.print(value + " ");
						break;
				}
				System.out.print("of");
				switch(shape) {
					case 0 :
						System.out.println(" Clubs");
						break;
					case 1 :
						System.out.println(" Diamonds");
						break;
					case 2 :
						System.out.println(" Hearts");
						break;
					case 3 :
						System.out.println(" Spades");
						break;
				}
			}
		}
	}
}