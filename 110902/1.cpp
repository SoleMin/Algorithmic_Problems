#include <cstdio>
#include <queue>
#include <cstring>
#define toint(a, b, c, d) ((a)*1000+(b)*100+(c)*10+(d))
using namespace std;

int main()
{
	int N, n, a, b, c, d, first, last, i, num, tmp;
	int step[10001];
	bool ban[10001];

	scanf("%d", &N);
	while (N--)
	{
		queue<int> q;
		scanf("%d %d %d %d", &a, &b, &c, &d);
		first = toint(a, b, c, d);
		scanf("%d %d %d %d", &a, &b, &c, &d);
		last = toint(a, b, c, d);

		memset(step, 0, sizeof(step));
		memset(ban, 0, sizeof(ban));

		scanf("%d", &n);
		for (i = 0; i < n; i++)
		{
			scanf("%d %d %d %d", &a, &b, &c, &d);
			ban[toint(a, b, c, d)] = 1;
		}
		q.push(first);

		while (!q.empty())
		{
			num = q.front();
			q.pop();

			a = num / 1000;
			b = (num % 1000) / 100;
			c = (num % 100) / 10;
			d = num % 10;

			tmp = toint((a+1)%10, b, c, d);
			if (!ban[tmp] && step[tmp]==0) {
				q.push(tmp);
				if (!step[tmp] || step[tmp] > step[num] + 1)
					step[tmp] = step[num] + 1;
			}

			tmp = toint((a + 9) % 10, b, c, d);
			if (!ban[tmp] && step[tmp] == 0) {
				q.push(tmp);
				if (!step[tmp] || step[tmp] > step[num] + 1)
					step[tmp] = step[num] + 1;
			}

			tmp = toint(a, (b+1)%10, c, d);
			if (!ban[tmp] && step[tmp] == 0) {
				q.push(tmp);
				if (!step[tmp] || step[tmp] > step[num] + 1)
					step[tmp] = step[num] + 1;
			}

			tmp = toint(a, (b + 9) % 10, c, d);
			if (!ban[tmp] && step[tmp] == 0) {
				q.push(tmp);
				if (!step[tmp] || step[tmp] > step[num] + 1)
					step[tmp] = step[num] + 1;
			}

			tmp = toint(a, b, (c+1)%10, d);
			if (!ban[tmp] && step[tmp] == 0) {
				q.push(tmp);
				if (!step[tmp] || step[tmp] > step[num] + 1)
					step[tmp] = step[num] + 1;
			}

			tmp = toint(a, b, (c + 9) % 10, d);
			if (!ban[tmp] && step[tmp] == 0) {
				q.push(tmp);
				if (!step[tmp] || step[tmp] > step[num] + 1)
					step[tmp] = step[num] + 1;
			}

			tmp = toint(a, b, c, (d+1)%10);
			if (!ban[tmp] && step[tmp] == 0) {
				q.push(tmp);
				if (!step[tmp] || step[tmp] > step[num] + 1)
					step[tmp] = step[num] + 1;
			}

			tmp = toint(a, b, c, (d + 9) % 10);
			if (!ban[tmp] && step[tmp] == 0) {
				q.push(tmp);
				if (!step[tmp] || step[tmp] > step[num] + 1)
					step[tmp] = step[num] + 1;
			}
			if (step[last])
				break;
		}

		if (step[last])
			printf("%d\n", step[last]);
		else
			printf("-1\n");
	}
}