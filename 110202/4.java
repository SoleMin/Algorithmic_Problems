import java.util.Scanner;
import java.util.StringTokenizer;
class Main {
	
	static int encode_card(char[] card) {
		int result;
		
		switch(card[0]) {
			case 'T' : result = 100; break;
			case 'J' : result = 110; break;
			case 'Q' : result = 120; break;
			case 'K' : result = 130; break;
			case 'A' : result = 140; break;
			default: result = (card[0] - '0') * 10;
		}
		switch(card[1]) {
			case 'H' : result += 1; break;
			case 'D' : result += 2; break;
			case 'S' : result += 3; break;
			case 'C' : result += 4; break;
		}
		return result;
	}
	
	static long get_hand_value(int hand[]) {
		int max, temp;
		int value[] = new int[5];
		int suit[] = new int[5];
		long result = -1;
		for(int i = 0; i < 4; i++) {
			max = i;
			for(int j = i + 1; j < 5; j++) {
				if(hand[j] > hand[max]) {
					max = j;
				}
			}
			temp = hand[i];
			hand[i] = hand[max];
			hand[max] = temp;
		}
		for(int i = 0; i < 5; i++) {
			value[i] = hand[i] / 10;
			suit[i] = hand[i] % 10;
		}
		
		// straight flush
		if(value[1] + 1 == value[0] && suit[1] == suit[0] &&
			value[2] + 2 == value[0] && suit[2] == suit[0] &&
			value[3] + 3 == value[0] && suit[3] == suit[0] &&
			value[4] + 4 == value[0] && suit[4] == suit[0])
			result = (9 << 20) + (value[0] << 16);
		
		// four card
		else if(value[0] == value[1] && value[0] == value[2] && value[0] == value[3])
			result = (8 << 20) + (value[0] << 16);
		
		// full house
		else if(value[0] == value[1] && value[0] == value[2] && value[3] == value[4])
			result = (7 << 20) + (value[0] << 16);
		else if(value[0] == value[1] && value[2] == value[3] && value[2] == value[4])
			result = (7 << 20) + (value[2] << 16);
		
		// flush
		else if(suit[0] == suit[1] && suit[0] == suit[2] && suit[0] == suit[3] && suit[0] == suit[4])
			result = (6 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] + 8) + (value[3] + 4) + value[4];
		
		// straight
		else if(value[1] + 1 == value[0] && value[2] + 2 == value[0] && value[3] + 3 == value[0] && value[4] + 4 == value[0])
			result = (5 << 20) + (value[0] << 16);
		
		// three card
		else if(value[0] == value[1] && value[0] == value[2])
			result = (4 << 20) + (value[0] << 16);
		else if(value[1] == value[2] && value[1] == value[3])
			result = (4 << 20) + (value[1] << 16);
		else if(value[2] == value[3] && value[2] == value[4])
			result = (4 << 20) + (value[2] << 16);
		
		// two pair
		else if(value[0] == value[1] && value[1] == value[2])
			result = (3 << 20) + (value[0] << 16) + (value[2] << 12) + (value[4] << 8);
		else if(value[0] == value[1] && value[3] == value[4])
			result = (3 << 20) + (value[0] << 16) + (value[3] << 12) + (value[2] << 8);
		else if(value[1] == value[2] && value[3] == value[4])
			result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[0] << 8);
		
		// one pair
		else if(value[0] == value[1])
			result = (2 << 20) + (value[0] << 16) + (value[2] << 12) + (value[3] << 8) + (value[4] << 4);
		else if(value[1] == value[2])
			result = (2 << 20) + (value[1] << 16) + (value[0] << 12) + (value[3] << 8) + (value[4] << 4);
		else if(value[2] == value[3])
			result = (2 << 20) + (value[2] << 16) + (value[0] << 12) + (value[1] << 8) + (value[4] << 4);
		else if(value[3] == value[4])
			result = (2 << 20) + (value[3] << 16) + (value[0] << 12) + (value[1] << 8) + (value[2] << 4);
		
		// high card
		else
			result = (1 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
		
		return result;
	}
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String draw;
		StringTokenizer st;
		int[] black = new int[5];
		int[] white = new int[5];
		long result = 0;
		
		while(scan.hasNextLine()) {
			draw = scan.nextLine();
			st = new StringTokenizer(draw, " ");
			for(int i = 0; i < 5; i++) {
				black[i] = encode_card(st.nextToken().toCharArray());
			}
			for(int i = 0; i < 5; i++) {
				white[i] = encode_card(st.nextToken().toCharArray());
			}
			result = get_hand_value(black) - get_hand_value(white);
			
			if(result > 0)
				System.out.println("Black wins.");
			else if(result < 0)
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
		}
	}
}