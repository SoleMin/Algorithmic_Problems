#include <iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>
char city[101][30];
#define MAX_N 10000
using namespace std;
int n, m, disc[MAX_N + 1], cut[MAX_N + 1], ans, d, a, b;
vector<vector<int>> vt;
int dfs(int here, bool r) {
	disc[here] = ++d;
	int ret = disc[here];
	int child = 0;
	for (int there : vt[here]) {
		if (!disc[there]) {
			child++;
			int df = dfs(there, 0);
			if (!r&&df >= disc[here]) 
				cut[here] = true;
			ret = min(ret, df);
		}
		else
			ret = min(ret, disc[there]);
	}
	if (r&&child > 1) 
		cut[here] = true;
	return ret;
}
int main() {
	char input[100];
	int road;
	int i, j, k, t;
	char start[40], end[40];
	vector <string> tmp;
	t = 0;
	while(scanf("%d", &n) == 1){
		if(n == 0) break;
		k = n;
		i = 0;
		t++;
		tmp.clear();
		vt.clear();
		vt.resize(n);
		memset(cut, 0, sizeof(cut));
		memset(disc, 0, sizeof(disc));
		while(k--){
			scanf("%s", city[i]);
			i++;
		}
		scanf("%d", &road);
		while(road--){
			scanf("%s %s", start, end);
			for(i = 0; i < n; i++){
				if(strcmp(start, city[i]) == 0) break;
			}
			for(j = 0; j < n; j++){
				if(strcmp(end, city[j]) == 0) break;
			}
			vt[i].push_back(j);
			vt[j].push_back(i);
		}
		for(i = 0; i < n; i++){
			if(!disc[i])
				dfs(i, 1);
		}
		ans = 0;
		for (i = 0; i < n; i++)
			if (cut[i])
				ans++;
		printf("City map #%d: %d camera(s) found\n", t, ans);
		k = 0;
		for (i = 0; i < n; i++)
			if (cut[i]){
				tmp.push_back(city[i]);
				k++;
			}
		sort(tmp.begin(), tmp.end());
		for(i = 0; i < k; i++){
			printf("%s\n", tmp[i].c_str());
		}
		printf("\n");
	}
}
