#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdbool.h>

#define LINE 100
#define N (80 + 1)

bool god(char* str, char* hint) {
	while (*str && *hint) {
		if (isalpha(*str) && isalpha(*hint)) {
			str++;
			hint++;
		}
		else if ((*str == ' ' && *hint == ' ') || (*str == '\n' && *hint == '\n')) {
			str++;
			hint++;
		}
		else
			return false;
	}
	return true;
}

int main(void) {
	int test_case;
	scanf("%d", &test_case);
	getchar();
	getchar();
	char texts[LINE][N];
	char crypt[26];
	char* hint = "the quick brown fox jumps over the lazy dog\n";
	while (test_case--) {
		int count = 0;
		while (fgets(texts[count], N, stdin) != NULL) {
			if (texts[count][0] == '\n')
				break;
			count++;
		}
		bool arr[N];
		for (int i = 0; i < N; i++)
			arr[i] = false;
		for (int i = 0; i < count; i++)
			if (god(texts[i], hint))
				arr[i] = true;
		
		bool flag;
		for (int _ = 0; _ < count; _++) {
			flag = false;
			if (arr[_] == false)
				continue;
			else {
				for (int i = 0; i < 26; i++)
					crypt[i] = '@';
				char* tp = texts[_];
				char* hp = hint;
				for (int i = 0; i < strlen(hint); i++) {
					if (isalpha(*tp)) {
						if (crypt[*tp - 'a'] != '@' && crypt[*tp - 'a'] != *hp)
							goto eol;
						crypt[*tp - 'a'] = *hp;
					}
					tp++;
					hp++;
				}
				flag = true;
				for (int i = 0; i < count; i++) {
					for (char* p = texts[i]; *p; p++)
						if(isalpha(*p))
							printf("%c", crypt[*p - 'a']);
						else
							printf("%c", *p);
				}
				break;
		}
			printf("\n");
			eol: ;
		}
		if (!flag)
			printf("No solution.\n");
		printf("\n");
	}
}