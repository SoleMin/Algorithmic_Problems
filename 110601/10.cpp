#include <iostream>
#include <algorithm>

using namespace std;

string f[500];
string add(string, string);
bool cmp(string, string, string);

int main() {
	f[0] = "1";
	f[1] = "1";
	f[2] = "2";
	for (int i = 3; i <= 480; i++) {
		f[i] = add(f[i - 1], f[i - 2]);
		//cout << f[i] << endl;
	}
	
	string a, b;
	while (cin >> a >> b) {
		if (a == "0" && b == "0")
			break;
		int count = 0;
		for (int i = 1; i <= 480; i++) {
			if (cmp(a, f[i], b))
				count++;
		}
		cout << count << '\n';
	}
	return 0;
}

string add(string a, string b) {
	long long num = 0;
	string res = "";
	int al = a.length();
	int bl = b.length();
	int i = 0;
	while (i < al || i < bl) {
		if (i < al)
			num += a[al - i - 1] - '0';
		if (i < bl)
			num += b[bl - i - 1] - '0';
		res += (num % 10) + '0';
		num /= 10;
		i++;
	}
	if (num)
		res += (num + '0');
	reverse(res.begin(), res.end());
	return res;
}

bool cmp(string a, string b, string c) {
	if (a.length() > b.length() || b.length() > c.length())
		return false;
	if (a.length() == b.length())
		if (a > b)
			return false;
	if (b.length() == c.length())
		if (b > c)
			return false;
	return true;
}




