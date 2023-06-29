#include <iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>
#define MAX 1000
using namespace std;

int G[MAX][MAX], d[MAX];
vector <int> W, S;	// weight, smart
int n = 1;

int dp(int i) {
	int& ans = d[i];
	if (ans > 0)
		return ans;
	ans = 1;
	for (int j = 0; j < n; j++) {
		if (G[j][i] && dp(j) + 1 > ans)
			ans = dp(j) + 1;
	}
	return ans;
}

void print(int i) {
	cout << i + 1 << endl;
	for (int j = 0; j < n; j++)
		if (G[j][i] && d[i] == d[j] + 1) {
			print(j);
			break;
		}
	return;
}

int main() {
	int w, s;
	while (cin >> w >> s) {
		W.push_back(w);
		S.push_back(s);
		n++;
	}
	n--;

	memset(G, 0, sizeof(G));
	memset(d, 0, sizeof(d));
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			if (W[i] > W[j] && S[i] < S[j]) G[i][j] = 1;

	for (int i = 0; i < n; i++) dp(i);

	int idx = 0, Max = d[0];
	for (int i = 0; i < n; i++) {
		if (d[i] > d[idx]) {
			idx = i;
			Max = d[i];
		}
	}
	cout << Max << endl;

	print(idx);
	return 0;
}