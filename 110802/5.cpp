#include <iostream>
#include <vector>
using namespace std;

int moved[4][2] = {
    { -1, 0 },
    { 0, 1 },
    { 1, 0 },
    { 0, -1 }
};

int solved;
int mTop;
int moveStack[51];
char moveChar[4] = { 'U', 'R', 'D', 'L' };
int maxDepth;
vector<vector<int>> v(4, vector<int>(4, 0));

int cost();
void solve();
void back(int a, int nowX, int nowY);

int main(void)
{
    // ios_base::sync_with_stdio(false);
    // cin.tie(nullptr);

    int testCase = 0;
    cin >> testCase;

    while (testCase--) {
        solved = 0;
        mTop = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cin >> v[i][j];
            }
        }

        solve();

        if (solved) {
            for (int i = 0; i < mTop; i++)
                cout << moveChar[moveStack[i]];
            cout << "\n";
        } else {
            cout << "This puzzle is not solvable.\n";
        }
    }
}

// Get heuristic
int cost(void)
{
    int i, j;
    int m1, m2;

    // Floor
    m1 = 0;
    for (i = 0; i < 4; i++) {
        for (j = 0; j < 4; j++) {
            if (v[i][j] != 0)
                m1 += abs(i - ((v[i][j] - 1) / 4));
        }
    }

    // Same Floor, Row
    m2 = 0;
    for (i = 0; i < 4; i++) {
        for (j = 0; j < 4; j++) {
            if (v[i][j] != 0)
                m2 += abs(j - ((v[i][j] - 1) % 4));
        }
    }

    return m1 + m2;
}

void solve(void)
{
    int i, j, k, l, value, x, y;
    value = 0;
    for (i = 0; i < 4; i++) {
        for (j = 0; j < 4; j++) {
            if (v[i][j] == 0) {
                value += i;
                x = i;
                y = j;
            }
            for (k = i; k < 4; k++) {
                if (k == i)
                    l = j + 1;
                else
                    l = 0;
                for (; l < 4; l++) {
                    if (v[k][l] != 0 && v[i][j] > v[k][l])
                        value++;
                }
            }
        }
    }

    if (value % 2 == 0)
        return;

    for (maxDepth = cost(); !solved && maxDepth <= 50; maxDepth += 2)
        back(0, x, y);
}

void back(int a, int nowX, int nowY)
{
    int i, c;
    int nextX, nextY;

    c = cost();
    if (c == 0) {
        solved = 1;
        return;
    }
    if (a + c > maxDepth)
        return;

    for (i = 0; i < 4; i++) {
        if (mTop > 0 && (moveStack[mTop - 1] + 2) % 4 == i)
            continue;

        // 중략 시작

        nextX = nowX + moved[i][0];
        nextY = nowY + moved[i][1];

        if (nextX < 0 || nextY < 0)
            continue;

        if (nextX >= 4 || nextY >= 4)
            continue;

        v[nowX][nowY] = v[nextX][nextY];
        v[nextX][nextY] = 0;

        // 중략 끝

        moveStack[mTop++] = i;
        back(a + 1, nextX, nextY);
        if (solved)
            return;
        mTop--;

        // 중략 시작

        v[nextX][nextY] = v[nowX][nowY];
        v[nowX][nowY] = 0;

        // 중략 끝
    }
}