#include <algorithm>
#include <iostream>
#include <sstream>
using namespace std;
#define Inf 9999999

int F_pos[101];
int Dis[501][501];

void initialize(int N)
{
    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= N; ++j)
            Dis[i][j] = Inf;
        Dis[i][i] = 0;
    }
}

void floyd(int N)
{
    for (int k = 1; k <= N; ++k)
        for (int i = 1; i <= N; ++i)
            for (int j = 1; j <= N; ++j)
                if (Dis[i][k] + Dis[k][j] < Dis[i][j])
                    Dis[i][j] = Dis[i][k] + Dis[k][j];
}

int main(void)
{
    int testCase, numFs, numIs;
    cin >> testCase;

    while (testCase--) {
        cin >> numFs >> numIs;
        for (int i = 0; i < numFs; ++i)
            cin >> F_pos[i];

        initialize(numIs);

        string str;
        getline(cin, str);
        while (getline(cin, str) && !str.empty()) {
            stringstream ss(str);
            int x, y, L;
            ss >> x >> y >> L;
            Dis[x][y] = L;
            Dis[y][x] = L;
        }

        floyd(numIs);

        int sL[501];
        int maxSL = 0;

        for (int i = 1; i <= numIs; ++i) {
            sL[i] = Inf;
            for (int j = 0; j < numFs; ++j)
                sL[i] = min(sL[i], Dis[i][F_pos[j]]);
            maxSL = max(maxSL, sL[i]);
        }

        int ans = 1;
        for (int i = 1; i <= numIs; ++i) {
            int nL = 0;
            for (int j = 1; j <= numIs; j++) {
                int tmp = min(Dis[i][j], sL[j]);
                nL = max(nL, tmp);
            }
            if (nL < maxSL) {
                maxSL = nL;
                ans = i;
            }
        }
        cout << ans << "\n";
        if (testCase)
            cout << endl;
    }
}