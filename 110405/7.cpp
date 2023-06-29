#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

bool cmp(pair<double, int> p1, pair<double, int> p2)
{
    if (p1.first == p2.first) {
        return p1.second < p2.second;
    }
    return p1.first > p2.first;
}

int main()
{
    int tCase = 0;
    cin >> tCase;
    while (tCase--) {
        int count;
        cin >> count;

        vector<pair<double, int>> v;

        for (int i = 0; i < count; i++) {
            int T, S;
            cin >> T >> S;

            v.push_back(make_pair(S * 1.0 / T, i + 1));
        }

        sort(v.begin(), v.end(), cmp);

        for (size_t i = 0; i < v.size() - 1; i++) {
            cout << v[i].second << " ";
        }

        cout << v[v.size() - 1].second;

        if (tCase != 0) {
            cout << "\n\n";
        }
    }
}