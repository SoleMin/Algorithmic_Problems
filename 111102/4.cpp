#include <iostream>
#include <string>
#include <cstring>
using namespace std;

int n;
string s1, s2;
long long dp[10001][101];

int main() {
	cin >> n;
	while(n--) {
		cin >> s1 >> s2;
		int len1 = s1.length(), len2 = s2.length();
		memset(dp, 0, sizeof(dp));
		
		for(int i = 0; i <= len1; i++)
			dp[i][0] = 1;
		
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if(s1[i - 1] == s2[j - 1]) 
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		
		cout << dp[len1][len2] << '\n';
	}
	
	
	return 0;
}