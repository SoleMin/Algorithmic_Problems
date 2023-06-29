#include <iostream>
#include <cstring>
#include <algorithm>
#define MAX 1000

using namespace std;

char c[4][MAX];
int len[4];

void sum(int r, int c1, int c2, int c3){
	int i = 0, carry = 0;
	for(; i<len[c3]; i++){
		c[r][i] = c[c1][i]*2 + c[c2][i] + c[c3][i] + carry;
		if(c[r][i] >= 10)
			carry = c[r][i]/10;
		else
			carry = 0;
		c[r][i] %= 10;
	}
	for(; i<len[c2]; i++){
		c[r][i] = c[c1][i]*2 + c[c2][i] + carry;
		if(c[r][i] >= 10)
			carry = c[r][i]/10;
		else
			carry = 0;
		c[r][i] %= 10;
	}
	for(; i<len[c1]; i++){
		c[r][i] = c[c1][i]*2 + carry;
		if(c[r][i] >= 10)
			carry = 1;
		else
			carry = 0;
		c[r][i] %= 10;
	}
	if(carry)
		c[r][i++] = carry;
	len[r] = i;
}

int main() {
	int n;
	while(cin >> n){
		memset(c, 0, sizeof(c));
		c[0][0] = 2;
		c[1][0] = 5;
		c[2][0] = 3;
		c[2][1] = 1;
		len[0] = len[1] = 1;
		len[2] = 2;
		if(n<3){
			cout << c[n-1][0] + 0 << endl;
			continue;
		}
		int i;
		for(i=3; i<n; i++){
			sum(i%4, (i-1)%4, (i-2)%4, (i-3)%4);
		}
		i = (i-1)%4;
		for(int j=0; j<len[i]; j++)
			c[i][j] = c[i][j] + 48;
		string result(c[i]);
		reverse(result.begin(), result.end());
		cout << result << endl;
	}

	return 0;
}