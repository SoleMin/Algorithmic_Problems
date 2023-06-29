#include <iostream>
#include <stdio.h>
#include <queue>
#include <vector>
#include <cmath>

#define MAXN 101
int n;
bool intree[MAXN];
double dot[MAXN][2], minval[MAXN][MAXN], result;

using namespace std;

void input();
double dist(int, int);
void solve();

int main() {
	int T;
	cin >> T;
	while (T-- != 0) {
		input();
		solve();
		printf("%0.2lf\n\n", result);
	}
	return 0;
}

void input() {
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> dot[i][0] >> dot[i][1];
}

double dist(int a, int b) {
	return sqrt(pow(dot[a][0] - dot[b][0], 2) + pow(dot[a][1] - dot[b][1], 2));
}

void solve() {
	vector<int> tree;
	result = 0;
	for (int i = 1; i <= n; i++)
		intree[i] = false;
	intree[1] = true;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++)
			minval[i][j] = dist(i, j);
	}
	int v = 1;
	tree.push_back(v);
	for (int count = 1; count < n; count++) { // 횟수?
		double min_edge = 99999;
		int next_node = 0;
		for (int i = 0; i < (int) tree.size(); i++) {
			int cur = tree[i];
			for (int next = 1; next <= n; next++) {
				if (!intree[next] && min_edge > minval[cur][next]) {
					min_edge = minval[cur][next];
					next_node = next;
				}
			}
		}
		result += min_edge;
		intree[next_node] = true;
		tree.push_back(next_node);
	}
}