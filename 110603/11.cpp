# include <iostream>
# include <algorithm>
# define MAX_SIZE (1000)

using namespace std;

/*
	<n = 1> 2개
		1, 4
	<n = 2> 5개
		11, 14, 41, 44, 2
	<n = 3> 13개
		111, 114, 141, 411, 144, 414, ,441, 444, 21, 12, 24, 42, 3
		
	
	기저값은 3이다.
	
	1-1. 기존의 것에 1을 더한다.
	
	1-2 기존의 것에 4를 더한다.
	
	2. 기존의 것에 2를 더한다.
	
	3. 기존의 것에 3을 더한다.
	
	dp[n] = dp[n-1]*2 + dp[n-2] + dp[n-3]
	
*/

static string dp[MAX_SIZE + 1];	// 0 is null

string add(string s1, string s2) {
	if(s1.length() < s2.length()){
		string temp;
		temp = s1;
		s1 = s2;
		s2 = temp;
	}
	
	int padding = s1.length() - s2.length();
	
	for (int i = 0; i < padding; i++){
		s2 = "0" + s2;
	}
	
	vector<int> sum;
	for (int i = 0; i < s1.length(); i++){
		sum.push_back((s1[i] - '0') + (s2[i] - '0'));
	}
	
	reverse(sum.begin(), sum.end());
	
	for (int i = 0; i < sum.size(); i++){
		if (sum[i] < 10){
			continue;
		}
		
		if (i < sum.size() - 1){
			sum[i + 1] += sum[i]/10;
		}
		else {
			sum.push_back(sum[i]/10);
		}
		
		sum[i] %= 10;
	}
	
	reverse(sum.begin(), sum.end());
	
	string r;
	int i = 0;
	while(sum[i] == 0){
		i++;
	}
	
	if (i >= sum.size()){
		r.push_back('0');
	}
	
	while(i < sum.size()){
		r.push_back((char)(sum[i] + '0'));
		i++;
	}
	
	return r;
}

void init(){
	for(int i = 0; i < MAX_SIZE + 1; i++){
		dp[i] = "0";
	}
	
	dp[1] = "2";
	dp[2] = "5";
	dp[3] = "13";
}

int main() {
	int n;
	while(cin >> n){
		init();
		
		for(int i = 4; i <= n; i++){
			//dp[i] = dp[i-1] * 2 + dp[i-2] + dp[i-3];
			dp[i] = add(add(add(dp[i-1], dp[i-1]), dp[i-2]), dp[i-3]);
		}
		
		cout << dp[n] << endl;
	} 
	
	return 0;
}