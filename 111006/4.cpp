#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>
#include <map>

#define MAX_NUM 100
#define MAX_LEN 31
using namespace std;

map<string,int> trans;
int low[MAX_NUM], dfn[MAX_NUM], t;
vector<int> v[MAX_NUM], Ans;
char str[MAX_NUM][MAX_LEN];
bool used[MAX_NUM];

int compare(const void *a,const void *b);
void DFS(int v, int N);

int main(void) {
	int i, j;
	int a, b, c = 1;
	int n, m;
	char str1[MAX_LEN], str2[MAX_LEN];
	
	while(scanf("%d", &n) != EOF) {
		if(n == 0)
			break;
		
		memset(low, 0, sizeof(low));
		memset(dfn, 0, sizeof(dfn));
		memset(used, false, sizeof(used));
		
		t = 1;
		
		for(i = 0; i < n; i++) {
			scanf("%s", str[i]);
		}
		
		qsort(str, n, sizeof(char[MAX_LEN]), compare);
		
		for(i = 0; i < n; i++) {
			trans[str[i]] = i;
		}
		
		scanf("%d", &m);
		
		for(i = 0; i < m; i++) {
			scanf("%s %s", str1, str2);
			a = trans[str1];
			b = trans[str2];
			v[a].push_back(b);
			v[b].push_back(a);
		}
		
		for(i = 0; i < n; i++) {
			if(!used[i])
				DFS(-1, i);
		}
		
		sort(Ans.begin(), Ans.end());
		
		if(c > 0)
			printf("\n");
		printf("City map #%d: %d camera(s) found\n", c++, Ans.size());
		
		for(i = 0; i < Ans.size(); i++) {
			printf("%s\n", str[Ans[i]]);
		}
		
		for(i = 0; i < n; i++) {
			v[i].clear();
		}
		Ans.clear();
		trans.clear();
	}
	
	return 0;
}

int compare(const void *a,const void *b) {
	return strcmp((char *)a,(char *)b);
}

void DFS(int V, int N) {
	int next, ch = 0;
	int i;
	bool flag = false;
	low[N] = t;
	dfn[N] = t;
	used[N] = true;
	t++;
	
	for(i = 0; i < v[N].size(); i++) {
		next = v[N][i];
		if(dfn[next] == 0) {
			ch++;
			DFS(N, v[N][i]);
			if(low[N] > low[next])
				low[N] = low[next];
			if(low[next] >= dfn[N])
				flag = true;
		} else if(V != next) {
			if(dfn[next] < low[N])
				low[N] = dfn[next];
		}
	}
	if(flag && (ch > 1 || V != -1)) {
		Ans.push_back(N);
	}
	return;
}