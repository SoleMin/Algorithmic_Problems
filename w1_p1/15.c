#include <stdio.h>
#include<string.h>
int main() {
	char c[1024]; //입력받는 문자열
	int charn=0; //입력받은 문자개수
	int wordn=0; //입력받은 단어개수
	int i;
	while(fgets(c,1024,stdin)!=NULL){
		charn=0, wordn=0, i=0;
		while(c[i]!='\n'&&strlen(c)>i){
			if(  (i==0&&(c[i]!=' '&&c[i]!='\t')) ||	 (i!=0&& (c[i]!=' '&&c[i]!='\t') && (c[i-1]==' '||c[i-1]=='\t')) ){
				wordn++;
			}
			if(c[i]!=' '&&c[i]!='\t'){
				charn++;
			}
			i++;
		}
		printf("%d %d\n", charn, wordn);
	}

	return 0;
}
