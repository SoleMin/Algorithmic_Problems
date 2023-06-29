#include <iostream>
#include <string>
#include <queue>
#include <map>
#include <cstring>

using namespace std;

const int INF = 1987654321;

int n;
bool visited[100][25][25];
vector<pair<int, int>> edge[100][100];
string src, dst;
map<string, int> cityNum;
int ret;

void solve() {
	// cityNum, blood, stime, dtime?
	queue<pair<pair<int, int>, pair<int, int>>> q;
	q.push({{cityNum[src], 0}, {0, 0}});
	visited[cityNum[src]][0][0] = true;
	
	while(!q.empty()) {
		pair<pair<int, int>, pair<int, int>> cur = q.front();
		q.pop();
		
		int curNum = cur.first.first;
		int blood = cur.first.second;
		int srcTime = cur.second.first;
		int dstTime = cur.second.second;
		
		if(curNum == cityNum[dst]) {
			ret = min(ret, blood);
			continue;
		}
		
		// adjacency matrix
		for(int i = 0; i < 100; i++) {
			//pair<int, int> curE = edge[curNum][i];
			vector<pair<int, int>> v2v = edge[curNum][i];
			
			if(v2v.size() == 0) continue;				// 두 정점 사이에 간선이 없다면
			for(int j = 0; j < v2v.size(); j++) {
				pair<int, int> curE = v2v[j];
				
				int start = curE.first, hlong = curE.second, end = (curE.first + curE.second) % 24;
				
				if(6 < start && start < 18) continue;		// 출발 시간이 부적절
				if(6 < (start + hlong) % 24 && (start + hlong) % 24 < 18) continue;	// 도착 시간 부적절
				if(visited[i][start][hlong]) continue;
				
				if(curNum != cityNum[src]) {
					if((dstTime <= start && 17 < dstTime && 17 < start) || (dstTime <= start && dstTime < 7 && start < 7) || (17 < dstTime && start < 7)) {
						q.push({{i, blood}, {start, end}});
					}
					else {
						q.push({{i, blood + 1}, {start, end}});
					}
				}
				else {
					q.push({{i, blood}, {start, end}});
				}
				
				visited[i][start][hlong] = true;
				// q.push({{i, blood}, {curE.first, curE.first + curE.second}});
			}
		}
	}
}

int main() {
	int t; cin >> t;
	
	string v1, v2;
	int stime, ttime;
	int idx = 0;
	for(int tc = 1; tc <= t; tc++) {
		ret = INF;
		cityNum.clear();
		memset(visited, 0, sizeof(visited));
		for(int i = 0; i < 100; i++)
			for(int j = 0; j < 100; j++)
				edge[i][j].clear();
		
		cin >> n;
		for(int i = 0; i < n; i++) {
			cin >> v1 >> v2 >> stime >> ttime;
			stime %= 24;
			if(ttime > 12) continue;					// 12시간 이내로 여행
			
			if(cityNum.find(v1) == cityNum.end()) 
				cityNum[v1] = idx++;
			if(cityNum.find(v2) == cityNum.end()) 
				cityNum[v2] = idx++;
			
			edge[cityNum[v1]][cityNum[v2]].push_back({stime, ttime});
		}
		cin >> src >> dst;
		
		solve();
		
		cout << "Test Case " << tc << ".\n";
		if(ret == INF)
			cout << "There is no route Vladimir can take.\n";
		else
			cout << "Vladimir needs " << ret << " litre(s) of blood.\n";
	}
	
	
	
	return 0;
}