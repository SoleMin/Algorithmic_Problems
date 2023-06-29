import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	int[] value = new int[5];
	int[] suit = new int[5];
	
	int rank;
	
	public Main(String[] cards) {
		getHandValue(cards);
	} 
	
	public void getHandValue(String[] cards) {
		int i, j, max, temp;
		
		int[] handValue = new int[5];
		
		// 점수 계산
		for (i = 0; i < 5; i++) {
			handValue[i] = encodeCard(cards[i]);
		}
		
		// 카드 정렬
		for (i = 0; i < 4; i++) {
			max = i;
			for (j = i+1; j <5; j++) {
				if (handValue[j] > handValue[max]) 
					max = j;
			}
			
			temp = handValue[i];
			handValue[i] = handValue[max];
			handValue[max] = temp;
		}
		
		for (i = 0; i < 5; i++) {
			value[i] = handValue[i] / 10;
			suit[i] = handValue[i] % 10;
		}
		
		rank();
		
	}
	
	
	private int encodeCard(String card) {
		int result;
		switch (card.charAt(0)) {
			case 'T' : result = 100; break;
			case 'J' : result = 110; break;
			case 'Q' : result = 120; break;
			case 'K' : result = 130; break;
			case 'A' : result = 140; break;
				default : result = (card.charAt(0) - '0') * 10;
		}
		
		switch (card.charAt(1)) {
			case 'H' : result = result + 1; break;
			case 'D' : result = result + 2; break; 
			case 'S' : result = result + 3; break;
			case 'C' : result = result + 4; break;
		}
		
		return result;
	}
	
	
	private void rank() {
		if (isStraightFlush()) rank = 8; // 8: Straight Flush
		else if (isFourCard()) rank = 7; // 7: Four of a Kind
		else if (isFullHouse()) rank = 6; // 6: Full House
		else if (isFlush()) rank = 5; // 5: Flush
		else if (isStraight()) rank = 4; // 4: Straight
		else if (isTriple()) rank = 3; // 3: Three of a Kind
		else if (isTwoPairs()) rank = 2; // 2: Two Pairs
		else if (isOnePair()) rank = 1; // 1: Pair
		else rank = 0; // 0: High Card
	}
	
	private boolean isStraightFlush() {
		return isStraight() && isFlush();
	}
	
	private boolean isFourCard() {
		int first = value[0];
		int second = value[2];
		
		return (first == value[1] && first == value[2] && first == value[3])
			|| (second == value[2] && second == value[3] && second == value[4]);
	}
	
	private boolean isFullHouse() {
		return isTriple() && getPairCount() > 1;
	}
	
	private boolean isFlush() {
		int first = suit[0];
		for (int i = 0; i < 5; i++) {
			if (first != suit[i]) 
				return false;
		}
		return true;
	}
	
	private boolean isStraight() {
		int first = value[0];
		for (int i = 0; i < 5; i++) {
			int next = value[i];
			if (next != first - i)
				return false;
		}
		
		return true;
	}
	
	private boolean isTriple() {
		for (int i = 0; i < 3; i++) {
			int val = value[i];
			if (val == value[i+1] && val == value[i+2])
				return true;
		}
		return false;
	}
	
	private boolean isTwoPairs() {
		return getPairCount() == 2;
	}
	
	private boolean isOnePair() {
		return getPairCount() == 1;
	}
	
	private int getPairCount() {
		int pairs = 0;
		for (int i = 0; i < 4; i++) {
			if (value[i] == value[i+1]) 
				pairs++;
		}
		return pairs;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public int compare(Main o) {
		for (int i = 0; i < 5; i++) {
			if (this.value[i] != o.value[i]) {
				return this.value[i] > o.value[i] ? 1 : -1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line == null || line.length() == 0) {
				break;
			}
			list.add(line);
		}
		
		
		// 결과 출력
		for (int i = 0; i < list.size(); i++) {
			String[] cards = list.get(i).split(" ");
			Main black = new Main(new String[] { cards[0], cards[1], cards[2], cards[3], cards[4] });
			Main white = new Main(new String[] { cards[5], cards[6], cards[7], cards[8], cards[9] });
			
			
			String result = "Tie.";
			if (black.getRank() == white.getRank()) {
				int compare = black.compare(white);
				result = compare > 0 ? "Black wins." : compare == 0 ? "Tie." : "White wins.";
			}
			else {
				result = black.getRank() > white.getRank() ? "Black wins." : "White wins.";
			}
			
			System.out.println(result);
		}
	}
	
	
}