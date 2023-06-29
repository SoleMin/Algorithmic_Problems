#include <stdio.h>
#include <stdlib.h>
int main() {
	int n;
	int i;
	int cnt=0;
	int arr[3000] ={0,};
	int arr1[3000] = {0,};
	int arr2[3000] ={0,};
	
	while(scanf("%d",&n)==1){
		if(n > 3000)
			break;
		for(i=0;i<n;i++){
			scanf("%d", &arr[i]);
		}
		for(i=1;i<n;i++){
			arr1[i] = abs(arr[i-1]-arr[i]);
		}
		for(i=1;i<n;i++){
			if(arr1[i]<=n-1 && arr2[arr1[i]]==0){
				arr2[arr1[i]]++;	
			}
		}
		for(i=1;i<n;i++){
			if(arr2[i]>0){
				cnt++;
			}
			else
				break;
		}
		if(cnt==n-1)
			printf("Jolly");
		else
			printf("Not jolly");
		printf("\n");
		for(i=0;i<n;i++){
			arr[i] = 0;
			arr1[i] = 0;
			arr2[i] = 0;
		}
		cnt = 0;
	}
	
	return 0;
}
