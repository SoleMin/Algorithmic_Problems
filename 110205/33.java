import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc, set, shuffle[][], cards[];
		int select;
		String blank;
		tc = sc.nextInt();
		sc.nextLine(); sc.nextLine();
		
		for(int t=1; t<=tc; t++) {
			//입력
			set = sc.nextInt();
			shuffle = new int[set][52];
			for(int i=0; i<set; i++)
				for(int j=0; j<52; j++)
					shuffle[i][j] = sc.nextInt();
			sc.nextLine();
			
			//카드 섞기
			cards = new int[52];
			for(int i=0; i<52; i++)
				cards[i] = i;
			int temp[] = new int[52];
			while(sc.hasNextLine()) {
				blank = sc.nextLine();
				if(blank.equals(""))
					break;
				select = Integer.parseInt(blank) - 1;
				for(int c=0; c<52; c++)
					temp[c] = cards[shuffle[select][c]-1];
				for(int c=0; c<52; c++)
					cards[c] = temp[c];
			}
			
			//카드 프린트
			for(int i=0; i<cards.length; i++)
				printCard(cards[i]);
			System.out.println();
			continue;
		}
		sc.close();
	}
	
	public static void printCard(int card) {
		int pattern = (int) (card / 13);
		int number = card % 13;
		
		//Jack Queen King Ace - 9 10 11 12
		switch(number) {
			case 9: System.out.print("Jack of "); break;
			case 10: System.out.print("Queen of "); break;
			case 11: System.out.print("King of "); break;
			case 12: System.out.print("Ace of "); break;
			default: System.out.print((number+2) + " of ");
		}
		
		//Patterns
		switch(pattern) {
			case 0: System.out.println("Clubs"); break;
			case 1: System.out.println("Diamonds"); break;
			case 2: System.out.println("Hearts"); break;
			case 3: System.out.println("Spades"); break;
		}
	}
}