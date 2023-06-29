import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[] black = new int[5];
		int[] white = new int[5];
		while(input.hasNextLine()) {
			String s = input.nextLine();
			Scanner cutter = new Scanner(s);
			for(int i=0; i<5; i++)
				black[i] = encode(cutter.next());
			for(int i=0; i<5; i++)
				white[i] = encode(cutter.next());
			cutter.close();
			
			int blackHand = handValue(black);
			int whiteHand = handValue(white);
			
			if(blackHand > whiteHand)
				System.out.println("Black wins.");
			else if(blackHand < whiteHand)
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
		}
	}
	
	public static int encode(String card) {
		int result;
		
		switch(card.charAt(0)) {
			case 'T' : result = 100; break;
			case 'J' : result = 110; break;
			case 'Q' : result = 120; break;
			case 'K' : result = 130; break;
			case 'A' : result = 140; break;
			default : result = (card.charAt(0) - '0') * 10;
		}
		switch(card.charAt(1)) {
			case 'H' : result += 1; break;
			case 'D' : result += 2; break;
			case 'S' : result += 3; break;
			case 'C' : result += 4; break;
		}
		
		return result;
	}
	
	public static int handValue(int[] cards) {
		int max, temp;
		for(int i=0; i<4; i++) {
			max = i;
			for(int j=i+1; j<5; j++)
				if(cards[j] > cards[max])
					max = j;
			temp = cards[i];
			cards[i] = cards[max];
			cards[max] = temp;
		}
		
		int value[] = new int[5];
		int suit[] = new int[5];
		for(int i=0; i<5; i++) {
			value[i] = cards[i]/10;
			suit[i] = cards[i]%10;
		}
		
		int result;
		/* straight flush */
		if(value[1]+1==value[0] && suit[1]==suit[0]
					&& value[2]+2==value[0] && suit[2]==suit[0]
					&& value[3]+3==value[0] && suit[3]==suit[0]
					&& value[4]+4==value[0] && suit[4]==suit[0])
			result = 9000000 + value[0];
		/* four card */
		else if(value[1]==value[2] && value[2]==value[3]
					&& (value[0]==value[1] || value[3]==value[4]))
			result = 8000000 + value[1];
		/* full house */
		else if(value[0]==value[1] && value[3]==value[4]
					&& (value[1]==value[2] || value[2]==value[3]))
			result = 7000000 + value[2];
		/* flush */
		else if(suit[0]==suit[1] && suit[1]==suit[2] && suit[2]==suit[3] && suit[3]==suit[4])
			result = 6000000 + value[0]*15*15*15*15 + value[1]*15*15*15
			+ value[2]*15*15 + value[3]*15 + value[4];
		/* straight */
		else if(value[1]+1==value[0] && value[2]+2==value[0]
					&& value[3]+3==value[0] && value[4]+4==value[0])
			result = 5000000 + value[0];
		/* three card */
		else if((value[0]==value[1] && value[1]==value[2])
					 || (value[1]==value[2] && value[2]==value[3])
					 || (value[2]==value[3] && value[3]==value[4]))
			result = 4000000 + value[2];
		/* two pair */
		else if((value[0]==value[1] && value[2]==value[3])
					 || (value[0]==value[1] && value[3]==value[4])
					 || (value[1]==value[2] && value[3]==value[4]))
			result = 3000000 + value[1];
		/* one pair */
		else if(value[0]==value[1] || value[1]==value[2])
			result = 2000000 + value[1];
		else if(value[2]==value[3] || value[3]==value[4])
			result = 2000000 + value[3];
		/* high card */
		else
			result = 1000000 + value[0]*15*15*15*15 + value[1]*15*15*15
			+ value[2]*15*15 + value[3]*15 + value[4];
		
		return result;
	}
}