#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(){
	int count = 0;
	while(1){
		int row, col;
		scanf("%d %d", &row, &col);
		if(row == 0 && col ==0){
			return 0;
		}
	
	char** arr = (char**)malloc(sizeof(char*) * row);
	for (int i = 0; i < row; i++){
		arr[i] = (char*)malloc(sizeof(char) * (col + 1));
	}
	for(int i = 0; i < row; i++){
		scanf("%s", arr[i]);
	}
	for(int i = 0; i < row; i++){
		for(int j = 0; j < col; j++){
			if (arr[i][j] == '.'){
				arr[i][j] += 2;
			}
		}
	}
	for(int i = 0; i < row; i++){
		for(int j = 0;j < col; j++){
			if(arr[i][j] == '*'){
				for(int m = i-1; m < i+2;m++){
					for(int n = j -1; n < j+2;n++){
						if(m>=0 && m< row && n>=0 && n< col && arr[m][n]>= '0'){
							arr[m][n]+= 1;
						}
					}
				}
			}
		}
	}
	count++;
	printf("Field #%d:\n",count);
	for(int i = 0; i < row; i++){
		printf("%s\n", arr[i]);
	}
	printf("\n");
	for(int i = 0; i < row; i++){
		free(arr[i]);
	}
	free(arr);
}
}