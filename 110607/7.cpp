#include <iostream>
#include <algorithm>
using namespace std;
int sds[10000001];
int ssize = 0;

void makesds(void) {
	int i = 1;
	for (; sds[sds[i] - 1] < 2000000001; ++i)
		for (int j = sds[i]; j < sds[i + 1]; ++j)
			sds[j] = sds[j - 1] + i + 1;
	ssize = sds[i] - 1;
}

int main() {
	int t, n;
	sds[0] = 1;
	sds[1] = 2;
	sds[2] = 4;
	makesds();
	while (cin >> n) {
		if (n == 0)
			break;
		cout << upper_bound(sds, sds + ssize, n) - sds << endl;
	}
}