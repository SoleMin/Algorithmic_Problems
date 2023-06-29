#include <stdio.h>
#include <stdbool.h>
#define MAX 100

int main(){
	bool mine[MAX+2][MAX+2]={false,};
	char line[MAX];
	char result[MAX][MAX]={'\0'};
	int n,m,count,tmp=1;
	
	while(1){
		for(int i=0;i<MAX+2;i++)
			for(int j=0;j<MAX+2;j++)
				mine[i][j]=false;
		scanf("%d %d",&n,&m);
		if(!n && !m) break;
		for(int i=0; i<n; i++){
			fgets(line,m+1,stdin);
			fgets(line,m+1,stdin);
			for(int j=0;j<m;j++)
				if(line[j]=='*') mine[i+1][j+1]=true;
				else mine[i+1][j+1]=false;
		}

		printf("Field #%d:\n",tmp++);
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				count = 0;
				if(mine[i+1][j+1]) result[i][j]='*';
				else{ 
					for(int a=-1;a<2;a++) 
						for(int b=-1;b<2;b++) 
							if(mine[i+a+1][j+b+1]) 
								count++;
					result[i][j]=count+'0';
				}
				printf("%c",result[i][j]);	
			}
			printf("\n");
		}
		printf("\n");
	}
	return 0;
}