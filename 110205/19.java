import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int widnum = sc.nextInt();
		System.out.println();
		
		for (int i = 0; i < widnum; i++) {
			int casenum = sc.nextInt();
			int[][] caseset = new int[casenum+1][53];
			int[][] set = new int[1][53];
			
			for(int w = 1; w <= 13; w++) {
				set[0][w] = (w%13+1)*10 + 1;
			}
			for(int w = 14; w <= 26; w++) {
				set[0][w] = (w%13+1)*10 + 2;
			}
			for (int w = 27; w <= 39; w++) {
				set[0][w] = (w%13+1)*10 + 3;
			}
			for (int w = 40; w <= 52; w++) {
				set[0][w] = (w%13+1)*10 + 4;
			}
			
			for (int k = 1; k <= casenum; k++) {
				for (int q = 1; q <= 52; q++) {
					caseset[k][q] = sc.nextInt();
				}
			}
			
			String exenum = sc.nextLine();
			
			while(sc.hasNextInt()) {
				exenum = sc.nextLine();
				
				if (exenum.equals("")) {
					break;
				}
				
				int[][] tempset = new int[1][53];
				
				for (int r = 1; r <= 52; r++) {
					tempset[0][r] = set[0][caseset[Integer.parseInt(exenum)][r]];
				}
				set = tempset;
			}
			
			printcard(set);
			System.out.println();
		
		}
	}
	
	public static void printcard(int[][] card) {
		for(int i = 1; i <= 52; i++) {
			
			switch (card[0][i]/10) {
				case 11:
					System.out.print("Jack ");
					break;
				case 12:
					System.out.print("Queen ");
					break;
				case 13:
					System.out.print("King ");
					break;
				case 1:
					System.out.print("Ace ");
					break;
				default :
					System.out.printf("%d ", card[0][i]/10);
			}
			
			System.out.print("of ");
			
			switch (card[0][i]%10) {
				case 1:
					System.out.print("Clubs");
					break;
				case 2:
					System.out.print("Diamonds");
					break;
				case 3:
					System.out.print("Hearts");
					break;
				case 4:
					System.out.print("Spades");
					break;
			}
			System.out.println();
		}
	}
}