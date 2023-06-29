#include <stdio.h>
#include <stdlib.h>	//절대값 구하기 위한 헤더
#define n 3000

int main() {
	int jump[n], jump_sub_abs[n-1], input_n, i, j, present, n_j;
	while(scanf("%d", &input_n)==1){
		if(input_n < 1 || input_n > 3000) return 0;
		present=0;
		for(i=0; i<input_n; i++){
			scanf("%d", &jump[i]);
		}
		for(i=0; i<input_n-1; i++){
			jump_sub_abs[i]=abs(jump[i]-jump[i+1]);	//차의 절대값 저장
		}
		for(i=0; i<input_n-1; i++){
			for(j=i+1; j<input_n-1; j++){
				if(jump_sub_abs[i]==jump_sub_abs[j]) present++;
			}
		}
		n_j=0;	//not jolly 카운트하려고 넣은 변수
		for(i=0; i<input_n; i++){
			if(jump_sub_abs[i]<1 || jump_sub_abs[i]>input_n-1 || present!=0) {
				n_j++;
			}
		}
		if(n_j>1) printf("Not jolly\n");
		if(n_j<=1) printf("Jolly\n");
	}
}