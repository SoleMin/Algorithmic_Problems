import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while (input.hasNextLine()){
			int[][] hands = new int[2][5];
			long[] value = new long[2];
			for (int i = 0; i < 2; i++){
				for (int j = 0; j < 5; j++){
					hands[i][j] = encodeCard(input.next());
				}
				value[i] = getHandValue(hands[i]);
			}
			if(value[0] > value[1])
				System.out.println("Black wins.");
			else if(value[0] < value[1])
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
			input.nextLine();
		}
	}
	
	public static int getValue(int n){
		return n/10;
	}
	public static int getSuit(int n){
		return n%10;
	}
	public static int encodeCard(String card){
		int result;
		switch (card.charAt(0)){
			case 'T': result = 100; break;
			case 'J': result = 110; break;
			case 'Q': result = 120; break;
			case 'K': result = 130; break;
			case 'A': result = 140; break;
			default: result = (card.charAt(0) - '0') * 10;
		}
		switch (card.charAt(1)){
			case 'H': result += 1; break;
			case 'D': result += 2; break;
			case 'S': result += 3; break;
			case 'c': result += 4; break;
		}
		return result;
	}
	public static long getHandValue(int[] hands){
		int[] value = new int[5];
		int[] suit = new int[5];
		long result = 0;
		for (int i = 0; i < 4; i++){
			int max = i;
			for (int j = i + 1; j < 5; j++)
				if (hands[j] > hands[max])
					max = j;
			int temp = hands[i];
			hands[i] = hands[max];
			hands[max] = temp;
		}
		for(int i = 0; i < 5; i++){
			value[i] = getValue(hands[i]);
			suit[i] = getSuit(hands[i]);
		}
		
		// straight flush
		if(value[1] + 1 == value[0] && suit[1] == suit[0] && value[2] + 2 == value[0] && suit[2] == suit[0] && value[3] + 3 == value[0] && suit[3] == suit[0] && value[4] + 4 == value[0] && suit[4] == suit[0])
			result = (9 << 20) + (value[0] << 16);
		// four
		else if(value[0] == value[3] || value[1] == value[4])
			result = (8 << 20) + (value[1] << 16);
		// full house
		else if((value[0] == value[2] && value[3] == value[4]) || (value[0] == value[1] && value[2] == value[4]))
			result = (7 << 20) + (value[0] << 16);
		// flush
		else if(suit[1] == suit[0] && suit[2] == suit[0] && suit[3] == suit[0] && suit[4] == suit[0])
			result = (6 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[1] << 4) + value[4];
		//straight
		else if(value[1] + 1 == value[0] && value[2] + 2 == value[0] && value[3] + 3 == value[0] && value[4] + 4 == value[0])
			result = (5 << 20) + (value[0] << 16);
		// three
		else if(value[0] == value[2] || value[1] == value[3] || value[2] == value[4])
			result = (4 << 20) + (value[2] << 16);
		//two 
		else if(value[0] == value[1] && value[2] == value[3])
			result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[4] << 8);
		else if(value[0] == value[1] && value[3] == value[4])
			result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[2] << 8);
		else if(value[1] == value[2] && value[3] == value[4])
			result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[0] << 8);
		//one
		else if(value[0] == value[1])
			result = (2 << 20) + (value[0] << 16) + (value[2] << 12) + (value[3] << 8) + (value[4] << 4);
		else if(value[1] == value[2])
			result = (2 << 20) + (value[1] << 16) + (value[0] << 12) + (value[3] << 8) + (value[4] << 4);
		else if(value[2] == value[3])
			result = (2 << 20) + (value[2] << 16) + (value[0] << 12) + (value[1] << 8) + (value[4] << 4);
		else if(value[3] == value[4])
			result = (2 << 20) + (value[3] << 16) + (value[0] << 12) + (value[1] << 8) + (value[2] << 4);
		//high card
		else
			result = (1 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3]<< 4) + value[4];
		return result;
	}
}