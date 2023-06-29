#include <stdio.h>
#include <string.h>

char minimum(char x, char y)
{
	if(x > y)
	{
		return y;
	}
	else if(y > x)
	{
		return x;
	}
	else
	{
		return x;
	}
}

void main(void)
{
	char *str, str1[1000], str2[1000];
	int count1[256], count2[256];
	int i, j;
	
	while (gets(str1))
	{
		gets(str2);
		for (i = 0; i < 256; i++)
		{
			count1[i] = 0;
			count2[i] = 0;
		}
		for (str = str1; *str; str++)
		{
			count1[*str]++;
		}
		for (str = str2; *str; str++)
		{
			count2[*str]++;
		}
		for (i = 0; i < 256; i++)
		{
			for (j = 0; j < minimum(count1[i], count2[i]); j++)
			{
				printf("%c", (char)i);
			}
		}
		printf("\n");
	}
	
}
