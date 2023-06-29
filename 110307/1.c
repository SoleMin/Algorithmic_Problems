#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define INIT (trie *)malloc(sizeof(trie))

typedef struct node
{
	struct node *next[27];
}trie;

void setNull(trie *t)
{
	int i;

	for(i = 0; i < 27; i++)
	{
		t->next[i] = NULL;
	}
}

void addWords(trie *t,char words[])
{
	trie *p;
	char ch;

	ch = words[0];
	if(ch=='\0')
		ch = '{';
	if(t->next[ch-'a']==NULL)
	{
		p = INIT;
		setNull(p);
		t->next[ch-'a'] = p;
		if(ch!='{')
			addWords (t->next[ch-'a'],&words[1]);
	}
	else
	{
		if(ch!='{')
			addWords(t->next[ch-'a'],&words[1]);
	}
}

void inputDic(trie *t)
{
	char tmp[20];

	while(gets(tmp)!=NULL&&strlen(tmp)!=0)
	{
		addWords(t,tmp);
	}
}

char st[20], ed[20];

typedef struct Node
{
	char str[20];
}type;

type que[10001];
int f, r;
int prev[10001];

int findWords(trie *t,char words[])
{
	if(words[0]=='\0')
	{
		return t->next['{'-'a']!=NULL;
	}
	else
	{
		if(t->next[words[0]-'a']==NULL)
			return 0;
		else
			return findWords(t->next[words[0]-'a'],&words[1]);
	}
}

void solve(trie *t)
{
	type p;
	trie *q;
	int i;
	char ch, tt, tmp[20];
	int out[300], cnt;

	if(!findWords(t,st)||!findWords(t,ed)||strlen(st)!=strlen(ed))
	{
		puts("No solution.");
		return ;
	}
	if(strcmp(st,ed)==0)
	{
		while(1)
		puts(st);
		return ;
	}
	strcpy(p.str,st);
	q = INIT;
	setNull(q);
	addWords(q,st);
	que[0] = p;
	prev[0] = -1;
	f = -1;r = 0;
	while(f!=r)
	{
		++f;
		p = que[f];
		strcpy(tmp,p.str);
		for(ch = 'a'; ch <= 'z'; ch++)
		{
			for(i = 0; tmp[i]; i++)
			{
				tt = tmp[i];
				tmp[i] = ch;
				if(findWords(t,tmp)&&!findWords(q,tmp))
				{
					addWords(q,tmp);
					++r;
					strcpy(que[r].str,tmp);
					prev[r] = f;
					if(strcmp(tmp,ed)==0)
					{
						cnt = 0;
						i = r;
						while(i!=-1)
						{
							out[cnt++] = i;
							i = prev[i];
						}
						for(i = cnt-1; i >= 0; i--)
						{
							puts(que[out[i]].str);
						}
						return ;
					}
				}
				tmp[i] = tt;
			}
		}
	}
	puts("No solution.");
}

int main()
{
	trie *t;

	t = INIT;
	setNull(t);
	inputDic(t);
	while(scanf("%s%s",st,ed)==2)
	{
		solve(t);
		putchar('\n');
	}
	return 0;
}