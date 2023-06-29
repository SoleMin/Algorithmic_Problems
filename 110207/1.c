#include <stdio.h>
#define SIZE 101

int main() {
	int n;
	int id,num,time;
	int chk_id[SIZE];
	int acc_time[SIZE];
	int correct_prob[SIZE];
	int incorrect_prob[SIZE][10];
	int id_arr[SIZE];
	int tmp_id,tmp_time,tmp_prob;
	char result;
	char buff[255];
		
	scanf("%d\n",&n);
	while(n--)
	{	
		for(int i=0;i<SIZE;i++)
		{
			id_arr[i] = i;
			chk_id[i] = 0;
			acc_time[i] = 0;
			correct_prob[i] = 0;
			for(int j=0;j<10;j++)
				incorrect_prob[i][j] = 0;
		}
		while(gets(buff) && buff[0]!='\0')
		{
			sscanf(buff,"%d %d %d %c",&id,&num,&time,&result);
			chk_id[id] = 1;
			if(result == 'C')
			{
				correct_prob[id]++;
				acc_time[id]+=time+(incorrect_prob[id][num] * 20);
			}
			else if(result == 'I')
				incorrect_prob[id][num]++;	
		}
		for(int i=0;i<SIZE;i++)
			for(int j=i+1;j<SIZE;j++)
			{
				if(chk_id[i] == 1 && chk_id[j] == 1 && correct_prob[i]<correct_prob[j] || correct_prob[i] == correct_prob[j] && acc_time[i] > acc_time[j])
				{
					tmp_time = acc_time[i];
					tmp_prob = correct_prob[i];
					tmp_id = id_arr[i];
					
					correct_prob[i] = correct_prob[j];
					acc_time[i] = acc_time[j];
					id_arr[i] = id_arr[j];
					
					correct_prob[j] = tmp_prob;
					acc_time[j] = tmp_time;
					id_arr[j] = tmp_id;
				}
			}
		
		for(int i=1;i<SIZE;i++)
		{
			if(chk_id[i] == 1)
				printf("%d %d %d\n", id_arr[i],correct_prob[i],acc_time[i]);

		}
		printf("\n");
	}	
}
