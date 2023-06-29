import java.util.*;

class Main { 
	public static int [] score(int card[][]){
		int score[] = new int[6];
		boolean intercept = false;
		
		//스트레이트 플러쉬
		for(int i = 0; i < 4; i++){
			if(card[0][i] != card[0][i+1] || card[1][i] +1 != card[1][i+1]){
				intercept = true;
				break;
			}
		}
		if(!intercept){
			score[0] = 8;
			score[1] = card[1][4];
			return score;
		}
		intercept = false;
		
		//포카드 확인
		if((card[1][0] == card[1][1] && card[1][1] == card[1][2] && card[1][2] == card[1][3]) || 
			 (card[1][1] == card[1][2] && card[1][2] == card[1][3] && card[1][3] == card[1][4])){
			score[0] = 7;
			score[1] = (card[1][0] == card[1][1]) ? card[1][3] : card[1][4];
			return score;
			
		}
		// 풀하우스 확인
		if((card[1][0] == card[1][1] && card[1][1] == card[1][2] && card[1][3] == card[1][4]) || (card[1][0] == card[1][1] && card[1][2] == card[1][3] && card[1][3] == card[1][4])){
			score[0] = 7;
			score[1] = (card[1][0] == card[1][1]) ? card[1][3]:card[1][4];
			return score;
		}
		// 플러시 확인
		for(int i=0; i<4; i++){
			if(card[0][i] != card[0][i+1]){
				intercept = true;
				break;
			}
		}
		if(!intercept){
			score[0] = 5;
			score[1] = card[1][4];
			return score;
		}
		intercept = false;
		// 스트레이트 확인
		for(int i=0; i<4; i++){
			if(card[1][i] + 1 != card[1][i+1]){
				intercept = true;
				break;
			}
		}
		if(!intercept){
			score[0] = 4;
			score[1] = card[1][4];
			return score;
		}
		intercept = false;
		//쓰리카드 확인
		for(int i = 0; i < 3; i++){
			if(card[1][i] == card[1][i+1] && card[1][i+1] == card[1][i+2]){
				score[0] = 3;
				score[1] = card[1][i+2];
				return score;
			}
		}
		// 투페어 확인
		if(card[1][0] == card[1][1] && card[1][2] == card[1][3]){
			score[0] = 2;
			score[1] = card[1][3];
			score[2] = card[1][1];
			score[3] = card[1][4];
		}
		else if(card[1][0] == card[1][1] && card[1][3] == card[1][4]){
			score[0] = 2;
			score[1] = card[1][4];
			score[2] = card[1][1];
			score[3] = card[1][2];
		}
		else if(card[1][1] == card[1][2] && card[1][3] == card[1][4]){
			score[0] = 2;
			score[1] = card[1][4];
			score[2] = card[1][2];
			score[3] = card[1][0];
		}
		if(score[0] == 2)
			return score;
		
		// 원페어 확인
		int k = 2;
		for(int i=0; i<4; i++){
			if(card[1][i] == card[1][i+1]){
				score[0] = 1;
				score[1] = card[1][i];
				for(int j=4; j>=0; j--){
					if(j != 1 && j != i +1)
						score[k++] = card[1][j];
				}
				return score;
			}
		}
		
		// 하이카드
		for(int i=1; i<6; i++)
			score[i] = card[1][5-i];
		return score;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score_b [] = new int [6];
		int score_w [] = new int [6];
		while(sc.hasNextLine()){
			//input
			String input = sc.nextLine();
			String [] all = input.split(" ");
			int [] all_2 = new int[10];
			int [][] black = new int [2][5];
			int [][] white = new int [2][5];
			for(int i=0; i<10; i++){
				switch(all[i].charAt(0)){
					case '2': all_2[i] = 2; break;
					case '3': all_2[i] = 3; break;
					case '4': all_2[i] = 4; break;
					case '5': all_2[i] = 5; break;
					case '6': all_2[i] = 6; break;
					case '7': all_2[i] = 7; break;
					case '8': all_2[i] = 8; break;
					case '9': all_2[i] = 9; break;
					case 'T': all_2[i] = 10; break;
					case 'J': all_2[i] = 11; break;
					case 'Q': all_2[i] = 12; break;
					case 'K': all_2[i] = 13; break;
					case 'A': all_2[i] = 14; break;
				}
				all_2[i] *= 10;
				switch (all[i].charAt(1)){
					case 'H': all_2[i] += 1; break;
					case 'D': all_2[i] += 2; break;
					case 'S': all_2[i] += 3; break;
					case 'C': all_2[i] += 4; break;
				}
			}
			
			int score = 0;
			for(int i=0; i<5; i++){
				black[0][i] = all_2[i];
				white[0][i] = all_2[i+5];
			}
			Arrays.sort(black[0]);
			Arrays.sort(white[0]);
			
			for(int i=0; i<5; i++){
				black[1][i] = black[0][i]/10;
				black[0][i] %= 10;
				white[1][i] = white[0][i]/10;
				white[0][i] %= 10;
			}
			score_b = score(black);
			score_w = score(white);
			
			int winner = 0;
			if(score_b[0] > score_w[0])
				winner = 1;
			else if(score_b[0] < score_w[0])
				winner = -1;
			else{
				if(score_b[0] > 2){
					if(score_b[1] > score_w[1])
						winner = 1;
					else if(score_b[1] < score_w[1])
						winner = -1;
				}
				else{
					for(int i=1; i<6; i++){
						if(score_b[i] > score_w[i]){
							winner = 1;
							break;
						}
						else if(score_b[i] < score_w[i]){
							winner = -1;
							break;
						}
					}
				}
			}
		if(winner == 1)
			System.out.println("Black wins.");
		else if(winner == -1)
			System.out.println("White wins.");
		else System.out.println("Tie.");
	}
}
}


// 오름차순으로 10개 정렬
// 각 숫자로 인코딩
// 5개 조건 걸어서 추가
