#include <stdio.h>

int main() {
	int n,test,party,i,j,result,check;

	scanf("%d",&test);
	while(test>0)
	{
		check =0;
		result = 0;
		scanf("%d",&n);
	 scanf("%d",&party);
	 if(n<7 || n>3650 || party<1 || party>100)
		 break; //n과 정당개수 범위 조건
			 
		int h[party-1];
	 for(i=0;i<party;i++)
	 scanf("%d",&h[i]); //h배열(휴업지수) 입력
		 
			
	 for(i=1;i<=n;i++)// 1일부터 n일까지 검사
	 {
		 if(i%7 != 0 && i%7 != 6) // 금 토 제외
		 {
			 for(j=0;j<party;j++)
			 {
				 if(i%h[j]==0) //각 날에 대해서 동맹휴업인 경우
				 {
					 result++; //근무안한 일 +1
					 break; //동맹휴업인경우 중복해서 더해지는것을 피하기 위한 반복문탈출
				 }
			 }
		 }
	 } //for
	 printf("%d\n",result);
		test--;
	}//while
	return 0;
}//main
