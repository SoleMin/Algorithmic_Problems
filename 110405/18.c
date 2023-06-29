#include <stdio.h>
void main() {
	int testcase;
	int n[100];
  int s[100][2000];
	int t[100][2000];
	int temp[2000];
	int ans[100][2000];
	char line[2000];
	int i,j,k,tmp;
	
	//정보입력받기
	scanf("%d", &testcase);
	
	for(i=0;i<testcase;i++){
		gets(line);
		scanf("%d", &n[i]);
		for(j=0;j<n[i];j++){
			scanf("%d %d", &t[i][j], &s[i][j]);
		}
	}
	
	for(i=0;i<testcase;i++){
		for(j=0;j<n[i];j++){
			ans[i][j]=j;
			temp[j]=s[i][j]/t[i][j];
			//double[인덱스][값]
		}
		for(j=0;j<n[i];j++){
			for(k=0;k<n[i]-1;k++){
				if(temp[k]<temp[k+1]){
					tmp=temp[k];
					temp[k]=temp[k+1];
					temp[k+1]=tmp;
					tmp=ans[i][k];
					ans[i][k]=ans[i][k+1];
					ans[i][k+1]=tmp;
				}
			}
		}
	}
	
	for(i=0;i<testcase;i++){
		for(j=0;j<n[i];j++){
			printf("%d ",ans[i][j]+1);
		}
		printf("\n");
	}
}
