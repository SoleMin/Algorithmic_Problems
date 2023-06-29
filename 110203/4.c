#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int case_number=0;
	int duration=0;  //지속기간을 입력받을 변수.
	int divide=0; //정당의 수
	int* days;
	int* people;
	scanf("%d" , &case_number);  //케이스 개수를 입력받음.
	
	for(int i=0; i<case_number; i++) //케이스 개수만큼 반복진행
	{
		scanf("%d", &duration);
	  days = (int*)malloc(sizeof(int)*duration+1); //1~duration 까지   기간만큼 크기의 배열을 선언
		scanf("%d", &divide);
	  people = (int*)malloc(sizeof(int)*divide);
		
		for(int j=0; j<divide; j++)// 정당의 수 만큼의 입력
		{
			int k=1;
			scanf("%d" , &people[j]); //각 정당의 쉬는 주기를 입력,
			while(people[j]*k <= duration) //주기에 정당이 쉬는날을 입력
			{
				days[people[j]*k] = 1;
				k++;
			}
		}
		int count=0;
		for(int j=1; j<=duration; j++) if(days[j] == 1 && j%7!=6 && j%7!=0) count++;// 쉬는날을 카운트하면서 금,토요일은 제외
		printf("%d\n" , count);
	}
	free(days);
	free(people);
}