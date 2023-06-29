import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[] num = new int[10];
		long[] BnW = new long[2];
			
		while(input.hasNext()){	
			String s = input.nextLine();
			String[] arr = s.split(" ");
			
			for(int i = 0; i<arr.length; i++){
				char[] c = arr[i].toCharArray();
				num[i] = encode_card(c);	
			}
			
			int[] black = Arrays.copyOfRange(num,0,5);
			int[] white = Arrays.copyOfRange(num,5,10);
			
			//System.out.println("흑" + Arrays.toString(black));
			//System.out.println("백" + Arrays.toString(white));
			BnW[0] = get_hand_value(black);
			BnW[1] = get_hand_value(white);
			
			if(BnW[0] > BnW[1])
				System.out.println("Black wins.");
			else if (BnW[0] < BnW[1])
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
		}
	}
	
	public static int encode_card(char[] card){
		int result;
		
		switch (card[0]){
			case 'T' : result = 100; break;
			case 'J' : result = 110; break;
			case 'Q' : result = 120; break;
			case 'K' : result = 130; break;
			case 'A' : result = 140; break;
			default : result = (card[0] - '0') * 10;
		}
		
		switch (card[1]){
			case 'H' : result += 1; break;
			case 'D' : result += 2; break;
			case 'S' : result += 3; break;
			case 'C' : result += 4; break;
		}
		return result;
	}
	
	
	public static long get_hand_value(int[] hand){
		int[] value = new int[5];
		int[] suit = new int[5];
		long result;
		
		// 내림차순으로 정렬
		for(int i = 0; i < 4; i++){
			int max = i;
			for(int j = i+1; j<5; j++)
				if(hand[j]>hand[max])
					max = j;
			int temp = hand[i];
			hand[i] = hand[max];
			hand[max] = temp;	
			}
		for(int i = 0; i<5; i++){
			value[i] = hand[i]/10;
			suit[i] = hand[i]%10;
		}
			
		// 9. 스트레이트플러시
		// 값 연속, 무늬 suit[0]으로 통일.
		if ((value[1] + 1 == value[0]) && (suit[1] == suit[0])
			 && (value[2] + 2 == value[0]) && (suit[2] == suit[0])
			 && (value[3] + 3 == value[0]) && (suit[3] == suit[0])
			 && (value[4] + 4 == value[0]) && (suit[4] == suit[0]))
			result = (9 << 20) + (value[0] << 16);
			
		// 8. 포카드
		// AAAAB or ABBBB.
		else if(((value[0] == value[1]) && (value[1] == value[2]) && (value[2] == value[3]))
					||((value[1] == value[4]) && (value[2] == value[3]) && (value[3] == value[4])))
			result = (8 << 20) + (value[2] << 16);
		
		// 7. 풀하우스
		// AAABB or AABBB.
		else if((((value[0] == value[1]) && (value[1] == value[2]))
																 		 && (value[3] == value[4])) // AAABB인 경우 
					||(((value[2] == value[3]) && (value[3] == value[4]))
																		 && (value[0] == value[1]))) // AABBB인 경우
			result = (7 << 20) + (value[2] << 16);
		
		// 6. 플러시
		// 무늬 통일
		else if((suit[0] == suit[1]) && (suit[1] == suit[2]) 
						&& (suit[2] == suit[3]) && (suit[3] == suit[4]))
			result = (6 << 20) + (value[0] << 16);
		
		// 5. 스트레이트
		// 값 연속
		// 하이카드 적용
		else if((value[0] == value[1]+1) && (value[0] == value[2]+2)
					 && (value[0] == value[3]+3) && (value[0] == value[4]+4))
			result = (5<<20) + (value[0] << 16) + (value[1] << 12) 
							+ (value[2] << 8) + (value[3] << 4) + value[4];
			
		// 4. 쓰리카드
		// AAABC or ABBBC or ABCCC
		else if( ((value[0] == value[1]) && (value[1] == value[2]))		//AAABC
					|| ((value[1] == value[2]) && (value[2] == value[3]))		//ABBBC
					|| ((value[2] == value[3]) && (value[3] == value[4])) )	//ABCCC
			result = (4<<20) + (value[2] << 16);
		
		// 3. 투 페어
		// AABCC or AABBC or ABBCC 
		// 작은 페어/남은 카드 한 장 하이카드
		else if((value[0] == value[1]) && (value[3] == value[4])) // AABCC
			result = (3<<20) + (value[0] << 16) + (value[3] << 12) + (value[2] << 8);
		else if((value[0] == value[1]) && (value[2] == value[3]))	//AABBC
			result = (3<<20) + (value[0] << 16) + (value[2] << 12) + (value[4] << 8);
		else if((value[1] == value[2]) && (value[3] == value[4]))	//ABBCC
			result = (3<<20) + (value[1] << 16) + (value[3] << 12) + (value[0] << 8);	
			
		// 2. 원 페어
		// AABCD or ABBCD or ABCCD or ABCDD
		// 페어 외 나머지 3장 하이카드
		else if(value[0] == value[1])	//AABCD
			result = (2<<20) + (value[0] << 16) + (value[2] << 12) + (value[3] << 8) + (value[4] << 4);
		else if(value[1] == value[2])	//ABBCD
			result = (2<<20) + (value[1] << 16) + (value[0] << 12) + (value[3] << 8) + (value[4] << 4);
		else if(value[2] == value[3])	//ABCCD
			result = (2<<20) + (value[2] << 16) + (value[0] << 12) + (value[1] << 8) + (value[4] << 4);
		else if(value[3] == value[4])	//ABCDD
			result = (2<<20) + (value[3] << 16) + (value[0] << 12) + (value[1] << 8) + (value[2] << 4);
		
		// 1. 하이카드
		else
			result = (1<<20) + (value[0] << 16) + (value[1] << 12)
							+ (value[2] << 8) + (value[3] << 4) + value[4];
	
		return result;
	}
}