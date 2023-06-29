#include <stdio.h>

int main(){
	int n,m,num = 1;
	int arr1[101][102]={0,};
	char arr2[101][102]={0,};
	
	while(1){
		scanf("%d %d",&n,&m);
		if(n == 0 && m == 0 )
			break;
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m+1; j++)
				scanf("%c", &arr2[i][j]);
				
		for(int i=1; i<=n; i++){
			for(int j=2; j<=m+1;j++){
				if(arr2[i][j]=='*'){
					arr1[i-1][j-1]++;
					arr1[i-1][j]++;
					arr1[i-1][j+1]++;
					arr1[i][j-1]++;
					arr1[i][j+1]++;
					arr1[i+1][j-1]++;
					arr1[i+1][j]++;
					arr1[i+1][j+1]++;
				}
			}
		}
		printf("Field #%d:\n",num);
		for(int i=1; i<=n; i++){
			for(int j=2; j<=m+1; j++){
				if(arr2[i][j] == '*')
					printf("*");
				else
					printf("%d",arr1[i][j]);
			}
			printf("\n");
		}
		printf("\n");
		num++;
		for(int i=0; i<=n+1; i++)
			for(int j=0; j<=m+2; j++)
				arr1[i][j] = 0;	
	}
}