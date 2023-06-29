import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String[] card;
		int bResult, wResult, tResult;
		int[] black = new int[5], white = new int[5];
		
		while(input.hasNext()){
		card = input.nextLine().split(" ");
			for(int i = 0; i < 5; i++)
				black[i] = encoder_card(card[i]);
			for(int i = 5; i < 10; i++)	
				white[i-5] = encoder_card(card[i]);
			
			
			bResult = get_hand_value(black);
			wResult = get_hand_value(white);
			if(bResult > wResult)
				System.out.println("Black wins.");
			else if(bResult < wResult)
				System.out.println("White wins.");
			else {
				tResult = isTie(black, white, bResult);
				if(tResult == 0)
					System.out.println("Tie.");
				else if(tResult > 0)
					System.out.println("Black wins.");
				else
					System.out.println("White wins.");
			}
		}
	}
	
	public static int encoder_card(String card) {
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
	
	public static int get_hand_value(int[] hand) {
		int i, j, max, temp;
		int[] value = new int[5], suit = new int[5];
		
		for(i = 0; i < 4; i++){
			max = i;
			for(j = i+1; j < 5; j++)
				if(hand[j] > hand[max])
					max = j;
			temp = hand[i];
			hand[i] = hand[max];
			hand[max] = temp;
		}
		
		for(i = 0; i < 5; i++){
			value[i] = hand[i] / 10;
			suit[i] = hand[i] % 10;
		}
		
		//스트레이트 플러시
		if(value[1]+1 == value[0] && suit[1] == suit[0] && value[2]+2 == value[0] && suit[2] == suit[0] && value[3]+3 == value[0] && suit[3] == suit[0] && value[4]+4 == value[0] && suit[4] == suit[0])
			return 10000 + value[0];
		//포카드
		if((value[2] == value[1] && value[3] == value[1]) && (value[0] == value[1] || value[4] == value[1]))
			return 9000 + value[1];
		//풀하우스
		if((value[1] == value[2] && value[3] == value[2] && value[0] == value[4]) || (value[0] == value[2] && value[1] == value[2] && value[3] == value[4]) || (value[3] == value[2] && value[4] == value[2] && value[0] == value[1]))
			return 8000 + value[2];
		//플러시
		if(suit[1] == suit[0] && suit[2] == suit[0] && suit[3] == suit[0] && suit[4] == suit[0])
			return 7000 + value[0];
		//스트레이트
		if(value[1]+1 == value[0] && value[2]+2 == value[0] && value[3]+3 == value[0] && value[4]+4 == value[0])
			return 6000 + value[0];
		//쓰리카드
		if((value[0] == value[2] && value[1] == value[2]) || (value[1] == value[2] && value[3] == value[2]) || (value[3] == value[2] && value[4] == value[2]))
			return 5000 + value[2];
		//투페어
		if((value[0] == value[1] && value[2] == value[3]) || (value[0] == value[1] && value[3] == value[4]) || (value[1] == value[2] && value[3] == value[4]))
			return 4000 + value[1];
		//원페어
		for(i = 0; i < 4; i++)
			if(value[i] == value[i+1])
				return 3000 + value[i];
		
		return 2000 + value[0];
	}
	
	public static int isTie(int[] b, int[] w, int tR) {
		int i, j, maxB, maxW, temp;
		int[] vB = new int[5], vW = new int[5];
		int rB = 0, rW = 0;
		
		for(i = 0; i < 4; i++) {
			maxB = i;	maxW = i;
			for(j = i+1; j < 5; j++){
				if(b[j] > b[maxB])
					maxB = j;
				if(w[j] > w[maxW])
					maxW = j;
			}
			temp = b[i];
			b[i] = b[maxB];
			b[maxB] = temp;
			temp = w[i];
			w[i] = w[maxW];
			w[maxW] = temp;
		}
		
		for(i = 0; i < 5; i++){
			vB[i] = b[i] /10;
			vW[i] = w[i] /10;
		}
		
		if(tR / 1000 == 4) {
			if(vB[0] == vB[1] && vB[2] == vB[3])	rB = vB[4];
			else if(vB[0] == vB[1] && vB[3] == vB[4])	rB = vB[2];
			else rB = vB[0];
			
			if(vW[0] == vW[1] && vW[2] == vW[3])	rW = vW[4];
			else if(vW[0] == vW[2] && vW[3] == vW[4])	rW = vW[2];
			else rW = vW[0];
			return (rB - rW);
		}
		if(tR / 1000 == 3) {
			rB = vB[4];	rW = vW[4];
			for(i = 0; i < 4; i++)
				if(vB[i] != vB[i+1])	{
					rB = vB[i];
					break;
				}
			for(i = 0 ; i < 4; i++)
				if(vW[i] != vW[i+1])	{
					rW = vW[i];
					break;
				}
			return (rB-rW);
		}
		
		rB = vB[0];	rW = vW[0];
		for(i = 1; i < 4; i++)
			if(vB[i] != vW[i+1]){
				rB = vB[i]; rW = vW[i];
				break;
			}
		return (rB-rW);
	}
	}

	