//힌트 활용
#include <stdio.h>
#include <math.h>
#define MAXN 100
#define MAXINT 100
#define MAXDEGREE 100
#define TRUE 1;
#define FALSE 0;

static int n, check[MAXN];
static double dot[MAXN][2], minval[MAXN], result;

typedef struct
{
	int v;
	int weight;
} edge;

typedef struct
{
	edge edges[MAXN+1][MAXDEGREE];
	int degree[MAXN+1];
	int nvertices;
	int nedges;
} graph;

void input(void)
{
	int i;
	
	scanf("%d", &n);			//점 갯수
	for(i=0;i<n;i++)			//각 점 위치
	{
		scanf("%lf %lf", &dot[i][0], &dot[i][1]);
	}
}

double dist(int a, int b)
{
	return sqrt(pow(dot[a][0]-dot[b][0], 2)+pow(dot[a][1]-dot[b][1], 2));
}

void solve(void);

void main(void)
{
	int i, t;
	
	scanf("%d", &t);
	for(i=0;i<t;i++)
	{
		input();
		
		solve();
		
		if(i>0)
		{
			printf("\n");
		}
		printf("%0.2lf\n", result);
	}
}

void solve(void)
{
	int i, j, a;
	
	result=0;		//결과=0
	for(i=0;i<n;i++)
	{
		check[i]=0;				//모든 값을 탐색이 안된 값으로 설정
	}
	
	check[0]=1;				//원점은 탐색했다고 설정
	
	for(i=1;i<n;i++)
	{
		minval[i]=dist(0,i);		//모든 거리 값을 원점으로부터의 거리로 설정
	}
	
	for(i=0;i<n-1;i++)
	{
		//프림 구현
		a=-1;				//임의의 위치
		for(j=0;j<n;j++)
		{
			if(check[j])			//현재 위치를 이미 탐색했다면 연산을 넘김
			{
				continue;
			}
			
			if(a==-1||minval[a]>minval[j])		//초기 위치거나, 현재 위치의 거리값이 탐색하고자 하는 곳보다 값이 크면
			{
				a=j;		//현재 위치 이동
			}
		}
		result+=minval[a];		//결과에 최종적인 위치의 값을 더해줌
		check[a]=1;		//현재 위치의 값은 1로 바꿔줌
			
		for(j=0;j<n;j++)
		{
			if(check[j])			//이미 탐색한 곳이라면 연산을 넘김
			{
				continue;
			}
			if(minval[j]>dist(a,j))		//탐색하고자 하는 위치와 현재 위치 사이의 값이 탐색위치 값보다 작다면
			{
				minval[j]=dist(a,j);		//해당 값으로 초기화해줌
			}
		}
	}
}

/*프림 알고리즘
=>핵심 : 가장 무게가 적은 간선 순으로 트리에 버텍스를 추가하는 방식
1. 간선의 정렬이 필요
2. 간선 무게순으로 트리에 버텍스 추가
3. 트리 완성 후 오일러 사이클 성립에 대한 추가 탐색 필요
*/