#include <stdio.h>
#define m 100
#define n 100
char input_arr[m][n], output_arr[m][n];
int main() {
	int input_m, input_n, i, j, field=1;
	while(scanf("%d %d", &input_m, &input_n)==2){
		if((input_m==0&&input_n==0)||input_m<0||input_n<0||input_m>100||input_n>100) break;
		for(i=0; i<input_m; i++){
			for(j=0; j<=input_n; j++){	//j<input_n이면 n-2까지만 입력받고 n-1 안 받고 끝남. 
				scanf("%c", &input_arr[i][j]);	//지뢰맵 입력
			}
		}
		printf("Field #%d:\n", field);
		for(i=0; i<input_m; i++){
			for(j=1; j<=input_n; j++){
				output_arr[i][j]='0';	//초기화
			}
		}
		for(i=0; i<input_m; i++) {
			for(j=1; j<=input_n; j++) {
				if(input_arr[i][j]=='*'){
					output_arr[i][j]='*';
					if(i-1>=0 && j-1>=0 && !(output_arr[i-1][j-1]=='*')) output_arr[i-1][j-1]++;
					if(i-1>=0 && !(output_arr[i-1][j]=='*')) output_arr[i-1][j]++;
					if(i-1>=0 && j+1<=input_n && !(output_arr[i-1][j+1]=='*')) output_arr[i-1][j+1]++;
					if(j-1>=0 && !(output_arr[i][j-1]=='*')) output_arr[i][j-1]++;
					if(j+1<=input_n && !(output_arr[i][j+1]=='*')) output_arr[i][j+1]++;
					if(i+1>=0 && j-1>=0 && !(output_arr[i+1][j-1]=='*')) output_arr[i+1][j-1]++;
					if(i+1<input_m && !(output_arr[i+1][j]=='*')) output_arr[i+1][j]++;
					if(i+1<input_m && j+1<=input_n && !(output_arr[i+1][j+1]=='*')) output_arr[i+1][j+1]++;
				}
			}
		}
		for(i=0; i<input_m; i++){
			for(j=1; j<=input_n; j++){
				printf("%c", output_arr[i][j]);
			}
			printf("\n");
		}
		printf("\n");
		field++;
	}
}