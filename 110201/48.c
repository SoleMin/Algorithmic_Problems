#include <stdio.h>
#define max 3000
#define abs(x) ((x)<0 ? (-(x)):(x))

void main() {
	int present[max+1];//n 이 3000이면 수열의 길이는 3001이기 때문
	int apple[max+1];
	int n, i ,j, diff,jolly;
	char line[50000];
	while (scanf("%d",&n) ==1 ){
		jolly=1;
		
		for(i=1;i<=n;i++){
			present[i]=0;
			scanf("%d",&apple[i]);
		}	
			for(j=1;j<n;j++){
			diff =	abs(apple[j]-apple[j+1]);
			 if(diff<=0 || diff>=n ||present[diff] ){
				jolly=0;
					
				break;
				}	
			present[diff]=1;
			//apple[j+1]=0;
			}
		
	gets(line);
	puts(jolly? "Jolly":"Not jolly");	
	}
}
