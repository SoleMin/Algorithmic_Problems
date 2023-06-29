import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int[] Bcardnumlist = new int[5];
			int[] Wcardnumlist = new int[5];
			
			for (int i = 0; i < 10; i++) {
				String card = sc.next();
				if (i < 5) {
					Bcardnumlist[i] = encode_card(card);
				} else {
					Wcardnumlist[i-5] = encode_card(card);
				}
			}
			
			Arrays.sort(Bcardnumlist);
			Arrays.sort(Wcardnumlist);
			
			if (card_value(Bcardnumlist) > card_value(Wcardnumlist)) {
				System.out.println("Black wins.");
			} else if (card_value(Bcardnumlist) < card_value(Wcardnumlist)) {
				System.out.println("White wins.");
			} else {
				System.out.println("Tie.");
			}
		}
		sc.close();
	}
	
	public static int encode_card(String card) {
		
		int cardnum;
		
		switch (card.charAt(0)) {
			case 'T' : cardnum = 100; break;
			case 'J' : cardnum = 110; break;
			case 'Q' : cardnum = 120; break;
			case 'K' : cardnum = 130; break;
			case 'A' : cardnum = 140; break;
			default: cardnum = (card.charAt(0) - '0') * 10;
		}
		switch (card.charAt(1)) {
			case 'H' : cardnum += 1; break;
			case 'D' : cardnum += 2; break;
			case 'S' : cardnum += 3; break;
			case 'C' : cardnum += 4; break;
		}
		
		return cardnum;
	}
	
	public static int card_value (int[] list) {
		
		int result = 0;
		
		if(list[1]/10 - 1 == list[0]/10 && list[1]%10 == list[0]%10
				&& list[2]/10 - 2 == list[0]/10 && list[2]%10 == list[0]%10
				&& list[3]/10 - 3 == list[0]/10 && list[3]%10 == list[0]%10
				&& list[4]/10 - 4 == list[0]/10 && list[4]%10 == list[0]%10) {
			result = (9 << 20) + (list[0]/10 << 16);
		} else if (list[0]/10 == list[3]/10) {
			result = (8 << 20) + (list[3]/10 << 16);
		} else if (list[1]/10 == list[4]/10) {
			result = (8 << 20) + (list[4]/10 << 16);
		} else if (list[0]/10 == list[2]/10 && list[3]/10 == list[4]/10) {
			result = (7 << 20) + (list[2]%10 << 16);
		} else if (list[2]/10 == list[4]/10 && list[0]/10 == list[1]/10) {
			result = (7 << 20) + (list[4]%10 << 16);
		} else if (list[0]%10 == list[4]%10) {
			result = (6 << 20) + (list[4]/10 << 16) + (list[3]/10 << 12);
		} else if (list[1]/10 -1 == list[0]/10 && list[2]/10 - 1 == list[1]/10
							&& list[3]/10 - 1 == list[2]/10 && list[4]/10 - 1 == list[3]/10) {
			result = (5 << 20) + (list[4]/10 << 16);
		} else if (list[0]/10 == list[2]/10) {
			result = (4 << 20) + (list[2]/10 << 16);
		} else if (list[1]/10 == list[3]/10) {
			result = (4 << 20) + (list[3]/10 << 16);
		} else if (list[2]/10 == list[4]/10) {
			result = (4 << 20) + (list[4]/10 << 16);
		} else if (list[0]/10 == list[1]/10 && list[2]/10 == list[3]/10) {
			result = (3 << 20) + (list[3]/10 << 16);
		} else if ((list[0]/10 == list[1]/10 && list[3]/10 == list[4]/10)
							|| (list[1]/10 == list[2]/10 && list[3]/10 == list[4]/10)) {
			result = (3 << 20) + (list[4]/10 << 16);
		} else if (list[0]/10 == list[1]/10) {
			result = (2 << 20) + (list[1]/10 << 16);
		} else if (list[1]/10 == list[2]/10) {
			result = (2 << 20) + (list[2]/10 << 16);
		} else if (list[2]/10 == list[3]/10) {
			result = (2 << 20) + (list[3]/10 << 16);
		} else if (list[3]/10 == list[4]/10) {
			result = (2 << 20) + (list[4]/10 << 16);
		} else {
			result = (1 << 20) + (list[4]/10 << 16) + (list[3]/10 << 12)
							+ (list[2]/10 << 8) + (list[1]/10 << 4) + (list[0]/10 << 0);
		}
		return result;
	}
}