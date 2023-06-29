#include <stdio.h>
long arr[1000000];

int main() {
	long i, j, k, n, currentNum;
	long most_cycle, cycle;
	
	while (scanf("%ld %ld", &i, &j) == 2) {
		int inputI = i;
		int inputJ = j;
		if (i > j) {	// 오른쪽 수가 왼쪽 수보다 클 때
			long temp = i;
			i = j;
			j = temp;
		}
		// 초기화
		most_cycle = 0; k = 0;
		n = i;	// 현재 문자 시작 : i
		while (n <= j) {	// i부터 1씩 증가시키면서 j까지 계산 -> cycle 초기화
			currentNum = n; cycle = 0;
			// cycle 구하기 -> 현재 currentNum에 대한 cycle
			while (currentNum != 1) {	// 1이 될 때까지 반복
				if (currentNum & 1) {	// 홀수면
					currentNum = 3*currentNum + 1;	// 3n + 1 -> 결과는 짝수
					cycle++;
				}
				while (!(currentNum & 1)) { // 짝수면 반복
					currentNum >>= 1;	// 나누기 2
					cycle++;
				}
			}
			arr[k] = cycle;	// cycle 값 배열에 담기
			//printf("k: %d, cycle: %d\n", k, cycle);
			n++; k++;
		}
		// cycle 배열 구하고 나서 가장 큰 cycle 구하기
		for (k = 0; k < j-i+1; k++) {
			if (arr[k] > most_cycle)
				most_cycle = arr[k];
		}
		printf("%ld %ld %ld\n", inputI, inputJ, most_cycle+1);	// 출력 순서 문제였다니.....ㅂㄷㅂㄷ
	}
	
	return 0;
}
