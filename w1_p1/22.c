/* Idea: fgets returns when ERROR or EOF occurs*/

#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>

#define WORD 1024

void count_word();

int main(void) {
	count_word();
	
	return 0;
}

void count_word() {
	char words[WORD];
	int char_num;
	int word_num;
	bool flag;
	while ((fgets(words, WORD, stdin)) != NULL) {
		char_num = 0;
		word_num = 0;
		flag = false;
		
		for (char* c = words; *c; c++) {
			if (isalpha(*c)) {
				char_num++;
				flag = true;
			}
			else if (isspace(*c) && flag) {
				word_num++;
				flag = false;	
			}
		}

		printf("%d %d\n", char_num, word_num);
	}
}