#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

const double INF = 1987654321;

int n;
vector<pair<double, double>> vertex;
double dist[101];
bool inTree[101];

double getDist(int a, int b) {
	double x = abs(vertex[a].first - vertex[b].first);
	double y = abs(vertex[a].second - vertex[b].second);
	return sqrt(x * x + y * y);
}

void solve() {
	for(int i = 0; i < 101; i++) {
		dist[i] = INF;
		inTree[i] = false;
	}
	dist[0] = 0;
	
	int cur = 0;
	while(!inTree[cur]) {
		inTree[cur] = true;
		for(int i = 0; i < n; i++) {
			if(inTree[i]) continue;
			double weight = getDist(cur, i);
			if(dist[i] > weight) {
				dist[i] = weight;
			}
		}
		
		cur = 0;
		double minWei = INF;
		for(int i = 1; i < n; i++) {
			if(!inTree[i] && minWei > dist[i]) {
				minWei = dist[i];
				cur = i;
			}
		}
	}
	double ret = 0;
	for(int i = 0; i < n; i++) {
		ret += dist[i];
	}
	cout << ret << "\n\n";
}

int main() {
	int t; cin >> t;
	double a, b;
	cout << fixed;
	cout.precision(2);
	
	while(t--) {
		vertex.clear();
		
		cin >> n;
		for(int i = 0; i < n; i++) {
			cin >> a >> b;
			vertex.push_back({a, b});
		}
		solve();
	}
	
	
	return 0;
}