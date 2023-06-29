#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct
{
	int number;
	int test_final;
	int penalty_final;
	int penalty[10];
	int correct[10];
}team;

void init (team* a, int number)
{
	a->number = number;
	a->test_final = 0;
	a->penalty_final = 0;
	for (int i = 0; i < 10; i++)
		a->penalty[i] = a->correct[i] = 0;
}

void swap (team teams[], int i, int j)
{
	int testTmp, penaltyTmp, numberTmp;
	testTmp = teams[j].test_final;
	penaltyTmp = teams[j].penalty_final;
	numberTmp = teams[j].number;
	teams[j].test_final = teams[i].test_final;
	teams[j].penalty_final = teams[i].penalty_final;
	teams[j].number = teams[i].number;
	teams[i].test_final = testTmp;
	teams[i].penalty_final = penaltyTmp;
	teams[i].number = numberTmp;
}

int main(void)
{
	int testCase, teamN = 0, teamNumber, questNumber, timeSpend, teamloc = 0;
	char result, buf[30];
	team teams[100];
	scanf("%d", &testCase);
	fgets(buf, 2, stdin);
	fgets(buf, 2, stdin);
	for (int tc = 0; tc < testCase; tc++)
	{
		teamN = 0;
		//시험 입력받기
		while(fgets(buf, sizeof(buf), stdin))
		{
			if (strcmp(buf, "\n") == 0)
				break;
			sscanf(buf, "%d %d %d %c", &teamNumber, &questNumber, &timeSpend, &result);
			//team 등록
			if (teamN == 0)
			{
				init(&teams[teamN++], teamNumber);
				teamloc = 0;
			}
			else
			{
				int sameTeam = 0;
				for (int i = 0; i < teamN; i++)
					if (teamNumber == teams[i].number)
					{
						teamloc = i;
						sameTeam = 1; break;
					}
				if (sameTeam == 0)
				{
					init(&teams[teamN], teamNumber);
					teamloc = teamN++;
				}
				sameTeam = 0;
			}
			
			//문제 해결 확인
			switch(result)
			{
				case 'C':
					teams[teamloc].penalty[questNumber] += timeSpend;
					teams[teamloc].correct[questNumber] = 1;
					teams[teamloc].test_final++;
					break;
				case 'I':
					teams[teamloc].penalty[questNumber] += 20;
					break;
			}
		}
		
		//패널티 시간 합계, 최종 정렬할 배열 생성
		for (int t = 0; t < teamN; t++)
			for (int p = 1; p < 10; p++)
				if (teams[t].correct[p] == 1)
					teams[t].penalty_final += teams[t].penalty[p];
		
		//최종정렬
		int change;
		for (int i = 0; i < teamN; i++)
		{
			change = i;
			for (int j = i+1; j <teamN; j++)
				if (teams[change].test_final < teams[j].test_final)
					change = j;
			swap (teams, change, i);
		}
		for (int i = 0; i < teamN; i++)
		{
			change = i;
			for (int j = i+1; j < teamN; j++)
					if (teams[change].test_final == teams[j].test_final && teams[change].penalty_final > teams[j].penalty_final)
						change = j;
			swap (teams, change, i);
		}
		for (int i = 0; i < teamN; i++)
		{
			change = i;
			for (int j = i+1; j<teamN; j++)
				if (teams[change].test_final == teams[j].test_final && teams[change].penalty_final == teams[j].penalty_final && teams[change].number > teams[j].number)
					change = j;
			swap (teams, change, i);
		}
		
					
		//케이스 결과 출력
		for (int i = 0; i < teamN; i++)
			printf("%d %d %d\n", teams[i].number, teams[i].test_final, teams[i].penalty_final);
		printf("\n");
	}
}