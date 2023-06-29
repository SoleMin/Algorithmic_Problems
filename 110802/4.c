#include <stdio.h>
#include <stdlib.h>

#define MAXMOVE 50
static int MAXDEPTH;
static int move[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};
static char movechar[4] = {'U' , 'R' , 'D' , 'L'};
static int solved , puzzle[4][4];
static int mtop , movestack[MAXMOVE];
int count = 0;
void back(int a, int nowx, int nowy);
	
void swap(int *x , int *y)
{
	int temp;
	
	temp = *x;
	*x = *y;
	*y = temp;
}

void input()
{
	int i , j;
	for(i=0; i<4; i++)
	{
		for(j=0; j<4; j++)
		{
			scanf("%d" , &puzzle[i][j]);
		}
	}
}

void output()
{
	int i;
	if(solved)
	{
		for(i=0; i<mtop; i++)
		{
			printf("%c" , movechar[movestack[i]]);
		}
		printf("\n");
	}
	else printf("This puzzle is not solvable.\n");
}

int cost()
{
	int i,j;
	int md1, md2;
	
	md1 = 0;
	for(i=0; i<4; i++)
	{
		for(j=0; j<4; j++)
		{
			if(puzzle[i][j]!=0)
			{
				md1+= abs(i-((puzzle[i][j]-1)/4));
			}
		}
	}
	md2=0;
	for(i=0; i<4; i++)
	{
		for(j=0; j<4; j++)
		{
			if(puzzle[i][j]!=0)
			{
				md2+= abs(j-((puzzle[i][j]-1)%4));
			}
		}
	}
	return md1+md2;
}

void solve()
{
	int i,j,k,l, value , x, y;
	value = 0;
	for(i=0; i<4; i++)
	{
		for(j=0; j<4; j++)
		{
			if(puzzle[i][j]==0)
			{
				value+=i;
				x=i;
				y=j;
			}
			for(k=i; k<4; k++)
			{
				if(k==i) l = j+1;
				else l =0;
				for(; l<4; l++)
				{
					if(puzzle[k][l]!=0 && puzzle[i][j] > puzzle[k][l]) value++;
				}
			}
		}
	}
	if(value%2==0) return;
	for(MAXDEPTH = cost(); !solved && MAXDEPTH <=MAXMOVE; MAXDEPTH+=2)
		back(0,x,y);
}

void back(int a, int nowx, int nowy)
{
	int i, c;
	int nextx , nexty;
	
	c = cost();
	if(c==0)
	{
		solved= 1;
		return;
	}
	if(a+c > MAXDEPTH) return;
	
	for(i=0; i<4; i++)
	{
		if(mtop>0 && (movestack[mtop-1]+2)%4==i) continue; //좌,우 처럼 이동에 의미가없는 것을 점프	
		
		nextx = nowx + move[i][0];
		nexty = nowy + move[i][1];	
		
		if(nextx <0 || nextx >3 || nexty <0 || nexty >3) continue;
		
		swap(&puzzle[nowx][nowy] , &puzzle[nextx][nexty]);
		movestack[mtop++] = i;
		back(a+1 , nextx, nexty); 
		if(solved) return;
		mtop--;
		swap(&puzzle[nowx][nowy] , &puzzle[nextx][nexty]);
	}
}

int main()
{
	int i, t;
	scanf("%d" , &t);
	for(i=0; i<t; i++)
	{
		input();
		mtop = 0;
		solved = 0;
		solve();
		output();
	}
}

