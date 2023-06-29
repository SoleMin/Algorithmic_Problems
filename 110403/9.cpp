#include <algorithm>
#include <deque>
#include <iostream>
#include <vector>
using namespace std;

int caseOne(deque<int>& before, deque<int>& after)
{
    // 2A + B + C
    int A = before[0];
    int B = before[1];
    int C = before[before.size() - 2];
    int D = before[before.size() - 1];

    after.push_back(C);
    after.push_back(D);

    for (int i = 0; i < 2; i++) {
        before.pop_back();
    }

    return 2 * A + C + D;
}

int caseTwo(deque<int>& before, deque<int>& after)
{
    // A + 2B + D
    int A = before[0];
    int B = before[1];
    int C = before[before.size() - 2];
    int D = before[before.size() - 1];

    after.push_back(C);
    after.push_back(D);

    for (int i = 0; i < 2; i++) {
        before.pop_back();
    }

    return A + 2 * B + D;
}

int caseThree(deque<int>& before, deque<int>& after)
{
    int A = before[0];
    int B = before[1];
    int C = before[2];
    after.push_back(A);
    after.push_back(B);
    after.push_back(C);
    before.pop_back();
    before.pop_back();
    before.pop_back();

    return A + B + C;
}

int caseFour(deque<int>& before, deque<int>& after)
{
    int A = before[0];
    int B = before[1];
    after.push_back(A);
    after.push_back(B);
    before.pop_back();
    before.pop_back();

    return B;
}

int main(void)
{
    int tCase = 0;
    cin >> tCase;
    while (tCase--) {
        int count = 0;
        int result = 0;
        cin >> count;
        deque<int> before(count, 0);
        deque<int> after;

        for (int i = 0; i < count; i++) {
            cin >> before[i];
        }

        sort(before.begin(), before.end());

        while (!before.empty()) {
            if (before.size() == 2) {
                result += caseFour(before, after);
            } else if (before.size() == 3) {
                result += caseThree(before, after);
            } else if (before.size() >= 4) {
                int A, B, C, D;
                A = before[0];
                B = before[1];
                C = before[before.size() - 2];
                D = before[before.size() - 1];

                if (A + C <= 2 * B) {
                    result += caseOne(before, after);
                } else {
                    result += caseTwo(before, after);
                }
            } else {
                result += before[0];
                after.push_back(before[0]);
                before.pop_front();
            }
        }

        cout << result << "\n";
        if (tCase != 0)
            cout << "\n";
    }
}