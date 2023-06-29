#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <queue>
using namespace std;

/*
탐색하여 더블릿인 경우에 간선 연결
adj 생성 후 BFS
100,000,000
*/

vector<string> dict;
map<string, bool> dup;
map<string, vector<string>> m;

bool isDoublets(string &s1, string &s2) {
	if(s1.length() != s2.length()) return false;
	int cnt = 0;
	for(int i = 0; i < s1.length(); i++) {
		if(s1[i] != s2[i]) cnt++;
	}
	if(cnt == 1) return true;
	return false;
}

void makeAdj() {
	for(int i = 0; i < dict.size(); i++) {
		for(int j = i + 1; j < dict.size(); j++) {
			string s1 = dict[i], s2 = dict[j];
			if(isDoublets(s1, s2)) {
				if(m.find(s1) == m.end()) {
					vector<string> v;
					v.push_back(s2);
					m[s1] = v;
				}
				else 
					m[s1].push_back(s2);
				
				if(m.find(s2) == m.end()) {
					vector<string> v;
					v.push_back(s1);
					m[s2] = v;
				}
				else
					m[s2].push_back(s1);
			}
		}	
	}
}

bool bfs(string &src, string &dst) {
	queue<pair<string, vector<string>>> q;
	q.push({src, vector<string>(1, src)});
	map<string, bool> visited;
	
	while(!q.empty()) {
		pair<string, vector<string>> cur = q.front();
		q.pop();
		// cout << cur.first << ' ';
		if(cur.first == dst) {
			for(int i = 0; i < cur.second.size(); i++) 
				cout << cur.second[i] << '\n';
			cout << '\n';
			return true;
		}
		
		for(int i = 0; i < m[cur.first].size(); i++) {
			if(visited.find(m[cur.first][i]) != visited.end()) continue;
			visited[m[cur.first][i]] = 1;
			cur.second.push_back(m[cur.first][i]);
			q.push({m[cur.first][i], cur.second});   
			cur.second.pop_back();
		}
	}
	return false;
}

int main() {
	string tmp;
	while(true) {
		getline(cin, tmp);
		if(tmp == "") break;
		if(dup.find(tmp) == dup.end()) {
			dict.push_back(tmp);
			dup[tmp] = 1;
		}
	}
	// for(int i = 0; i < dict.size(); i++)
	// 	cout << dict[i] << ' ';
	// cout << '\n';
	
	makeAdj();
	
	string tmp2;
	while(true) {
		cin >> tmp >> tmp2;
		if(cin.eof()) break;
		if(!bfs(tmp, tmp2))
			cout << "No solution.\n\n";
		// cout << tmp << ' ' << tmp2 << '\n';
	}
	
	
	
	// for(map<string, vector<string>>::iterator iter = m.begin(); iter != m.end(); iter++) {
	// 	cout << (*iter).first << ": ";
	// 	for(int i = 0; i < (*iter).second.size(); i++) {
	// 		cout << (*iter).second[i] << ' ';
	// 	}
	// 	cout << '\n';
	// }
	
	
	
	return 0;
}