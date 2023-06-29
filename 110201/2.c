#include <stdio.h>
#define MAX_ARRAY 3003
#define ABS(x) (((x)>=0) ? (x) : (-1*(x)))
int main() {
	int n, input1, input2, chk, tmp;
	int arr[MAX_ARRAY];
	char str[MAX_ARRAY];
	
	while(scanf("%d", &n) == 1){
		
		for(int j=0; j<=n; j++) arr[j]=0;
		chk=1;
		scanf("%d", &input1);
		for (int i=1; i<n; i++){
			
			scanf("%d", &input2);
			tmp = ABS(input1-input2);
			if(arr[tmp] || tmp<=0 || tmp>=n){
				chk=0;
				break;
			}else
				arr[tmp]=1;
			input1=input2;
		}
		if(chk)
			printf("Jolly\n");
		else
			printf("Not jolly\n");
		
		gets(str);
	}
	return 0;
}
