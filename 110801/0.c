#include <stdio.h>
int main() {
	int chess;
	int bishop;
	long long arr[17][69];
	int i,j;
	long long result = 0;
	int temp;
	while(scanf("%d", &chess) == 1){
		scanf("%d", &bishop);
		if(chess == 0 && bishop == 0)
			break;
		result = 0;
		for(i=0;i<chess*2;i++){
			arr[1][1] = 1;
			for(j=0;j<bishop+1;j++){
				arr[i][j] = 0;
			}
		}
		for(i=0;i<chess*2;i++)
			arr[i][0] =1;
		for(i=2;i<chess*2;i++){
			for(j=1;j<=bishop;j++){
				if(i%2 == 1){
					temp = i/4*2+1;
				}
				else{
					temp = (i-1)/4*2+2;
				}
				arr[i][j] = arr[i-2][j] + arr[i-2][j-1]*(temp - j +1);
			}
		}
		for(i=0;i<=bishop;i++){
			result += arr[chess*2-1][i]*arr[chess*2-2][bishop-i];
		}
		if(bishop>2*chess)
			printf("0\n");
		else if(bishop == 1 && chess == 1)
			printf("1\n");
		else
			printf("%lld\n", result);
		
	}
}
