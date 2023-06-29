#include <stdio.h>
#include <stdbool.h>

int main(){
	int t,n,p,h,count;
	bool date[3650];
	scanf("%d",&t);	//테스트케이스 횟수
	for(int T=0;T<t;T++){
		for(int j=0;j<3650;j++)
			date[j]=false;
		count=0;
		scanf("%d",&n); //요일
		scanf("%d",&p); //정당 수
		for(int i=0;i<p;i++){
			scanf("%d",&h); //휴업지수
			for(int j=0;(j*h)+h-1<n;j++)
				date[(j*h)+h-1] = true;
		}
		
		for(int j=0;j<n;j++){
			if(j%7>4)continue;
			if(date[j]){
				count++;
			}
		}
		printf("%d\n",count);
	}
}