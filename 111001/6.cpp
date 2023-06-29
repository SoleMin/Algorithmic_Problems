#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <cstdio>

using namespace std;
int p[10001];
double d[101][2];

struct edge {
	int u, v;
	double w;
	bool operator < (const edge &p) {
		return w < p.w;
	}
};
vector<edge> e;

int fset(int f) {
	if (p[f] == f)
		return f;
	return fset(p[f]);
}

void mset(int m) {
	for (int i = 0; i < m; i++)
		p[i] = i;
}

double krus(int k) {
	int u, v;
	double sum = 0;
	sort(e.begin(), e.end());
	mset(k);
	for (int i = 0; i < e.size(); i++) {
		u = fset(e[i].u);
		v = fset(e[i].v);
		if (u != v) {
			p[u] = v;
			sum += e[i].w;
		}
	}
	return sum;
}

int main() {
	int t, f;
	cin >> t;
	while (t--) {
		e.clear();
		cin >> f;
		for (int i = 0; i < f; i++)
			cin >> d[i][0] >> d[i][1];
		for (int i = 0; i < f; i++)
			for (int j = i + 1; j < f; j++) {
				edge ed;
				ed.u = i;
				ed.v = j;
				ed.w = sqrt(pow(d[i][0] - d[j][0], 2) + pow(d[i][1] - d[j][1], 2));
				e.push_back(ed);
			}
		printf("%.2lf\n", krus(f));
		cout << endl;
	}
	return 0;
}