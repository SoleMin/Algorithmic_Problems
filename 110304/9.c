#include <stdio.h>
#include <string.h>

int main(void)
{
	char buf[100];
	char crypt[100][100];
	int alp[26];
	char hint[] = "the quick brown fox jumps over the lazy dog";
	int testCase, notHint, hintFound, sent;
	scanf("%d", &testCase);
	fgets (buf, 2, stdin);
	fgets (buf, 2, stdin);
	for (int sc = 0; sc < testCase; sc++)
	{
		sent =0; hintFound = -1;
		for (int i = 0; i < 26; i++)
			alp[i] = -1;
		
		while (1)
		{
			if (fgets(buf, 100, stdin) == NULL || strcmp(buf, "\n") == 0)
				break;
			buf[strlen(buf) - 1] = '\0';
			if (strlen(hint) == strlen(buf) && hintFound == -1)
			{
				notHint = 0;
				for (int i = 0; hint[i] != '\0'; i++)
					if((hint[i] == ' ' && buf[i] != ' ') || (hint[i] != ' ' && buf[i] == ' '))
					{
						notHint = 1; break;
					}
				
				if (notHint != 1)
				{
					for (int i = 0; i < strlen(hint); i++)
					{
						if (buf[i] != ' ' && hint[i] != ' ' && alp[buf[i] -'a'] != -1 && alp[buf[i] -'a'] != hint[i] - 'a')
						{
							for (int j = 0; j < 26; j++)
								alp[j] = -1;
							break;
						}
						alp[buf[i] - 'a'] = hint[i] - 'a';
					}
					for (int i = 0; i < 26; i++)
						if (alp[i] == -1)
						{
							for (int j = 0; j < 26; j++)
								alp[j] = -1;
							notHint = 1; break;
						}
				}
				if (notHint != 1)
					hintFound = 1;
			}
			sprintf(crypt[sent++], "%s", buf);
		}
		
			for (int sentcount = 0; sentcount < sent; sentcount++)
			{
				if (hintFound == -1)
				{
					printf("No solution.\n");
					break;
				}
				for (int i = 0; crypt[sentcount][i] != '\0'; i++)
					printf("%c", crypt[sentcount][i] == ' ' ? ' ': (char)alp[crypt[sentcount][i] - 'a'] +'a');
				printf("\n");
			}
		if (sc + 1 != testCase)
			printf("\n");
	}
}