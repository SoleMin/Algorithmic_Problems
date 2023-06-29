import java.io.*;
import java.util.Scanner;

class Main {
	static String[] initDec() {
		String[] cardPattern = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] dec = new String[52];
		int index = 0;
		for(int i = 0; i < cardPattern.length; i++) {
			for(int j = 2; j <= 10; j++) {
				dec[index] = Integer.toString(j) + " of " + cardPattern[i];
				index++;
			}
			dec[index++] = "Jack of " + cardPattern[i];
			dec[index++] = "Queen of " + cardPattern[i];
			dec[index++] = "King of " + cardPattern[i];
			dec[index++] = "Ace of " + cardPattern[i];
		}
		return dec;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		int n;
		String[] dec = initDec();
		String[][] newDec = new String[tc][52];
		for(int i = 0; i < tc; i++) {
			for(int j = 0; j < 52; j++) {
				newDec[i][j] = dec[j];
			}
		}
		
		for(int i = 0; i < tc; i++) {
			dec = initDec();
			n = scan.nextInt();
			int[][] mode = new int[n][52];
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < 52; k++) {
					mode[j][k] = scan.nextInt() - 1;
				}
			}
			scan.nextLine();
			while(scan.hasNextLine()) {
				String inputMode = scan.nextLine();
				if(inputMode.trim().equals(""))
					break;
				else {
					int modeNum = Integer.parseInt(inputMode) - 1;
					for(int m = 0; m < 52; m++) {
						newDec[i][m] = dec[mode[modeNum][m]];
					}
					for(int m = 0; m < 52; m++) {
						dec[m] = newDec[i][m];
					}
				}
			}
		}
		for(int i = 0; i < tc; i++) {
			for(int j = 0; j < 52; j++) {
				System.out.println(newDec[i][j]);
			}
			System.out.println();
		}
	}
}