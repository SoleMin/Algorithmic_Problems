import java.util.*;
class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int repeat_T = in.nextInt();                 //반복 수
		for(int i = 0; i < repeat_T; i++){
			
			int period = in.nextInt();                 //기간
			int Hartals = 0;                           //파업 수
			int party_numbers = in.nextInt();          //정당 갯수
			int party[] = new int[party_numbers];      //각 정당의 휴업 기간
			
			//정당 휴업 기간 설정
			for(int j = 0; j < party_numbers; j++){
				party[j] = in.nextInt();
			}
			
			//기간 만큼 반복
			for(int j = 1; j <= period; j++){
				//금.토는 제외
				if((j % 7 != 0) && ((j+1) % 7 != 0)){
					for(int k = 0; k < party_numbers; k++){
						//정당의 휴업 기간에 걸리면 
						if(j % party[k] == 0){
							Hartals += 1;
							break;
						}
					}
				}
			}
			System.out.println(Hartals);
		}
	}
}