#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct
{
	char name[100];
	int value;
}ErdosValue;
typedef struct
{
	char name[100];
	struct ListNode* next;
	struct ListNode* prev;
}ListNode;
typedef struct
{
	int number;
	ListNode * llink;
	ListNode * head;
}List;
typedef struct
{
	char name[100];
	List value;
}ErdosDic;

List input (List list, char* name)
{
	ListNode *node = (ListNode *)malloc(sizeof(ListNode));
	sprintf(node->name, name);
	node->next = NULL;
	node->prev = NULL;
	if (list.number == 0)
	{
		list.number++;
		list.llink = node;
		list.head = node;
	}
	else
	{
		node->next = list.llink;
		list.llink->prev = node;
		list.llink = node;
		list.number++;
	}
	return list;
}
char * delete_head(List * list)
{
	ListNode * tmp = list -> head;
	char *buf = (char*)malloc(sizeof(char)*100);
	if (list -> number == 0)
		return NULL;
	else
	{
		sprintf(buf, tmp->name);
		list->head = list->head->prev;
		free(tmp);
		list->number--;
		return buf;
	}
}

int main (void)
{
	int sc, p, n, odd = 0, k = 0, same = 0, ppN= 0, dicN = 0, ErN = -1, j, rank = 0, rankstack = 0, dicTmp = 0, dicX = 0;// odd 짝수판별 k = namebuf 작성할때 사용 ppN = 사람숫자 dicN 딕셔너리 사람숫자
	char buf[1024], nameBuf[64]; 
	ErdosDic dic[100];
	ErdosValue val[100];
	scanf("%d", &sc);
	for (int s = 1; s <= sc; s++)
	{
		for (int a = 0; a <dicN; a++)
		{
			sprintf(dic[a].name, "");
			sprintf(val[a].name, "");
			val[a].value = 0;
		}
		ErN = -1; dicN = 0;
		List coWritten = {0, NULL};
		scanf ("%d %d", &p, &n);
		fgets(buf, sizeof(buf), stdin);
		for (int i = 0; i < p; i++)
		{
			coWritten.number = 0;
			coWritten.llink = NULL;
			fgets(buf, sizeof(buf), stdin);
			for ( j = 0; j < strlen(buf); j++)
			{
				if (buf[j] == ',')
				{
					if (++odd % 2 == 0)
					{
						nameBuf[k] = '\0';
						coWritten = input(coWritten, nameBuf);
						odd = k = 0;
						j++, ppN++;
						continue;
					}
				}
				else if (buf[j] == ':')
				{
					nameBuf[k] = '\0';
					coWritten = input(coWritten, nameBuf);
					odd =  k = 0;
					ppN++;
					break;
				}
				nameBuf[k++] = buf[j];
			}
			
			for (ListNode * p = coWritten.llink; p != NULL; p = p->next)
			{
				for ( j = 0; j < ppN; j++)
					if(strcmp(dic[j].name , p->name) == 0)
					{
						same = 1; break;
					}
				if (same != 1)
				{
					List value = {0, NULL};
					strcpy(dic[dicN].name, p->name);
					if (strcmp (dic[dicN].name, "Erdos, P.") == 0)
						ErN = dicN;
					for (ListNode* k = coWritten.llink; k != NULL; k = k -> next)
					{
						if (strcmp(k->name, dic[dicN].name) != 0)
							value = input(value, k->name);
					}
					dic[dicN++].value = value;
					same = 0;
				}
				else
				{
					List value = dic[j].value;
					for (ListNode * k = coWritten.llink; k != NULL; k = k->next)
					{
						if (strcmp (k->name, dic[j].name) != 0)
							value = input(value, k->name);
					}
					dic[j].value = value;
					same = 0;
				}
			}
		}
		
		// 수 계산
		if ( ErN != -1)
		{
			dicTmp = 1;
			int arr1[64];
			for (ListNode *a = dic[ErN].value.llink; a != NULL; a = a->next)
				for (int b = 0; b < dicN; b++)
					if (strcmp(a -> name, dic[b].name) == 0)
					{
						arr1[rankstack++] = b;
						break;
					}
			rank = 0;
			coWritten.head = NULL;
			coWritten.llink = NULL;
			coWritten.number = 0;
			strcpy(val[0].name, dic[ErN].name);
			val[0].value = rank;
			same = 0;
			while (1)
			{
				if (coWritten.number == 0)
				{
					for (int a = 0; a < rankstack; a++)
						coWritten = input(coWritten, dic[arr1[a]].name);
					rank++;
					rankstack = 0;
				}
				if (coWritten.number == 0)
					break;
				sprintf(nameBuf, delete_head(&coWritten));
				for (int i = 0; i < dicTmp; i++)
					if (strcmp(val[i].name, nameBuf) == 0)
					{
						same = 1;
						break;
					}
				if (same == 1)
				{
					same = 0;
					continue;
				}
				sprintf(val[dicTmp].name, nameBuf);
				val[dicTmp].value = rank;
				for (int a = 0; a < dicN; a++)
					if (strcmp(nameBuf, dic[a].name) == 0)
					{
						dicX = a; break;
					}
				for (ListNode * a = dic[dicX].value.llink; a != NULL; a = a->next)
					for (int b = 0; b < dicN; b++)
						if (strcmp(a->name, dic[b].name) == 0)
						{
							arr1[rankstack++] = b;
							break;
						}
				dicTmp++;
			}
			same = 0;
		}
		printf("Scenario %d\n", s);
		for (int np= 0; np < n; np++)
		{
			fgets(nameBuf, sizeof(nameBuf), stdin);
			nameBuf[strlen(nameBuf) - 1] = '\0';
			if (ErN == -1)
			{
				printf("%s infinity\n", nameBuf);
				if (strcmp(nameBuf, "Erdos, P.") == 0)
					printf("%s 0", nameBuf);
				continue;
			}
			for (j = 0; j < dicTmp; j++)
				if (strcmp(nameBuf, val[j].name) == 0)
				{
					same = 1;
					break;
				}
			if (same == 1)
			{
				printf("%s %d\n", nameBuf, val[j].value);
				same = 0;
			}
			else
				printf("%s infinity\n", nameBuf);
		}
	}
}

