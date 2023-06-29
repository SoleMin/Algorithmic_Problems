#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string dp[10001][101];

string add(string a, string b) {
	long long num = 0;
	string res = "";
	int al = a.length();
	int bl = b.length();
	int i = 0;
	while (i < al || i < bl) {
		if (i < al)
			num += a[al - i - 1] - '0';
		if (i < bl)
			num += b[bl - i - 1] - '0';
		res += (num % 10) + '0';
		num /= 10;
		i++;
	}
	if (num)
		res += (num + '0');
	reverse(res.begin(), res.end());
	return res;
}

int main() {
	int T;
	cin >> T;
	while (T--) {
		string a, b;
		cin >> a >> b;
		int al = a.length();
		int bl = b.length();
		
		for (int i = 0; i <= al; i++) {
			for (int j = 1; j <= bl; j++)
				dp[i][j] = "";
			dp[i][0] = "1";
		}
		
		a = " " + a;
		b = " " + b;
			
		for (int i = 1; i <= al; i++)
			for (int j = 1; j <= bl; j++) {
				if (a[i] == b[j])
					dp[i][j] = dp[i - 1][j - 1];
				dp[i][j] = add(dp[i][j], dp[i - 1][j]);
			}
		cout << dp[al][bl] << '\n';
	}
	return 0;
}