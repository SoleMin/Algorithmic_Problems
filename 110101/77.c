#include <stdio.h>

int main() {
	unsigned int i, j, input_i, input_j, original_i, original_j, temp, cycle_length, cycle_max;
	while(scanf("%d %d", &input_i, &input_j)==2){	//정수가 제대로 입력되었다면 반복문 실행
		original_i=input_i;	//입력한 i가 swap 시 변경되기 때문에, 다른 변수에 저장
		original_j=input_j;	//입력한 j가 swap 시 변경되기 때문에, 다른 변수에 저장
		if(input_i>input_j){	//만약 먼저 입력한 i가 나중에 입력한 j보다 크다면 
			temp=input_i;	//temp 변수에 i 저장
			input_i=input_j;	//i에 j 저장
			input_j=temp;	//j에 temp, 즉 원래 i 값을 저장
		}
		cycle_max=0;	//가장 큰 사이클을 저장할 변수 초기화
		for(i=input_i; i<=input_j; i++){	//i부터 j까지 반복문 실행
			j=i;	//j에 i 저장
			cycle_length=1;	
			while(j!=1){
				if (j%2!=0){
					j=3*j+1;
					cycle_length++;
				}
				while(j%2==0) {
					j=j/2;
					cycle_length++;
				}
			}
			if(cycle_max<cycle_length) cycle_max=cycle_length;
		}
		printf("%d %d %d\n",original_i, original_j, cycle_max);
	}
}