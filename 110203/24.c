#include <stdio.h>
int main() {
	int test, i, j, k, count =0, temp; 
	int days; //기간
	int party; // 정당
	int p_max[100];
	
	scanf("%d", &test); // 테스트 케이스 개수
	
	for(i =0;  i< test; i++){
		scanf("%d", &days); // 시뮬레이션 돌릴 기간
		scanf("%d", &party); // 정당의 개수
		count = temp = 0;
		// 각각의 정당의 휴업 지수
		for(j=0; j <party; j++)
			scanf("%d",&p_max[j]);
		//
		for(j =1; j <=days; j++){
			for(k = 0; k < party; k++){
				temp = p_max[k];
				if((j-1+7)% 7 < 5)
				if(j % temp == 0){
					count++;
					break;
				}
			}
		}
		
		printf("%d\n",count);
	}
	
}
