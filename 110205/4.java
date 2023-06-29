import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = input.nextInt();
		input.nextLine();
		for(int r=0; r<repeat; r++) {
			int n = input.nextInt();
			int[][] suffle = new int[n][52];
			for(int i=0; i<n; i++)
				for(int j=0; j<52; j++)
					suffle[i][j] = input.nextInt();
			
			int[] cards = new int[52];
			for(int i=0; i<52; i++)
				cards[i] = i;
			
			int[] cardsTemp = new int[52];
			String s = input.nextLine();
			s = input.nextLine();
			while(!s.isEmpty()) {
				int command = Integer.parseInt(s) - 1;
				for(int i=0; i<52; i++)
					cardsTemp[i] = cards[suffle[command][i]-1];
				for(int i=0; i<52; i++)
					cards[i] = cardsTemp[i];
				
				if(!input.hasNextLine())
					break;
				s = input.nextLine();
			}
			
			if(r>0)
				System.out.println();
			for(int i=0; i<52; i++) {
				switch(cards[i]%13)
				{
					case 9: System.out.print("Jack"); break;
					case 10: System.out.print("Queen"); break;
					case 11: System.out.print("King"); break;
					case 12: System.out.print("Ace"); break;
					default: System.out.print(cards[i]%13 + 2);
				}
				System.out.print(" of ");
				switch(cards[i]/13)
				{
					case 0: System.out.println("Clubs"); break;
					case 1: System.out.println("Diamonds"); break;
					case 2: System.out.println("Hearts"); break;
					case 3: System.out.println("Spades"); break;
					default: System.out.println("문양 출력 관련 오류 발생");
				}
			}
		}
	}
}