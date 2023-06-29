import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int black[] = new int[5];
			int white[] = new int[5];
			long black_score;
			long white_score;
			int i;
			
			for(i = 0; i < 5; i++){
				String s = in.next();
				black[i] = encode(s);
			}
			for(i = 0; i < 5; i++){
				String s = in.next();
				white[i] = encode(s);
			}
			//카드를 값을 위주로 정렬
			Arrays.sort(black);
			Arrays.sort(white);
			
			black_score = check_score(black);
			white_score = check_score(white);
			
			//누가 이겼는지 확인
			if(black_score == white_score) System.out.println("Tie.");
			else if(black_score > white_score) System.out.println("Black wins.");
			else System.out.println("White wins.");
		}
	}
	
	//각 카드를 계산 하기 편하게 정수 형태로 변환
	static int encode(String s){
		int result;
		switch(s.charAt(0)){
			case 'T': result = 100; break;
			case 'J': result = 110; break;
			case 'Q': result = 120; break;
			case 'K': result = 130; break;
			case 'A': result = 140; break;
			default: result = Integer.parseInt(String.valueOf(s.charAt(0))) * 10;
		}
		switch(s.charAt(1)){
			case 'H': result += 1; break;
			case 'D': result += 2; break;
			case 'S': result += 3; break;
			case 'C': result += 4; break;
		}
		return result;
	}
	
	//카드들을 바탕으로 몇 점인지 확인
	static long check_score(int[] card){
		
		long score = 0;
		int n[] = new int[5]; //값을 저장
		int s[] = new int[5]; //무늬를 저장
		for(int i = 0; i < 5; i++){
			n[i] = card[i]/10;
			s[i] = card[i]%10;
		}
		//원페어인 경우
		if(n[0]==n[1] || n[1]==n[2] || n[2]==n[3] || n[3]==n[4]){
			//투페어인 경우
			if((n[0]==n[1] && n[2]==n[3]) || (n[0]==n[1] && n[3]==n[4]) || (n[1]==n[2] && n[3]==n[4])){
				score += 20000000000L;
				int j = 8;
				for(int i = 4; i > 0; i--){
					if(n[i]==n[i-1]){
						score += (n[i]*Math.pow(10,j));
						j -= 2;
					}
					else{
						score += n[i];
					}
				}
			}
			//원페어인 경우
			else{
				score += 10000000000L;
			
				int j = 6;
				for(int i = 4; i > 0; i--){
					if(n[i]==n[i-1]){
						score += (n[i]*Math.pow(10,8));
					}
					else{
						score += n[i] * Math.pow(10,j);
						j -= 2;
					}
				}
			}
		}
		//쓰리카드인 경우
		if((n[0]==n[1] && n[1]==n[2]) || (n[1]==n[2] && n[2]==n[3]) || (n[2]==n[3] && n[3]==n[4])){
			//풀하우스인 경우
			if((n[0]==n[1] && n[1]==n[2] && n[3]==n[4]) || (n[2]==n[3] && n[3]==n[4] && n[0]==n[1])){
				score += 60000000000L;
				for(int i = 4; i > 0; i--){
					if((n[i]==n[i-1]) && (n[i-1]==n[i-2])){
						score += n[i];
						break;
					}
				}
			}
			//포카드인 경우
			else if((n[0]==n[1] && n[1]==n[2] && n[2]==n[3]) || (n[1]==n[2] && n[2]==n[3] && n[3]==n[4])){
				score += 70000000000L;
				for(int i = 4; i > 0; i--){
					if(n[i]==n[i-1]){
						score += n[i];
						break;
					}
				}
			}
			//쓰리카드인 경우
			else{
				score += 30000000000L;
				for(int i = 4; i > 0; i--){
					if(n[i]==n[i-1]){
						score += n[i];
						break;
					}
				}
			}
		}
		//스트레이트인 경우
		if(n[0]+1==n[1] && n[1]+1==n[2] && n[2]+1==n[3] && n[3]+1==n[4]){
			score += (40000000000L + n[4]);
		}
		//플러시인 경우
		if(s[0]==s[1] && s[1]==s[2] && s[2]==s[3] && s[3]==s[4]){
			//스트레이트 플러시
			if(n[0]+1==n[1] && n[1]+1==n[2] && n[2]+1==n[3] && n[3]+1==n[4]){
				score += (80000000000L + n[4]);
			}
			//플러시인 경우
			else{
				score += 50000000000L;
				int j = 8;
				for(int i = 4; i >= 0; i--){
					score += n[i] * Math.pow(10, j);
					j -= 2;
				}
			}
		}
		//하이카드인 경우
		if(score == 0){
			int j = 8;
			for(int i = 4; i >= 0; i--){
				score += n[i] * Math.pow(10, j);
				j -= 2;
			}
		}
		
		return score;
	}
}