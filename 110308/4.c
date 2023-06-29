#include <stdio.h>
#include <string.h>
#define MAX 500
static char pre_line[1000];
static int p_len;

int process() {
	char line[MAX] = { 0 };
	char word[MAX] = { 0 };
	int l_len = 0;
	int w_len = 0;
	int i;
	if (p_len == 0)
		return 0;
	
	for (i = 0; pre_line[i] == ' '; i++)
		line[l_len++] = ' ';

	pre_line[p_len] = '\0';

	while (i < p_len) 
	{
		w_len = 0;
		while(i < p_len && pre_line[i] != ' ')
			word[w_len++] = pre_line[i++];
		word[w_len] = '\0';
		if (w_len + l_len > 72 && l_len != 0) 
		{
			while (l_len > 0 && line[l_len - 1] == ' ')
				l_len--;
			line[l_len] = '\0';
			printf("%s\n",line);
			l_len = 0;
		}
		for (int j = 0; j < w_len; j++)
			line[l_len++] = word[j];
		while(i < p_len && pre_line[i] == ' ')
		{
			line[l_len++] = ' ';
			i++;
		}
	}
	if (l_len!=0) 
	{
		while (l_len > 0 && line[l_len - 1] == ' ')
			l_len--;
		line[l_len] = '\0';
		printf("%s\n", line);
	}
}
int main() {
	char buff[MAX];
	int b_len;
	int i;
	p_len = 0;
	while (gets(buff)) {

		b_len = strlen(buff) - 1;
		while (b_len >= 0 && buff[b_len] == ' ')
			b_len--;
		buff[b_len + 1] = '\0';
		b_len++;

		if (b_len == 0 || buff[0] == ' ') 
		{
			process();
			p_len = 0;
			if (b_len == 0)
				printf("\n");
			else 
			{
				for (i = 0; buff[i] != 0; i++)
					pre_line[p_len++] = buff[i];
			}
		}
		else 
		{
			if (p_len != 0)
				pre_line[p_len++] = ' ';
			for (i = 0; buff[i] != 0; i++)
				pre_line[p_len++] = buff[i];
		}
	}
	process();
	return 0;
}