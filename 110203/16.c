#include <stdio.h>
int main() {
	int t, day, dang; //케이스 개수, 시뮬 기간, 당 개수
	int restday=0; //동맹휴업 일수
	int rest[100]; //동맹 휴업지수 저장
	char line[5000];
	scanf("%d", &t);
	for(int i=0;i<t;i++){
		//날 수와 당 개수 받기
		scanf("%d", &day);
		if(day<7||day>3650){
			printf("오류 : 7<= 시뮬레이션 기간 <= 3650입니다.");
			scanf("%d", &day);
		}
		scanf("%d", &dang);
		if(dang<1||dang>100){
			printf("오류 : 1<= 정당 개수 <=100입니다.");
			scanf("%d", &dang);
		}
		//당 휴업지수 받기
		for(int j=0;j<dang;j++){
			scanf("%d", &rest[j]);
		}
		//동맹휴업 확인
		for(int k=1;k<=day;k++){
			if(k%7==0 || k%7==6){
				continue;
			}
			for(int s=0;s<dang;s++){
				if(k%rest[s]==0){
					restday++;
					break; //이날은 더이상 하면안됨
				}
			}
		}
	
		printf("%d\n", restday);
		restday=0;
	}
	return 0;
}
