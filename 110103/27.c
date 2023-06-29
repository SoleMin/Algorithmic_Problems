#include <stdio.h>
#include <math.h>	//올림 함수 쓰기 위한 헤더 
#define student 1000	//학생 수 1000명으로 전처리
int main() {
	int n, i;	//unsigned 해도 test10에서 Fail
	while(scanf("%d", &n)==1){
		//scanf("%d", &n);
		if(n==0 || n>1000) break;	
		double money_n[student];
		double sum=0, avg=0, move_money=0, move_sum=0;
		for(i=0; i<n; i++){
			scanf("%lf", &money_n[i]);
			if(money_n[i]<0 || money_n[i]>10000)	return;
		}
		for(i=0; i<n; i++){
			sum+=money_n[i];
		}
		avg=sum/n;
		double avg2=ceil(avg*100)/100;	//1센트 단위이니 0.x센트는 존재x. 따라서 소수점 셋째자리 수까지 평균 나올 경우, 반올림
		for(i=0; i<n; i++){
			if(money_n[i]>avg2){
				move_money=money_n[i]-avg2;
				move_sum+=move_money;
			}
		}
		printf("$%.2lf\n", move_sum);
	}
}