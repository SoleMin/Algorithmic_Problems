#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <ctype.h>
#include <map>
struct my
{
	char name[20];
	char time[500][20];
	char type[500][20];
	int dist[500];
	int fee;
	int count;
};

void swap(struct my* a, struct my* b)
{
	struct my temp;
	temp = *a;
	*a = *b;
	*b = temp;
}

void sort(struct my* list, int n)
{
	int i, j, min;
	min = 0;
	for (i = 0; i < n; i++)
	{
		min = i;
		for (j = i + 1; j < n; j++)
			if (strcmp(list[min].name, list[j].name) > 0)
				min = j;
		swap(&list[i], &list[min]);
	}
}

void quickSort(struct my* nodes, int low, int high)
{
	int pivot, i, j, temp;
	if (low < high)
	{
		pivot = low;
		i = low;
		j = high;
		while (i < j)
		{
			while (strcmp(nodes[i].name, nodes[pivot].name) >= 0 && i <= high)
			{
				i++;
			}
			while (strcmp(nodes[i].name, nodes[pivot].name) < 0 && j >= low)
			{
				j--;
			}
			if (i < j)
			{
				swap(&nodes[i], &nodes[j]);
			}
		}
		if (j >= 0)
			swap(&nodes[j], &nodes[pivot]);
		quickSort(nodes, low, j - 1);
		quickSort(nodes, j + 1, high);
	}
}

int find(struct my list[500], const char* name)
{
	int i;
	for (i = 0; i < 500; i++)
		if (strcmp(list[i].name, name) == 0)
			return i;
	return -1;
}

void calFee(struct my* list, int* fee, int n)
{
	int i, j, k, close;

	for (i = 0; i < n; i++)
	{
		for (j = 0; strcmp(list[i].type[j], "enter") != 0 && j < list[i].count; j++); // enter 찾기
		for (k = 0; (strcmp(list[i].type[k], "exit") != 0 || strcmp(list[i].time[j], list[i].time[k]) > 0) && k < list[i].count; k++);
		while (j != list[i].count && k != list[i].count) {
			if (k == list[i].count) continue;

			close = k;
			for (k = 0; k < list[i].count; k++)
			{
				if (strcmp(list[i].type[k], "exit") == 0 && strcmp(list[i].time[close], list[i].time[k]) > 0 && strcmp(list[i].time[j], list[i].time[k]) < 0)
					close = k;
			}
			list[i].fee += fee[atoi(&list[i].time[j][6])] * abs(list[i].dist[j] - list[i].dist[close]) + 100;
			list[i].type[j][0] = '\0';
			list[i].type[close][0] = '\0';
			for (j = 0; strcmp(list[i].type[j], "enter") != 0 && j < list[i].count; j++); // enter 찾기
			for (k = 0; (strcmp(list[i].type[k], "exit") != 0 || strcmp(list[i].time[j], list[i].time[k]) > 0) && k < list[i].count; k++);
		}
	}
}

int main()
{
	int T, t, i, j, k, w, stdfee, cnt, h, timesection;
	char input[50], temname[50], temtime[20], temtype[20], tmp[20], tmp2[20];
	struct my* list;
	int fee[24], temdist;

	scanf("%d", &T);
	for (t = 0; t < T; t++)
	{
		list = new struct my[500];
		j = 0, h = 0;
		for (i = 0; i < 500; i++) {
			list[i].fee = 0;
			list[i].count = 0;
		}


		for (i = 0; i < 24; i++)
			scanf("%d", &fee[i]);
		fgets(tmp, 50, stdin);
		while (fgets(input, 50, stdin))
		{
			if (input[0] == '\n')
				break;
			input[strlen(input) - 1] = '\0';
			sscanf(input, "%s %s %s %d", temname, temtime, temtype, &temdist);

			if ((h = find(list, (const char*)temname)) < 0 ) {
				sscanf(input, "%s %s %s %d", list[j].name, list[j].time[list[j].count], list[j].type[list[j].count], &list[j].dist[list[j].count]);
				list[j].count++;
				j++;
			}
			else {
				sscanf(input, "%*s %s %s %d", list[h].time[list[h].count], list[h].type[list[h].count], &list[h].dist[list[h].count]);
				list[h].count++;
			}
		}

		calFee(list, fee, j);

		for (i = 0; i < j; i++)
			if (list[i].fee > 0)
				list[i].fee += 200;

		sort(list, j);

		for (i = 0; i < j; i++)
			if (list[i].fee > 0)
				printf("%s $%.2f\n", list[i].name, ((double)list[i].fee) / 100);
		printf("\n");

	}
}