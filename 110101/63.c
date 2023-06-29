#include <stdio.h>
void main() {
	long i,k, times ,big ,small , input1 , input2, temp, max_times ;
	while(scanf("%ld %ld", &small , &big) == 2){
		max_times=0;
		input1=small;
		input2=big;
		//printf("a");
		if(small>big){
			temp=big;
			big=small;
			small=temp;		
			//printf("b");
		}	
		//printf("c");
	
		for(k=small; k<=big;k++){
			
			//printf("%d", k);
			i=k;
			//printf("%d",i);
			times=1;
			while(i != 1){
				if(!(i & 1) ){
					i=i/2;	
				}
				else{
					i=i*3+1;}
			//	printf("%d",i);
				times++;	
			}
			//printf(" %d ",times);
		if(times> max_times){		
		 max_times=times;}
		}
		
	
	printf("%ld %ld %ld\n",input1, input2, max_times);
	}
	
	
}
