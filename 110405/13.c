#include <stdio.h>

int main(void) {
	int i, j, k, testcase ,temp;
	int n;
	int time[1000], s[1000], result[1000];
	
	scanf("%d", &testcase);

	for (k = 0; k < testcase; k++) {
		getchar();
		scanf("%d", &n);

		
		for (i = 0; i < n; i++) {
			scanf("%d %d", &time[i],&s[i]);
		}
		for (i = 0; i < n; i++) {
			result[i] = i;
		}
		for (i = 1; i < n; i++) {
			for (j = 0; j < n - 1; j++) {
				if (time[result[j]] * s[result[j + 1]] > time[result[j + 1]] * s[result[j]]) {
					temp = result[j];
					result[j] = result[j + 1];
					result[j + 1] = temp;
				}
			}
		}
		if (k > 0) {
			printf("\n");
		}
		for (j = 0; j < n - 1; j++) {
			printf("%d ", result[j] + 1);
		}
		printf("%d\n", result[n - 1] + 1);
	}
}