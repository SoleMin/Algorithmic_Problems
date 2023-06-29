#include <stdio.h>
#include <math.h>
#define MAXN 100
static int n, check[MAXN];
static double dot[MAXN][2], minval[MAXN], result, g[MAXN][MAXN];

void input(void) {
	int i, j;
	scanf("%d", &n);
	for (i = 0; i < n; i++) { // 점들 입력받기
		scanf("%lf %lf", &dot[i][0], &dot[i][1]);
	}
}

double dist(int a, int b) { // 두 점 사이의 거리 = 가중치
	return sqrt(pow(dot[a][0] - dot[b][0], 2) + pow(dot[a][1] - dot[b][1], 2));
}

int main() {
	int i, t;
	scanf("%d", &t);
	for (i = 0; i < t; i++)
{
	input();
	solve();
		
	if (i > 0)
		printf("\n");
	
	printf("%0.2lf\n", result);
	}
	return 0;
}

void solve(void) {
	int i, j, a;
	double min;
	result = 0;
	for (i = 0; i < n; i++) {
		check[i] = 0; // check는 방문 확인 함수
	}
	check[0] = 1;
	for (i = 1; i < n; i++) {
		minval[i] = dist(0, i); // minval은 가중치 배열
	}
	
	for (i = 0; i < n - 1; i++) {
		min = 100000;
		for(j = 0; j < n; j++){
			if(minval[j] < min && check[j] == 0){
				min = minval[j];
				a = j;
			}
		}
		check[a] = 1;
		result += min;
		
		for(j = 0; j < n; j++){
			if(check[j] == 0 && minval[j] > dist(a, j)){
				minval[j] = dist(a, j);
			}
		}
		
	}
}
