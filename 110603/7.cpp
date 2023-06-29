#include <iostream>
#include <vector>
#define MAX_SIZE 300
using namespace std;

string arrayToString(vector<int> v)
{
    string result = "";
    int j = 0;

    for (int i = 0; i < v.size(); i++) {
        if (v[i] != 0) {
            j = i;
            break;
        }
    }

    for (int i = j; i < v.size(); i++) {
        result.push_back(v[i] + '0');
    }

    return result;
}

vector<int> stringToArray(string s)
{
    vector<int> result(MAX_SIZE, 0);

    int j = MAX_SIZE - s.size();
    for (int i = 0; i < s.size(); i++) {
        result[j] = s[i] - '0';
        j++;
    }

    return result;
}

vector<int> arrayAddArray(vector<int> v1, vector<int> v2)
{
    vector<int> result(MAX_SIZE, 0);

    for (int i = 0; i < result.size(); i++) {
        result[i] = v1[i] + v2[i];
    }

    for (int i = MAX_SIZE - 1; i > 0; i--) {
        if (result[i] >= 10) {
            result[i - 1] += 1;
            result[i] -= 10;
        }
    }

    return result;
}

int vectorCompare(vector<int> v1, vector<int> v2)
{
    int result = 0;

    for (int i = 0; i < v1.size(); i++) {
        result = v1[i] - v2[i];
        if (result != 0)
            break;
    }

    return result;
}

int main(void)
{
    vector<string> dp(4, "0");
    dp[1] = "2";
    dp[2] = "5";
    dp[3] = "13";

    for (int i = 4; i <= 1000; i++) {
        string d;
        vector<int> tmp = arrayAddArray(stringToArray(dp[i - 1]), stringToArray(dp[i - 1]));
        tmp = arrayAddArray(tmp, stringToArray(dp[i - 2]));
        tmp = arrayAddArray(tmp, stringToArray(dp[i - 3]));
        d = arrayToString(tmp);
        dp.push_back(d);
    }

    int input;
    while (cin >> input) {
        cout << dp[input] << "\n";
    }

    return 0;
}