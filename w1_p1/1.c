#include <stdio.h>
#define SIZE 1024

int main() {
	char buffer[SIZE];
	int i, j, word_num = 0, letter_num = 0;
	
	for(;fgets(buffer, SIZE, stdin);){
		for(i=0;buffer[i]!='\n';i++){
			if(buffer[i]!=' ' && buffer[i]!='\t' && buffer[i]!='\n')
				letter_num++;
		}
		for(i=0;buffer[i]!='\n';i++){
			if((buffer[i]==' '||buffer[i]=='\t') && word_num==0){}
			else if((buffer[i]!=' ' && buffer[i]!='\t')  && (buffer[i+1] == ' ' || buffer[i+1] == '\t' || buffer[i+1] =='\n')){
				word_num++;
			}
		}
		printf("%d %d\n", letter_num, word_num);
		word_num=0;
		letter_num=0;
	}
	
	
	return 0;
}
