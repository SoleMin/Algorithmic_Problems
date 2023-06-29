import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int casenum = scan.nextInt();
		scan.nextLine();
		
		String[] setcard = new String[52];
		String[] num = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		String[] pat = {"Clubs","Diamonds","Hearts","Spades"};
		int n = 0;
		for(int i = 0; i < 4; i++ ){
			for(int j = 0; j <13;j++){
			setcard[n++] = num[j] + " of "+ pat[i];
			}
		}
		
		for(int k = 0; k < casenum ; k++){
			
			int[] deck = new int[52];
			for(int a = 0; a < 52; a++){
				deck[a] = a;
			}
			
			int shuf = scan.nextInt();
			int[][] shufcase = new int[shuf][52];
			for(int a= 0; a< shuf; a++){
				for(int b = 0; b< 52;b++ ){
					shufcase[a][b] = scan.nextInt();
				}
				scan.nextLine();
			}
			int[] changedeck = new int[52];
			while(scan.hasNextLine()){
				String shufnum = scan.nextLine();
				if(shufnum.equals("")) break;
				int shuffle_number = Integer.parseInt(shufnum);
				
				for(int l = 0; l< 52; l++){
					changedeck[l] = deck[shufcase[shuffle_number-1][l]-1]; 
				}
				System.arraycopy(changedeck,0,deck,0,deck.length);
			}
			for(int b = 0; b< 52 ; b++){
				System.out.println(setcard[deck[b]]);
			}
			System.out.println("");
		}
	}
}