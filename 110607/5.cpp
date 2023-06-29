
#include <bits/stdc++.h>
 
using namespace std;
 const long long n=2e9;

int main(void){
	vector <long long> output;
	output.push_back(0);
		output.push_back(1);
	output.push_back(3);
 for(long long i = 3, k = 0; k <= n; i++) {
        k = *(output.end() - 1) + (lower_bound(output.begin(), output.end(), i) - output.begin());
        output.push_back(k);
    }
 
    long long num;
    while(~scanf("%lld", &num) && num) {
        printf("%lld\n", (long long)(lower_bound(output.begin(), output.end(), num) - output.begin()));
    }
 
    return 0;
	
}