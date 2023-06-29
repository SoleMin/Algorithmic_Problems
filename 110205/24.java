import java.util.Scanner;
import java.util.Stack;

class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		int testcase = scanner.nextInt();
		
		scanner.nextLine();
		scanner.nextLine();
		
		for(int i = 0; i < testcase; i++){
			int num = scanner.nextInt();
			int mix[][] = new int[num][52];
			
			for(int j = 0; j < num; j++){
				for(int k = 0; k < 52; k++){
					mix[j][k] = scanner.nextInt()-1;
				}
			}
			scanner.nextLine();
			
			int[] deck = new int[52];
			for(int l = 0; l < deck.length; l++)
				 deck[l] = l;
			
			while(scanner.hasNextLine()){
				
				String line = scanner.nextLine();
				if(line.equals(""))
					break;
				
				int s = Integer.parseInt(line) - 1;
				
				int[] temp = new int[52];
				for(int m = 0; m < temp.length; m++)
					temp[m] = deck[mix[s][m]];
				deck = temp.clone();
			}
			
			String[] card = new String[52];
			
			String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
			String[] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

			int cun = 0;
			for(int m = 0; m < 4; m++){
				for(int o = 0; o < 13; o++)
					card[cun++] = value[o] + " of " + suit[m];
			}
	
			for(int p = 0; p < card.length; p++){
				System.out.println(card[deck[p]]);
			}
			System.out.println();
		}
		
	}
}	
	