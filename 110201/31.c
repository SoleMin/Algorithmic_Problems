/* Idea: when error occurs scanf returns EOF, fgets returns NULL */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main(void) {
	int num;
	while (scanf("%d", &num) != EOF) {
		bool* flag = malloc(sizeof(bool) * num);
		int prev;
		scanf("%d", &prev);
		int cur;
		for (int i = 1; i < num; i++) {
			scanf("%d", &cur);
			int res = (prev > cur ? prev - cur : cur - prev);
			if (res >= 1 && res < num)
				flag[res] = true;
			prev = cur;
		}
		bool not = false;
		for (int i = 1; i < num; i++) {
			if (!flag[i]) {
				not = true;
				break;
			}
		}
		if (not)
			printf("Not jolly\n");
		else
			printf("Jolly\n");
	}
}