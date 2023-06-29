#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <queue>
using namespace std;
/*
	짝수번째 cin에서 마지막 문제 제거, ':'이면 종료
	홀수번째 + 짝수번째로 이름 붙이기
	
	저자들 벡터에 저장 후, O(n^2)로 엣지 연결
	map<string, string>으로 연결.
	
	Erdos,P.부터 시작해서 BFS.
	방문 여부 확인은 어떻게?
	-> map<string, bool>로 확인?
*/
int p, n;
map<string, vector<string>> adj;
map<string, bool> visited;
vector<string> writerSave;

int bfs(string target) {
	visited.clear();
	
	queue<pair<string, int>> q;
	q.push({"Erdos,P.", 0});
	visited["Erdos,P."] = true;
	
	while(!q.empty()) {
		pair<string, int> here = q.front();
		q.pop();
		
		if(here.first == target) 
			return here.second;	
		
		vector<string> nextList = adj[here.first];
		for(int i = 0; i < nextList.size(); i++) {
			if(visited.find(nextList[i]) != visited.end()) continue;
			
			visited[nextList[i]] = true;
			q.push({nextList[i], here.second + 1});
		}
	}
	return -1;
}

int main() {
	int t; cin >> t;
	int scenario = 1;
	while(t--) {
		adj.clear();
		
		cin >> p >> n;
		for(int i = 0; i < p; i++) {
			string name1, name2; 
			writerSave.clear();
			while(true) {
				cin >> name1 >> name2;
				string fullName = name1 + name2.substr(0, name2.length() - 1);
				writerSave.push_back(fullName);
				
				if(name2[name2.length() - 1] == ':') {
					getline(cin, name2);	// 버퍼에 남은 나머지 입력 날리기
					break;
				}
			}
			for(int j = 0; j < writerSave.size(); j++) {
				if(adj.find(writerSave[j]) == adj.end())
					adj[writerSave[j]] = writerSave;
				else {
					for(int k = 0; k < writerSave.size(); k++) {
						if(j == k) continue;
						adj[writerSave[j]].push_back(writerSave[k]);
					}
				}
			}
		}
		cout << "Scenario " << scenario++ << '\n';
		for(int i = 0; i < n; i++) {
			string name1, name2;
			cin >> name1 >> name2;
			
			int erdosNum = bfs(name1 + name2);
			if(erdosNum == -1) 
				cout << name1 << ' ' << name2 << " infinity\n";
			else
				cout << name1 << ' ' << name2 << ' ' << erdosNum << '\n';
		}
	}
	
	return 0;
}