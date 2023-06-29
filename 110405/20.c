#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int t;
	int s;
	int index;
} job;

int compare(const void* a, const void* b) {
	job* j = (job*)a;
	job* i = (job*)b;
	double j_value = (double)j->s / (double)j->t;
	double i_value = (double)i->s / (double)i->t;
	if (j_value == i_value)
		return j->index - i->index; //더블의 차이라 문제 생길 수 있다.
	if (j_value > i_value)
		return -1;
	return 1;
}

int main() {
	int test_case;
	scanf("%d", &test_case);
	while (test_case--) {
		int n;
		scanf("%d", &n);
		job* jobs = malloc(sizeof(job) * n);
		for (int i = 0; i < n; i++) {
			scanf("%d %d", &jobs[i].t, &jobs[i].s);
			jobs[i].index = i + 1;
		}
		qsort(jobs, n, sizeof(job), compare);
		for (int i = 0; i < n; i++)
			printf("%d ", jobs[i].index);
		printf("\n\n");
		free(jobs);
	}
}
