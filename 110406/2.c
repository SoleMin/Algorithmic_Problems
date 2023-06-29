#include <stdio.h>
#include <string.h>
int main() {
	int test_case, cnt;
	int i, j, k, t, n;
	int cost[25];
	char tmp[100];
	char line[100];
	char name[1000][100];
	char time[1000][100];
	char word[1000][100];
	int num[1000];
	int month[1000], day[1000], hour[1000], min[1000];
	double result[1000], temp;
	char result_name[1000][100];
	scanf("%d", &test_case);
	while(test_case--){
		for(i = 1;i <= 24;i++)
			scanf("%d", &cost[i]);
		i = 0;
		fgets(line, 100, stdin);
		while(fgets(line, 100, stdin)){
			if(line[0] == '\n') break;
			sscanf(line, "%s %s %s %d", name[i], time[i], word[i], &num[i]);
			for(j = 0;j < strlen(time[i]);j++){
				if(time[i][j] == ':') time[i][j] = ' ';
			}
			sscanf(time[i], "%d %d %d %d", &month[i], &day[i], &hour[i], &min[i]);
			i++;
		}
		for(j = 0;j < i;j++) {
			for(k = 0;k < i - j - 1;k++) {
				if(day[k] > day[k + 1]) {
					temp = day[k];
					day[k] = day[k + 1];
					day[k + 1] = temp;
					
					temp = hour[k];
					hour[k] = hour[k + 1];
					hour[k + 1] = temp;
					
					temp = min[k];
					min[k] = min[k + 1];
					min[k + 1] = temp;
					
					temp = num[k];
					num[k] = num[k + 1];
					num[k + 1] = temp;
					
					strcpy(tmp, name[k]);
					strcpy(name[k], name[k + 1]);
					strcpy(name[k + 1], tmp);
					
					strcpy(tmp, word[k]);
					strcpy(word[k], word[k + 1]);
					strcpy(word[k + 1], tmp);
				}
				else if(day[k] == day[k + 1]){
					if(hour[k] > hour[k + 1]){
						temp = hour[k];
						hour[k] = hour[k + 1];
						hour[k + 1] = temp;
					
						temp = min[k];
						min[k] = min[k + 1];
						min[k + 1] = temp;
					
						temp = num[k];
						num[k] = num[k + 1];
						num[k + 1] = temp;
					
						strcpy(tmp, name[k]);
						strcpy(name[k], name[k + 1]);
						strcpy(name[k + 1], tmp);
					
						strcpy(tmp, word[k]);
						strcpy(word[k], word[k + 1]);
						strcpy(word[k + 1], tmp);
					}
					else if(hour[k] == hour[k + 1]){
						if(min[k] > min[k + 1]){
							temp = min[k];
							min[k] = min[k + 1];
							min[k + 1] = temp;
					
							temp = num[k];
							num[k] = num[k + 1];
							num[k + 1] = temp;
					
							strcpy(tmp, name[k]);
							strcpy(name[k], name[k + 1]);
							strcpy(name[k + 1], tmp);
					
							strcpy(tmp, word[k]);
							strcpy(word[k], word[k + 1]);
							strcpy(word[k + 1], tmp);
						}
					}
				}
			}
		}
		t = 0;
		for(j = 0;j < i;j++){
			if(strncmp(word[j], "enter", 5) == 0){
				cnt = 0;
				for(k = j + 1;k < i;k++){
					if(strncmp(name[k], name[j], strlen(name[k])) == 0 && strncmp(word[k], "exit", 4) == 0){cnt++; break;}
				}
				if(cnt > 0){
					if(num[k] > num[j])
						result[t] = (double)((num[k] - num[j]) * cost[hour[j] + 1] + 100);
					else
						result[t] = (double)((num[j] - num[k]) * cost[hour[j] + 1] + 100);
					result[t] = result[t] / 100;
					strcpy(result_name[t], name[j]);
					t++;
				}
			}
		}
		for(j = 0;j < t;j++){
			for(k = 0;k < t - j - 1;k++){
				if(strncmp(result_name[k], result_name[k + 1], strlen(result_name[k])) > 0){
					strcpy(tmp, result_name[k]);
					strcpy(result_name[k], result_name[k + 1]);
					strcpy(result_name[k + 1], tmp);
					
					temp = result[k];
					result[k] = result[k + 1];
					result[k + 1] = temp;
				}
			}
		}
		for(j = 0;j < t;j++){
			if(strncmp(result_name[j], result_name[j + 1], strlen(result_name[j])) == 0){
				n = 1;
				while(1){
					if(strncmp(result_name[n], result_name[n + 1], strlen(result_name[n])) == 0){
						n++;
					}	
					else
						break;
				}
				for(k = j + 1;k <= j + n;k++) result[j] += result[k];
				printf("%s $%.2f\n", result_name[j], result[j] + 2);
				j = j + n + 1;
			}
			else
				printf("%s $%.2f\n", result_name[j], result[j] + 2);
		}
		printf("\n");
	}
	return 0;
}
