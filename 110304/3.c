#include <stdio.h>
#include <string.h>

char key[] = "the quick brown fox jumps over the lazy dog";
char texts[101][81] = { 0 };
char al[123] = { 0 };

int check(char arr[],int len)
{
	if (len != strlen(key))
		return 0;
	for (int i = 0; i<len; ++i)
		if (key[i] == ' ' && arr[i] != ' ') 
			return 0;
	for (int i = 0; i<len; ++i) {
		if (al[arr[i]] != 0 && al[arr[i]] != key[i])
			return 0;
		else
			al[arr[i]] = key[i];
	}
	return 1;
}

int main()
{
	int case_;
	int t_len;
	int cnt,flag;
	scanf("%d\n", &case_);

	for(int c=case_;c>0;c--){
		cnt = 0;
		while (gets(texts[cnt]) != 0 && texts[cnt][0] != '\0')
		{
			cnt++;
		}
		flag = 0;
		for (int i = 0; i < cnt; ++i) 
		{
			for (int j = 0; j < 123; ++j)
				al[j] = 0;
			t_len = strlen(texts[i]);
			if (check(texts[i],t_len) == 1) 
			{
				flag = 1;
				break;
			}
		}

		if (flag) 
		{
			for (int i = 0; i < cnt; ++i) 
			{
				for (int j = 0; texts[i][j]; j++) 
					printf("%c", al[texts[i][j]]);
				printf("\n");
			}
		}
		else
			printf("No solution.\n");
		if (case_) 
			printf("\n");
	}
	return 0;
}