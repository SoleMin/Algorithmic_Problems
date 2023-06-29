#include <iostream>
using namespace std;

// T, N, P, Hi (-> H1, H2, H3, ...)
int main(void) {
	int t, n, p, h[100], i, date, k, nowork;
	bool closure;
	
	scanf("%d", &t);	// test case 개수
	for (k=0;k<t;k++) {	// test case 만큼 반복
		nowork = 0;	// 휴업 기간 초기화
		scanf("%d", &n);	// 시뮬레이션 돌릴 기간
		scanf("%d", &p); 	// 정당의 개수
		for (int d=0;d<p;d++) {	// 정당 휴업일 저장
			scanf("%d", &h[d]);
		}
		for (date=1;date<=n;date++) {	// 날짜 하루씩 증가 (1일부터 n일까지)
			closure = false;	// 이 날에 휴업하는 정당이 있는지 아직 모름
			// 날짜 % 휴업일 == 0 && 날짜 % 휴업일 != 6 && 날짜 % 휴업일 != 0 이면 동맹휴업++
			for (i=0;i<p;i++) {	// 특정 날짜에 휴업하는 정당이 있는지 판단 - k[0], k[1], k[2], ...
				if(date % h[i] == 0 && date % 7 != 6 && date % 7 != 0)	// 휴업일 배수 && 금요일 아님 && 토요일 아님
					closure = true;	// 이 날은 휴업함
			}
			if (closure)	// 휴업하는 정당 있으면
				nowork++;	// 휴업 기간++
		}	
		cout<<nowork<<'\n';
	}
	
	return 0;
}