#include <cstdio>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <set>
#define MAX 10001
#define MAX_N 1000
using namespace std;

vector<vector<int>> vt;
map<string, int> place;
set<string> cam_place;
int visit[MAX_N];
int cam[MAX_N], camcnt, mapnum=0, num;
string place_name[MAX_N];


int dfs(int cur, bool flag) {
	int child = 0;
	visit[cur] = ++num;
	int ret = visit[cur];
	for (int i = 0; i < vt[cur].size(); i++) {
		int next = vt[cur][i];
		if (visit[next]) {
			ret = min(ret, visit[next]);
			continue;
		}
		child++;
		int prev = dfs(next, 0);
		if (!flag && prev >= visit[cur])
		{
			cam[cur] = true;
			cam_place.insert(place_name[cur]);
		}
		ret = min(ret, prev);
	}
	if (flag && child > 1)
	{
		cam[cur] = true;
		cam_place.insert(place_name[cur]);
	}
	return ret;
}
int main() {
	int N, R;

	while (scanf("%d", &N) == 1 && N != 0)
	{
		place.clear();
		cam_place.clear();
		for(int i=0;i<MAX_N;i++)
		{
			cam[i] = visit[i] = 0;
			place_name[i] = "";
		}
		camcnt = 0;
		num = 0;
		vt.resize(N + 1);
		for (int i = 0; i <= N; i++)
			vt[i].clear();
		if(mapnum)
			printf("\n");
		
		
		
		string name, name2;
		for (int i = 1; i <= N; i++)
		{
			cin >> name;
			place.insert(make_pair(name, i));
			place_name[i] = name;
		}
		scanf("%d", &R);

		for (int i = 0; i < R; i++)
		{
			cin >> name >> name2;
			vt[place[name]].push_back(place[name2]);
			vt[place[name2]].push_back(place[name]);
		}

		for (int i = 1; i <= N; i++)
			if (!visit[i])
				dfs(i, 1);
		for (int i = 1; i <= N; i++)
			if (cam[i])
				camcnt++;

		printf("City map #%d: %d camera(s) found\n", ++mapnum, camcnt);
		int count = 0;
		
		for (auto it = cam_place.begin(); it != cam_place.end(); ++it)
			cout << *it << endl;
	
		

	}
	return 0;
}