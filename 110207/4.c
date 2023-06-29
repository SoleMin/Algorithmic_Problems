#include <stdio.h>
#include <stdlib.h>

struct team{
	int arr[10];
	int late[10];
	int fCount, fScore, submit;
};
int rank[101]={0, };
struct team teamScore[101];

void sorting(int cnt)
{
	int i, j, k, count_max;
	for(i=0; i<101; i++) rank[i]=0;
	for(k=0; k<cnt; k++){
		for(i=1; i < 101; i++)
			if(teamScore[i].submit == 1 && rank[i] ==0){
				count_max = i;
				break;
			}
		for(i=1; i<=100; i++)
		{
			if(teamScore[i].submit==0 || rank[i] != 0)
				continue;
			if(teamScore[count_max].fCount < teamScore[i].fCount)
				count_max = i;
		}
		for(i=1; i<=100; i++){
			if(rank[i] != 0) continue;
			if(teamScore[count_max].fCount == teamScore[i].fCount)
				if(teamScore[count_max].fScore > teamScore[i].fScore)
					count_max=i;
		}
		rank[count_max]=k+1;
	}
}

int main() {
	int T, i, j, l, k, team, qnum, time, cnt;
	char ch;
	char str[20];
	
	fgets(str, 10, stdin);
	T = atoi(str);
	fgets(str, 4, stdin);
	for(k=0; k<T; k++)
	{
		for(i = 0; i < 101; i++){
			for(j=0; j<10; j++){
				teamScore[i].arr[j]=0;
				teamScore[i].late[j]=0;
				teamScore[i].submit=0;
			}
			teamScore[i].fCount=0, teamScore[i].fScore=0;
		}
		
		while(fgets(str, 20, stdin)){
			if(str[0] == '\n'){
				break;
			}
			team = atoi(str);
			for(i=0; str[i] != ' '; i++);
			qnum = atoi(&str[i+1]);
			for(i=i+1; str[i] != ' '; i++);
			time = atoi(&str[i]);
			for(i = i+1; str[i] != ' '; i++);
			ch = str[i+1];
			
			if(ch=='C'){
				if(teamScore[team].arr[qnum] == 1)
					continue;
				teamScore[team].arr[qnum] = 1;
				teamScore[team].late[qnum] += time;
			}else if(ch=='I'){
				teamScore[team].late[qnum] += 20;
			}
			teamScore[team].submit = 1;
		}
		for(i=1; i<=100; i++){
			for(j=1; j<= 9; j++){
				if(teamScore[i].arr[j]){
					teamScore[i].fCount++;
					teamScore[i].fScore += teamScore[i].late[j];
				}
			}
		}
		cnt=0;
		for(i=1; i<=100; i++)
			if(teamScore[i].submit != 0)
				cnt++;
		sorting(cnt);
		for(i=0; i<cnt; i++){
			for(j=1; j<=100; j++)
				if(rank[j]==i+1){
					printf("%d %d %d\n", j, teamScore[j].fCount, teamScore[j].fScore);
					break;
				}
		}
		printf("\n");
	}
	return 0;
}
