#include <stdio.h>
#define P 100
int main() {
	int T, input_N, input_P, i, j, holiday, s_cnt=0;
	int h_day[P];	//동맹 휴업 지수 저장
	scanf("%d", &T);
	while(1){
		scanf("%d", &input_N);
		if(input_N<7||input_N>3650) return 0;
		scanf("%d", &input_P);
		if(input_P<1||input_P>100) return 0;
		for(i=0; i<input_P; i++){
			scanf("%d", &h_day[i]);
		}
		holiday=0;
		for(i=1; i<=input_N; i++){
			for(j=0; j<input_P; j++){
				if(i%h_day[j]==0 && i%7!=6 && i%7!=0) {
					holiday++; //if문 코드 한줄에 다 넣어서 에러났던 것 같음.
					break;	//i에서 조건 충족해서 j가 여러번 돌면 중복되는 거라 중단. 
				}
			}
		}
		printf("%d\n", holiday);
		s_cnt++;
		if(s_cnt==T) return 0;
	}
}
