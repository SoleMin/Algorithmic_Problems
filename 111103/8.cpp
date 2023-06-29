#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

#define NUM 1000

typedef struct Elephant{
	int weight;
	int iq;
	int idx;
};

int compare(const void *a, const void *b)
{
	if(((Elephant *)a)->iq < ((Elephant *)b)->iq)
		return 1;
	if(((Elephant *)a)->iq > ((Elephant *)b)->iq)
		return -1;
	else {
		if(((Elephant *)a)->weight > ((Elephant*)b)->weight)
			return 1;
		if(((Elephant *)a)->weight < ((Elephant*)b)->weight)
			return -1;
		return 0;
	}
}

void print(int num);

int lis[NUM];
int back[NUM];
int numElements;
Elephant e[NUM+1];

int main()
{
	int max = -1;
	int idx = 0;

	while(scanf("%d %d", &e[numElements].weight, &e[numElements].iq) == 2)
	{
		e[numElements].idx = numElements + 1;
		numElements++;
	}
	qsort(e, numElements, sizeof(Elephant), compare);
 
	for(int i = 0; i < numElements; i++)
	{
		lis[i] = 1; back[i] = -1;
		for(int j = 0; j <= i-1; j++)
		{
			if((e[j].iq != e[i].iq) && (e[j].weight < e[i].weight) && (lis[j] + 1 > lis[i]))
			{
				lis[i] = lis[j] + 1;
				back[i] = j;
			}
		}
	}
	for(int i = 0; i < numElements; i++)
	{
		if(max < lis[i])
		{
			max = lis[i];
			idx = i;
		}
	}
	printf("%d\n",max);
	print(idx);
	return 0;
}

void print(int num)
{
	if(back[num] != -1)
	{
		print(back[num]);
		printf("%d\n",e[num].idx);
	}
	else
		printf("%d\n",e[num].idx);
}