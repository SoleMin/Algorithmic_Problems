#include <stdio.h>
#define MAX_ARR 3660
int main() {
	int T, N, P, input, day;
	int arr[MAX_ARR];
	
	scanf("%d", &T);
	
	for(int i=0; i<T; i++){
		scanf("%d %d", &N, &P);
		
		for(int j=0; j<=MAX_ARR; j++) arr[j]=0;
		
		for(int j=0; j<P; j++){
			scanf("%d", &input);
			for(int k=1; input*k <= N; k++)
				if((input*k)%7 != 6 &&  (input*k)%7 != 0)
				arr[input*k]=1;
		}
		day = 0;
		for(int j=1; j<=N; j++)
			if(arr[j])
				day++;
		printf("%d\n", day);
		
	}
	
}
