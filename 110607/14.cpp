#include <cstdio>
#include <algorithm>
const int MAX = 999999;
using namespace std;

long long loc[MAX];

int main() {
	loc[1] = 1;
	loc[2] = 3;
	for (int i = 3; i < MAX; ++i) {
		loc[i] = loc[i - 1] + (lower_bound(loc + 1, loc + i, i) - loc);
	}
	int n;
	while (scanf("%d", &n), n) {
		printf("%d\n", lower_bound(loc + 1, loc + MAX, n) - loc);
	}
	return 0;
}