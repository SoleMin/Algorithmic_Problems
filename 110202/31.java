import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static String[] Cards = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "K", "Q", "A"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//카드를 한개의 배열에 넣고, 각 카드의 인덱스가 카드의 우선순위를 가짐.
		//switch case 문으로 하이카드, 원페어, 투페어, 쓰리카드, 스트레이트, 플러쉬, 풀하우스, 포카드, 스트레이트 플러시 등의 경우를 골라냄.
		
		while (sc.hasNext()) {
			String[] black = new String[5];
			String[] white = new String[5];
			
			for (int i = 0; i < 5; i++) {
				black[i] = sc.next();
			}
			
			for (int i = 0; i < 5; i++) {
				white[i] = sc.next();
			}
			
			//정렬
			Arrays.sort(white, Comparator.comparingInt(i -> getIndex(i.charAt(0))));
			Arrays.sort(black, Comparator.comparingInt(i -> getIndex(i.charAt(0))));
			
			if (winCheck(isStp(black), isStp(white))) continue;
			if (winCheck(isFour(black), isFour(white))) continue;
			if (winCheck(isFull(black), isFull(white))) continue;
			if (winCheck(isFlush(black), isFlush(white))) continue;
			if (winCheck(isStraight(black), isStraight(white))) continue;
			if (winCheck(isTriple(black), isTriple(white))) continue;
			if (isTwo(black)[0] == isTwo(white)[0] && winCheck(isTwo(black)[1], isTwo(white)[1])) continue;
			
			if (winCheck(isTwo(black)[0], isTwo(white)[0])) continue;
			if (isOne(black)[0] == isOne(white)[0] && winCheck(isOne(black)[1], isOne(white)[1])) continue;
			
			if (winCheck(isOne(black)[0], isOne(white)[0])) continue;
			
			if (black[4]. charAt(0) == white[4].charAt(0)) {
				if (black[3]. charAt(0) == white[3].charAt(0)) {
					if (black[2]. charAt(0) == white[2].charAt(0)) {
						if (black[1]. charAt(0) == white[1].charAt(0)) {
							winCheck(getIndex(black[0].charAt(0)), getIndex(white[0].charAt(0)));
						}
						else
							winCheck(getIndex(black[1].charAt(0)), getIndex(white[1].charAt(0)));
					}
					else
						winCheck(getIndex(black[2].charAt(0)), getIndex(white[2].charAt(0)));
				}
				else
					winCheck(getIndex(black[3].charAt(0)), getIndex(white[3].charAt(0)));
			}
			else
				winCheck(getIndex(black[4].charAt(0)), getIndex(white[4].charAt(0)));
			
		}

	}
	
	
	
	
	public static int isStp(String[] deck) {
		int val = -1;
		char pat = 'n';
		for (int i = 0; i < 5; i++) {
			int val_tmp = getIndex(deck[i].charAt(0));
			char pat_tmp = deck[i].charAt(1);
			if ((val != -1 && val + 1 != val_tmp) || (pat != 'n' && pat != pat_tmp)) {
				return -1;
			}
			
			val = val_tmp;
			pat = pat_tmp;
		}
		return val;
	}
	
	public static int isFour(String[] deck) {
		if ((deck[1].charAt(0) == deck[2].charAt(0) && deck[2].charAt(0) == deck[3].charAt(0)) && (deck[3].charAt(0) == deck[4].charAt(0) || deck[0].charAt(0) == deck[1].charAt(0))) {
			return getIndex(deck[2].charAt(0));
		} else {
			return -1;
		}
	}
	
	public static int isFull(String[] deck) {
		if ((deck[0].charAt(0) == deck[1].charAt(0) && deck[2].charAt(0) == deck[3].charAt(0) && deck[3].charAt(0) == deck[4].charAt(0)) || (deck[0].charAt(0) == deck[1].charAt(0) && deck[1].charAt(0) == deck[2].charAt(0) && deck[3].charAt(0) == deck[4].charAt(0))) {
			return getIndex(deck[2].charAt(0));
		} else {
			return -1;
		}
	}
	
	public static int isFlush(String[] deck) {
		if (deck[0].charAt(1) == deck[1].charAt(1) && deck[1].charAt(1) == deck[2].charAt(1) && deck[2].charAt(1) == deck[3].charAt(1) && deck[3].charAt(1) == deck[4].charAt(1)) {
			return getIndex(deck[0].charAt(0));
		}
		return -1;
	}
	
	public static int isStraight(String[] deck) {
		int val = -1;
		
		for (int i = 0; i < 5; i++) {
			int val_tmp = getIndex(deck[i].charAt(0));
			
			if (val != -1 && val + 1 != val_tmp) {
				return -1;
			}
			
			val = val_tmp;
		}
		return val;
	}
	
	public static int isTriple(String[] deck) {
		if ((deck[0].charAt(0) == deck[1].charAt(0) && deck[1].charAt(0) == deck[2].charAt(0)) || (deck[1].charAt(0) == deck[2].charAt(0) && deck[2].charAt(0) == deck[3].charAt(0)) || (deck[2].charAt(0) == deck[3].charAt(0) && deck[3].charAt(0) == deck[4].charAt(0))) {
			return getIndex(deck[2].charAt(0));
		} else return -1;
	}
	
	public static int[] isTwo(String[] deck) {
		int[] result = {-1, -1};
		
		if (deck[0].charAt(0) == deck[1].charAt(0) && deck[2].charAt(0) == deck[3].charAt(0)) {
			result[0] = Math.max(getIndex(deck[0].charAt(0)), getIndex(deck[2].charAt(0)));
			result[1] = getIndex(deck[4].charAt(0));
		}
		if (deck[0].charAt(0) == deck[1].charAt(0) && deck[3].charAt(0) == deck[4].charAt(0)) {
			result[0] = Math.max(getIndex(deck[0].charAt(0)), getIndex(deck[3].charAt(0)));
			result[1] = getIndex(deck[2].charAt(0));
		}
		if (deck[1].charAt(0) == deck[2].charAt(0) && deck[3].charAt(0) == deck[4].charAt(0)) {
			result[0] = Math.max(getIndex(deck[1].charAt(0)), getIndex(deck[3].charAt(0)));
			result[1] = getIndex(deck[0].charAt(0));
		}
		return result;
	}
	
	public static int[] isOne(String[] deck) {
		int[] result = {-1, -1};
		
		if (deck[0].charAt(0) == deck[1].charAt(0)) {
			result[0] = getIndex(deck[0].charAt(0));
			result[1] = getIndex(deck[4].charAt(0));
		}
		
		if (deck[1].charAt(0) == deck[2].charAt(0)) {
			result[0] = getIndex(deck[1].charAt(0));
			result[1] = getIndex(deck[4].charAt(0));
		}
		
		if (deck[2].charAt(0) == deck[3].charAt(0)) {
			result[0] = getIndex(deck[2].charAt(0));
			result[1] = getIndex(deck[4].charAt(0));
		}
		
		if (deck[3].charAt(0) == deck[4].charAt(0)) {
			result[0] = getIndex(deck[3].charAt(0));
			result[1] = getIndex(deck[2].charAt(0));
		}
		return result;
	}
	
	public static int getHigh(String[] deck) {
		return getIndex(deck[4].charAt(0));
	}
	
	public static int getIndex(char c) {
		return Arrays.asList(Cards).indexOf(String.valueOf(c));
	}
	
	public static boolean winCheck(int black, int white) {
		if (white != -1 || black != -1) {
			if (white > black) {
				System.out.println("White wins.");
			}
			else if (white < black) {
				System.out.println("Black wins.");
			}
			else {
				System.out.println("Tie.");
			}
			return true;
		}
		return false;
	}
}