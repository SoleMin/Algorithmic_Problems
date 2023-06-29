#include <stdio.h>
#include <stdlib.h>

int intcompare(int *i, int *j){
	if(*i>*j)return (1);
	if(*i<*j)return (-1);
	return(0);
}

int main() {
	int n;
	int person;
	int i,j=0;
	int arr[1000]={0};
	int result=0;
	scanf("%d",&n);
	
	while(j != n){
		scanf("%d",&person);

		result=0;
		for(i=0;i<person;i++){
			scanf("%d",&arr[i]);
		}
		qsort((char*)arr, person,sizeof(int),intcompare);

	 if(person == 1 ||person == 3){
			for(i=0;i<person;i++){
				result+=arr[i];
			}
		 }
		else if(person ==2){
			result=arr[1];
		}
		else if(person%2 == 0 ){ //사람 수가 짝수일 때
			for(i=person-1;i>=3;i-=2){
				if(2*arr[1]<arr[0]+arr[i-1]){
					result+=arr[0]+arr[i]+arr[1]+arr[1];
				}
				else{
					result+=arr[0]+arr[0]+arr[i-1]+arr[i];
				}
			}
			result+=arr[1];
		}
		
		else if(person%2 == 1 ){ //사람 수가 홀수일 때
			for(i=person-1;i>=4;i-=2){
				if(2*arr[1]<arr[0]+arr[i-1]){
					result+=arr[0]+arr[i]+arr[1]+arr[1];
				}
				else{
					result+=arr[0]+arr[0]+arr[i-1]+arr[i];
				}
			}
			result+=arr[0]+arr[1]+arr[2];
		}
	

	printf("%d\n\n",result);
		j++;
	}
	
	
	return 0;
}
