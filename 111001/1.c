#include <stdio.h>
#include <math.h>
#define MAX_N 100

static int n, check[MAX_N];
static double dot[MAX_N][2], minval[MAX_N], result;

void input(void);
double dist(int a, int b);
void solve(void);
void main(void) {
	int i, t;
	
	scanf("%d", &t);
	for(i = 0; i < t; i++) {
		input();
		
		solve();
		
		if(i > 0)
			printf("\n");
		printf("%0.2lf\n", result);
	}
}

void input(void) {
	int i;
	
	scanf("%d", &n);
	for(i = 0; i < n; i++) {
		scanf("%lf %lf", &dot[i][0], &dot[i][1]);
		//printf("%lf %lf\n", dot[i][0], dot[i][1]);
	}
}

double dist(int a, int b) {
	return sqrt(pow(dot[a][0] - dot[b][0], 2.0) +
							pow(dot[a][1] - dot[b][1], 2.0));
}

void solve(void) {
	int i, j, a;
	double min;
	int near = 0;
	result = 0;
	for(i = 0; i < n; i++) {
		check[i] = 0;
	}
	check[0] = 1;
	for(i = 1; i < n; i++) {
		minval[i] = dist(0, i);
	}
	for(i = 0; i < n - 1; i++) {
		// 프림 알고리즘 구현
		min = 0x7FFFFFFF;
		for(j = 1; j < n; j++) {
			if(0 <= minval[j] && minval[j] < min) {
				min = minval[j];
				near = j;
			}
		}
		result += min;
		//printf("%lf\n", min);
		minval[near] = -1;
		for(j = 1; j < n; j++) {
			if(dist(j, near) < minval[j]) {
				minval[j] = dist(j, near);
			}
		}
	}
}