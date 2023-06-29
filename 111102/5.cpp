# include <iostream>
# include <string>
# include <algorithm>
# include <vector>

# define MAX_SIZE (10000)

using namespace std;

static string dp[MAX_SIZE][101];

string bigNum_Add(string a, string b) {

    long long res = 0, al = a.length(), bl = b.length();
    string c;

    for (long long i = 0; i < al || i < bl; i++) {
        if (i < al)
            res += a[al - i - 1] - '0';
        if (i < bl)
            res += b[bl - i - 1] - '0';

        c += (res % 10) + '0';
        res /= 10;
    }


    if (res) c += res + '0';

    reverse(c.begin(), c.end());

    return c;
}

int main() {

    int test_case;
    cin >> test_case;

    string s1, s2;

    while (test_case-- > 0) {
        cin >> s1 >> s2;

        s1 = " " + s1;
        s2 = " " + s2;

        for (int i = 0; i <= s1.size(); i++) {
            for (int j = 0; j <= s2.size(); j++) {
                dp[i][j] = "";
            }
        }

        dp[0][0] = "1";
        for (int i = 1; i <= s1.size(); i++) {
            dp[i][0] = "1";
        }

        for (int i = 1; i <= s1.size(); i++) {
            for (int j = 1; j <= s2.size(); j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //else if (s1[i] != s2[j] {
                //  dp[i][j] = dp[i - 1][j];
                //}

                dp[i][j] = bigNum_Add(dp[i][j], dp[i - 1][j]);
            }
        }
        cout << dp[s1.size()][s2.size()] << endl;
    }

    

    return 0;
}