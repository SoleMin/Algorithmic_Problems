#include <stdio.h>
#include <string.h>
int main() {
	int num;
	char team1[3];
	int team;
	int problem1;
	int time1;
	char c;
	int result[101][3];
	int i,j;
	char line;
	int len;
	int temp;
	int Icnt[101][10];
	int problem;
	scanf("%d\n", &num);
	
	while(num!=0){
		for(i=1;i<101;i++){
			result[i][0]=0;
			result[i][1] = 0;
			result[i][2] = 0;
			for(j=0;j<10;j++){
				Icnt[i][j] = 0;
			}
		}
		
		while(scanf("%c",&team1[0]) == 1){
			if(team1[0] == '\n')
				break;
			for(i=1;i<3;i++){
				scanf("%c", &team1[i]);
				if(team1[i]==' '){
					team1[i] = '\0';
					break;
				}
			}
			scanf("%d %d %c",&problem1, &time1, &c);
			scanf("%c", &line);
			problem = problem1;
			len = strlen(team1);
			if(len == 3)
				team = 100;
			else if(len == 2)
				team = ((team1[0]-48)*10)+(team1[1]-48);
			else
				team = team1[0]-48;
			
			result[team][0] = team;	
			if(c=='I'){
					Icnt[team][problem]++;
					time1 = 0;
			}
			else if(c=='C'){
				if(Icnt[team][problem]>0){
					time1 += 20*Icnt[team][problem];
				}
				else
					time1 +=0;
			}
			else{
				time1 = 0;
			}
			result[team][2] += time1;
			if(c=='C'){
					result[team][1]++;
			}
		}
		for(i=1;i<101;i++){
			for(j=i;j<101;j++){
				if(result[i][1]<result[j][1]){
					temp = result[i][1];
					result[i][1] = result[j][1];
					result[j][1] = temp;
					temp = result[i][0];
					result[i][0] = result[j][0];
					result[j][0] = temp;
					temp = result[i][2];
					result[i][2] = result[j][2];
					result[j][2] = temp;
				}
			}
		}
		for(i=1;i<101;i++){
			for(j=i;j<101;j++){
				if(result[i][1]==0&&result[i][2]==0){
					if(result[j][1]==0 && result[j][2]==0){
						if(result[i][0] > result[j][0]){
							temp = result[i][2];
							result[i][2] = result[j][2];
							result[j][2] = temp;
							temp = result[i][1];
							result[i][1] = result[j][1];
							result[j][1] = temp;
							temp = result[i][0];
							result[i][0] = result[j][0];
							result[j][0] = temp;
						}
					}
				}
				else if(result[i][1] == result[j][1]){
					if(result[i][2] > result[j][2]){
						temp = result[i][0];
						result[i][0] = result[j][0];
						result[j][0] = temp;
						temp = result[i][1];
						result[i][1] = result[j][1];
						result[j][1] = temp;
						temp = result[i][2];
						result[i][2] = result[j][2];
						result[j][2] = temp;
					}
				}
			}
		}
		for(i=1;i<101;i++){
			for(j=i;j<101;j++){
				if(result[i][1]>0){
					if(result[i][1] == result[j][1] && result[i][2]==result[j][2]){
						if(result[i][0]>result[j][0]){
							temp = result[i][0];
							result[i][0] = result[j][0];
							result[j][0] = temp;
							temp = result[i][1];
							result[i][1] = result[j][1];
							result[j][1] = temp;
							temp = result[i][2];
							result[i][2] = result[j][2];
							result[j][2] = temp;
						}
					}
				}
			}
		}
			for(i=1;i<101;i++){
				for(j=0;j<3;j++){
					if(result[i][0]!= 0){
						if(j==2)
							printf("%d", result[i][j]);
						else
							printf("%d ", result[i][j]);
					}
					else 
						break;
				}
				if(result[i][0]!=0)
					printf("\n");
			}
		printf("\n");
		num--;
	}
	return 0;
}
