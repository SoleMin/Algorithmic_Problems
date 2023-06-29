#include <stdio.h>
#include <stdlib.h>
#include <string.h>

static int d[8][4] = {0,0,0,1,
											0,0,0,-1,
											0,0,1,0,
											0,0,-1,0,
											0,1,0,0,
											0,-1,0,0,
											1,0,0,0,
											-1,0,0,0};
static int arr[9999];

int main() {
	int num;
	int S[4];
	int E[4];
	int **X;
	int Y;
	char line;
	int i,j;
	int SS;
	int SSSS;
	int EE;
	int XX;
	int D[4];
	int cnt = 0;
	int temp;
	scanf("%d", &num);
	scanf("%c", &line);
	while(num != 0){
		for(i=0;i<4;i++){
			scanf("%d", &S[i]);
		}
		for(i=0;i<4;i++){
			scanf("%d", &E[i]);
		}
		scanf("%d", &Y);
		X = (int**)malloc(sizeof(int*)*Y);
		for(i=0;i<Y;i++){
			X[i] = (int*)malloc(sizeof(int)*4);
		}
		for(i=0;i<Y;i++){
			for(j=0;j<4;j++){
				scanf("%d", &X[i][j]);
			}
			XX = X[i][0]*1000+X[i][1]*100+X[i][2]*10+X[i][3];
			arr[XX] = 1;
		}
		scanf("%c", &line);
		SSSS = S[0]*1000+S[1]*100+S[2]*10+S[3];
		EE = E[0]*1000+E[1]*100+E[2]*10+E[3];
		
		for(i=0;i<4;i++){
			if(S[i] - E[i]>0){
				D[i] = -1;
				if(E[i]+10 - S[i] < S[i]-E[i])
					D[i] = 1;
				
			}
			else if(S[i] - E[i] < 0){
				D[i] = 1;
				if(S[i]+10 - E[i] < abs(S[i]-E[i]))
					D[i] = -1;
			}
		}
		temp = 0;
		while(SS!= EE){
			for(i=0;i<4;i++){
				while(S[i]!=E[i]){
					S[i] += D[i];
					if(S[i] == 10)
						S[i] = 0;
					else if(S[i] == -1)
						S[i] = 9;
					for(j=0;j<Y;j++){
						if(S[0]*1000+S[1]*100+S[2]*10+S[3] == X[j][0]*1000+X[j][1]*100+X[j][2]*10+X[j][3]){
							temp = 1000;
							break;
						}
					}
					if(temp == 1000){
						S[i] -= D[i];
						if(S[i] == 10)
							S[i] = 0;
						else if(S[i] == -1)
						S[i] = 9;
						temp = 0;
						break;
					}
					else{
						cnt++;
					}
				}
			}
			SS = S[0]*1000+S[1]*100+S[2]*10+S[3];
			if(SS == SSSS)
				break;
		}
		int result = bfs(SSSS,EE);
		if(result != 0)
			printf("%d\n", result);
		else{
			if(SS ==SSSS)
				printf("-1\n");
			else
				printf("%d\n", cnt);
		}
		cnt = 0;
		num--;
	}
}
int bfs( int a, int b ){
	if ( a == b ) 
		return 0;
	int A[4];
	int B[4];
	int queue[9999];
	int dequeue[9999];
	int cnt = 0;
	int i,j;
	int temp;
	int temp1 = 0;
	int c;
	queue[temp1++] = a;
	arr[a] = 1;dequeue[a] = 0;
	while (cnt < temp1) {
		temp = queue[cnt];
		for (i = 0 ; i < 4 ; i++) {
			A[3-i] = temp%10;
			temp /= 10;
		}
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 4; j++) {
				B[j] = A[j]+d[i][j];
				if (B[j] == -1) B[j] = 9;
				if (B[j] == 10) B[j] = 0;
			}
			c = B[0]*1000+B[1]*100+B[2]*10+B[3];
			if (c == b) 
				return dequeue[queue[cnt]]+1;
			if (arr[c] == 0) {
				arr[c] = 1;
				dequeue[c] = dequeue[queue[cnt]]+1;
				queue[temp1++] = c;
			}
		}
		cnt++;
	}
	return 0;
}