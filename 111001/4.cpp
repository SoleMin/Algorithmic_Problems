#include <iostream>
#include <math.h>
#include <vector>
using namespace std;

double result;

double dist(int a, int b, vector<vector<double>>& v)
{
    return sqrt(pow(v[a][0] - v[b][0], 2) + pow(v[a][1] - v[b][1], 2));
}

void solve(vector<int>& check, vector<double>& minval, vector<vector<double>>& v)
{
    int i;
    double sum = 0;
    double minV = INT32_MAX - 1;

    result = 0;
    for (i = 0; i < v.size(); i++) {
        check[i] = 0;
    }
    for (i = 0; i < v.size(); i++) {
        minval[i] = minV;
    }

    minval[0] = 0;
    i = 0;
    while (!check[i]) {
        check[i] = 1;
        sum += minval[i];

        for (int j = 0; j < v.size(); j++) {
            if (!check[j]) {
                double tmp = dist(i, j, v);
                if (tmp < minval[j])
                    minval[j] = tmp;
            }
        }

        i = 0;
        minV = INT32_MAX - 1;

        for (int j = 0; j < v.size(); j++) {
            if (!check[j]) {
                if (minval[j] < minV) {
                    i = j;
                    minV = minval[j];
                }
            }
        }
    }

    result = sum;
}
int main(void)
{
    int tCase = 0;
    cin >> tCase;

    while (tCase--) {
        int cnt = 0;
        cin >> cnt;

        vector<vector<double>> v(cnt, vector<double>(2, 0.0));
        vector<double> minval(cnt, 0);
        vector<int> check(cnt, 0);
        for (int i = 0; i < cnt; i++) {
            cin >> v[i][0] >> v[i][1];
        }

        solve(check, minval, v);
        printf("%.2f\n", result);

        if (tCase != 0)
            cout << "\n";
    }
}