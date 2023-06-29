#include <stdio.h>
#define abs(x) ((x)<0 ? (-(x)) : (x))
#define MAX_TEAM 100
#define MAX_PROB 9

int main() {
	int t, team_num, prob_num, time, temp;
	char line[100], judge;
	scanf("%d\n", &t);
	while(t--){
		int team[MAX_TEAM+1][4] = {0};
		int solved[MAX_TEAM+1][MAX_PROB+1] = {0};
		for(int i=1; i<=MAX_TEAM; i++){
			team[i][0] = i;
		}
		while(gets(line) && *line){
			sscanf(line, "%d %d %d %c", &team_num, &prob_num, &time, &judge);
			switch(judge){
				case 'C': team[team_num][3] = 1; if(solved[team_num][prob_num]<=0){team[team_num][2] += time+abs(solved[team_num][prob_num]); solved[team_num][prob_num] = 1;}	break;
				case 'I': team[team_num][3] = 1; if(solved[team_num][prob_num]<=0){solved[team_num][prob_num] -= 20;} break;
				default: team[team_num][3] = 1; break;
			}
		}
		for(int i=1; i<=MAX_TEAM; i++){
			for(int j=1; j<=MAX_PROB; j++){
				if(team[i][3]==1 && solved[i][j]==1)
					team[i][1]++;
			}
		}
		for(int i=1; i<=MAX_TEAM; i++){
			for(int j=i+1; j<=MAX_TEAM; j++){
				if((team[i][1]<team[j][1]) || (team[i][1]==team[j][1] && team[i][2]>team[j][2])){
					for(int k=0; k<4; k++){
						temp = team[i][k];
						team[i][k] = team[j][k];
						team[j][k] = temp;
					}
				}
			}
		}
		for(int i=1; i<=MAX_TEAM; i++){
			if(team[i][3]==0) continue;
			printf("%d %d %d\n", team[i][0], team[i][1], team[i][2]);
		}
		printf("\n");
	}
}