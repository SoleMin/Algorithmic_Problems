#include <bits/stdc++.h>
using namespace std;
int main() {
	int n, k;
	while(cin>>n>>k){
		int po = 0;
		if(n == 0 && k == 0)
			break;
		int a[20] = {}, b[20] = {};
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				if((i+j)%2)
					a[(i+j)/2]++;
			else
				b[(i+j)/2]++;
		}
		sort(a, a+n-1);
		sort(b, b+n);
		int aa[20][20] = {}, bb[20][20] = {};
		aa[0][0] = 1;
		aa[0][1] = a[0];
		bb[0][0] = 1;
		bb[0][1] = b[0];
		for(int i = 1; i < n-1; i++){
			aa[i][0] = 1;
			for(int j = 1; j <= a[i]; j++)
				aa[i][j] = aa[i-1][j] + aa[i-1][j-1]*(a[i]-(j-1));
		}
		for(int i = 1; i < n; i++) {
			bb[i][0] = 1;
			for(int j = 1; j <= b[i]; j++)
				bb[i][j] = bb[i-1][j] + bb[i-1][j-1]*(b[i]-(j-1));
		}
		for(int i = 0; i <= k; i++)
			po+=bb[n-1][k-i]*aa[n-2][i];
		cout<<po<<endl;
	}
	return 0;
}