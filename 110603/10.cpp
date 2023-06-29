#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string dp[1001];

string add(string, string);

int main() {
	dp[0] = "1";
	dp[1] = "2";
	dp[2] = "5";
	dp[3] = "13";
	
	for (int i = 4; i <= 1000; i++)
		dp[i] = add(add(dp[i - 1], dp[i - 1]), add(dp[i - 2], dp[i - 3]));
	
	int n;
	while (cin >> n)
		cout << dp[n] << '\n';
	return 0;
}

string add(string a, string b) {
	long long num = 0;
	string res = "";
	int a_length = a.length();
	int b_length = b.length();
	int i = 0;
	while (i < a_length || i < b_length) {
		if (i < a_length)
			num += a[a_length - i - 1] - '0';
		if (i < b_length)
			num += b[b_length - i - 1] - '0';
		res += (num % 10) + '0';
		num /= 10;
		i++;
	}
	if (num)
		res += (num + '0');
	reverse(res.begin(), res.end());
	return res;
}