#include <iostream>
#include <string>
#include <vector>
using namespace std;

int n[1000000];

void compute_Next(string P) {
	int m = P.length();
	int k = 0;
	int q = 1;
	while (q < m) {
		while (k > 0 && P[k] != P[q])
			k = n[k-1];
		if (P[k] == P[q])
			++k;
		n[q] = k;
		q++;
	}
}

void KMP(string T, string P) {
	int n = T.length(); int m = P.length(); int k = 0, count = 0;
	vector<int> which;
	compute_Next(P);
	int q = 0;
	while (k < n) {	// 문자열 T 안에서
		while (q > 0 && T[k] != P[q])
			q = ::n[q - 1];
		if (T[k] == P[q]) {
			if (q == m-1) {
				count++;	// 횟수
				which.push_back(k - m + 2);	// 위치
				q = ::n[q];
			}
		}
		q++;
		k++;
	}
	
	cout << count << endl;
	for(int w : which) {
		cout << w << ' ';
	}
}

// T의 길이 n, P의 길이 m (n >= m)
int main(void) {
	string T, P;
	
	getline(cin, T);	// P를 찾을 문자열 T
	getline(cin, P);	// T에서 찾을 문자열 P
	
	KMP(T, P);
	// 출력
	// T에서 P가 나타나는 횟수
	// P가 나타나는 위치 -> 각각 SP로 구분
	
	return 0;
}