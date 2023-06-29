import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {
	static int getValue(int x){
		return ((x) / 10);
	}
	static int getSuit(int x){
		return ((x) % 10);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		boolean loop = false;
		
		while((s = br.readLine()) != null){
			StringTokenizer st = new StringTokenizer(s);
			
			int [][] hand = new int[2][5];
			long [] handValue = new long[2];
			for(int i = 0; i < 2; i++){
				for(int j = 0; j < 5; j++){
					hand[i][j] = encode(st.nextToken());
				}
				handValue[i] = function(hand[i]);
			}
		
			if(handValue[0] > handValue[1])
				System.out.println("Black wins.");
			else if(handValue[1] > handValue[0])
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
		}
	}
	static int encode(String card){
		int result;
		
		switch(card.charAt(0)){
			case 'T' : result = 100; break;
			case 'J' : result = 110; break;
			case 'Q' : result = 120; break;
			case 'K' : result = 130; break;
			case 'A' : result = 140; break;
			default : result = (card.charAt(0) - '0') * 10;
		}
		switch(card.charAt(1)){
			case 'H' : result += 1; break;
			case 'D' : result += 2; break;
			case 'S' : result += 3; break;
			case 'C' : result += 4; break;	
		}
		return result;
	}
	static long function(int [] hand){
		int temp;
		int[] value = new int[5];
		int[] suit = new int[5];
		long result = 0;
		
		for(int i = 0; i < 4; i++){
			for(int j = i + 1; j < 5; j++){
				if(hand[i] < hand[j]){
					temp = hand[i];
					hand[i] = hand[j];
					hand[j] = temp;
				}
			}
		}
		for(int i = 0; i < 5; i++){
			value[i] = getValue(hand[i]);
			suit[i] = getSuit(hand[i]);
		}
		
		if(value[1] + 1 == value[0] && suit[1] == suit[0]
				&& value[2] + 2 == value[0] && suit[2] == suit[0]
				&& value[3] + 3 == value[0] && suit[3] == suit[0]
				&& value[4] + 4 == value[0] && suit[4] == suit[0])
			result = (9 << 20) + (value[0] << 16);
		
		else if(value[0] == value[3] || value[1] == value[4])
			result = (8 << 20) + (value[1] << 16);
		
		else if(value[0] == value[2] && value[3] == value[4])
			result = (7 << 20) + (value[0] << 16);
		else if(value[0] == value[1] && value[2] == value[4])
			result = (7 << 20) + (value[2] << 16);
		
		else if(suit[0] == suit[1] && suit[0] == suit[2]
					 	&& suit[0] == suit[3] && suit[0] == suit[4])
			result = (6 << 20) + (value[0] << 16) + (value[1] << 12)
							+ (value[2] << 8) + (value[3] << 4) + value[4];
		
		else if(value[1] + 1 == value[0] && value[2] + 2 == value[0]
					 	&& value[3] + 3 == value[0] && value[4] + 4 == value[0])
			result = (5 << 20) + (value[0] << 16);
		
		else if(value[0] == value[2] || value[1] == value[3] 
						|| value[2] == value[4])
			result = (4 << 20) + (value[2] << 16);
		
		else if(value[0] == value[1])
			result = (3 << 20) + (value[0] << 16) + (value[2] << 12)
							+ (value[3] << 8) + (value[4] << 4);
		else if(value[1] == value[2])
			result = (3 << 20) + (value[1] << 16) + (value[0] << 12)
							+ (value[3] << 8) + (value[4] << 4);
		else if(value[2] == value[3])
			result = (3 << 20) + (value[2] << 16) + (value[0] << 12)
							+ (value[1] << 8) + (value[4] << 4);
		else if(value[3] == value[4])
			result = (3 << 20) + (value[3] << 16) + (value[0] << 12)
							+ (value[1] << 8) + (value[2] << 4);
		
		else
			result = (2 << 20) + (value[0] << 16) + (value[1] << 12)
							+ (value[2] << 8) + (value[3] << 4) + value[4];
		
		return result;
	}
}