#include <stdio.h>
#include <math.h>
#include <float.h>

#define MAXN 100 //점은 최대 100개

static int n, check[MAXN];
//n: 점들의 갯수
//
static double dot[MAXN][2], minval[MAXN], result;
//dot: 0에는 x좌표가, 1에는 y좌표가 들어가 있다.
//
//result: 최소비용신장트리의 모든 가중치를 더한 값

void input(void) {
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%lf %lf", &dot[i][0], &dot[i][1]);
}

double dist(int a, int b) {
	return sqrt(pow(dot[a][0] - dot[b][0], 2) + pow(dot[a][1] - dot[b][1], 2));
}

void solve(void) {
  int vnear;
	result = 0;
	for (int i = 0; i < n; i++)
		check[i] = 0;
	check[0] = 1; //일단 0번 노드를 넣는다.
	for (int i = 1; i < n; i++)
		minval[i] = dist(0, i); //각 노드를 0번 노드와의 거리로 초기화 시킴
	for (int i = 0; i < n - 1; i++) {
    double min = DBL_MAX;
    for (int j = 1; j < n; j++)
      if (minval[j] < min && !check[j]) {
        min = minval[j];
        vnear = j;
      }
    result += minval[vnear];
    check[vnear] = 1;
    for (int j = 1; j < n; j++)
      if (dist(vnear, j) < minval[j]) {
        minval[j] = dist(vnear, j);
      }
	}
}

int main(void) {
	int t;
	scanf("%d", &t);
	for (int i = 0; i < t; i++) {
		input();
		solve();
		if (i > 0)
			printf("\n");
		printf("%0.2lf\n", result);
	}
}