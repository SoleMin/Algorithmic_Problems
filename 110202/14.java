import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[] blackHand = new int[5];
		int[] whiteHand = new int[5];
		int blackValue, whiteValue;
		int result = 0;
		
		while(input.hasNext()) {
			for(int i=0; i < 5; i++) {
				String s = input.next();
				blackHand[i] = encodeCard(s);
			}
			Arrays.sort(blackHand);
			for(int i=0; i < 5; i++) {
				String s = input.next();
				whiteHand[i] = encodeCard(s);
			}
			Arrays.sort(whiteHand);
			
			blackValue = getHandValue(blackHand);
			whiteValue = getHandValue(whiteHand);
			
			if(blackValue > whiteValue)
				result = 2;
			else if(blackValue < whiteValue)
				result = 1;
			else {
				for(int i=0; i < 5; i++) {
					blackHand[i] = getValue(blackHand[i]);
					whiteHand[i] = getValue(whiteHand[i]);
				}
				result = compare(blackHand, whiteHand);
			}
			
			if(result == 2)
				System.out.println("Black wins.");
			else if(result == 1)
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
		}
	input.close();
	}
	
	public static int getHandValue(int[] array) {
		int result = 0;
		int[] value = new int[5];
		int[] suit = new int[5];
		int[] number = new int[15];
		
		for(int i=2; i <= 14; i++)
			number[i] = 0;
		
		for(int i=0; i < 5; i++) {
			value[i] = getValue(array[i]);
			suit[i] = getSuit(array[i]);
			number[value[i]]++;
		}
		
		if(suit[0] == suit[1] && suit[0] == suit[2]
				&& suit[0] == suit[3] && suit[0] == suit[4])
			if(value[0]+1 == value[1] && value[0]+2 == value[2]
					&& value[0]+3 == value[3] && value[0]+4 == value[4])
				result = 10000;
			else
				result = 7000;
		
		if(isEqualType(number, 4))
			result = 9000;
		else if(isEqualType(number, 3))
			if(isEqualType(number, 2))
				result = 8000;
			else
				result = 5000;
		else if(isEqualType(number, 2))
			if(isTwoFair(number))
				result = 4000;
			else
				result = 3000;
		else
			if(value[0]+1 == value[1] && value[0]+2 == value[2]
					&& value[0]+3 == value[3] && value[0]+4 == value[4])
				result = 6000;
			else
				result = 2000;
		
		return result;
	}
	
	public static int compare(int[] bH, int[] wH) {
		for(int i=4; i >= 0; i--)
			if(bH[i] > wH[i])
				return 2;
			else if(bH[i] < wH[i])
				return 1;
		return 0;
	}
	
	public static boolean isTwoFair(int[] array) {
		int count = 0;
		for(int i=0; i < array.length; i++)
			if(array[i] == 2)
				count++;
		
		return (count == 2) ? true : false;
	}
	
	public static boolean isEqualType(int[] array, int n) {
		for(int i=0; i < array.length; i++)
			if(array[i] == n)
				return true;
		return false;
	}
	
	public static int getValue(int n) {
		return n / 10;
	}
	
	public static int getSuit(int n) {
		return n % 10;
	}
	
	public static int encodeCard(String s) {
		int result;
		
		switch(s.charAt(0)) {
			case 'T': result = 100; break;
			case 'J': result = 110; break;
			case 'Q': result = 120; break;
			case 'K': result = 130; break;
			case 'A': result = 140; break;
			default: result = (int)(s.charAt(0) - '0') * 10;
		}
		switch(s.charAt(1)) {
			case 'H': result += 1; break;
			case 'D': result += 2; break;
			case 'S': result += 3; break;
			case 'C': result += 4; break;
		}
		
		return result;
	}
}