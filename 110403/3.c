#include <stdio.h>
#include <stdlib.h>

int intcompare(int* i, int* j) {
	if (*i > * j)
		return (1);
	if (*i < *j)
		return (-1);
	return(0);
}

int main(void) {
	int cases, i, n, count = 0;
	int type1, type2, x1, x2, x3, x4;
	int time[1000], result[1000] = { 0, };
	char line;

	scanf("%d", &cases);
	scanf("%c", &line);

	while (cases != 0) {

		scanf("%d", &n);

		for (i = 0; i < n; i++)
			scanf("%d", &time[i]);

		while (n > 3) {
			qsort((void*)time, (size_t)n, sizeof(int), intcompare);

			x1 = time[0];
			x2 = time[1];
			x3 = time[n - 2];
			x4 = time[n - 1];

			type1 = x1 + (2 * x2) + x4;
			type2 = (2 * x1) + x3 + x4;

			if (type1 > type2)
				result[count] += type2;
			else
				result[count] += type1;

			n = n - 2;
		}

		if (n == 3) {
			result[count] += time[0] + time[1] + time[2];
		}

		if (n == 2) {
			result[count] += time[1];
		}

		if (n == 1) {
			result[count] += time[0];
		}
		cases--;
		count++;
	}

	for (i = 0; i < count; i++)
		printf("%d\n\n", result[i]);
}