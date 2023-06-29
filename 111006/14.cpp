#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

int discovered[101];
bool isCut[101];
int num;

int dfs(int start, bool isRoot, vector<vector<int>>& graph)
{
    discovered[start] = ++num;
    int ret = discovered[start];

    int child = 0;

    for (int i = 0; i < graph[start].size(); i++) {
        int next = graph[start][i];

        if (discovered[next]) {
            ret = min(ret, discovered[next]);
            continue;
        }

        child++;
        int prev = dfs(next, false, graph);

        if (!isRoot && prev >= discovered[start])
            isCut[start] = true;

        ret = min(ret, prev);
    }

    if (isRoot)
        isCut[start] = (child >= 2);

    return ret;
}
int main(void)
{
    int tCase = 1;
    int v;
    while (cin >> v) {
        if (v == 0)
            break;
        num = 0;

        for (int i = 0; i < 101; i++) {
            discovered[i] = 0;
        }
        for (int i = 0; i < 101; i++) {
            isCut[i] = false;
        }

        unordered_map<string, int> table;
        vector<vector<int>> graph(v);
        vector<string> stringToInt;
        for (int i = 0; i < v; i++) {
            string s;
            cin >> s;
            table.insert(make_pair(s, i));
            stringToInt.push_back(s);
        }

        int e;
        cin >> e;
        for (int i = 0; i < e; i++) {
            string s1, s2;
            cin >> s1 >> s2;

            graph[table[s1]].push_back(table[s2]);
            graph[table[s2]].push_back(table[s1]);
        }

        // for (auto& i : graph) {
        //     for (auto& j : i) {
        //         cout << j << " ";
        //     }
        //     cout << "\n";
        // }
        // cout << "\n";

        for (int i = 0; i < v; i++) {
            if (!discovered[i])
                dfs(i, true, graph);
        }

        vector<int> result;
        int cnt = 0;
        for (int i = 0; i < v; i++) {
            if (isCut[i]) {
                cnt++;
                result.push_back(i);
            }
        }

        cout << "City map #" << tCase++ << ": " << cnt << " camera(s) found\n";
        vector<string> result2;
        for (int i = 0; i < result.size(); i++) {
            result2.push_back(stringToInt[result[i]]);
        }
        sort(result2.begin(), result2.end());
        for (int i = 0; i < result2.size(); i++) {
            cout << result2[i] << "\n";
        }
        cout << "\n";
    }
}