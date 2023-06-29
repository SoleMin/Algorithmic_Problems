#include <stdio.h>
int main() {
	int casenum, days, partys;
	int i, j, k, n;
	int linechecker = 0;
	int hartal_parameter[3650];
	int hartal_days;
	//테스트 케이스 개수 입력받기
	scanf("%d", &casenum);
	//테스트 케이스 만큼 반복 실행하겠다.
	for (i = 0; i < casenum; i++) {
	//시뮬레이션 날짜수 입력받기
		scanf("%d", &days);
	//정당의 개수 입력받기
		scanf("%d", &partys);
	//정당의 개수만큼 휴업지수 입력받기
		for (j = 0; j < partys; j++) {
			scanf("%d", &hartal_parameter[j]);
		}
	//날짜를 휴업지수로 나누었을때 
	//날짜 나누기 휴업지수의 나머지 == 0 && 날짜 나누기 7의 나머지가 0 or 6 이 아니면 추가
		hartal_days = 0;
		for (k = 1; k <= days; k++) {
			for (n = 0; n < partys; n++) {
				if (k % hartal_parameter[n] == 0 && (k % 7 > 0 && k % 7 < 6)) {
					hartal_days++;
					break;
				}
			}
		}
	//줄바꿈 확인
		if (linechecker != 0) {
			printf("\n");
		}
		linechecker++;
	//자료의 개수확인
		printf("%d",hartal_days);
	}
	return 0;
}