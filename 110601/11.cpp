#include <iostream>
#include <string>
#include <vector>
using namespace std;

int fibo[3][101];
int len[3];

void addition() {
	int a, b;
	int carry = 0;
	// len[0] <= len[1] 이므로
	for(int i = 0; i < len[1]; i++) {
		fibo[0][i] += carry;
		a = fibo[0][i];
		b = fibo[1][i];
		carry = (a + b) / 10;
		fibo[2][i] = (a + b) % 10;
	}
	if(carry) {
		len[2] = len[1] + 1;
		fibo[2][len[1]] = 1;
	}
	else
		len[2] = len[1];
}

int comp(vector<int> &num) {
	if(len[2] > num.size())
		return 1;
	else if(len[2] < num.size())
		return -1;
	for(int i = len[2] - 1; i >= 0; i--) {
		if(fibo[2][i] > num[i])
			return 1;
		else if(fibo[2][i] < num[i])
			return -1;
	}
	return 0;
}

void move() {
	for(int i = 0; i < len[1]; i++) 
		fibo[0][i] = fibo[1][i];
	for(int i = 0; i < len[2]; i++)
		fibo[1][i] = fibo[2][i];
	len[0] = len[1];
	len[1] = len[2];
}

int solve(vector<int> &st, vector<int> &en) {
	fibo[0][0] = 0;
	fibo[1][0] = 1;
	len[0] = 1;
	len[1] = 1;
	int cnt = 0;
	while(true) {
		//add
		addition();
		if(len[2] >= 101) break;
		
		// for(int i = len[2] - 1; i >= 0; i--)
		// 	cout << fibo[2][i];
		// cout << endl;
		// compare
		if(comp(st) != -1) {
			if(comp(en) != 1)
				cnt++;
			else
				break;
		}
		// move
		move();
	}
	return cnt;
}

void init() {
	for(int i = 0; i < 3; i++) {
		for(int j = 0; j < 101; j++)
			fibo[i][j] = 0;
		len[i] = 0;
	}
}

int main() {
	string a, b;
	while(true) {
		cin >> a >> b;
		if(a == "0" && b == "0") break;
		vector<int> st, en;
		for(int i = a.size() - 1; i >= 0; i--)
			st.push_back(a[i] - '0');
		for(int i = b.size() - 1; i >= 0; i--)
			en.push_back(b[i] - '0');
		cout << solve(st, en) << '\n';
		init();
	}
	
	return 0;
}