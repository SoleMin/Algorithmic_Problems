#include <stdio.h>
int main() {
	char arr[101][101] = {0,};
	char field[101][101] = {0,};
	char str[10201] = {0,};
	int x=0,y=0,cnt=0,fcnt=1;
	
	while(scanf("%d %d\n",&x,&y) !=EOF)
	{
		for(int i=0;i<101;i++)
			for(int j=0;j<101;j++)
			{
				arr[i][j] = 0;
				field[i][j] = 0;
			}
		
		
		if(x==0 && y==0)
			return 0;
		for(int i=0;i<x;++i) 
		{// 필드입력
			scanf("%s",str);
			for(int j=0;j<y;++j)
			{
				arr[i][j] = str[j]; // 필드넣기
			}
		}
		for(int i=0; i<x; ++i)
		{
			for(int j=0;j<y;++j)
			{
				cnt=0;
				if(arr[i][j] == '*'){
					field[i][j] = '*';
					continue;
				}
				if(i-1>=0 && j-1>=0 && arr[i-1][j-1] == '*')
					cnt++;
				if(i-1>=0 && j>=0 && arr[i-1][j] == '*')
					cnt++;
				if(i-1>=0 && j+1<=y && arr[i-1][j+1] == '*')
					cnt++;
				if(i>=0 && j-1>=0 && arr[i][j-1] == '*')
					cnt++;
				if(i>=0 && j+1<=y && arr[i][j+1] == '*')
					cnt++;
				if(i+1<=x && j-1>=0 && arr[i+1][j-1] == '*')
					cnt++;
				if(i+1<=x && j>=0 && arr[i+1][j] == '*')
					cnt++;
				if(i+1<=x && j+1<=y && arr[i+1][j+1] == '*')
					cnt++;
				
				field[i][j] = cnt + '0';
					
				}
		}		
		printf("Field #%d:\n",fcnt++);
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
				printf("%c", field[i][j]);
			printf("\n");
		}
		printf("\n");
	}		
}

