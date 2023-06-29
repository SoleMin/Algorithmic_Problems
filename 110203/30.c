#include <stdio.h>

void main(){
	int testCase,day,n,c;
	scanf("%d",&testCase);
	int count[testCase];
	for(int i=0;i<testCase;i++){
		scanf("%d",&day);
		scanf("%d",&n);
		int h[n];
		c=0;
		
		for(int j=0; j<n; j++){
			scanf("%d",&h[j]);
		}
		
		for(int j=1;j<=day;j++){
			if(j%7==6 || j%7==0){
				continue;
			}
			for(int p=0;p<n;p++){
				if(j%h[p]==0){
					c++;
					break;
				}
			}
			count[i]=c;
		}
	}
	for(int j=0;j<testCase;j++)
		printf("%d\n",count[j]);
}
