#include <stdio.h>
int main() {
	
	// 최대 사이클 길이를 구하기 : 1,5일때 1부터 구한 사이클, 2부터 구한 사이클, 3부터구한 사이클 ... 중 제일 긴 것을 찾기??
	
	long start, end, rstart, rend;
	long temp, i, j, length, longest;
	while( scanf("%ld %ld", &start, &end)==2){
		rstart = start;
		rend = end;
		//숫자 크기 지정
		if (start > end){
			temp = end;
			end = start;
			start = temp;
		}
		//start와 end 사이의 모든 수에 대한 사이클 중 최대 길이 찾기 (?)
		longest = 0;
		for(i = start; i<=end; i++){
			j = i;
			length = 1;
			//1이 되면 사이클 종료
			while( j != 1 ){
				if (j % 2 != 0){ // 홀수
					j = j * 3 + 1;
					length = length + 1;
				}
				if (j % 2 == 0){ // 짝수
					j = j / 2;
					length = length + 1;
				}
			}
			
			if(length > longest)
				longest = length;
		}
		printf("%ld %ld %ld\n", rstart, rend, longest);
		
	}
	
}
