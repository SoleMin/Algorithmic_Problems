//예시 답안 (힌트) 사용
#include <stdio.h>
#define MAXDEPTH 16

static int remainto[11][11]={ {0,1,1,0,1,2,3,2,3,3,3},
														 {1,2,2,0,0,1,2,3,4,4,4},
														 {0,2,3,1,1,0,1,4,5,3,5},
														 {1,1,2,2,2,0,0,3,4,2,4},
														 {0,0,1,2,3,1,1,2,3,1,3},
														 {1,0,0,1,2,2,2,1,2,2,2},
														 {0,1,1,2,3,3,3,0,1,2,3},
														 {1,2,2,3,4,4,4,0,0,1,2},
														 {0,2,3,4,5,3,5,1,1,0,1},
														 {1,1,2,3,4,2,4,2,2,0,0},
														 {0,0,1,2,3,1,3,2,3,1,1} };
static int finalstate[24]={0,3,4,3,0,5,6,5,0,1,2,1,0,7,8,7,0,9,10,9,0,1,2,1};
static int state[24], point[2], count[2], stack[MAXDEPTH], result[MAXDEPTH], rn, solveable;

int left(int base, int offset);
int right(int base, int offset);
void back(int a);

void main(void)
{
	int n,i,j;
	
	scanf("%d", &n);
	for(i=0;i<n;i++)
	{
		for(j=0;j<24;j++)
		{
			scanf("%d", &state[j]);
		}
		
		count[0]=count[1]=0;
		point[0]=0;
		point[1]=12;
		rn=MAXDEPTH+1;
		solveable=0;
		back(0);
		
		if(solveable)
		{
			if(rn==0)
			{
				printf("PUZZLE ALREADY SOLVED\n");
			}
			else
			{
				for(j=0;j<rn;j++)
				{
					printf("%d", result[j]);
				}
				printf("\n");
			}
		}
		else
		{
			printf("NO SOLUTION WAS FOUND IN %d STEPS\n", MAXDEPTH);
		}
	}
}

int left(int base, int offset)
{
	if(base<12)
	{
		base+=offset;
		if(base>=12)
		{
			base-=12;
		}
	}
	else
	{
		base+=offset;
		if(base>=24)
		{
			base-=12;
		}
	}
	
	return base;
}

int right(int base, int offset)
{
	if(base<12)
	{
		base-=offset;
		if(base<0)
		{
			base+=12;
		}
	}
	else
	{
		base-=offset;
		if(base<12)
		{
			base+=12;
		}
	}
	
	return base;
}

void back(int a)
{
	int i, j, temp1, temp2, issame, minmove;
	if(a==rn)
	{
		return;
	}
	issame=1;
	for(i=0;i<12&&issame;i++)
	{
		if(state[left(point[0], i)]!=finalstate[i])
		{
			issame=0;
		}
	}
	for(i=0;i<12&&issame;i++)
	{
		if(state[left(point[1], i)]!=finalstate[i+12])
		{
			issame=0;
		}
	}
	
	if(issame)
	{
		for(i=0;i<a;i++)
		{
			result[i]=stack[i];
		}
		rn=a;
		solveable=1;
		return;
	}
	minmove=0;
	for(i=0;i<21;i++)
	{
		temp1=state[left(point[i/12], i%12)];
		
		if(minmove<remainto[i/2][temp1])
		{
			minmove=remainto[i/2][temp1];
		}
	}
	
	if(a==MAXDEPTH||a+minmove>MAXDEPTH||a+minmove>=rn)
	{
		return;
	}
	
	for(i=1;i<=4;i++)
	{
		if(a>=rn-1)
		{
			break;
		}
		stack[a]=i;
		//printf("check1, %d\n", i);
		switch(i)
		{
				//위치가 0이면 왼쪽, 1이면 오른쪽 (count, point에 적용)
				//왼쪽일땐 시계 = 오른쪽, 반시계 = 왼쪽
				//오른쪽일땐 시계 = 왼쪽, 반시계 = 오른쪽
				//왼쪽일땐 시계방향이면 --, 반시계방향이면 ++
				//오른쪽일땐 시계방향이면 ++, 반시계방향이면 --
			case 1:		//왼쪽 시계방향
				if(count[0]>0||count[0]==-5)		//회전횟수 기억=>무의미한 회전감지
				{
					break;
				}
				point[0]=right(point[0], 2);		//왼쪽의 반대방향으로 2칸 이동
				for(j=1;j<=3;j++)
				{
					state[right(point[1], j)]=state[right(point[0], j)];		//왼쪽으로 이동된 숫자를 오른쪽에도 반영
				}
				
				temp1=count[0];
				temp2=count[1];
				count[0]--;		//왼쪽 차감
				count[1]=0;		//오른쪽은 0으로 초기화
				
				back(a+1);		//깊이를 1 늘려 다시 탐색
				//탐색 실패시
				count[0]=temp1;		//원대로로 되돌림
				count[1]=temp2;
				
				point[0]=left(point[0], 2);		//오른쪽으로 민것도 다시 왼쪽으로 되돌림
				for(j=1;j<=3;j++)
				{
					state[right(point[1], j)]=state[right(point[0], j)];		//이동은 이동대로 됐으니 다시 반영
				}
				break;
				
			case 2:		//오른쪽 시계방향 구현
				if(count[1]<0||count[1]==5)
				{
					break;
				}
				
				point[1]=left(point[1], 2);
				for(j=1;j<=3;j++)
				{
					state[right(point[0], j)]=state[right(point[1], j)];
				}
				
				temp1=count[0];
				temp2=count[1];
				count[0]=0;
				count[1]++;
				
				back(a+1);
				
				count[0]=temp1;
				count[1]=temp2;
				
				point[1]=right(point[1], 2);
				for(j=1;j<=3;j++)
				{
					state[right(point[0], j)]=state[right(point[1], j)];
				}
				break;
				
			case 3:		//왼쪽 반시계방향 구현
				if(count[0]<0||count[0]==5)
				{
					break;
				}
				
				point[0]=left(point[0], 2);
				for(j=1;j<=3;j++)
				{
					state[right(point[1], j)]=state[right(point[0], j)];
				}
				
				temp1=count[0];
				temp2=count[1];
				count[0]++;
				count[1]=0;
				
				back(a+1);
				
				count[0]=temp1;
				count[1]=temp2;
				
				point[0]=right(point[0], 2);
				for(j=1;j<=3;j++)
				{
					state[right(point[1], j)]=state[right(point[0], j)];
				}
				break;
				
			case 4:		//오른쪽 반시계방향 구현
				if(count[1]>0||count[1]==-5)
				{
					break;
				}
				
				point[1]=right(point[1], 2);
				for(j=1;j<=3;j++)
				{
					state[right(point[0], j)]=state[right(point[1], j)];
				}
				
				temp1=count[0];
				temp2=count[1];
				count[0]=0;
				count[1]--;
				
				back(a+1);
				
				count[0]=temp1;
				count[1]=temp2;
				
				point[1]=left(point[1], 2);
				for(j=1;j<=3;j++)
				{
					state[right(point[0], j)]=state[right(point[1], j)];
				}
				break;
		}
	}
}