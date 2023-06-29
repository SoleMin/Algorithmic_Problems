#include <iostream>
#include <cstring>
#include <sstream>
#include <algorithm>
using namespace std;
#define Inf 9

int N ,R ,camera=0;
char city[101][31];
char start[31] , finish[31];
int graph[101][101] , graph_2[101][101];
char Ans[101][31];
int answer[101];

void init()
{
	for(int a=0; a<N; a++)
		for(int b=0; b<N; b++){
			if(a==b) graph[a][b] = 0;
			else graph[a][b]=Inf;
		}
}
void init_2()
{
	for(int a=0; a<N; a++)
		for(int b=0; b<N; b++)
			graph_2[a][b] = graph[a][b];
}
void sort()
{
	for(int a=0; a<camera-1; a++)
	{	
		for(int b=a+1; b<camera; b++)
		{
			if(strcmp(Ans[a] , Ans[b]) > 0)
			{
				char swap[31];
				strcpy(swap , Ans[b]);
				strcpy(Ans[b] , Ans[a]);
				strcpy(Ans[a] , swap);
			}
		}
	}
}
bool input()
{
	scanf("%d" , &N);
	init();
	if(N==0) return false; //0입력이 들어올시 프로그램종료
	
	for(int a=0; a<N; a++) scanf("%s" , city[a]); //도시이름을 입력받음
	
	scanf("%d" , &R);
	for(int a=0; a<R; a++)
	{
		int first , second;
		scanf("%s %s" , start, finish);
		for(int b=0; b<N; b++)
		{
			if(strcmp(city[b] , start) == 0) first = b;
			if(strcmp(city[b] , finish) == 0) second = b;
		}
		graph[first][second] = 1;
		graph[second][first] = 1;
	}
	return true;
}

void solve()
{
	for(int T = 0; T<N; T++)
	{
		int count = 0;
		init_2();
		for (int k = 0; k < N; ++k)
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					if(T == k || T == i || T == j) continue;
					else if(i==j) continue;
					else if (graph_2[i][k] + graph_2[k][j] < graph_2[i][j])
						graph_2[i][j] = graph_2[i][k] + graph_2[k][j];
		for(int a=0; a<N; a++)
		{
			if(T==a) continue;
			if(count!=0) break;
			for(int b=0; b<N; b++)
			{
				if(T==b) continue;
				if(graph_2[a][b] == Inf) 
				{
					answer[camera] = T;
					strcpy(Ans[camera] , city[T]);
					camera++;
					count++;
					break;
				}
			}
		}
	}
}

int main()
{
	int numbering = 1;
	while(input())
	{
		solve();
		sort();
		
		printf("City map #%d: %d camera(s) found\n" , numbering++ , camera);
		for(int a=0; a<camera; a++) 
			printf("%s\n" , Ans[a]);
		
		camera = 0;	
		printf("\n");
	}
}
