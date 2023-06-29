#include <iostream>
#include <string>
#include <algorithm>
#define MAX 100

using namespace std;

static char a[MAX+1], b[MAX+1], f[3][MAX+1];
static int lena, lenb, len[3];

int compare(int fib, char *n, int l){
	if(len[fib] < l)
		return -1;
	if(len[fib] > l)
		return 1;
	for(int i=l-1; i>=0; i--){
		if(f[fib][i] < n[i])
			return -1;
		if(f[fib][i] > n[i])
			return 1;
	}
	return 0;
}

void sum(int t, int f1, int f2){
	int c, i = 0, carry = 0;
	for(; i<len[f1] && i<len[f2]; i++){
		f[t][i] = f[f1][i] + f[f2][i] + carry;
		if(f[t][i] >= 10)
			carry = 1;
		else
			carry = 0;
		f[t][i] %= 10;
	}
	if(i < len[f1])
		c = f1;
	else
		c = f2;
	for(; i<len[c]; i++){
		f[t][i] = f[c][i] + carry;
		if(f[t][i] >= 10)
			carry = 1;
		else
			carry = 0;
		f[t][i] %= 10;
	}
	if(carry)
		f[t][i++] = 1;
	len[t] = i;
}

int main() {
	string line;
	while(getline(cin, line)){
		if(line == "0 0")
			break;
		reverse(line.begin(), line.end());
		lenb = line.copy(b, line.find(" "));
		line.erase(0, line.find(" ")+1);
		lena = line.copy(a, line.length());
		for(int i=0; i<lenb; i++){
			b[i] = b[i] - '0';
			if(i<lena)
				a[i] = a[i] - '0';
		}
		len[0] = len[1] = 1;
		f[0][0] = f[1][0] = 1;
		int i, result;
		for(i = 1; compare(i%3, a, lena)<0; i++)
			sum((i+1)%3, i%3, (i-1)%3);
		result = i;
		for(; compare(i%3, b, lenb)<=0; i++)
			sum((i+1)%3, i%3, (i-1)%3);
		result = i - result;
		cout << result << endl;
	}

	return 0;
}