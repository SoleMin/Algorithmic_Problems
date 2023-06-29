#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <string.h>
using namespace std;
 
vector<int> vc[10000];
int visit[10000]={0,};
int check[10000] ={0, };
static int num2=1;
int number;

int dfs(int v, int tf){
		visit[v] = ++number;
		int ret = visit[v];
		int child = 0; 
		for (int i = 0; i < vc[v].size(); i++){
			int next = vc[v][i];
			if (visit[next]){
				ret = min(ret, visit[next]);
				continue;
			}
			child++;
			int prev = dfs(next, 0);
			if (tf == 0 && prev >= visit[v])
				check[v] = 1;
			ret = min(ret, prev);
		}
    if (tf == 1 && child>1)
        check[v] = 1;
 
    return ret;
}
int main()
{
	int num;
	int num1;
	int i,j,k;
	//int vc[100][100];
	char name[1000][31];
	char way[1000][31];
	char way1[1000][31];
	int u,v;
	//int number = 1;
	while(scanf("%d\n",&num) == 1){
		/*for(i=0;i<num;i++){
			check[i] = 0;
		}*/
		
		if(num == 0)
			break;
		for(i = 0;i<num;i++){
			scanf("%s",name[i]);
		}
		scanf("%d\n", &num1);
		for(i = 0;i<num1;i++){
			scanf("%s %s", way[i],way1[i]);
		}
	/*	for(i=0;i<num;i++){
			for(j=0;j<num;j++){
				vc[i][j] = 0;
			}
		}
		for(i=0;i<num;i++){
			for(j=0;j<num1;j++){
				if(strcmp(name[i],way[j])==0){
					for(k=0;k<num;k++){
						if(strcmp(name[k],way1[j])==0){
							vc[i][k] = 1;
							vc[k][i] = 1;
							
						}
					}
				}
				if(strcmp(name[i],way1[j])==0){
					for(k=0;k<num;k++){
						if(strcmp(name[k],way[j])==0){
							vc[k][i] = 1;
							vc[i][k] = 1;
						
						}
					}
				}
			}
		}*/
		for(i=0;i<=num1;i++){
			for(j=0;j<=num;j++){
				if(strcmp(way[i],name[j])==0){
					u = j+1;
				}
				if(strcmp(way1[i],name[j])==0){
					v = j+1;
				}
			}
			vc[u].push_back(v);
			vc[v].push_back(u);
			//printf("%d :  %d <-> %d\n",i, u,v);
		}
		for (i = 1; i <= num; i++)
			if (visit[i]==0)
				dfs(i, 1);
		int cnt = 0;
		for (i = 1; i <= num; i++)
			if (check[i] == 1)
				cnt++;
 		char result[100][30];
		int C = 0;
		printf("City map #%d: %d camera(s) found\n", num2,cnt);
		for (i = 0; i <= num; i++)
			if (check[i]==1){
					//printf("%s\n", name[i-1]);
					strcpy(result[C],name[i-1]);
					C++;
				}
		char temp1[30];
		for(i=0;i<C;i++){
			for(j=0;j<C;j++){	
				if(strcmp(result[i],result[j])<0){
					strcpy(temp1,result[i]);
					strcpy(result[i],result[j]);
					strcpy(result[j],temp1);
				}
			}
		}
		for(i=0;i<C;i++){
			printf("%s\n", result[i]);
		}
		printf("\n");
		num2++;
		C=0;
		memset(check,0,sizeof(check));
		memset(visit,0,sizeof(visit));
		for(i=0;i<num;i++){
			for(j=0;j<num;j++){
				name[i][j] = '\0';
			}
		}
		for(i=0;i<num1;i++){
			for(j=0;j<num1;j++){
				way[i][j] = '\0';
				way1[i][j] = '\0';
			}
		}
		number = 0;
		for(i=0;i<10002;i++){
			vc[i].clear();
		}
	}
}

