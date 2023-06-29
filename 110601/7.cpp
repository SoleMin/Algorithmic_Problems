#include <algorithm>
#include <iostream>
#include <vector>
#define MAX_SIZE 107
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
    vector<string> v;
    v.push_back("1");
    v.push_back("2");
    v.push_back("3");
    for (int i = 3; i < 500; i++) {
        v.push_back(arrayToString(arrayAddArray(stringToArray(v[i - 1]), stringToArray(v[i - 2]))));
    }

    // for (auto& i : v) {
    //     cout << i << "\n";
    // }

    string a, b;
    while (cin >> a >> b) {
        if (a == "0" && b == "0") {
            break;
        }
        vector<int> aValue = stringToArray(a);
        vector<int> bValue = stringToArray(b);
        int cnt = 0;
        for (size_t i = 0; i < v.size(); i++) {
            vector<int> dpValue = stringToArray(v[i]);
            int cmp1 = vectorCompare(dpValue, aValue);
            int cmp2 = vectorCompare(bValue, dpValue);
            if (cmp1 >= 0 && cmp2 >= 0) {
                cnt++;
                // for (auto& i : dpValue) {
                //     cout << i;
                // }
                // cout << "\n";
                // for (auto& i : aValue) {
                //     cout << i;
                // }
                // cout << "\n";
                // for (auto& i : bValue) {
                //     cout << i;
                // }
                // cout << "\n";
                // cout << cmp1 << " " << cmp2 << "\n";
            }
        }

        cout << cnt << "\n";
    }

    return 0;
}