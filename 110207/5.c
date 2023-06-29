#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BUFSIZE 12000
#define MAX_TEAM 100

typedef struct _res {
	int team;
	int pro;
	int total;
	int choice[9];
	int solve;
} res;

int main(void) {
	int cas;
	int team, num, time, i, j;
	char L; char line[BUFSIZE];
	char* token;
	char delim[] = " ";
	res resort[MAX_TEAM];
	res tmp;
	
	fgets(line, BUFSIZE, stdin);
	cas = atoi(line);
	fgets(line, BUFSIZE, stdin);
	
	while(cas--) {
		for(i = 0; i < MAX_TEAM; i++) {
			resort[i].team = i + 1;
			resort[i].pro = 0;
			resort[i].total = 0;
			resort[i].solve = 0;
			for(j = 0; j < 9; j++)
				resort[i].choice[j] = 0;
		}
		while(fgets(line, BUFSIZE, stdin) != NULL) {
			if(line[0] == '\n') 
				break;
			
			token = strtok(line, delim);
			team = atoi(token);
			token = strtok(NULL, delim);
			num = atoi(token);
			token = strtok(NULL, delim);
			time = atoi(token);
			token = strtok(NULL, delim);
			L = token[0];
			
			if(L == 'I') {
				resort[team - 1].choice[num - 1]++;
				resort[team - 1].solve = 1;
			} else if(L == 'C') {
				resort[team - 1].pro++;
				resort[team - 1].total += time;
				resort[team - 1].solve = 1;
				if(resort[team - 1].choice[num - 1] > 0)
					for(i = 0; i < resort[team - 1].choice[num - 1]; i++)
						resort[team - 1].total += 20;
			} else if(L == 'R' || L == 'L' || L == 'E')
				resort[team - 1].solve = 1;
		} // 입력 끝
		
		for(i = 0; i < MAX_TEAM; i++) {// 문제수에 대해 정렬.
			for(j = 0; j < MAX_TEAM - 1; j++) {
				if(resort[j].pro > resort[j + 1].pro) {	// 맞힌 문제수가 많은 것으로 오름차순 정렬
					tmp = resort[j + 1];
					resort[j + 1] = resort[j];
					resort[j] = tmp;
				}
			}
		}
		
		for(i = 0; i < MAX_TEAM; i++) { // 문제수에 대해 정렬.
			for(j = 0; j < MAX_TEAM - 1; j++) {
				if(resort[j].pro == resort[j + 1].pro) { // 맞힌 문제수가 같을 때 
					if(resort[j].total < resort[j + 1].total) {   // 시간 낮은 것이 큰 수로 취급하여 오름차순 정렬 
						tmp = resort[j + 1];
						resort[j + 1] = resort[j];
						resort[j] = tmp;
					}
				}
			}
		}
		
		for(i = 0; i < MAX_TEAM; i++) { // 문제수에 대해 정렬.
			for(j = 0; j < MAX_TEAM - 1; j++) {
				if(resort[j].pro == resort[j + 1].pro) { // 맞힌 문제수가 같을 때 
					if(resort[j].total == resort[j + 1].total) { // 팀 번호가 작은 것이 큰 수로 취급하여 오름차순 정렬
						if(resort[j].team < resort[j + 1].team) {
							tmp = resort[j + 1];
							resort[j + 1] = resort[j];
							resort[j] = tmp;
						}
					}
				}
			}
		}
		for(i = MAX_TEAM - 1; i >= 0; i--) {
			// printf("%d %d %d\n", resort[i].team, resort[i].pro, resort[i].total);
			if(resort[i].solve != 0) printf("%d %d %d\n", resort[i].team, resort[i].pro, resort[i].total); 
		}
		if(cas >= 0)
			printf("\n");
	} // 끝
	
	return 0; 
}