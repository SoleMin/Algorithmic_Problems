#include <stdio.h>
#define BUFSIZE 1024

int main() {
	char line[BUFSIZE];
	
	while (fgets(line,BUFSIZE,stdin) != NULL) {
		int word=0, letter=0, i=0;
		while (line[i] != '\n' && strlen(line) > i) {
			if ((i==0 && (line[i]!=' ' && line[i] != '\t'))||(i>0 && (line[i-1]==' ' || line[i-1]=='\t') && (line[i] != ' ' && line[i]!='\t')))
				word++;
			if (line[i] != ' ' && line[i]!='\t')
				letter++;
			i++;
		}
		printf("%d %d\n", letter, word);
	}
	return 0;
}
