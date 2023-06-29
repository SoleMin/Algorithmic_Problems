#define MAX 4000
#define DEFAULT 2147483647
#define erdos_name "Erdos, P."
#include <stdio.h>
#include <string.h>

typedef struct node {
	char name[100];
	int num;
}node;

node data[MAX];

int map[MAX][MAX];

int main()
{
	int scenario;
	int paper,pname;
	scanf("%d", &scenario);
	for(int sc=1;sc<=scenario;sc++)
	{
		int sum = 1;
		int i,j,k;
		char str[100000];
		
		scanf("%d %d\n", &paper, &pname);
		strcpy(data[0].name, erdos_name);
		data[0].num = 0;
		for (int a=1;a<MAX;a++)
			data[a].num = DEFAULT;
		
		for (int a=0;a<MAX;a++)
			for(int b=0;b<MAX;b++)
				map[a][b] = 0;
		
		for(i=0;i<paper;i++)
		{
			gets(str);
			char name[1000];
			int flag[MAX] = {0,};
			int x = 0;
			int len = strlen(str);
			
			
			for(j=0;j<len;j++)
			{
				if(x !=0 || str[j] != ' ')
					name[x++] = str[j];
				if((str[j] == ',' && str[j-1] == '.' && j>1) || str[j] == ':')
				{
					x--;
					name[x] = '\0';
					int exist = 0;
					for(k=0;k<sum;k++)
						if(!strcmp(name,data[k].name))
						{
							exist= 1;
							x = k;
							break;
						}
					if(!exist)
					{
						strcpy(data[sum].name, name);
						x=sum;
						sum++;
					}
					flag[x] = 1;
					x = 0;
					if(str[j] == ':')
						break;
				}
			}
			for(j=0;j<sum;j++)
				if (flag[j])
					for (k=0;k<sum;k++)
						if(flag[k] && k!=j)
							map[j][k] = 1;
		}
		for(i=0;i<sum;i++)
			for(j=0;j<sum;j++)
				if(data[j].num == i)
				{
					for(k=0;k<sum;k++)
						if(map[j][k])
						{
							if(data[k].num > i + 1)
								data[k].num = i+1;
						}
				}
		printf("Scenario %d\n", sc);
		for(i=0;i<pname;i++)
		{
			gets(str);
			for(j=0;j<sum;j++)
				if(!strcmp(str, data[j].name))
					break;
			printf("%s ",str);
			if(data[j].num == DEFAULT)
					printf("infinity\n");
			else
				printf("%d\n", data[j].num);
		}
	}
	return 0;
}
