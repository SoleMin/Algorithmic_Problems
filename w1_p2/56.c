#include <stdio.h>
#define SIZE 1024	//SIZE=1024

int main() {
	char line[SIZE];	//char형 배열 line의 크기는 1024
	while(fgets(line, SIZE, stdin)!=NULL){	//fgets(읽어들인 문자열 저장할 char배열 가르키는 포인터, 읽어들일 최대 문자수, 표준입력)
		if(line[0]=='0'){
			int hex=0;
			sscanf(line+2,"%x",&hex);	//sscanf(입력한 문자열, 포멧, 인수 리스트): 버퍼에서 포맷 지정하여 읽어오는 함수
			printf("%d\n", hex);	//10진수로 출력
		}
		else {
			int dec=0;
			sscanf(line, "%d", &dec);	
			printf("0x%X\n", dec);	//16진수로 출력
		}
	}
	return 0;
}
