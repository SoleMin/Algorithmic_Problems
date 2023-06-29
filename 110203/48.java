import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		
		for ( int i =0; i<testCase; i++){
			int days = 0; 
			int totalDays = input.nextInt();
			int n = input.nextInt();
			int[] arr = new int[100]; 
			
			for (int j =0; j<n; j++){
				arr[j]=input.nextInt();
			}
			
			for(int k =1; k<=totalDays; k++){
				if(k%7!=0){
					if(k%7!=6){
						for(int l =0; l<n; l++){
							if(k%arr[l]==0){
								days++;
								break;
								
							}
						}
					}
				}
			}
			System.out.println(days);
		}
		input.close();
		
/*
		3)n에서 각자의 휴업지수를 나누고, 몫을 모두 더한 후 중복된 수를 뺀다 (최소공배수 이용) 
		나머지가 0인경우 작은 수만 연산.
		0이 아닌 경우 나머지의 몫을 더한 , n에서 최소공배수를 나눈만큼 뺴준다
		금요일 과 토요일 동맹 휴업이 없는 것을 나타낼 때.
		전체일 수에서 7일 나눈다. 
		나머지가 0~5인 경우 몫x2 
		나머지가 6인 경우 몫x2+1  ->>>>>>>>>>>>>> x 
		
		//반대로 생각해서 휴무일만 계산하면 ?
		  ~ % 7 < 6 인 경우 */
	}
}