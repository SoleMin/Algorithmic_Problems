#include <iostream>
#include <vector>
using namespace std;

int n, k;
long long result;
int cnt;
vector<vector<int>> v;

bool promising(int x, int y)
{
    int d[4][2] = {
        { 1, 1 },
        { 1, -1 },
        { -1, 1 },
        { -1, -1 }
    };
    int dx = x, dy = y;
    for (int i = 0; i < 4; i++) {
        dx = x, dy = y;
        while (true) {
            dx += d[i][0];
            dy += d[i][1];
            if (dx < 0 || dy < 0)
                break;
            if (dx >= n || dy >= n)
                break;

            if (v[dy][dx]) {
                return false;
            }
        }
    }

    return true;
}

void backTracking(int x, int y)
{
    // cout << x << " " << y << " " << n << " " << k << " " << endl;

    for (int i = y; i < n; i++) {
        for (int j = x; j < n; j++) {
            v[i][j] = 1;

            if (promising(j, i)) {
                cnt++;
                if (cnt == k)
                    result++;
                else {
                    if (j + 1 == n) {
                        backTracking(0, i + 1);
                    } else {
                        backTracking(j + 1, i); // x , y j == x, i == y
                    }
                }
                // cout << cnt << "\n";
                cnt--;
            }
            v[i][j] = 0;
        }
        x = 0;
    }
}

int main(void)
{
    while (cin >> n >> k) {
        if (n == 0 && k == 0)
            break;
        v.clear();
        for (int i = 0; i < n; i++) {
            vector<int> tmp;
            for (int j = 0; j < n; j++) {
                tmp.push_back(0);
            }
            v.push_back(tmp);
        }
        result = 0;
        cnt = 0;

        // backTracking
        backTracking(0, 0);
        cout << result << "\n";
    }
}