/* Idea: don't need lcm or gcd */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int t;
	scanf("%d", &t);
	while (t--) {
		int n;
		scanf("%d", &n);
		int number_of_party;
		scanf("%d", &number_of_party);
		int* p = malloc(sizeof(int) * number_of_party);
		for (int i = 0; i < number_of_party; i++)
			scanf("%d", &p[i]);
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 7 == 6 || i % 7 == 0)
				continue;
			for (int j = 0; j < number_of_party; j++)
				if (i % p[j] == 0) {
					result++;
					break;
				}
		}
		printf("%d\n", result);
	}
}