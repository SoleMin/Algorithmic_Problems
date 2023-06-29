import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testCase = input.nextInt();
		input.nextLine();
		input.nextLine();
		
		String[] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", 				  												"Queen","King", "Ace"};
		String[] shape = {"Clubs", "Diamonds", "Hearts", "Spades"};
		
		for(int i = 0; i < testCase; i++){
			int shufNum = input.nextInt();
			int[][] mixNum = new int[shufNum][52];
			for(int j = 0; j < shufNum; j++){
				for(int k = 0; k < 52; k++){
					mixNum[j][k] = input.nextInt() - 1;
				}
				input.nextLine();
			}
			int[] oldMix = new int[52];
			for(int j = 0; j < 52; j++)
				oldMix[j] = j;
			
			while(input.hasNextLine()){
				String howShuf = input.nextLine();
				if(howShuf.equals(""))
					break;
				
				int howShuffle = Integer.parseInt(howShuf) - 1;
				int[] newMix = new int[52];
				for(int j = 0; j < 52; j++)
					newMix[j] = oldMix[mixNum[howShuffle][j]];
				oldMix = newMix.clone();
			}
			String[] card = new String[52];
			int num = 0;
			for(int j = 0; j < 4; j++){
				for(int k = 0; k < 13; k++){
					card[num++] = value[k] + " of " + shape[j];
				}
			}
			for(int j = 0; j < 52; j++)
				System.out.println(card[oldMix[j]]);
			System.out.println();
		}
		input.close();
	}
}