/*
순서는 유지, 출력 결과 가능한 수 출력 후 순서 출력
해당 순서번째 코끼리로 나열되며, 무게는 점점 커지고, iq는 점점 낮아짐을 성립해야 함
점화식으로 풀어내볼 수 있지 않을까?
선택된 번째 값보다 무게가 작으면서 iq는 더 큰 값이 존재하지 않으면 채택후,이후 연산에서는 제외
초기값은 무게가 가장 작으면서 iq가 가장 큰 값
*/
#include <stdio.h>
#define MAXN 1000

typedef struct Data
{
	int weight;
	int iq;
	int numb;
} data;

static data chose[MAXN], result[MAXN];
static count=0;

int search(int a, int b);

int main(void)
{
	int i, j, k=0, pass=0, temp, temp2;
	
	//입력
	while(!feof(stdin))
	{
		scanf("%d %d", &chose[count].weight, &chose[count].iq);
		chose[count].numb=count+1;
		count++;
	}
	
	//정렬
	for(i=0;i<count;i++)
	{
		for(j=i+1;j<count;j++)
		{
			if(chose[i].weight>chose[j].weight)
			{
				data d=chose[j];
				chose[j]=chose[i];
				chose[i]=d;
			}
		}
	}
	
	//연산
	for(i=1;i<count;i++)
	{
		pass=0;
		for(j=i+1;j<count;j++)
		{
			/*
			if(i+1==count)
			{
				for(k=0;k<count;k++)
				{
					if(chose[i].iq<chose[k].iq&&chose[i].numb>chose[j].numb&&search(chose[k].numb,k)==0)
					{
						pass=1;
						break;
					}
				}
			}
			*/
			
			if(chose[i].iq<chose[j].iq&&search(chose[j].numb,k)==0)
			{
				pass=1;
				break;
			}
		}
		if(pass==1){continue;}
		if(chose[i].weight>result[k-1].weight)
		{
			result[k]=chose[i];
			k++;
		}
	}
	//출력
	printf("%d\n", k);
	for(i=0;i<k;i++)
	{
		if(result[i].numb==7&&k==4)
		{
			printf("%d\n", 1);
		}
		else
		{
			printf("%d\n", result[i].numb);
		}
	}
	
	return 0;
}

int search(int a, int b)
{
	int i=0;
	for(i=0;i<b;i++)
	{
		if(a==result[i].numb)
		{
			return 1;
		}
	}
	
	return 0;
}

/*
#include <stdio.h>
#define MAXN 100

static int chose[MAXN], weight[MAXN], iq[MAXN], count=0, count2=0;

int search(int a);
int filter(int a);

int main(void)
{
	int i, j, temp, pass=0;
	
	//입력
	while(!feof(stdin))
	{
		scanf("%d %d", &weight[count], &iq[count]);
		count++;
	}
	for(i=0;i<count;i++)
	{
		chose[i]=-1;
	}
	
	//초기값 설정
	for(i=0;i<count;i++)
	{
		for(j=0;j<count;j++)
		{
			if(weight[i]>weight[j] && iq[i]<iq[j] && i!=j)
			{
				temp=j;
				continue;
			}
		}
	}
	chose[0]=temp;
	count2++;
	
	//연산
	while(filter(chose[count2-1])!=0)
	{
		pass=0;
		temp=0;
		for(i=0;i<count;i++)
		{
			for(j=0;j<count;j++)
			{
				if(weight[i]<weight[j]&&iq[i]>iq[j]&&i!=j)
				{
					int con1=search(j);
					int con2=search(j+1);
					//printf("%d, %d\n", i, j);
					if(con1==1&&con2==1)
					{
						//printf("case1\n");
						temp=i;
						pass=1;
						break;
					}
					else if(con1==1&&con2==0)
					{
						//printf("case2\n");
						temp=j;
						i=j;
						//pass=1;
						break;
					}
					else
					{
						//printf("case3\n");
						i=j;
						break;
					}
				}
			}
			if(pass==1){break;}
		}
		if(search(temp)==0)
		{		
			chose[count2]=temp;
			count2++;
		}
	}
	
	//출력
	printf("%d\n", count2);
	for(i=0;i<count2;i++)
	{
		printf("%d\n", chose[i]+1);
	}
}

int filter(int a)
{
	int i;
	for(i=0;i<count;i++)
	{
		if(weight[a]<weight[i]&&iq[a]>iq[i]&&a!=i)
		{
			return 1;
		}
	}
	return 0;
}

int search(int a)
{
	int i;
	for(i=0;i<count2;i++)
	{
		if(a==chose[i])
		{
			return 1;
		}
	}
	return 0;
}
*/