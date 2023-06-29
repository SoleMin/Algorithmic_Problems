#include <cstdio>
#include <iostream>
#include <cstdlib>
#include <string>
#include <algorithm>

using namespace std;

int mycomp(string a, string b)
{
	if (a.length() < b.length()) {
		return -1;
	}
	else if (a.length() > b.length()) {
		return 1;
	}

	return a.compare(b);
}

string add(string a, string b)
{
	string c;
	int i, o, alen;
	c.resize(b.length());
	alen = a.length();
	o = 0;
	for (i = 0; i < alen; i++)
	{
		c[i] = o + a[i] + b[i] - '0';
		o = 0;
		if (c[i] > '9') {
			c[i] -= 10;
			o = 1;
		}
	}
	if (i < b.length()) {
		c[i] = b[i] + o;
		o = 0;
		if(c[i]>'9') {
			c[i] -= 10;
			o = 1;
		}
	}
	if (o == 1) {
		c.resize(c.length() + 1);
		c[i] = '1';
		o = 0;
	}
	return c;
}

int findfiv(string a, string b)
{
	int count;
	string revA, revB, f1, f2, f3;
	revA = a, revB = b;
	reverse(revA.begin(), revA.end());
	reverse(revB.begin(), revB.end());

	f1 = "0";
	f2 = "1";
	f3 = "1";
	count = 0;
	while (mycomp(f3, b) <= 0) {
		if (mycomp(f3, a) >= 0)
			count++;
		reverse(f3.begin(), f3.end());
		f1 = f2;
		f2 = f3;
		f3 = add(f1, f2);
		reverse(f3.begin(), f3.end());
	}
	return count;
}

int main() {
	string a, b;
	int result;
	cin >> a;
	cin >> b;

	while (a[0] != '0' || b[0] != '0')
	{
		result = findfiv(a, b);
		cout << result << endl;

		cin >> a;
		cin >> b;
	}
}
