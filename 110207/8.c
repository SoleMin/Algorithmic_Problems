#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STR 1024

typedef enum {false, true, purgatory} bool;

typedef struct {
	int time;
	bool solved;
} problem;

typedef struct {
	problem problems[9];
	int num;
} team;

int compare(const void* a, const void* b);
void reset(team* teams);

int main(void) {
	int test_case;
	scanf("%d", &test_case);
	getchar();
	getchar();
	team teams[100];
	char str[STR];
	while (test_case--) {
		reset(teams);
		while (fgets(str, STR, stdin) != NULL) {
			if (str[0] == '\n') {
				break;
			}
			int team_num, number, time;
			char type;
			sscanf(str, "%d %d %d %c", &team_num, &number, &time, &type);
			switch (type) {
				case 'C': teams[team_num - 1].problems[number - 1].solved = true; teams[team_num - 1].problems[number - 1].time += time; break;
				case 'I': if (teams[team_num - 1].problems[number - 1].solved == true)
										break;
									teams[team_num - 1].problems[number - 1].solved = purgatory;
									teams[team_num - 1].problems[number - 1].time += 20;
									break;
				default: teams[team_num - 1].problems[number - 1].solved = purgatory; break;					
			}
		}
		qsort(teams, 100, sizeof(team), compare);
		for (int i = 0; i < 100; i++) {
			int solved = 0;
			int time = 0;
			bool tried = false;
			for (int j = 0; j < 9; j++) {
				if (teams[i].problems[j].solved == true) {
					solved++;
					time += teams[i].problems[j].time;
					tried = true;
				}
				else if (teams[i].problems[j].solved == purgatory)
					tried = true;
			}
			if (tried == false)
				continue;
			printf("%d %d %d\n", teams[i].num, solved, time);
		}
		printf("\n");
	}
}

int compare(const void* a, const void* b) {
	team* ateam = (team*)a;
	team* bteam = (team*)b;
	int a_solved = 0;
	int b_solved = 0;
	int a_time = 0;
	int b_time = 0;
	for (int i = 0; i < 9; i++) {
		if (ateam->problems[i].solved == true) {
			a_solved++;
			a_time += ateam->problems[i].time;
		}
		if (bteam->problems[i].solved == true) {
			b_solved++;
			b_time += bteam->problems[i].time;
		}
	}
	if (a_solved > b_solved)
		return -1;
	if (a_solved < b_solved)
		return 1;
	if (a_time < b_time)
		return -1;
	if (a_time > b_time)
		return 1;
	return ateam->num - bteam->num;
}

void reset(team* teams) {
	for (int i = 0; i < 100; i++) {
		teams[i].num = i + 1;
		for (int j = 0; j < 9; j++) {
			teams[i].problems[j].time = 0;
			teams[i].problems[j].solved = false;
		}
	}
}