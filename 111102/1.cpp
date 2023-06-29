/* 
 * 서로 다른 부분열 (distinct Subsequences)
 * 
 * 2021.Dec.1
 */

#include <iostream>
#include <vector>
using namespace std;

int main(void)
{
    int tCase = 0;
    cin >> tCase;
    while (tCase--) {
        string s1;
        string s2;
        cin >> s1 >> s2;

        vector<vector<long long>> dp(s2.size(), vector<long long>(s1.size(), 0));
        if (s1[0] == s2[0])
            dp[0][0] = 1;

        for (int i = 1; i < s1.size(); i++) {
            if (s1[i] == s2[0]) {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < s2.size(); i++) {
            for (int j = 1; j < s1.size(); j++) {
                if (s1[j] == s2[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

                    if (s2[i] == s2[i - 1])
                        dp[i][j]--;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        cout << dp[s2.size() - 1][s1.size() - 1] << "\n";
    }
}