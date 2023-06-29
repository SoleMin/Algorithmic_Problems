#include <stdio.h>
int main(){
	int t, n, i, j, team_num, problem_num, time, tmp;
	int incor_cnt[101][10];
	int cor_cnt[101];
	int team[101];
	int tot_time[101];
	int rank[101];
	char type;
	char line[100];
	scanf("%d\n", &n);
	for(t = 0;t < n;t++){
		for(i = 0;i <= 100;i++){
			cor_cnt[i] = team[i] = tot_time[i] = 0;
			for(j = 0;j <= 9;j++)
				incor_cnt[i][j] = 0;
		}
		while(gets(line) && *line){
			sscanf(line, "%d %d %d %c", &team_num, &problem_num, &time, &type);
			team[team_num] = 1;
			if(type == 'C'){
				cor_cnt[team_num]++;
				tot_time[team_num] += time + (incor_cnt[team_num][problem_num] * 20);
			}
			else if(type == 'I'){
				incor_cnt[team_num][problem_num]++;
			}
		}
		for(i = 0;i <= 100;i++) rank[i] = i;
		for(i = 1;i < 100;i++){
			for(j = i + 1;j <= 100;j++){
				if(team[i] == 1 && team[j] == 1 && cor_cnt[i] < cor_cnt[j] || cor_cnt[i] == cor_cnt[j] && tot_time[i] > tot_time[j]){
					tmp = rank[i];
					rank[i] = rank[j];
					rank[j] = tmp;
					
					tmp = cor_cnt[i];
					cor_cnt[i] = cor_cnt[j];
					cor_cnt[j] = tmp;
							
					tmp = tot_time[i];
					tot_time[i] = tot_time[j];
					tot_time[j] = tmp;
				}
			}
		}
		for(i = 1;i <= 100;i++){
			if(team[i]){
				printf("%d %d %d\n", rank[i], cor_cnt[i], tot_time[i]);
			}
		}
		printf("\n");	
	}
	return 0;
}
