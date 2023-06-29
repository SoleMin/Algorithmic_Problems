#include <stdio.h>
int main() {
	int num;
	int i,j;
	int temp =2;
	int temp2 =2;
	int arr[1000000];
	int arr1[673366];
	int md;
	arr1[1] = 1;
	arr1[2] = 3;
	arr1[3] = 5;
	for(i=4;i<673366;i++){
		temp2 = 1;
		 while(temp2<=temp){
			 md = (temp2+temp)/2;
			 if(i<=arr1[md])
				 temp = md-1;
			 else
				 temp2 = md+1;
		 }
		arr1[i] = arr1[i-1] + temp2;
		temp++;
	}
	while(scanf("%d",&num) == 1){	
		if(num == 0)
			break;
		if(num<1000000){
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 2;
			for(i=4;i<=num;i++)	
				arr[i] = 1+arr[i-arr[arr[i-1]]];	
			printf("%d\n", arr[num]);
		}
		else{
			for(i=1;i<673366;i++){
				if(num<arr1[i]){
					printf("%d\n", i);
					break;
				}
			}
		}
	}
}
