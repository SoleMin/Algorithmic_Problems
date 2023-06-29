#include <stdio.h>
#include <string.h>

int next[1000001]={'\0'};
int search[1000001]={'\0'};
int where=0 , count = 0;

void compute_Next(char P[])
{
	int j=0;
	for(int i=1; i<strlen(P); i++)
	{
		while(j>0 && P[j]!=P[i])
		{
			j = next[j-1];
		}
		if(P[j] == P[i])
		{
			next[i]=++j;
		}
	}
}

void KMP(char T[] , char P[])
{
	int j=0;
	int n = strlen(T);
	for(int i=0; i<n; i++) //Time Error부분
	{
		while(j>0 && T[i]!=P[j])
		{
			j = next[j-1];
		}
		if(T[i]==P[j])
		{
			if(j==strlen(P)-1)
			{
				search[where++] = i-strlen(P)+2;
				j=next[j];
			}
			else
			{
				j++;
			}
		}
	}
}

int main()
{
	char T[1000001]={'\0'} ,  P[1000001]={'\0'};
	gets(T);
	gets(P);
	if(strlen(T) < strlen(P)) return 0;
	compute_Next(P);
	KMP(T,P);
	
	printf("%d\n" , where);
	for(int a=0; a<where; a++)
	{
		printf("%d "  , search[a]);
	}
}
