#include <stdio.h>
#include <ctype.h>
int main() {
	int words, letters, i;
	char line[1024];
	while(fgets(line, 1024,stdin)!=NULL) {
		words=0, letters=0;
		for(i=0;i<strlen(line);i++) {
			if(i==0) {
				if(!isspace(line[i])){
					words++;
				}
			}
			else{
				if(isspace(line[i-1])&&!isspace(line[i])) {
					words++;
				}
			}
			if(!isspace(line[i])) {
				letters++;
			}
			if(line[i]=='\n'){
				break;
			}
		}
		printf("%d %d\n",letters,words);
	}
	return 0;
}
