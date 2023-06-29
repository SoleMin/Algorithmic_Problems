#include <stdio.h>

int main() 
{
	char input[1024];
		
	while (fgets(input, 1024, stdin) != NULL)
	{
		int i = 0;				// 인덱스
		int chr = 0;			// 글자 갯수
		int word = 0;			// 단어 갯수
		int count = 0;		// 공백 갯수
		
		while(input[i] != '\0')
		{
			// 글자 갯수를 위한 공백 갯수 세기
			if ((input[i] == ' ' || input[i] == '\t') || (input[i] == '\t' || input[i] == '\n'))
				count++;
			
			// 문자로 끝날 때
			if ((i == 0 && input[i] != ' ' && input[i] != '\t') || 
				i > 0 && ((input[i-1] == ' ' || input[i-1] == '\t') && (input[i] != ' ' && input[i] != '\t')))
				word++;
			i++;
		}
	
		//문자로 끝나지 않을 때
		if (input[strlen(input)-2] == ' ' || input[strlen(input)-2] == '\t')		
			word--;
		
		chr = strlen(input) - count;	// 글자 갯수
		printf("%d %d\n", chr, word);
	}
	return 0;
}
	