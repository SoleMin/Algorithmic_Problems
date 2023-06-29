#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int sum(int a)
{
    if (a + 1 >= 10) {
        return 0;
    }

    return (a + 1);
}

int sub(int a)
{
    if (a - 1 < 0) {
        return 9;
    }

    return (a - 1);
}

int mult(int a)
{
    int result = 1;

    for (int i = 0; i < a; i++) {
        result *= 10;
    }

    return result;
}

vector<int> graph(int n)
{
    vector<int> result;
    int num[4] = { 0 };

    num[0] = n % 10;
    num[1] = (n / 10) % 10;
    num[2] = (n / 100) % 10;
    num[3] = n / 1000;

    for (int i = 0; i < 4; i++) {
        int a = 0;
        for (int j = 0; j < 4; j++) {
            if (i == j) {
                a += sum(num[j]) * mult(j);
            } else
                a += num[j] * mult(j);
        }
        result.push_back(a);
        a = 0;
        for (int j = 0; j < 4; j++) {
            if (i == j) {
                a += sub(num[j]) * mult(j);
            } else
                a += num[j] * mult(j);
        }
        result.push_back(a);
    }

    return result;
}

int BFS(vector<int> visit, int start, int end)
{
    queue<pair<int, int>> q;
    int floor = -1;
    q.push(make_pair(start, 0));
    visit[start] = 1;

    while (!q.empty()) {
        int nowValue = q.front().first;
        int nowFloor = q.front().second;
        q.pop();

        if (nowValue == end) {
            floor = nowFloor;
            break;
        }
        vector<int> v = graph(nowValue);

        for (int i = 0; i < v.size(); i++) {
            int nextValue = v[i];
            if (visit[nextValue] == 0) {
                q.push(make_pair(nextValue, nowFloor + 1));
                visit[nextValue] = 1;
            }
        }
    }

    return floor;
}

int main(void)
{
    int testCase = 0;
    cin >> testCase;

    while (testCase--) {
        vector<int> visit(10000, 0);
        int start1, start2, start3, start4;
        int end1, end2, end3, end4;
        cin >> start1 >> start2 >> start3 >> start4;
        cin >> end1 >> end2 >> end3 >> end4;

        int startNum = 1000 * start1 + 100 * start2 + 10 * start3 + start4;
        int endNum = 1000 * end1 + 100 * end2 + 10 * end3 + end4;

        int n;
        cin >> n;
        for (int i = 0; i < n; i++) {
            int tmp1, tmp2, tmp3, tmp4;
            cin >> tmp1 >> tmp2 >> tmp3 >> tmp4;

            int tmp = 1000 * tmp1 + 100 * tmp2 + 10 * tmp3 + tmp4;
            visit[tmp] = 1;
        }

        // BFS
        int result = BFS(visit, startNum, endNum);

        cout << result << "\n";
    }

    // vector<int> r = graph(1000);
    // for (auto& i : r) {
    //     cout << i << " ";
    // }
}