#include <stdio.h>
int main() {
	int num;
	int num1;
	int i,j;
	char line;
	int T[1000];
	int S[1000];
	int result[1000];
	int temp;
	int temp1=0;
	
	scanf("%d", &num);
	scanf("%c", &line);
	temp = 0;
	while(num!=0){
		scanf("%d", &num1);
		for(i=0;i<num1;i++){
			scanf("%d",&T[i]);
			scanf("%d",&S[i]);
		}
		for(i=0;i<num1;i++){
			result[i] = i;
		}
		for(i=1;i<num1;i++){
			for(j=0;j<num1-i;j++){
				if(T[result[j]]*S[result[j+1]] > T[result[j+1]]*S[result[j]]){
					temp = result[j];
					result[j] = result[j+1];
					result[j+1] = temp;
				}
			}
		}
		for(i=0;i<num1-1;i++){
			printf("%d ", result[i]+1);
		}
		printf("%d\n", result[num1-1]+1);
		printf("\n");
		num--;
	}
}
