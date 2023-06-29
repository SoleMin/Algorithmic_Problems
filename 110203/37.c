#include <stdio.h>
void main() {
	int t,n,p,i=0,j=0,k=0,f=0,lost;
	int h[100];
	
	
	 scanf("%d",&t); /*case의 겟수*/	 
	 for(i=0;i<t;i++){
		scanf("%d",&n);//총 몇일 동안 계산?
		scanf("%d",&p);//정당의 겟수?
		for(j=0;j<p;j++){
			scanf("%d", &h[j]);
		}
		lost=0;
		//printf("h[%d]=%d \n",j,h[j]);	
		for(k=1;k<=n;k++)
			if((k-1)%7<5)//금토 제외
				for(f=0;f<p;f++)
					if(k%h[f]==0){//쉬는 날 계산
						lost++;
						break;
					}
				
			
		
		printf("%d\n",lost);
	
	}
	
	
}
