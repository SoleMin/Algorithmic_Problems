#include <stdio.h>
#define abs(x) (x < 0) ? -(x): (x)
int main() {
	int n;
	int nhouse;
	int arr1[501]={0,};
	scanf("%d",&n);
	while(n>0){
		scanf("%d",&nhouse);
		for(int i=1;i<=nhouse;i++){
			arr1[i] = 0;
			scanf("%d",&arr1[i]);
		}
		for(int i=1;i<=nhouse-1;i++){
			for(int j=1;j<=nhouse-i-1;j++){
				if(arr1[j] > arr1[j+1]){
					int temp = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = temp;
				}
			}
		}
		int mid;
		if((nhouse%2) == 0)
			mid = nhouse/2;
		else
			mid = (nhouse+1)/2;
		int sum = 0;
		for(int i=1; i<=nhouse;i++){
			sum += abs(arr1[mid]-arr1[i]);
		}
		printf("%d\n",sum);
		
			
		n--;
	}
	return 0;
}
