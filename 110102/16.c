#include <stdio.h>

int main()
{
	int row,col,i,j,k,l,cnt;
	char line[100];
	char board[15][15];
	
	cnt = 1; //각 지뢰밭에 대한 field의 카운트 변수
	scanf("%d %d",&row, &col);
	while(1)
	{if ((row==0)&&(col==0))
		break;
		for(i=1;i<=row;i++)
			for(j=1;j<=col;j++)
				board[i][j]='0'; // 출력시킬 배열 보드를 0으로 초기화
	 
		for(i=1;i<=row;i++)
		{
			scanf("%s",line); //행단위로 문자열을 배열입력을 통해 받음
			for(j=1;j<=col;j++)
				if(line[j-1]=='*') //입력받은 문자열 배열에 지뢰가 있다면
				{
					for(k=i-1;k<=i+1;k++) //해당 행의 윗 행과 아랫행까지
						for(l=j-1;l<=j+1;l++) //해당 열의 왼쪽 열과 우측열까지
							if(board[k][l]!='*') //지뢰가 위치한곳이 아니면
								board[k][l]++; //숫자를 1 증가시킨다.
					board[i][j]='*'; //그리고 출력시킬 배열의 해당 인덱스를 *로 한다.
				}
		}
		if(cnt>1)printf("\n");
		printf("Field #%d:\n",cnt++); //while문이 반복될 때마다 cnt값이 증가하고 이를 출력함
		for(i=1;i<=row;i++)
		{
			for(j=1;j<=col;j++)
				putchar(board[i][j]);
			putchar('\n'); //보드 출력
		}
		scanf("%d %d", &row,&col);
	}
}

