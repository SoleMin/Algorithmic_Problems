import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		final int NUM_CARDS = 52;
		final int MAX_SHUFFLES = 100;
		
		int[][] shuffle = new int[MAX_SHUFFLES][NUM_CARDS + 1];
		int[] deck = new int[NUM_CARDS + 1];
		int[] old_deck = new int[NUM_CARDS + 1];
		String line;
		int num_cases, num_shuffles;
		int t, i, j, k;
		int suit, value;
		
		num_cases = sc.nextInt();
		sc.hasNextLine();
		
		for(t = 0; t < num_cases; t++)
		{
			num_shuffles = sc.nextInt();
			for(i = 1; i <= num_shuffles; i++)
			{
				for(j = 1; j <= NUM_CARDS; j++)
					shuffle[i][j] = sc.nextInt();
			}
			
			for(i = 1; i <= NUM_CARDS; i++)
				deck[i] = i;
			
			line = sc.nextLine();
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				if(line.equals(""))
					break;
				
				k = Integer.parseInt(line);
				
				for(i = 1; i <= NUM_CARDS; i++)
					old_deck[i] = deck[i];
				for(i = 1; i <= NUM_CARDS; i++)
					deck[i] = old_deck[shuffle[k][i]];
			}
			if(t > 0)
				System.out.println();
			
			for(i = 1; i <= 52; i++)
			{
				value = (deck[i] - 1) % 13;
				suit = (deck[i] - 1) / 13;
				
				switch(value)
				{
					case 9: System.out.print("Jack"); break;
					case 10: System.out.print("Queen"); break;
					case 11: System.out.print("King"); break;
					case 12: System.out.print("Ace"); break;
					default: System.out.print(value + 2); break;
				}
				System.out.print(" of ");
				switch(suit)
				{
					case 0: System.out.print("Clubs\n"); break;
					case 1: System.out.print("Diamonds\n"); break;
					case 2: System.out.print("Hearts\n"); break;
					case 3: System.out.print("Spades\n"); break;
				}
			}
		}
		sc.close();
	}
}