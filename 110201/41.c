#include <stdio.h>
#define MAX 3000

int main() {
	int n, isJolly, input1, input2, sub;
	int num[MAX];
	char line[10000];
	while( scanf("%d", &n) > 0 ){
		isJolly = 1;
		for(int i = 0; i < n; i++)
			num[i]=0;
		
		scanf("%d", &input1);
		for(int i = 1; i < n; i++){
			scanf("%d", &input2);
			sub = input1 - input2;
			if(sub<0)
				sub = -(sub);
			if(sub>=n || sub <= 0){
				isJolly=0;
				n=0;
				break;
			}
			num[sub]++;
			input1 = input2;
		}
		
		for(int i = 1; i < n; i++){
			if (num[i] > 1){
				isJolly = 0;
				break;
			}
		}
		fgets(line, 10000, stdin);  //'\n'이 나올 때까지 문자열 입력받음.
		if(isJolly)
			printf("Jolly\n");
		else
			printf("Not jolly\n");
		
	}
}
