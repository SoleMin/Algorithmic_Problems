#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

void input();
int bfs();

int ban[10000];
int n;
string begin_status, end_status;

int main() {
	int T;
	cin >> T;
	cin.get();
	cin.get();
	while (T-- != 0) {
		input();
		cin.get();
		cout << bfs() << '\n';
		for (int i = 0; i < 10000; i++)
			ban[i] = 0;
	}
}

void input() {
	string s;
	getline(cin, s);
	s.erase(remove(s.begin(), s.end(), ' '), s.end());
	begin_status = s;
	getline(cin, s); 
	s.erase(remove(s.begin(), s.end(), ' '), s.end());
	end_status = s;
	cin >> n;
	cin.get();
	for (int i = 0; i < n; i++) {
		getline(cin, s);
		s.erase(remove(s.begin(), s.end(), ' '), s.end());
		ban[stoi(s)] = 1;
		//cout << stoi(s) << endl;
	}
	//cout << begin_status << ' ' << end_status << endl;
}

int bfs() {
	queue<pair<string, int>> queue;
	queue.push(make_pair(begin_status, 0));
	ban[stoi(begin_status)] = 1;
	while (!queue.empty()) {
		string cur = queue.front().first;
		int count = queue.front().second;
		for (int i = 0; i < 4; i++) {
			string next = cur;
			int wheel = cur[i] - '0';
			wheel = wheel ? wheel - 1 : 9;
			next[i] = wheel + '0';
			if (!ban[stoi(next)]) {
				if (stoi(next) == stoi(end_status))
					return count + 1;
				ban[stoi(next)] = 1;
				queue.push({ next, count + 1 });
			}
			wheel = (wheel + 2) % 10;
			next[i] = wheel + '0';
			if (!ban[stoi(next)]) {
				if (stoi(next) == stoi(end_status))
					return count + 1;
				ban[stoi(next)] = 1;
				queue.push({ next, count + 1 });
			}
		}
		queue.pop();
	}
	return -1;
}