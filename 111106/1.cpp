/**
 * 페리 탑승 (Ferry Loading)
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
        vector<int> v;
        int left = 0, right = 0, n = 0;
        vector<vector<int>> dp(10001, vector<int>(2, 0));
        vector<vector<vector<int>>> from(201, vector<vector<int>>(10001, vector<int>(2, 0)));

        cin >> n;
        n *= 100;

        for (int i = 0; i <= n; i++) {
            dp[i][0] = -1;
            dp[i][1] = 0;
        }
        dp[0][0] = 0;
        int carLengthSum = 0;
        int maxValue = 0;

        int tmp;
        int index = 0;
        while (cin >> tmp) {
            if (tmp == 0)
                break;

            if (carLengthSum <= 2 * n) {
                for (int i = n; i >= tmp; i--) {
                    if (dp[i - tmp][0] != -1 && carLengthSum - i + tmp <= n && dp[i][0] < (index + 1)) {
                        dp[i][0] = (index + 1);
                        dp[i][1] = carLengthSum - i + tmp;
                        from[index + 1][i][0] = dp[i - tmp][0];
                        from[index + 1][i][1] = tmp;
                        if (dp[maxValue][0] < dp[i][0] || (dp[maxValue][0] == dp[i][0] && abs(maxValue - dp[maxValue][1]) > abs(i - dp[i][1])))
                            maxValue = i;
                    }
                }
            }

            carLengthSum += tmp;
            index++;
        }

        cout << dp[maxValue][0] << "\n";
        if (tCase != 0)
            cout << "\n";
    }
}