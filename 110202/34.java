import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while ((input = br.readLine()) != null) {
			if (input.equals("")) {
				break;
			}
			
			String inputs[] = input.split(" ");
			int cards[] = new int[10];
			
			int whites[] = new int[5];
			int blacks[] = new int[5];
			int temp = 0;
			
			for (int i = 0; i < 10; i++) {
				// cards[i] = encodeCard(inputs[i]);
				if (i < 5) {
					blacks[i] = encodeCard(inputs[i]); //cards[i];
				}
				else {
					whites[temp] = encodeCard(inputs[i]); // cards[i];
					temp++;
				}
			}
			
			long blackResult = getHandValue(blacks);
			long whiteResult = getHandValue(whites);
			
			if (blackResult > whiteResult) {
				System.out.println("Black wins.");
			}
			else if (blackResult < whiteResult) {
				System.out.println("White wins.");
			}
			else {
				System.out.println("Tie.");
			}
		}
	}
	
	public static int encodeCard(String card) {
		int result = 0;
		
		switch (card.charAt(0)) {
			case 'T' :
				result = 100;
				break;
			case 'J' :
				result = 110;
				break;
			case 'Q' :
				result = 120;
				break;
			case 'K' :
				result = 130;
				break;
			case 'A' :
				result = 140;
				break;
			default :
				result = (card.charAt(0) - '0') * 10;
		}
		
		switch (card.charAt(1)) {
			case 'H' :
				result = result + 1;
				break;
			case 'D' :
				result = result + 2;
				break;
			case 'S' :
				result = result + 3;
				break;
			case 'C' :
				result = result + 4;
				break;
		}
		
		return result;
	}
	
	public static long getHandValue(int hand[]) {
		int max = 0;
		int temp = 0;
		int value[] = new int[5];
		int suit[] = new int[5];
		long result = 0;
		
		for (int i = 0; i < 4; i++) {
			max = i;
			for (int j = i + 1; j < 5; j++) {
				if (hand[j] > hand[max]) {
					max = j;
				}
			}
			temp = hand[i];
			hand[i] = hand[max];
			hand[max] = temp;
		}
		
		for (int i = 0; i < 5; i++) {
			value[i] = hand[i] / 10; 
			suit[i] = hand[i] % 10;
		}
		
		if (value[1] + 1 == value[0] && suit[1] == suit[0]
			 && value[2] + 2 == value[0] && suit[2] == suit[0]
			 && value[3] + 3 == value[0] && suit[3] == suit[0]
			 && value[4] + 4 == value[0] && suit[4] == suit[0]) {
			result = (9 << 20) + (value[0] << 16);
		}
		else if (((value[0] == value[1]) && (value[1] == value[2]) && (value[2] == value[3]))
			 || ((value[1] == value[2]) && (value[2] == value[3]) && (value[3] == value[4]))) {
			result = (8 << 20) + (value[1] << 16);
		}
		else if (((value[0] == value[1]) && (value[1] == value[2]) && (value[2] == value[3]))
						 || ((value[0] == value[1]) && (value[1] == value[2]) && (value[3] == value[4]))) {
			result = (7 << 20) + (value[2] << 16);
		}
		else if ((suit[0] == suit[1]) && (suit[1] == suit[2]) && (suit[2] == suit[3]) && (suit[3] == suit[4])) {
			result = (6 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
		}
		else if ((value[1] + 1 == value[0]) && (value[2] + 1 == value[1]) && (value[3] + 1 == value[2]) && (value[4] + 1 == value[3])) {
			result = (5 << 20) + (value[0] << 16);
		}
		else if (((value[0] == value[1]) && (value[1] == value[2]))
						 || ((value[1] == value[2]) && (value[2] == value[3]))
						 || ((value[2] == value[3]) && (value[3] == value[4]))) {
			result = (4 << 20) + (value[2] << 16);
		}
		else if ((value[0] == value[1]) && (value[2] == value[3])) {
			result = (3 << 20) + (value[0] << 16) + (value[2] << 12) + (value[4] <<8);
		}
		else if ((value[0] == value[1]) && (value[3] == value[4])) {
			result = (3 << 20) + (value[0] << 16) + (value[3] << 12) + (value[2] << 8);
		}
		else if ((value[1] == value[2]) && (value[3] == value[4])) {
			result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[0] << 8);
		}
		else if (value[0] == value[1]) {
			result = (2 << 20) + (value[0] << 16) + (value[2] << 12) + (value[3] << 8) + (value[4] << 4);
		}
		else if (value[1] == value[2]) {
			result = (2 << 20) + (value[1] << 16) + (value[0] << 12) + (value[3] << 8) + (value[4] << 4);
		}
		else if (value[2] == value[3]) {
			result = (2 << 20) + (value[2] << 16) + (value[0] << 12) + (value[1] << 8) + (value[4] << 4);
		}
		else if (value[3] == value[4]) {
			result = (2 << 20) + (value[3] << 16) + (value[0] << 12) + (value[1] << 8) + (value[2] << 4);
		}
		else {
			result = (1 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
		}
		
		return result;
	}
}