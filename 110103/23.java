import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner (System.in);
		int member;
		int moneysum = 0;
		
		while(true){
			
			member = input.nextInt();
			//System.out.println("member = " + member);
			if(member == 0){
				break;
			}
		
			int[] moneyarr = new int[member]; // 처음 각자 쓴  돈이 *100 되어 저장되는 배열
			int[] realmoney = new int[member]; // 각자 진짜 써야하는 돈
			int[] answermoney = new int[member]; // 최종적으로 각자 얼마씩 내야하는지 들어있는 배열
			
			for (int i=0; i<member; i++){
				moneyarr[i] = (int)( 100*(input.nextDouble())+ 0.5 ); // 100씩 곱하고 int로 형변환해주기
				moneysum = moneysum + moneyarr[i]; // 처음 쓴 돈의 합을 구하기
			}
			int tmp;
			// 처음 쓴 돈 크기순으로 나열하기
			for(int n=0; n<member; n++){
				for(int m=0; m<member; m++){
					if(moneyarr[m] < moneyarr[n]){
						tmp = moneyarr[m];
						moneyarr[m] = moneyarr[n];
						moneyarr[n] = tmp;
					}
				}
			}
			
			// 크기순으로 배열됬는지 확인
			//for(int n=0; n<member; n++){
				//System.out.println(" moneyarr[ " + n +"]= " + moneyarr[n]);
			//}
			
			
			tmp = 0;
			
			// 순서에 따른 각자 진짜 내야하는 돈
			for(int i=0; i<member; i++){
				realmoney[i] = moneysum/member;
			}
			
			//for(int i=0; i<member; i++){
				//System.out.println("원래 일케 냈어야함 : realmoney[" + i + "] = " + realmoney[i] );
			//}
			
			//System.out.println("쓴 돈의 총 합 : " + moneysum );
			
			moneysum = moneysum % member; // 위에서 넣고 난 나머지로 갱신해서 다시 분배
			//System.out.println("나머지는 얼마? : " + moneysum);
			
			// 나머지도 많이 낸 순서대로 다시 분배
			int j=0;
			for(j=0; j<moneysum; j++){
				realmoney[j] = realmoney[j] + 1; 
			}
			//System.out.println("나머지는 몇번 돌아감? : " + j );
			j = 0;
			
			//System.out.println("이제 이걸 순서대로 뺄거.");
			//for(int i=0; i<member; i++){
				//System.out.println("realmoney[" + i + "]=" + realmoney[i]);
			//}
			
			
			moneysum = 0;
			int ttmp = 0;
			// 이제 진짜 낸 돈에서 각자 낼 돈을 빼주고 뺀 값을 다 더해서 나누기 2해주면 나옴.
			for(int i=0; i<member; i++){
				
				ttmp = moneyarr[i] - realmoney[i];
				// 음수일 경우 양수로 바꾸기
				if ( ttmp < 0 ){
					ttmp = ttmp * (-1);
				}
				
				answermoney[i] = ttmp; // 각자 내야하는 돈을 저장해주기
				
			}
			ttmp = 0;
			
			int answersum = 0;
			for(int i=0; i<answermoney.length; i++){
				//System.out.println("각자 내야 하는 돈: " + answermoney[i] + "(" + i + ")" );
				answersum = answersum + answermoney[i];
			}
			
			answersum = answersum/2; 
			Double aanswersum = 0.0;
			//System.out.println("double 하기 전 값: " + answersum);
			aanswersum = (double)(answersum/100.0);
			if(aanswersum % 1.0 <= 0.0){
				System.out.printf("$" + "%.2f", aanswersum);
				System.out.println();
			
			}
			else
				System.out.println("$" + aanswersum);	
			//System.out.println("사이클 돌아감");
		}
	}
}