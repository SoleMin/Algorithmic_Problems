#include <iostream>
#include <map>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct node {
	string from;
	int time;
	int blood;
};

struct inform {
	string to;
	int from_time;
	int to_time;
};

void input();
bool compare(inform, inform);
void print();
int bfs();

int n;
string departure, destination;
map<string, vector<inform>> schedule;
map<string, int> visited;

int main() {
	int T;
	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		cin >> n;
		input();
		//print();
		cout << "Test Case " << tc << ".\n";
		int res = bfs();
		if (res != 1000)
			cout << "Vladimir needs " << res << " litre(s) of blood.\n";
		else
			cout << "There is no route Vladimir can take.\n";
		schedule.erase(schedule.begin(), schedule.end());
		visited.erase(visited.begin(), visited.end());
	}

	return 0;
}

void input() {
	for (int i = 0; i < n; i++) {
		vector<inform> v;
		string from, to;
		int from_time, to_time;
		cin >> from >> to >> from_time >> to_time;
		schedule.insert({ from, v });
		to_time = (from_time + to_time) % 24;
		to_time = !to_time ? 24 : to_time;
		from_time = from_time >= 18 ? from_time - 6 : from_time + 18;
		to_time = to_time >= 18 ? to_time - 6 : to_time + 18;
		if (12 <= from_time && from_time <= 24 && 12 <= to_time && to_time <= 24 && from_time < to_time) {
			//cout << from << ' ' << to << ' ' << from_time << ' ' << to_time << endl;
			schedule[from].push_back({ to, from_time, to_time });
			visited.insert({ to, 0 });
			visited[to]++;
		}
	}
	for (auto iter = schedule.begin(); iter != schedule.end(); iter++)
		sort(iter->second.begin(), iter->second.end(), compare);
	cin >> departure >> destination;
}

bool compare(inform a, inform b) {
	if (a.to_time == b.to_time) {
		if (a.from_time == b.from_time)
			return a.to < b.to;
		else
			return a.from_time < b.from_time;
	}
	else
		return a.to_time < b.to_time;
}

/*
* 입력 테스트
*/
void print() {
	for (auto iter = schedule.begin(); iter != schedule.end(); iter++)
		for (int i = 0; i < iter->second.size(); i++)
			cout << iter->first << ' ' << iter->second[i].to << ' ' << iter->second[i].from_time << ' ' << iter->second[i].to_time << '\n';
}

int bfs() {
	int res = 1000;
	queue<node> queue;
	queue.push({ departure, 6, 0 });
	while (!queue.empty()) {
		string from = queue.front().from;
		for (int i = 0; i < schedule[from].size(); i++) {
			int time = queue.front().time;
			int blood = queue.front().blood;
			string to = schedule[from][i].to;
			int from_time = schedule[from][i].from_time;
			int to_time = schedule[from][i].to_time;
			if (time > from_time)
				blood++;
			time = from_time;
			if (visited[to]) {
				if (to == destination)
					res = blood < res ? blood : res;
				queue.push({ to, to_time, blood });
				visited[to] -= 1;
			}
		}
		queue.pop();
	}
	return res;
}