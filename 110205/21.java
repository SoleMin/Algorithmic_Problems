import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
		
	private static void printCards(int[] cards) {
		int number, shape;
		
		for (int i = 0; i < 52; i++){
			number = cards[i] % 13;
			shape = cards[i] / 13;
			
			switch (number)
			{
				case 0 :
					System.out.print("Ace");
					shape--;
					break;
					
				case 10 :
					System.out.print("Jack");
					break;
					
				case 11 :
					System.out.print("Queen");
					break;
					
				case 12 :
					System.out.print("King");
					break;
					
				default :
					System.out.print(number + 1);
					break;
					
			}
			
			System.out.print(" of ");
			
			switch (shape)
			{
				case 0 :
					System.out.print("Clubs");
					break;
					
				case 1 :
					System.out.print("Diamonds");
					break;
					
				case 2 :
					System.out.print("Hearts");
					break;
					
				case 3 :
					System.out.print("Spades");
					break;
			}
			
			//System.out.println(" " + cards[i]);
			System.out.println();
		}
		
		System.out.println();
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = input.nextInt();
		
		int [][] mix;
		int [] card = new int[52];
		int [] temp = new int[52];
		int numMix, now = 0;
		
		for (int i = 0; i < cases; i++){
			
			for (int j = 0; j < 52; j++)
				card[j] = j + 1;
			
			numMix = input.nextInt();
			//System.out.println("numMix = " + numMix);
			
			mix = new int [numMix][52];
			
			for (int j = 0; j < numMix; j++)
				for (int k = 0; k < 52; k++)
					mix[j][k] = input.nextInt();
			
			boolean again = true;
			
			input.nextLine();
			
			while (input.hasNextLine()) {
				
				String a = input.nextLine();
				
				if (a.equals("")){
					again = false;
					break;
				}
				
				
				
					//System.out.println(a);
// 				//now = 1;
 				now = Integer.parseInt(a);
				//System.out.println("now : " + now);
		
				
				
				for (int j = 0; j < 52; j++){
					temp[j] = card[(mix[now - 1][j]) - 1];
					//System.out.print(" "+ temp[j]);
				}
				//System.out.println();
				
				for (int j = 0; j < 52; j++)
					card[j] = temp[j];
				
				
					
			}	
			
			printCards(card);
			
			
	
		//printCards(card);
	
		
		}
		
	}

	
}