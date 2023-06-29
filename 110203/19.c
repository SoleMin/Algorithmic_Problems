#include <stdio.h>

void main(void) {
	int n,t,p,i,j,k,lostday;
	int h[100]; //동맹휴업지수 
	
	scanf("%d", &t);   // 테스트케이스 개수 
	for(i=0; i<t; i++){   
		scanf("%d", &n);
		scanf("%d", &p);   //정당의 수 입력 
		for(j=0; j < p; j++)
			scanf("%d", &h[j]);   //정당별 동맹휴업 지수 입력 
		lostday = 0; 
		for(j=1; j<=n; j++)
			if ((j-1)%7 < 5)    // 금,토,일 제외
				for(k=0; k <p; k++)
					if(j % h[k] == 0){ // 동맹휴업일이라면
						lostday++;
		        break;
					}
		printf("%d\n",lostday);
	}
	
	
}
