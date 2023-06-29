#include <stdio.h>
#include <string.h>
#define MAXN 80
#define LINE_NUM 4

const char* keyBoard[LINE_NUM] = {"`123456789-=", "QWERTYUIOP[]\\", "ASDFGHJKL;" , "ZXCVBNM,./"};

void main()
{
	while (!feof(stdin))
	{
		int i;
		char temp[500];
	
		if (!gets(temp))
			break;
		
		for(i=0; i<(int)strlen(temp); i++)
		{
			int j;
			int decode_ok = 0;
			for(j=0; j<LINE_NUM; j++)
			{
				if(strchr(keyBoard[j],temp[i]))
				{
					printf("%c", *(strrchr(keyBoard[j], temp[i]) -1));
					decode_ok = 1;
				}
			}
			if(!decode_ok)
				printf(" ");
		}
		printf("\n");
	}
}