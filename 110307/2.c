#include <stdio.h>
#include <string.h>
#include <stdlib.h>
typedef struct
{
	char name [16];
	short doublets[500];
	int count;
	int mother;
}dic;
typedef struct
{
	short queue[500];
	int front, rear;
}QueueType;
void initQueue(QueueType *q)
{
	q->front = q->rear = 0;
}
int isEmpty(QueueType *q)
{
	return (q->front == q->rear)? 1: 0;
}
void enqueue(QueueType * q, int item)
{
	q->rear = (q->rear+1) % 500;
	q->queue[q->rear] = item;
}
int dequeue(QueueType * q)
{
	q->front = (q->front +1) % 500;
	return q->queue[q->front];
}

void init (dic * buf, char *name)
{
	sprintf(buf -> name, "%s", name);
	buf -> count = 0;
	for (int i = 0; i < 16; i++)
		buf -> doublets[i] = -1;
}
void connecting (dic * buf[], int count)
{
	int diff = 0;
	for (int i = 0; i < count; i++)
		for (int j = 0; j < count; j++, diff =0)
		{
			if (i == j)
				continue;
			if(strlen(buf[i]->name) == strlen(buf[j]->name))
				for (int k = 0; k < strlen(buf[i] -> name); k++)
					if (buf[i] -> name[k] != buf[j]->name[k] && ++diff != 1)
						break;
			if (diff == 1)
				buf[i] ->doublets[buf[i] -> count++] = j;
		}
}
int way (dic * buf[] , int start, int end, short search[], int words)
{
	int dq, find = -1, tmp;
	QueueType q;
	initQueue(&q);
	
	if ((start == -1 || end == -1) || start == end)
		return -1;
	enqueue(&q, start);
	while(!isEmpty(&q) && find == -1)
	{
		dq = dequeue(&q);
		for (int i = 0; i < buf[dq]->count; i++)
		{
			tmp = buf[dq] -> doublets[i];
			if (tmp == end)
			{
				find = 1;
				buf[tmp] -> mother = dq;
				break;
			}
			if (buf[tmp] -> mother == -1)
			{
				buf[tmp] -> mother = dq;
				enqueue(&q, tmp);
			}
		}
	}
	if (find == 1)
	{
		dq = 0;
		tmp = end;
		while (tmp != start)
		{
			search[dq++] = tmp;
			tmp = buf[tmp] -> mother;
		}
		search[dq++] = start;
	}
	else
		dq = -1;
	return dq;
}
int main (void)
{
	char buf[35];
	char *buf1 = NULL, *buf2 = NULL;
	int words = 0, ways = -1, startPoint = -1, endPoint = -1;
	short search[128];
	dic * dictionary[25143];
	
	while (1)
	{
		if (fgets(buf, 16, stdin)== NULL || strcmp(buf, "\n") == 0)
				break;
		buf [strlen(buf)-1] = '\0';
		dictionary[words] = malloc(sizeof(dic));
		init(dictionary[words++], buf);
	}
	connecting (dictionary, words);
	
	while (1)
	{
		startPoint = endPoint = -1;
		if (fgets (buf, 35, stdin) == NULL || strcmp (buf, "\n") == 0)
			break;
		buf[strlen(buf)-1] = '\0';
		buf1 = strtok(buf, " ");
		buf2 = strtok(NULL, " ");
		for (int i = 0; i < words; i++)
		{
			if (strcmp(buf1, dictionary[i] -> name) ==0)
				startPoint = i;
			if (strcmp(buf2, dictionary[i] -> name) == 0)
				endPoint = i;
			dictionary[i] -> mother = -1;
		}
		ways = way(dictionary, startPoint, endPoint, search, words);
		
		if (ways == -1)
		{
			printf("No solution.\n\n");
			continue;
		}
		for (int i = ways-1; i >= 0; i--)
			printf("%s\n", dictionary[search[i]] ->name);
		printf("\n");
	}
}