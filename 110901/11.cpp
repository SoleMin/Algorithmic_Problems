#include <iostream>
#include <vector>
#include <list>
#include <stack>
#include <queue>
#include <algorithm>
#include <array>

using namespace std;

bool dfs(vector<vector<int>> g) {
    vector<int> color(g.size(), 0);
    vector<bool> visited(g.size(), false);
    stack<int> stk;

    stk.push(0);
    color[0] = 1;

    while (!stk.empty()) {
        int curr = stk.top();
        stk.pop();

        visited[curr] = true;

        for (int i = 0; i < g[curr].size(); ++i) {
            int next = g[curr][i];
            
            if (!visited[next]) {
                visited[next] = true;

                if (color[curr] == 1) color[next] = 2;
                else color[next] = 1;

                stk.push(curr);
                stk.push(next);

                break;
            } else {
                if (color[curr] == color[next]) return false;
            }
        }
    }
    return true;
}

int main() {
    int n, l;
    while (true) {
        cin >> n;
        if (n == 0) break;
        cin >> l;
        vector<vector<int>> graph(n);
        for (int i = 0; i < l; ++i) {
            int a, b;
            cin >> a >> b;
            graph[a].push_back(b);
            graph[b].push_back(a);
        }

        for (auto &i: graph) {
            for (int j = 0; j < i.size(); ++j) {
                sort(i.begin(), i.end());
            }
        }

        if (dfs(graph)) cout << "BICOLORABLE.";
        else cout << "NOT BICOLORABLE.";
        cout << endl;
    }


    return 0;
}
