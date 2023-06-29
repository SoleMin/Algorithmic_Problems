#include <stdio.h>

int main(void) {
	int m,n;
	int i;
	int j;
	int num =1;
	char arr[101][101]={0,};
	char arr1[101][101]={0,};
	
	while(1){
		scanf("%d %d", &m,&n);
		if(m==0 && n==0){
			break;
		}
		for(i = 0;i<m;i++){
			for(j= 0;j<n+1;j++){
				arr[i][j] = getchar();
				if(arr[i][j] == '*')
					arr1[i][j] = '*';
				else
					arr1[i][j] = 48;
			}
		}
		for(i=0;i<m;i++){
			for(j=0;j<n+1;j++){
						if(arr1[i][j-1]=='*'){ 
							if(arr1[i][j]=='*')
								arr1[i][j] += 0;
							else
								arr1[i][j] += 1;
						}
						if(arr1[i][j+1]=='*'){ 
							if(arr1[i][j]=='*')
								arr1[i][j] += 0;
							else
								arr1[i][j] += 1;
						}
						if(arr1[i+1][j] =='*'){
							if(arr1[i][j]=='*')
								arr1[i][j] += 0;
							else
								arr1[i][j] +=1;
						}
						if(arr1[i+1][j-1] =='*'){
							if(arr1[i][j]=='*')
								arr1[i][j]+=0;
							else
								arr1[i][j]+=1;
						}
						if(arr1[i+1][j+1] =='*'){
							if(arr1[i][j]=='*')
								arr1[i][j]+=0;
							else
								arr1[i][j]+=1;
						}
						if(arr1[i-1][j] =='*'){
							if(arr1[i][j]=='*')
								arr1[i][j]+=0;
							else
								arr1[i][j] +=1;
						}
						if(arr1[i-1][j+1] =='*'){
							if(arr1[i][j]=='*')
								arr1[i][j]+=0;
							else
								arr1[i][j]+=1;
						}
						if(arr1[i-1][j-1] =='*'){
							if(arr1[i][j]=='*')
								arr1[i][j]+=0;
							else
								arr1[i][j]+=1;
						}
			}
		}
		printf("Field #%d:\n", num);
		if(m==1&&n==1){
			if(arr[0][0]=='.')
				printf("0");
		}
		for(i=0;i<m;i++){
			for(j=1;j<n+1;j++){
				printf("%c", arr1[i][j]);
			}
			printf("\n");
		}
		printf("\n");
		num++;
		for(i=0;i<m;i++){
			for(j=0;j<n+1;j++){
				arr[i][j] = '\0';
				arr1[i][j]='\0';
			}
		}
  }	
	return 0;
}
