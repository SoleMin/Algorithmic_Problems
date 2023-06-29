#include <stdio.h>
int main() {
	char input[1024][1024];
	int column;
	int row;
	int mine = 1;
	int output[1024][1024];
	int minedetector = 0;
	int try = 1;
	
	
	while(1){
		scanf("%d %d", &column, &row);
		
		if(column == 0 && row == 0){
			break;
		}
		
		for(int i = 0; i < column; i++){ //숫자 다음줄에 나오는 폭탄위치와 '.'을 받아서 input에 저장
			scanf("%s", &input[i]);
		}
		
		for(int j = 0; j < column; j++){
			for(int k = 0; k < row; k++){
				if(input[j][k] == '*'){
					output[j][k] = 815;
				}
				else{
					if(input[j][k + 1] == '*' && k + 1 < row){ //3시 방향에 폭탄
						minedetector++;
					}
					if(input[j][k - 1] == '*' && k - 1 >= 0){ //9시 방향에 폭탄
						minedetector++;
					}
					if(input[j -1][k - 1] == '*' && j - 1 >= 0 && k - 1 >= 0){ //11시 방향에 폭탄이 있으며 위치가 구석이 아닌 경우
						minedetector++; 
					}
					if(input[j - 1][k] == '*' && j - 1 >= 0){ //12시 방향에 폭탄이 있으며 인덱스가 1이상인경우
						minedetector++;
					}
					if(input[j - 1][k + 1] == '*' && j - 1 >= 0 && k + 1 < row){ //1시 방향에 폭탄, 구석이나 모서리 아닌 경우
						minedetector++;
					}
					if(input[j + 1][k + 1] == '*' && j + 1 < column && k + 1 < row){ // 5시 방향에 폭탄
						minedetector++;
					}
					if(input[j + 1][k] == '*' && j + 1 < column){ //6시 방향에 폭탄
						minedetector++;
					}
					if(input[j + 1][k - 1] == '*' && j + 1 < column && k - 1 >= 0){ //7시 방향에 폭탄
						minedetector++;
					}
					
					output[j][k] = minedetector;
					minedetector = 0;
				}
			}
		}
		
		printf("Field #%d:\n", try);
		try++;
		for(int a = 0; a < column; a++){
			for(int b = 0; b < row; b++){
				if(output[a][b] == 815){
					printf("*");
				}
				else{
					printf("%d", output[a][b]);
				}
			}
			
			printf("\n");
		}
		printf("\n");
	}
	return 0;
}
