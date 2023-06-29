#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <stdbool.h>

#define N 1000

typedef struct {
	int index;
	int weight;
	int iq;
} elephant;

elephant arr[N];
int dp[N];
int parent[N];
int n = 0;
bool flag = false;

int compare(const void* a, const void* b) {
	elephant x = (*(elephant*)a);
	elephant y = (*(elephant*)b);
	if (x.iq == y.iq)
		return -1 * x.index + y.index;
  return y.iq - x.iq;
}

void path_finder(int i) {
	if (i == -1)
		return;
	path_finder(parent[i]);
	printf("%d\n", arr[i].index);
}

void lis(void) {
	int idx;
  int *best, i, j, max = INT_MIN;
  best = malloc (sizeof(int) * n);
  for (int i = 0; i < n; i++) {
    best[i] = 1;
    parent[i] = -1;
  }
  for (int i = 1; i < n; i++)
    for (int j = 0; j < i; j++)
      if (arr[i].weight > arr[j].weight && best[i] < best[j] + 1 ) {
				if (arr[i].iq == arr[j].iq) {
					best[i] = best[j] + 1;
					//printf("i: %d, j: %d, arr[i]: %d, arr[j]: %d\n", i, j, arr[i].index, arr[j].index);
					flag = true;
				}
				else {
		    	best[i] = best[j] + 1;
        	parent[i] = j;
				}
				if (max == best[i]) {
					if (arr[i].iq == arr[j].iq)
						continue;
					if (arr[i].index < arr[idx].index) {
						max = best[i];
						idx = i;
						parent[i] = j;
					}
				}
			  if (max < best[i]) {
					idx = i;
				  max = best[i];
				}
		  }
	//for (int i = 0; i < n; i++)
		//printf("weight: %d, iq: %d, index: %d, best: %d\n", arr[i].weight, arr[i].iq, arr[i].index, best[i]);
	if (flag)
  	printf("%d\n", max - 1);
	else
		printf("%d\n", max);
	//printf("idx: %d, index: %d\n", idx, arr[idx].index);
  path_finder(idx);
  free(best);
}

int main(void) {
	while (scanf("%d %d", &arr[n].weight, &arr[n].iq) != EOF) {
		arr[n].index = n + 1;
		n = n + 1;
	}
	qsort(arr, n, sizeof(elephant), compare);
	//for (int i = 0; i < n; i++)
		//printf("weight: %d, iq: %d, index: %d\n", arr[i].weight, arr[i].iq, arr[i].index);
  lis();
	//for (int i = 0; i < n; i++)
		//printf("weight: %d, iq: %d, index: %d\n", arr[i].weight, arr[i].iq, arr[i].index);
}