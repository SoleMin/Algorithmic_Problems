#include <iostream>
#include <map>
#include <queue>
#include <string>
#include <unordered_map>
#include <vector>
using namespace std;

vector<int> bfs(int start, int end, vector<vector<int>>& graph, vector<bool>& visit, map<string, int>& um)
{
    unordered_map<int, int> route;
    queue<pair<int, int>> q;
    q.push(make_pair(start, 1));
    int min = 0;

    while (!q.empty()) {
        int index = q.front().first;
        int floor = q.front().second;
        q.pop();
        visit[index] = true;

        if (index == end) {
            min = floor;
            break;
        }

        for (const auto& item : graph[index]) {
            if (!visit[item]) {
                q.push(make_pair(item, floor + 1));
                route.insert(make_pair(item, index));
            }
        }
    }

    vector<int> result;

    int path = end;
    for (int t = 0; t < min; t++) {
        result.push_back(path);
        path = route[path];
    }

    return result;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    map<string, int> um; // string -> index
    vector<string> s; // 인덱스 -> String

    string input;
    getline(cin, input);

    int index = 0;
    while (input != "") {
				if (!um.count(input)) {
        	um.insert(make_pair(input, index++));
        	s.push_back(input);
				}
        getline(cin, input);
    }

    vector<vector<int>> graph(um.size());

    for (const auto& item : s) {
        for (size_t i = 0; i < item.length(); i++) {
            string copied = item;
            for (char c = 'a'; c <= 'z'; c++) {
                // 더블릿 체크
                copied[i] = c;

                if (um.count(copied)) {
                    graph[um[item]].push_back(um[copied]);
                }
            }
        }
    }

    string start, end;
    bool isFirst = true;

    while (cin >> start >> end) {
        vector<int> result;
        vector<bool> visit(um.size(), false);
        vector<int> r;

        if (um.count(start) && um.count(end))
            r = bfs(um[start], um[end], graph, visit, um);

        if (!isFirst)
            cout << "\n";

        isFirst = false;

        if (r.empty()) {
            cout << "No solution.\n";
        } else {
            for (auto iter = r.rbegin(); iter != r.rend(); iter++)
                cout << s[*iter] << "\n";
        }
    }
}