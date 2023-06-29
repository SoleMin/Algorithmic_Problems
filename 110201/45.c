#include <stdio.h>
int main() {
	
	int his[3000];
	char line[10000];
	int n, isjolly, pre, af, minu;
	
	while(scanf("%d", &n)==1){ 
		isjolly = 1; // 기본적으로 jolly라고 해둠
		for(int i=0; i<=n; i++){ // 차가 기존에 나왔던 건지 체크하는 배열을 우선 0으로 채워둠
			his[i] = 0;
		}
		scanf("%d", &pre); // 비교할 숫자 하나 먼저 받고 for문
		for(int i=1; i<n; i++){
			scanf("%d", &af);
			minu = pre-af; // 앞 뒤 숫자의 차이
			if(minu < 0)
				minu = minu * -1;
			if(minu <= 0 || minu >= n || his[minu]){ // Not jolly의 조건
				isjolly = 0;
				break;
			}
			his[minu] = 1; // 바로 위 if문에서 걸리지 않고 내려오면 실행, 그 차이가 존재했다는것을 저장
			pre = af; // 다음 배열의 수와 비교를 위해 pre값을 갱신하기
		}
		
		gets(line); // 하던 줄이 다음줄로 넘어갈까봐
		if(isjolly == 0)
			printf("Not jolly\n");
		else
			printf("Jolly\n");
	}
	return 0;
}
