#include <stdio.h>
#include <string.h>
#include <ctype.h>
void search(char word[]);
int all_arrow(int a, int  b, char word[]);
int where(int i, int j , int a, int b, char word[]);

char board[50][50]={'\0'};
int count=0 , height , width;

void search(char word[])  //맨첫번째 알파벳을 찾는코드
{
	count=0;
	for(int a=0; a<height; a++)
	{
		for(int b=0; b<width; b++)
		{
			if(tolower(board[a][b]) == tolower(word[count]))
			{
				if(strlen(word) == 1)  //단어가 1글자인경우 출력후 종료
				{
					printf("%d %d\n", a+1 , b+1);
					return;
				}
				int value = all_arrow(a , b , word); //맨첫번째 알파벳에 대해서 그단어를 만들수있는가를 판별하는 함수로 옮김
				if(value == 1)return;
				count=0;
			}
		}
	}
	printf("\n");
}
int all_arrow(int a, int b ,char word[])
{
	
	for(int i=a-1; i<=a+1; i++)
	{
		for(int j=b-1; j<=b+1; j++)
		{
			if(i<0 || j<0 || i>height || j>width)continue; //판을 벗어나는 범위는 제외 
			if(i==a && j==b) continue; //중앙은 제외
			count=1;
			if(tolower(word[count]) == tolower(board[i][j]))  //8방향중 어떤방향으로 가야하는지 정하는 코드
			{
				if(strlen(word)==2) //단어가 2글자일경우 출력후 종료
				{
					printf("%d %d\n" , a+1 , b+1);
					return 1;
				}
				int value = where(i, j, a , b ,word);
				if(value == 2)return 1; //3글자부터는 출력후 순차적으로 함수를 종료함
			}
		}
	}
	return 0;
}

int where(int i, int j , int a, int b , char word[]) //길이가 3이상인 단어에 대해서 방향을 정해 탐색하는 코드.....
{
	count=2;
	int fail=0;
	//판을 벗어나는 범위에 대해서 모두 공백(\0)값을 가지므로 특별히 예외처리하지는 않음
	if(i==a-1 && j==b-1)//좌상단
	{
		while(count!=strlen(word))
		{
			if(tolower(word[count]) == tolower(board[--i][--j])) count++;
			else return 0;
		}
		if(count==strlen(word))
		{
			printf("%d %d\n" , a+1 , b+1);
			return 2;
		}
	}
	if(i==a-1 && j==b) // 상단
	{
		while(count!=strlen(word))
		{
			if(tolower(word[count]) == tolower(board[--i][j])) count++;
			else return 0;
		}
		if(count==strlen(word))
		{
			printf("%d %d\n" , a+1 , b+1);
			return 2;
		}
	}
	if(i==a-1 && j==b+1)//우상단
	{
		while(count!=strlen(word))
		{
			if(tolower(word[count]) == tolower(board[--i][++j])) count++;
			else return 0;
		}
		if(count == strlen(word))
		{
			printf("%d %d\n" , a+1 , b+1);
			return 2;
		}
	}
	if(i==a && j==b-1) //좌
	{
		while(count!=strlen(word))
		{
			if(tolower(word[count]) == tolower(board[i][--j])) count++;
			else  return 0;//만약같지 않은 부분이 나온다면 탐색중지
		}
		if(count == strlen(word)) 
		{
			printf("%d %d\n" , a+1,b+1);
			return 2;
		}
	}
	if(i==a && j==b+1) //우
	{
		while(count!=strlen(word))
		{
			if(tolower(word[count]) == tolower(board[i][++j])) count++;
			else return 0;
		}
		if(count == strlen(word))
		{
			printf("%d %d\n", a+1, b+1);
			return 2;
		}
	}
	if(i==a+1 && j==b-1) //좌하단
	{
		while(count!=strlen(word))
		{
			if(tolower(word[count]) == tolower(board[++i][--j])) count++;
			else return 0;
		}
		if(count == strlen(word))
		{
			printf("%d %d\n" , a+1 , b+1);
			return 2;
		}
	}
	if(i==a+1 && j==b) //하단
	{
		while(count!=strlen(word))
		{
			if(tolower(word[count]) == tolower(board[++i][j])) count++;
			else return 0;
		}
		if(count == strlen(word))
		{
			printf("%d %d\n" , a+1 , b+1);
			return 2;
		}
	}
	if(i==a+1 && j==b+1) //우하단
	{
		while(count!=strlen(word))
		{
			if(tolower(word[count]) == tolower(board[++i][++j])) count++;
			else return 0;
		}
		if(count == strlen(word))
		{
			printf("%d %d\n" , a+1 , b+1);
			return 2;
		}
	}
}


int main() 
{
	int cases , howmany;
	scanf("%d" , &cases);
	for(int a=0; a<cases; a++) //테스트 케이스의 수만큼 
	{
		char word[50]={'\0'}; //케이스마다에서 초기화를 하기위에 이위치에 선언
		scanf("%d %d" , &height , &width);
		for(int b=0; b<height; b++) scanf("%s" , board[b]);
	
		
		scanf("%d" , &howmany);
		for(int b=0; b<howmany; b++) //검색하고자하는 단어들을 입력받음
		{
			scanf("%s" , word);
			search(word);
		}
		printf("\n");
	}
}
