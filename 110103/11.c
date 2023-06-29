#include <stdio.h>
int main() {
	int student , count=0;
	float average =0;
	float real[1000] = {'\0'};//평균치를 맞추기 위해 내야하는돈 
	float money[1000] = {'\0'};//최대학생의수가 1000ㅇ므로 돈을 내는 수도 1000개가 최대
	while(scanf("%d",&student))
	{
		average=0;
		if(student==0) break; //학생의 수가 0일경우 끝
		for(int i=0; i<student; i++)
		{
			float real_money; // 실제 학생들이 낸 금액
			scanf("%f",&real_money);
			money[i]=real_money;
			average +=real_money; // 낸돈의 총합 (평균치 게산을 위함)
		}
		average = average/student;
		for(int i=0; i<student; i++)
		{
			if(money[i]>average)
			{
				int n = (money[i] - average)*100;  //1센트 단위 (소수 세째자리버림)게산을 위함
				float N = (float)(n/100.00);
				real[count] +=N;
			}
		}
		count++;
	}
	for(int i=0; i<count; i++)
	{
		printf("$%.2f\n", real[i]); 
	}
}
