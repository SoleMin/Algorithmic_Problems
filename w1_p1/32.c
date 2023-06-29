#include <stdio.h>
#include <stdlib.h>

int main() {
	char str[1024];
	int cnt_word, cnt_char, i;
	while(fgets(str, sizeof(str), stdin) != NULL){
		cnt_word = cnt_char = i = 0;
		while(str[i] != '\n' && strlen(str)>i){
			if((i==0 && (str[i]!=' ' && str[i]!='\t')) || (i>0 && (str[i-1]==' ' || str[i-1]=='\t') && (str[i]!=' ' && str[i]!='\t')))
				cnt_word++;
			if(str[i]!=' ' && str[i]!='\t')
				cnt_char++;
			i++;
		}
		printf("%d %d\n", cnt_char, cnt_word);
	}
	return 0;
}