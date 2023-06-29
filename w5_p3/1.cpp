#include <iostream>
#include <cstring>

using namespace std;
int compute_Next(int next[1000001], string A){
	int m, k, q;
	m = (int)A.size();
	next[0] = 0;
	k = 0;
	for(q = 1;q<=m;q++){
		for(;k>0 && (A[k] != A[q]);){
			k = next[k-1];
		}
		if(A[k]==A[q]){
			k++;
		}
		next[q] = k;
	}
	return 0;
}

int KMP(string A, string B, int idx[1000000]){
	int ans = 0, i, j, n, m, count = 0, num = 0, id=0, k, l, min=0;
	int next[1000001] = {0,};
	n = (int)A.size();
	m = (int)B.size();
	compute_Next(next, B);
		for(i=0, j=0;i<=n;i++){
			for(;j>0 && A[i] != B[j];){
					j = next[j-1];
				}
			if(A[i] == B[j])
				j++;
			if(j == m){
				idx[num] = i-m+2;
				ans++;
				num++;
			}
		}
	return ans;
}
int main() {
	int i, j, k, num, check=0;
	int idx[1000000] = {0, };
	string T;
	string P;
	getline(cin, T);
	getline(cin, P);
	
	num = KMP(T, P, idx);
	cout << num << endl;
	for(i=0;i<num;i++){
		cout << idx[i];
		if(i<num-1)
			cout << " ";
	}
	return 0;
}