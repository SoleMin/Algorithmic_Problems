#include <iostream>
#include <vector>
#include <list>
#include <stack>
#include <queue>
#include <algorithm>
#include <array>
#include <string>
#include <map>
#include <cmath>

using namespace std;

map<int, vector<int>> adj;
map<int, vector<double>> weight;

double bfs(map<int, pair<double, double>> node) {
    map<int, bool> visited;
    list<int> spanningTree;
    double result = 0;
    for (int i = 0; i < node.size(); ++i) visited[i] = false;
    spanningTree.push_back(0);
    visited[0] = true;

    while (spanningTree.size() < node.size()) {
        priority_queue<pair<double, int>, vector<pair<double, int>>, greater<>> pq;
        for (auto i: spanningTree) {
            for (int j = 0; j < weight[i].size(); ++j) {
                if (!visited[adj[i][j]]) pq.push({weight[i][j], adj[i][j]});
            }
        }
        result += pq.top().first;
        visited[pq.top().second] = true;
        spanningTree.push_back(pq.top().second);
    }
    return result;
}

int main() {
    cout << fixed;
    cout.precision(2);
    int t;
    string s;
    cin >> t;
    while (t--) {
        getline(cin, s);
        cin.ignore();
        vector<pair<double, double>> freckles;
        int n;
        cin >> n;
        while (n--) {
            double x, y;
            cin >> x >> y;
            freckles.emplace_back(x, y);
        }

        map<int, pair<double, double>> node;
        for (int i = 0; i < freckles.size(); ++i) node[i] = freckles[i];

        for (int i = 0; i < freckles.size(); ++i) {
            for (int j = 0; j < freckles.size(); ++j) {
                if (i == j) continue;
                adj[i].push_back(j);
                weight[i].push_back(
                        sqrt(pow(node[i].first - node[j].first, 2) + pow(node[i].second - node[j].second, 2))
                );
            }
        }

        cout << bfs(node) << endl << endl;
        adj.clear();
        weight.clear();
    }
    return 0;
}
