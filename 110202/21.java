import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int [] black = new int [5];
		int [] white = new int [5];
		
		while(scan.hasNext()) {
			for (int i = 0; i < 5; i ++)
				black[i] = encodeCard(scan.next());
			for (int i = 0; i < 5; i ++)
				white[i] = encodeCard(scan.next());
			if (getHandValue(black) > getHandValue(white)) System.out.println("Black wins.");
			else if (getHandValue(black) < getHandValue(white)) System.out.println("White wins.");
			else System.out.println("Tie.");
		}
	}
	
	public static int encodeCard (String card) {
		int result;
		
		switch (card.charAt(0)) {
			case 'T' : result = 100; break;
			case 'J' : result = 110; break;
			case 'Q' : result = 120; break;
			case 'K' : result = 130; break;
			case 'A' : result = 140; break;
			default : result = (card.charAt(0)- '0') * 10; 
		}
		
		switch (card.charAt(1)) {
			case 'H' : result += 1; break;
			case 'D' : result += 2; break;
			case 'S' : result += 3; break;
			case 'C' : result += 4; break;
		}
		return result;
	}

	public static long getHandValue (int[] hand) {
		int max, temp;
		int [] value = new int [5];
		int [] suit = new int [5];
		long result;
		
		for (int i = 0; i < 4; i++) {
			max = i;
			for (int j = i+1; j < 5; j++)
				if (hand[j] > hand[max])
					max = j;
			temp = hand[i];
			hand[i] = hand[max];
			hand[max] = temp;
		}
		
		for (int i = 0; i < 5; i ++) {
			value[i] = getValue(hand[i]);
			suit[i] = getSuit(hand[i]);
		}
		
		/* straight flush */
		if (value[1] + 1 == value[0] && suit[1] == suit[0]
			 && value[2] + 2 == value[0] && suit[2] == suit[0]
			 && value[3] + 3 == value[0] && suit[3] == suit[0]
			 && value[4] + 4 == value[0] && suit[4] == suit[0])
			return result = (9 << 20) + (value[0] << 16);
		
		/* four card */
		int [] num = new int[15];
		for (int i = 1; i < 15; i ++)
			num[i] = 0;
		for (int i = 0; i < 5; i ++)
			num[value[i]]++;
		
		if (num[value[0]] == 4)
			return result = (8 << 20) + (value[0] << 16);
		else if (num[value[1]] == 4)
			return result = (8 << 20) + (value[1] << 16);
		
		/* full house */
		boolean isTwo = false;
		for(int i = 1; i < 15; i ++) {
			if (num[i] == 2) isTwo = true; 
		}
		
		if (num[value[0]] == 3)
			if (isTwo == true)
				return result = (7 << 20) + (value[0] << 16);
		else if (num[value[1]] == 3)
			if (isTwo == true)
				return result = (7 << 20) + (value[1] << 16);
		else if (num[value[2]] == 3)
			if (isTwo == true)
				return result = (7 << 20) + (value[2] << 16);
		
		/* flush */
		if (suit[0] == suit[1] && suit[0] == suit[2] &&
			 suit[0] == suit[3] && suit[0] == suit[4]) {
			return result = (6 << 20) + (value[0] << 16) + (value[1] << 12) +
																	(value[2] << 8) + (value[3] << 4) + (value[4] << 0);
		}
		
		/* straight */
		if (value[1] + 1 == value[0] && value[2] + 2 == value[0] &&
			 value [3] + 3 == value[0] && value[4] + 4 == value[0])
			return result = (5 << 20) + (value[0] << 16);
		
		/* three card */
		int threeCard = 0;
		
		for(int i = 1; i < 15; i ++) {
			if (num[i] == 3) threeCard = i;
		}
		if (threeCard != 0)
			return result = (4 << 20) + (threeCard << 16);
		
		/* two fair */
		int twoCard = 0;
		int cardNum = 0;
		int cardNum2 = 0;
		int last = 0;
		for (int i = 1; i < 15; i ++) {
			if (num[i] == 2) {
				twoCard++;
				if (cardNum == 0) cardNum = i;
				else cardNum2 = i;
			}
			else if (num[i] == 1) last = i;
		}
		
		if (twoCard == 2) {
			result = 0;
			if (cardNum > cardNum2) result = (3 << 20) + (cardNum << 16) + (cardNum2 << 12) + (last << 8);
			else if (cardNum < cardNum2) result = (3 << 20) + (cardNum2 << 16) + (cardNum << 12) + (last << 8);
			return result;
		}
		
		/* one fair */
		if (twoCard == 1){
			if (cardNum != value[0]) return result = (2 << 20) + (cardNum << 16) + (value[0] << 12);
			else return result = (2 << 20) + (cardNum << 16) + (value[2] << 12);
		}
			
		/* high card */
		result = (1 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) +
												(value[3] << 4) + (value[4] << 0);
		return result;
	}
	
	public static int getValue (int x){
		return x / 10;
	}
	public static int getSuit (int x) {
		return x * 10;
	}
}