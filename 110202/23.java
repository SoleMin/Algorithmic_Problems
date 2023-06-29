import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String cards[];
		int scoreB, scoreW;
		
		while(sc.hasNextLine()) {
			cards = new String[10];
			for(int i=0; i<10; i++)
				cards[i] = sc.next();
			
			int black[] = new int[5];
			int white[] = new int[5];
			for(int i=0; i<5; i++) {
				black[i] = card2num(cards[i]);
				white[i] = card2num(cards[i+5]);
			}
			
			scoreB = grade(black);
			scoreW = grade(white);
			
			if(scoreB>1000 && scoreW<1000)
				scoreB = 0;
			else if(scoreB<1000 && scoreW>1000)
				scoreW = 0;
			
			if(scoreB == scoreW)
				System.out.println("Tie.");
			else if(scoreB > scoreW)
				System.out.println("Black wins.");
			else
				System.out.println("White wins.");
			
			sc.nextLine();
		}
		sc.close();
	}
	
	//카드를 숫자로 변환
	public static int card2num(String card) {
		int num = 0;
		
		//카드 모양 - 100단위, 클럽-다이아-하트-스페이드
		switch(card.charAt(1)) {
			case 'C': num = 100; break;
			case 'D': num = 200; break;
			case 'H': num = 300; break;
			case 'S': num = 400; break;
		}
		
		//카드 숫자
		switch(card.charAt(0)) {
			case 'T': num += 10; break;
			case 'J': num += 11; break;
			case 'Q': num += 12; break;
			case 'K': num += 13; break;
			case 'A': num += 14; break;
			default: num += (card.charAt(0) - '0');
		}
		
		return num;
	}
	
	//카드 모양 확인
	public static int check_pattern(int card) {
		return (card / 100);
	}
	//카드 숫자 확인
	public static int check_number(int card) {
		return (card % 100);
	}
	
	//카드 등금 계산
	public static int grade(int[] cards) {
		int score = 0; //단계별 점수
		int high = 0, most = 0; //가장 높은 카드, 가장 많은 동일 카드
		int countN[] = new int[15]; //동일 숫자 개수 저장
		int pairN = 0; //쌍 개수
		boolean straight = true, same = false; //연속 숫자, 같은 모양
		
		int n[] = new int[5]; //카드 숫자
		int p[] = new int[5]; //카드 모양
		for(int i=0; i<5; i++) {
			n[i] = check_number(cards[i]);
			p[i] = check_pattern(cards[i]);
		}
		Arrays.sort(n); Arrays.sort(p);
		
		//연속, 패턴 확인
		for(int i=1; i<5; i++)
			if(n[i] - n[i-1] != 1)
				straight = false;
		if(p[0]==p[1] && p[1]==p[2] && p[2]==p[3] && p[3]==p[4])
			same = true;
		
		//동일 개수
		for(int i=0; i<5; i++) {
			if(n[0]==n[3] || n[1]==n[4]) {
				countN[n[2]] = 3;
				high = n[2];
				break;
			}
			for(int j=i; j<5; j++) {
				if(i!=j && n[i]==n[j]) {
					countN[n[j]]++;
					high = n[j];
				}
			}
		}
		
		//쌍 개수, 같은 개수
		for(int i=0; i<countN.length; i++) {
			if(countN[i] != 0) {
				pairN++;
				if(most <= countN[i])
					most = countN[i];
			}
		}
		
		/*등급별 계산*/
		//하이 카드
		if(pairN==0 && !same && !straight)
			return (n[4]*100000000 + n[3]*1000000 + n[2]*10000 + n[1]*100 + n[0]);
		
		//다섯 장이 연속일 때
		if(straight) {
			//스트레이트 플러시 - 802~814
			if(same)
				score = 800 + n[4];
			//스트레이트 - 402~414
			else
				score = 400 + n[4];
			return score;
		}
		
		//플러시 - 502~514
		if(same) {
			return ( 500 + n[4] );
		}
		
		//두장 값이 같을 때
		if(most == 1) {
			//투 페어 - 202~214
			if(pairN == 2)
				score = 200 + high;
			//원 페어 - 102~114
			else if(pairN==1)
				score = 100 + high;
		}
		//세장 값이 같을 때
		else if(most == 2) {
			//풀하우스 - 602~614
			if(pairN == 2)
				score = 600 + high;
			else
				score = 300 + high;
		}
		//네장 값이 같을때
		else if(most == 3) {
			//포카드 - 702~714
			score = 700 + high;
		}
		
		return score;
	}
}
