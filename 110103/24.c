#include <stdio.h>

int main(){
	int n,std[100],sum,tmp,average,index,result;
	double money;
	
	while(1){
		scanf("%d",&n);
		if(!n) break;
		sum=0;
		result=0;
		for(int i=0;i<n;i++){
			scanf("%lf",&money);
			std[i] = (int)(money*100+0.1);
			sum+=std[i];
		}
		for(int i=0;i<n-1;i++)
			for(int j=i+1;j<n;j++)
				if(std[i]>std[j]){
					tmp=std[i];
					std[i]=std[j];
					std[j]=tmp;
				}
		average=sum/n;
		for(int i=1;i<=sum%n;i++)
			std[n-i]--;
		for(int i=0;i<n;i++)
			result+=abs(average-std[i]);
		result/=2;
		printf("$%.2lf\n",result/100.0);
	}
}