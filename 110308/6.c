#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdbool.h>

#define N 2048

int main(void) {
	char text[N] = "";
	char buffer[N] = "";
	char word[N];
	{
		char temp[N];
		while (fgets(temp, N, stdin) != NULL)
			strcat(text, temp);
	}//text에는 이제 모든 문자열이 담겨져 있다.
	int i = 0;
	while (i < strlen(text)) {
		bool loong = false;
		bool print = false;
		int word_count = 0;
		while (text[i] != ' ' && text[i] != '\n' && i <= strlen(text) - 1)
			word[word_count++] = text[i++];
		word[word_count] = '\0';
		
		//printf("'%d %d'\n", strlen(text), i);
		
		if (word_count > 72) {
			int len = strlen(buffer);
			for (int i = len - 1; i >= 0; i--)
				if (buffer[i] == ' ')
					buffer[i] = '\0';
				else
					break;
			if (strlen(buffer))
				printf("%s\n", buffer);
			buffer[0] = '\0';
			printf("%s\n", word);
			word_count = 0;
			while (text[i] == ' ')
				i++; //출력되는 줄의 맨 뒤에 있는 스페이스 삭제
			print = true;
			loong = true;
		} //72글자가 넘는 단어가 있으면 한 줄에 그 단어 하나만 출력한다.
		if (word_count > 0 && word_count + strlen(buffer) <= 72) {
			strcat(buffer, word);
			word_count = 0;
		} //버퍼에 담을 수 있으면 넣는다.
		if (word_count > 0 && word_count + strlen(buffer) > 72) {
			int len = strlen(buffer);
			for (int i = len - 1; i >= 0; i--)
				if (buffer[i] == ' ')
					buffer[i] = '\0';
				else
					break;
			/*
			for (int i = len - 1; i >= 0; i--) {
				if (isalnum(buffer[i]) || ispunct(buffer[i]))
					break;
				else
					buffer[i] = '\0';
			}*///출력되는 줄의 맨 뒤에 있는 스페이스는 모두 삭제된다.
			if (word_count + strlen(buffer) + 1 <= 72) {
				strcat(buffer, " ");
				strcat(buffer, word);
				word_count = 0;
			}
			else {
				printf("%s\n", buffer);
				buffer[0] = '\0';
				strcat(buffer, word);
				word_count = 0;
				print = true;
			}
		} //버퍼를 출력하고 버퍼에 넣는다.
		
		while (text[i] == ' ') {
			if (strlen(buffer) <= 72) {
				strcat(buffer, " ");
				i++;
			} //버퍼에 공간이 있으면 공백을 넣는다.
			else {
				int len = strlen(buffer);
				for (int i = len - 1; i >= 0; i--)
					if (buffer[i] == ' ')
						buffer[i] = '\0';
					else
						break;
				/*
				for (int i = len; i >= 0; i--) {
					if (isalnum(buffer[i]) || ispunct(buffer[i]))
						break;
					else
						buffer[i] = '\0';
				}*/
				printf("%s\n", buffer);
				buffer[0] = '\0';
				while (text[i] == ' ')
					i++;
				print = true;
			} //버퍼에 공간이 없으면 버퍼를 비우고 공백은 무시한다.
		}

		while (text[i] == '\n') {
			if (i == strlen(text) - 1) {
				i++;
				break;
			} // 마지막 개행은 무시한다.
			/*
			if (text[i + 1] == ' ') {
				if (!print) {
					int len = strlen(buffer);
					for (int i = len - 1; i >= 0; i--)
						if (buffer[i] == ' ')
							buffer[i] = '\0';
						else 
							break;
					printf("%s\n");
					buffer[0] = '\0';
					i++;
				}
				break;
			}//여기서 뒤에 공백을 제거해야 할 수도 있음*/
			if (text[i + 1] == '\n') {
				int len = strlen(buffer);
				for (int i = len - 1; i >= 0; i--) {
					if (buffer[i] == ' ')
						buffer[i] = '\0';
					else
						break;
				}
				if (!print) {
					printf("%s\n\n", buffer);
					buffer[0] = '\0';
				}
				else
					printf("\n");
				i += 2;
				break;
			} //개행 문자 조건
			else {
				if (strlen(buffer) <= 72) {
					if (!loong)
						strcat(buffer, " ");
					i++;
					break;
				}
				else {
					int len = strlen(buffer);
					for (int i = len - 1; i >= 0; i--)
						if (buffer[i] == ' ')
							buffer[i] = '\0';
						else
							break;
					printf("%s\n", buffer);
					buffer[0] = '\0';
					i++;
					break;
				}
			}
		}
	}
	printf("%s", buffer);
}

/*
#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
#include <string.h>

#define N 1024

int main(void) {
	char str[N];
	char buffer[N];
	
	int count = 0;
	int last_blank = -1;
	int new_line = -1;
	int word_len = 0;
	while (fgets(str, N, stdin) != NULL) {
		if (str[0] == '\n') {//빈줄
			if (new_line >= 0) {
				buffer[new_line] = '\n';
				new_line = -1;
				word_len = 0;
				last_blank = -1;
				buffer[count] = '\0';
				count = 0;
			}
			printf("%s\n", buffer);
			continue;
		}
		bool only_blank = true;//공백만 있는 줄
		for (int i = 0; i < strlen(str); i++)
			if (str[i] != ' ' && str[i] != '\n')
				only_blank = false;
		if (only_blank) {
			printf("\n");
			continue;
		}
		
		char* p = str;
		while (*p) {
			if (*p == ' ') {
				buffer[count] = *p;
				last_blank = count;
				word_len = 0;
				
				if (new_line >= 0) {
					buffer[new_line] = '\n';
					new_line = -1;
				//}
				
			}
			else if (*p == '\n') {
				buffer[count] = ' ';
				word_len = 0;
				
				if (new_line >= 0) {
					buffer[new_line] = '\n';
					new_line = -1;
				}
				else 
					new_line = count;
			}
			else {
				if (count >= 70 && (*(p + 1) != ' ' && *(p + 1) != '\n')) {
					buffer[last_blank] = '\0';
					printf("%s", buffer);
					int temp = 0;
					for (int i = last_blank + 1; i < count; i++, temp++)
						buffer[temp] = buffer[i];
					count = temp;
					buffer[count] = *p;
					last_blank = -1;
					new_line = -1;
					word_len++;
				}
				else {
					buffer[count] = *p;
					word_len++;
				}
			}
			if (word_len >= 72) {
				printf("%s", buffer);
			}
			count++;
			p++;
		}
	}
}
*/