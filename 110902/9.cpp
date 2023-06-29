#include <iostream>
#include <vector>
#include <list>
#include <stack>
#include <queue>
#include <algorithm>
#include <array>
#include <string>
#include <map>

using namespace std;

int bfs(array<int, 4> start,
        array<int, 4> end,
        map<array<int, 4>, list<array<int, 4>>> g,
        vector<array<int, 4>> block
) {
    map<array<int, 4>, bool> visited;
    map<array<int, 4>, int> level;
    queue<array<int, 4>> que;
    list<int> list;

    que.push(start);
    visited[start] = true;
    for (auto i: block) visited[i] = true;
    level[start] = 0;
    int cnt = 0;

    while (!que.empty() && cnt != g.size() - block.size()) {
        array<int, 4> curr = que.front();
        que.pop();

        for (auto &i: g[curr]) {
            if (!visited[i]) {
                if (i == end) return level[curr] + 1;
                level[i] = level[curr] + 1;
                que.push(i);
                visited[i] = true;
                cnt++;
            }
        }
    }
    return -1;
}

array<int, 4> split(const string &s) {
    array<int, 4> temp{};
    int n = 0;
    for (char i: s) if (i != ' ') temp[n++] = i - '0';
    return temp;
}

list<array<int, 4>> node(array<int, 4> arr) {
    list<array<int, 4>> result;
    for (int i = 0; i < 4; ++i) {
        array<int, 4> left = arr;
        array<int, 4> right = arr;
        left[i]--;
        right[i]++;
        if (left[i] == -1) left[i] = 9;
        if (right[i] == 10) right[i] = 0;
        result.push_back(left);
        result.push_back(right);
    }
    return result;
}

int main() {
    int t;
    string s;
    map<array<int, 4>, list<array<int, 4>>> graph;
    for (int i = 0; i < 10; ++i) {
        for (int j = 0; j < 10; ++j) {
            for (int k = 0; k < 10; ++k) {
                for (int l = 0; l < 10; ++l) {
                    array<int, 4> key = {i, j, k, l};
                    list<array<int, 4>> value = node(key);
                    graph.insert({key, value});
                }
            }
        }
    }

    cin >> t;
    getline(cin, s);
    cin.ignore();
    while (t--) {

        int a, b, c, d;
        cin >> a >> b >> c >> d;
        array<int, 4> start = {a, b, c, d};
        cin >> a >> b >> c >> d;
        array<int, 4> end = {a, b, c, d};

        vector<array<int, 4>> wheels;
        int n;
        cin >> n;

        for (int i = 0; i < n; ++i) {
            cin >> a >> b >> c >> d;
            wheels.push_back({a, b, c, d});
        }

        cout << bfs(start, end, graph, wheels) << endl;

        getline(cin, s);
        cin.ignore();
    }

    return 0;
}
