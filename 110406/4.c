#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

#define N (1000 + 1)

int fees[24];

typedef struct {
	int date;
	bool enter;
	int gate;
} info;

typedef struct {
	char name[24 + 1];
	int count;
	info arr[600 + 1];
} photo;

void solve(photo* shot) {
	int fee = 200;
	bool tinder = false;
	bool enter = false;
	int enter_gate, exit_gate;
	int enter_time;
	for (int i = 0; i < shot->count; i++) {
		if (!enter && shot->arr[i].enter) {
			enter = true;
			enter_gate = shot->arr[i].gate;
			enter_time = shot->arr[i].date;
			continue;
		}
		if (enter && !shot->arr[i].enter) {
			enter = false;
			tinder = true;
			exit_gate = shot->arr[i].gate;
			int hour = ((enter_time / 100) % (24 * 60)) / 60;
			int abs_value = exit_gate > enter_gate ? exit_gate - enter_gate : enter_gate - exit_gate;
			fee += 100 + abs_value * fees[hour];
			continue;
		}
	}
	int cent = fee % 100;
	if (tinder)
		printf("%s $%d.%02d\n", shot->name, fee / 100, fee % 100);
}

void god(photo* arr, int count) {
	for (int i = 0; i < count; i++) {
		printf("%s\n", arr[i].name);
		for (int j = 0; j < arr[i].count; j++)
			printf("%d %d %d\n", arr[i].arr[j].date, arr[i].arr[j].enter, arr[i].arr[j].gate);
	}
}

int compare(const void* a, const void* b) {
	int d1 = ((info*)a)->date;
	int d2 = ((info*)b)->date;
	if (d1 % 100 > d2 % 100)
		return 1;
	return d1 / 100 - d2 / 100;
}

int parser(photo* arr) {
	int count = 0;
	char str[1024];
	char name[24 + 1];
	char enter_string[5 + 1];
	int month, day, hour, minute, gate, all_in_one;
	bool enter;
	while (fgets(str, N, stdin) != NULL) {
		bool new_one = true;
		if (str[0] == '\n')
			break;
		sscanf(str, "%s %d:%d:%d:%d %s %d", name, &month, &day, &hour, &minute, enter_string, &gate);
		all_in_one = (minute + hour * 60 + day * 60 * 24) * 100 + month;
		enter = strcmp(enter_string, "enter") == 0 ? true : false;

		for (int i = 0; i < count; i++)
			if (strcmp(arr[i].name, name) == 0) {
				arr[i].arr[arr[i].count].date = all_in_one;
				arr[i].arr[arr[i].count].enter = enter;
				arr[i].arr[arr[i].count].gate = gate;
				new_one = false;
				arr[i].count++;
				break;
			}
		if (new_one) {
			strcpy(arr[count].name, name);
			arr[count].arr[arr[count].count].date = all_in_one;
			arr[count].arr[arr[count].count].enter = enter;
			arr[count].arr[arr[count].count].gate = gate;
			arr[count].count++;
			count++;
		}
	}
	return count;
}

int main(void) {
	int test_case;
	scanf("%d", &test_case);
	getchar();
	getchar();
	while (test_case--) {
		photo arr[N];
		for (int i = 0; i < N; i++)
			arr[i].count = 0;
		for (int i = 0; i < 24; i++)
			scanf("%d", &fees[i]);
		getchar();
		int count = parser(arr);
		qsort(arr, count, sizeof(photo), strcmp);
		for (int i = 0; i < count; i++) {
			qsort(arr[i].arr, arr[i].count, sizeof(info), compare);
			solve(&arr[i]);
		}
		printf("\n");
	}
}