#include <stdio.h>
#include <string.h>	//string 함수 사용하려면 필요
#define SIZE 1024	//SIZE는 1024의 크기를 가짐

int main() {
	char line[SIZE];	//char형 배열 line의 크기는 1024
	while(fgets(line, SIZE, stdin)!=NULL){	//입력값이 NULL이 아닐 때까지 계속 반복
		int words=0, letters =0, i=0;
		while(line[i]!='\n' && strlen(line)>i){	//i번째 배열이 줄바꿈이 아니고 길이가 문자열 i보다 길면 계속 반복
			if((i==0&&(line[i]!=' ' && line[i]!='\t')) || (i>0 && (line[i-1]==' ' || line[i-1]=='\t') && (line[i]!=' ' && line[i]!='\t')))	words++;
			if(line[i]!=' ' && line[i]!='\t')	letters++;
			i++;
		}
		printf("%d %d\n", letters, words);
	}
}