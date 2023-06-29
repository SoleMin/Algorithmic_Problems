#include <stdio.h>
#include <string.h>

int main() {
	int case_;
	int m,n,k;
	int x_dir[8] = {-1,-1,-1,0,0,1,1,1};
	int y_dir[8] = {-1,0,1,-1,1,-1,0,1};
	char grid[52][52];
	char word[100];
	int wd_len,x,y;
	int a,b,c,d;
	int b_flag;
	scanf("%d\n",&case_);
	
	for(int c=0;c<case_;c++)
	{
		scanf("%d %d",&m,&n);
		for(int i=0;i<m;i++)
			scanf("%s",grid[i]); // 그리드 입력받기
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				if(grid[i][j]>='A' && grid[i][j]<='Z')
					grid[i][j] += 32; // tolower
		
		
		scanf("%d",&k);
		for(int i=0;i<k;i++)
		{
			b_flag=0;
			for(a=0;a<100;a++)
				word[a] = 0;
			scanf("%s",word);
			wd_len = strlen(word);
			for(a=0;a<wd_len;a++)
				if(word[a]>='A' && word[a] <='Z')
					word[a] += 32;
			for(a=0;a<m;a++)
			{
				for(b=0;b<n;b++)
				{
					if(word[0] == grid[a][b])
					{
						x = a;
						y = b;
						for(c=0;c<8;c++)
						{
							for(d=0;d<wd_len;d++)
								if(word[d] != grid[a+d*x_dir[c]][b+d*y_dir[c]])
									break;
							if(d==wd_len){
								printf("%d %d\n",a+1,b+1);
								b_flag=1;
								break;
							}
							if(b_flag)
								break;
						}
						if(b_flag)
							break;
					}
				}
			}		
		}
		printf("\n");
	}
	return 0;
}
