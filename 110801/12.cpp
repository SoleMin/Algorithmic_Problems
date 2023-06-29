#include <iostream>
#include <algorithm>
#include <vector>
#include <list>
#include <stack>
#include <map>

using namespace std;

int n, k, cnt = 0;
vector<pair<int, int>> bishops;

bool cross(int level) {
    for (int i = 0; i < level; ++i) {
        if (abs(bishops[i].first - bishops[level].first) == abs(bishops[i].second - bishops[level].second))
            return false;
    }
    return true;
}

void backtracking(int level, int x, int y) {
    if (level == k) cnt++;
    else {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!i && !j) {
                    i = y;
                    j = x;
                }
                bishops[level] = {i, j};
                if (cross(level)) backtracking(level + 1, j, i);
            }
        }
    }
}

int main() {
    while (true) {
        cin >> n >> k;
        if (!n && !k) break;
        for (int i = 0; i < k; ++i) bishops.emplace_back(NULL, NULL);
        backtracking(0, 0, 0);
        cout << cnt << endl;
        cnt = 0;
        bishops.clear();
    }
    return 0;
}
