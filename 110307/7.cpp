#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <map>
#include <queue>

using namespace std;

map<string, bool> d;
map<string, string> p;
map<string, vector<string>> g;

void bfs(string s);
bool count(string s1, string s2);

int main() {
	string s;
	vector<string> key;
	
	while(getline(cin, s)) {
		if(s.empty()) break;
		key.push_back(s);
	}
	
	for(auto i: key) {
		vector<string> value;
		for(auto j: key) {
			if(i == j) continue;
			if(count(i, j)) value.push_back(j);
		}
		
		sort(value.begin(), value.end());
		value.erase(unique(value.begin(), value.end()), value.end());
		
		g.insert({i, value});
	}
	
	while(true) {
		getline(cin, s);
		if(s.empty()) break;
		
		vector<string> out;
		string temp;
		
		for(char i: s) {
			if(i == ' ') {
				out.push_back(temp);
				temp = "";
			} else temp += i;
		}
		out.push_back(temp);
		
		bfs(out[0]);
		
		vector<string> result;
		result.push_back(out[1]);
		while(true) {
			if(p[result.back()].empty()) break;
			result.push_back(p[result.back()]);
		}
		reverse(result.begin(), result.end());
		
		if (result.size() == 1) cout << "No solution." << endl;
		else for (auto i: result) cout << i << endl;
		cout << endl;
		
		d.clear();
		p.clear();
	}
	return 0;
}

void bfs(string s) {
	queue<string> q;
	
	for(auto i: g) {
		d.insert({i.first, true});
		p.insert({i.first, ""});
	}
	
	d[s] = 0;
	
	q.push(s);
	while(!q.empty()) {
		string h = q.front();
		q.pop();
		
		for(int i = 0; i < g[h].size(); ++i) {
			string t = g[h][i];
			if(d[t]) {
				d[t] = false;
				p[t] = h;
				q.push(t);
			}
		}
	}
}

bool count(string s1, string s2) {
	int cnt = 0;
	if (s1.length() != s2.length()) return false;
	else for(int i = 0; i < s1.length(); ++i) if(s1[i] != s2[i]) cnt++;
	return cnt == 1;
}