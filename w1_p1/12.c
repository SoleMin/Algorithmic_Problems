#include <stdio.h>
#include <string.h>

int main() {
	char line[1024];

	while (fgets(line,1024,stdin)!=NULL) {
		int words=0, letters=0, i=0;
		
		while(line[i] != '\n'){
			if(line[i] != ' ' && line[i] != '\t'){
				letters++;
				if(line[i+1] == ' ' || line[i+1] == '\t' || line[i+1] == '\n')
					words++;
		}
			i++;
		}
		
		printf("%d %d\n", letters, words);
					
	}
	
	return 0;
}
