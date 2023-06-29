#include <stdio.h>
#include <stdlib.h>
#define MAX_N 3000

int main(void) {

	int present[MAX_N];
	int n,i,jolly;
	int pre,cur,dif;
	char line[5000];
	while(scanf("%d",&n) == 1){
	
		jolly =1;
		for(i=1;i<=n;i++)
			present[i]=0;
		scanf("%d",&pre);
		for(i=1;i<n;i++){
			scanf("%d",&cur);
			dif=abs(pre-cur);
			
			if(dif ==0 || dif >= n || present[dif] ==1){
				jolly=0;
				break;
			}
			present[dif]=1;
			pre = cur;
		}
		
		gets(line);
		puts(jolly ? "Jolly" : "Not jolly");
	}
	
	return 0;
}
