#include <stdio.h>
int main() {
	
	int cases; // 케이스 수
	int days; // 시물돌릴 날짜들
	int num; // 정당 수
	int hartal[100];
	int total; // 총 손실 근무일 
	int i,j,d;
	
	
	
	scanf("%d", &cases); // 입력의 첫번째 줄 : 입력될 테스트 케이스 개수
	
	for(i=0; i<cases; i++){ // 두번째줄부터~ / 첫번째 : 날 수, 두번째 : 정당의 수
		scanf("%d", &days); // 두번째줄 : 시뮬 돌릴 날짜수
		scanf("%d", &num); // 세번째줄 : 정당 수
		for(j=0; j<num; j++){
			scanf("%d", &hartal[j]);
		}
		
		// 한 케이스 입력 다 받고 나서 실행
		total = 0;
		for(j=1; j<=days; j++){
			if((j-1)%7 < 5){
				for(int e=0; e<num; e++){ // 하루에 정당들이 얼마나 쉬는가... 한 정당이 쉬면 바로 숫자올리고 break
					if( j % hartal[e] == 0 ) {
						total ++;
						break;
					}
				}
			}
		}
		printf("%d\n", total);
	}
	return 0;
}
