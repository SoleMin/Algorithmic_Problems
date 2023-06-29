#include <stdio.h>

int main() {
	scanf("%*d");

	int a, b, c, d, s, t;
	while (scanf("%d %d %d %d", &a, &b, &c, &d) == 4) {
		int ck[10001] = {}, tn, i, j, n, tmp;

		s = a * 1000 + b * 100 + c * 10 + d;

		scanf("%d %d %d %d", &a, &b, &c, &d);
		t = a * 1000 + b * 100 + c * 10 + d;

		scanf("%d", &n);
		while (n--) {
			scanf("%d %d %d %d", &a, &b, &c, &d);
			tn = a * 1000 + b * 100 + c * 10 + d;
			ck[tn] = 1;
		}

		int q[10001], used[10001] = {}, step[10001] = {};
		int qt = 0;
		
		q[qt] = s;
		used[s] = 1;
		step[s] = 1;
		
		for (i = 0; i <= qt; i++) {
			tn = q[i];
			a = tn / 1000;
			b = tn % 1000 / 100;
			c = tn % 100 / 10;
			d = tn % 10;

			tmp = (a + 1) % 10 * 1000 + b * 100 + c * 10 + d;
			if (used[tmp] == 0 && ck[tmp] == 0) {
				used[tmp] = 1;
				step[tmp] = step[tn] + 1;
				q[++qt] = tmp;
			}
			tmp = (a + 9) % 10 * 1000 + b * 100 + c * 10 + d;
			if (used[tmp] == 0 && ck[tmp] == 0) {
				used[tmp] = 1;
				step[tmp] = step[tn] + 1;
				q[++qt] = tmp;
			}
			tmp = a * 1000 + (b + 1) % 10 * 100 + c * 10 + d;
			if (used[tmp] == 0 && ck[tmp] == 0) {
				used[tmp] = 1;
				step[tmp] = step[tn] + 1;
				q[++qt] = tmp;
			}
			tmp = a * 1000 + (b + 9) % 10 * 100 + c * 10 + d;
			if (used[tmp] == 0 && ck[tmp] == 0) {
				used[tmp] = 1;
				step[tmp] = step[tn] + 1;
				q[++qt] = tmp;
			}
			tmp = a * 1000 + b * 100 + (c + 1) % 10 * 10 + d;
			if (used[tmp] == 0 && ck[tmp] == 0) {
				used[tmp] = 1;
				step[tmp] = step[tn] + 1;
				q[++qt] = tmp;
			}
			tmp = a * 1000 + b * 100 + (c + 9) % 10 * 10 + d;
			if (used[tmp] == 0 && ck[tmp] == 0) {
				used[tmp] = 1;
				step[tmp] = step[tn] + 1;
				q[++qt] = tmp;
			}
			tmp = a * 1000 + b * 100 + c * 10 + (d + 1) % 10;
			if (used[tmp] == 0 && ck[tmp] == 0) {
				used[tmp] = 1;
				step[tmp] = step[tn] + 1;
				q[++qt] = tmp;
			}
			tmp = a * 1000 + b * 100 + c * 10 + (d + 9) % 10;
			if (used[tmp] == 0 && ck[tmp] == 0) {
				used[tmp] = 1;
				step[tmp] = step[tn] + 1;
				q[++qt] = tmp;
			}
			if (used[t])    break;
		}
		if (used[t])
			printf("%d\n", step[t] - 1);
		else
			printf("-1\n");

	}
	return 0;
}