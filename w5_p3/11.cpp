#include <iostream>
#include <vector>

using namespace std;

string T, P;
int n, m, count;
int* pi;
vector<int> ans;

void input();
void pi_();
void kmp();
void print();

int main() {
	input();
	pi_();
	kmp();
	print();
	
	return 0;
}

void input() {
	getline(cin, T);
	getline(cin, P);
	n = T.length();
	m = P.length();
}

void pi_() {
	pi = new int[m];
	pi[0] = 0;
	int j = 0;
	for (int i = 1; i < m; i++) {
		while (j > 0 && P[i] != P[j])
			j = pi[j - 1];
		if (P[i] == P[j])
			pi[i] = ++j;
	}
}

void kmp() {
	int j = 0;
	for (int i = 0; i < n; i++) {
		while (j > 0 && T[i] != P[j])
			j = pi[j - 1];
		if (T[i] == P[j]) {
			if (j == m - 1) {
				count++;
				ans.push_back(i - m + 2);
				j = pi[j];
			}
			else
				j++;
		}
	}
}

void print() {
	cout << count << '\n';
	for (int i = 0; i < (int) ans.size(); i++)
		cout << ans[i] << ' ';
}