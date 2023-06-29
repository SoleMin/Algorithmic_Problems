#include <string.h>
#include <stdio.h>

int main() {
	char input[1024];
	int letter_cnt = 0;
	int word_cnt = 0;
	int i = 0;
	
	while (fgets(input, sizeof(input), stdin) != NULL)
	{
		char* ptr = strtok(input," \n\t\r");
		while (ptr != NULL)
		{
			letter_cnt = letter_cnt + strlen(ptr);
			ptr = strtok(NULL," \n\t\r");
			word_cnt++;
		}
		printf("%d %d\n",letter_cnt, word_cnt);
		letter_cnt = 0;
		word_cnt = 0;
	}
	return 0;
}
