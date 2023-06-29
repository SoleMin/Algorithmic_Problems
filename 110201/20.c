#include <stdio.h>
int main() {
	int n; //입력받을 숫자의 개수
	int num1, num2;
	int samplenum=0;
	int present[3001];
	int jolly;
	char line[5000];
	
	while(scanf("%d",&n)==1){
		for(int i=1;i<=n;i++){
			present[i]=0;
		}
		scanf("%d",&num1);
		jolly=1;
		
		for(int i=0;i<n-1;i++){
			if(n==1)break;
			scanf("%d",&num2);
			samplenum=(num1>num2)?num1-num2:num2-num1;
			if(present[samplenum]==1||samplenum>=n||samplenum<=0){ 
				jolly=0;
				break;
			}
			present[samplenum]=1;
			num1=num2;
		}
	gets(line);
	if(jolly==1)printf("Jolly\n");
	else printf("Not jolly\n");
	}
	return 0;
}
