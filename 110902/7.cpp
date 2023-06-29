#include <iostream>
#include <cstring>
#include <queue>
using namespace std;

static int t, n, cnt, num, startnum, endnum, bannum, ban[10001];
int button[8] = { 1000, -1000, 100, -100, 10, -10, 1, -1 };

void input() {
	for (int i = 0; i < 4; i++) {
		if (i > 0)
			startnum *= 10;
		cin >> num;
		startnum += num;
	}
		
	for (int i = 0; i < 4; i++) {
		if (i > 0)
			endnum *= 10;
		cin >> num;
		endnum += num;
	}
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		bannum = 0;
		for (int j = 0; j < 4; j++) {
			if (j > 0)
				bannum *= 10;
			cin >> num;
			bannum += num;
		}
		ban[bannum] = -1;
	}
}

int bfs() {
	if (startnum == endnum)
		return 0;
	if (ban[endnum] == -1)
		return -1;
	queue<int> q;
	queue<int> qindex;
	q.push(startnum);
	qindex.push(1);
	while (!q.empty()) {
		int p = q.front();
		q.pop();
		int indexp = qindex.front();
		qindex.pop();
		for (int i = 0; i < 8; i++) {
			int np = p;
			if (i == 0 || i == 1) {
				int z = np + button[i];
				if (z >= 10000)
					np -= 9000;
				else if (z < 0)
					np += 9000;
				else
					np += button[i];
			}
			if (i == 2 || i == 3) {
				int z = np % 1000 + button[i];
				if (z >= 1000)
					np -= 900;
				else if (z < 0)
					np += 900;
				else
					np += button[i];
			}
			if (i == 4 || i == 5) {
				int z = np % 100 + button[i];
				if (z >= 100)
					np -= 90;
				else if (z < 0)
					np += 90;
				else
					np += button[i];
			}
			if (i == 6 || i == 7) {
				int z = np % 10 + button[i];
				if (z >= 10)
					np -= 9;
				else if (z < 0)
					np += 9;
				else
					np += button[i];
			}
			int idx = ban[np];
			if (idx != 0)
				continue;
			if (np == endnum)
				return indexp;
			idx = ban[np] = indexp + 1;
			q.push(np);
			qindex.push(idx);
		}
	}
	return -1;
}

int main() {
	cin >> t;
	while (t--) {
		startnum = 0;
		endnum = 0;
		memset(ban, 0, sizeof ban);
		input();
		ban[startnum] = 1;
		cout << bfs();
		cout << endl;
	}
}