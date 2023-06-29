import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int[][] caseD;
		int t, n, c;
		String tem, temp;

		
		t = input.nextInt();
		for(int v = 0; v < t; v++){
			String[] original = {"", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC", "AC",
												 "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD", "AD",
												"2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH", "AH",
												"2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "QS", "KS", "AS"};
			String[] result = {"", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC", "AC",
												"2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD", "AD",
												"2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH", "AH",
												"2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "QS", "KS", "AS"};
			n = input.nextInt();
			caseD = new int[n+1][54];
			for(int i = 1; i <= n; i++)
				for(int k = 1; k < 53; k++)
					caseD[i][k] = input.nextInt();
			tem = input.nextLine();
			
			while(input.hasNextLine()){
				tem = input.nextLine();
				if(tem.length() == 0)
					break;
				c = Integer.parseInt(tem);
				for(int i = 1; i < 53; i++)
					result[i] = original[caseD[c][i]];
				for(int i = 1; i < 53; i++)
					original[i] = result[i];
			}
			
			for(int i = 1; i < 53; i++){
				switch(result[i].charAt(0)){
					case 'T': System.out.print("10"); break;
					case 'J': System.out.print("Jack"); break;
					case 'Q': System.out.print("Queen"); break;
					case 'K': System.out.print("King"); break;
					case 'A': System.out.print("Ace"); break;
					default : System.out.print(result[i].charAt(0));
				}
				System.out.print(" of ");
				switch(result[i].charAt(1)){
					case 'C': System.out.print("Clubs"); break;
					case 'D': System.out.print("Diamonds"); break;
					case 'H': System.out.print("Hearts"); break;
					case 'S': System.out.print("Spades"); break;
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}