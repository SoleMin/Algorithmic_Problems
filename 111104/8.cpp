#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool comapre(const pair<int, int>& a, const pair<int, int>& b)
{
    return a.second < b.second;
}

int main(void)
{
    vector<pair<int, int>> v;
    int a, b;
    while (cin >> a >> b)
    {
        v.push_back(make_pair(a, b));
    }
    sort(v.begin(), v.end(), comapre);

    // vector<vector<int>> dp(v.size(), vector<int>(v.size(), 9999999));
    vector<int> dp(v.size(), 9999999);
    // for (int i = 0; i < v.size(); i++) {
    //     dp[i][0] = 0;
    // }

    dp[0] = 0;
    int maxValue = 0;

    for (int i = 0; i < v.size(); i++) {
        int c = 0;
        for (int j = v.size() - 1; j >= 1; j--) {
            if ((dp[j - 1] + v[i].first) <= v[i].second) {
                dp[j] = min(dp[j - 1] + v[i].first, dp[j]);
                c++;
            }
            if (c > maxValue) {
                maxValue = c;
            }
        }
    }

    cout << maxValue;

    return 0;
}