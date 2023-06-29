#include <stdio.h>
#include <string.h>

int main(void)
{
	char a [1024];
	char b [1024];
	while (1)
	{
		int alpA[26] = {0, };
		int alpB[26] = {0, };
		if (fgets(a, 1024, stdin) == NULL)
			break;
		fgets(b, 1024, stdin);
		for (int i = 0; i < strlen(a); i++)
			alpA[a[i] - 'a']++;
		for (int i = 0; i < strlen(b); i++)
			alpB[b[i] - 'a']++;
		
		for (int i = 0; i < 26; i++)
			if (alpA[i] <= alpB[i])
				for (int k = 0; k < alpA[i]; k++)
					printf("%c", (char)i + 'a');
			else
				for (int k = 0; k < alpB[i]; k++)
					printf("%c", (char)i + 'a');
		printf("\n");
			
	}
}