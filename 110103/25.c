#include <stdio.h>
#include <math.h>
int main() {
	while(1){
		float nums[1010]={0};
		float sum=0;
		float div;
		int	n;
		float res1=0;
		float res2=0;
		float result=0;
		
		scanf("%d",&n);
		if(n==0||n>1000) break;
		
		for(int i=0; i<n; i++){
			scanf("%f",&nums[i]);
			sum+=nums[i];
		}
		div=round(sum/n*100)/100;
		
		for(int j=0; j<n; j++){
			if(nums[j]>div) res1+=nums[j]-div;
			else res2+=div-nums[j];
		}
		if(res1<res2) result=res1;
		else result=res2;
		
		printf("$%.2f\n",result);
	}
	return 0;
}
