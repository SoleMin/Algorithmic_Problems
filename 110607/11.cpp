#include <iostream>
#define MAX 100000

using namespace std;

int main() {
	long long n, k, f[MAX], ff[MAX], sum, result, idx=3;
	f[0] = 1;
	f[1] = 2;
	f[2] = 2;
	ff[0] = 1;
	for(int i=2; idx<MAX; i++){
		for(int j=0; idx<MAX && j<f[i]; j++){
			f[idx++] = i+1;
		}
	}
	while(cin >> n){
		if(n == 0)
			break;
		if(n < MAX){
			cout << f[n-1] << endl;
			continue;
		}
		k = 0;
		sum = 1;
		while(ff[k] < n){
			sum += f[k];
			k++;
			ff[k] = ff[k-1] + (k+1)*f[k];
		}
		result = sum + (n-ff[k-1])/k;
		cout << result << endl;
	}
	
	return 0;
}