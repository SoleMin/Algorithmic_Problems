#include <stdio.h>
#include <string.h>

int main()
{
	char input1[500], print[120]="";
	int len1, printlen, i;

	while (fgets(input1, 500, stdin))
	{
		if (input1[0] == '\n')
		{
			printf("%s\n\n", print);
			print[0] = '\0';
			continue;
		}

		len1 = strlen(input1);
		if(input1[len1-1]=='\n')
			input1[len1 - 1] = '\0';

		while (strlen(input1) > 0) {
			printlen = strlen(print);
			len1 = strlen(input1);

			if (len1 + printlen < 72)
			{
				if (printlen > 0)
					strcat(print, " ");
				strcat(print, input1);
				input1[0] = '\0';
			}
			else
			{
				for (i = 0; input1[i] != ' ' && i<len1; i++);

				if (i == len1 && printlen == 0) // 띄어쓰기가 없고 프린트 할 배열이 비어 있으면
				{
						printf("%s\n", input1);
						input1[0] = '\0';
				
				}
				else // input이 한 단어가 아니면
				{
					for (i = 71 - printlen; input1[i] != ' ' && i >= 0; i--); // input1의 띄어쓰기 위치 찾기
					if(i == -1) {
						printf("%s\n", print);
						print[0] = '\0';
					}
					else if (i <= 71 - printlen) {
						if (printlen > 0)
							strcat(print, " ");
						strncat(print, input1, i);
						strcpy(input1, &input1[i + 1]);
						printf("%s\n", print);
						print[0] = '\0';
					}
					else {
						printf("%s\n", print);
						print[0] = '\0';
					}
				}
			}
		}
	}

	if (strlen(print) > 0)
		printf("%s", print);
	return 0;
}