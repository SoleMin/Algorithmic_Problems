#include <string.h>
#include <stdio.h>
int main() {
	char str[100][90];
	char code[30];
	char check[50];
	char space[5];
	const char example[50] = "the quick brown fox jumps over the lazy dog";
	int i, T, t, j, N, key, nosolution, reset;
	
	scanf("%d", &T);
	fgets(space, 4, stdin);
	fgets(space, 4, stdin);
	for(t=0; t<T; t++)
	{
		N=0;
		for(i=0; i<30; i++) code[i]=-1;	// code 배열 초기화
		
		while(fgets(str[N], 85, stdin)){
			if(str[N][0]=='\n')
				break;
			str[N][strlen(str[N])-1] = '\0';
			N++;
		}
		
		for(i=0; i<N; i++){
			if(strlen(example)==strlen(str[i])){
				for(j=0; str[i][j]!='\0'; j++)
					if(isalpha(example[j]) != isalpha(str[i][j]))
						break;
				if(str[i][j]=='\0'){ // 양쪽 문장의 띄워쓰기 위치가 같으면
					for(j=0; str[i][j]!='\0'; j++)
						code[str[i][j]-97]=example[j];
					
					for(j=0; example[j] != '\0'; j++){		// 복호화 해봐서 예시문장이랑 같은지 보자
						if(isalpha(example[j]))
							check[j] = code[str[i][j]-97];
						else
							check[j]=example[j];
					}
					check[j] = '\0';
					if(strcmp(check, example) != 0){		// 예시랑 다르면
						for(reset = 0; reset < 30; reset++)code[reset]=-1;
					}
					else									// 예시랑 같으면
						break;
				}
			}
			
		}
		
		
		
		for(i=0; i<N; i++){
			nosolution = 0;
			for(j=0; str[i][j]!='\0'; j++){
				if(isalpha(str[i][j]) && code[str[i][j]-97] < 0){
					nosolution = 1;
					break;
				}
			}
			if(!nosolution){
				for(j=0; str[i][j] != '\0'; j++){
					if(isalpha(str[i][j]))
						printf("%c", code[str[i][j]-97]);
					else
						printf("%c", str[i][j]);
				}
			printf("\n");
			}
			else{
				printf("No solution.\n");
				break;
			}
		}
		printf("\n");
	}
	return 0;
}
