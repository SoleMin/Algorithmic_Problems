#include <stdio.h>

// 친척 집을 나타내는 정수 최대 500
#define MAX_N 500

void main(void) {

	// 값 저장
	int num[MAX_N];
	int num_case, n;
	int town, complex , i, j, pivot, temp, sum_distance;
	
	scanf("%d", &num_case);
	while(num_case-- > 0){
		scanf("%d", &n);
		for(i=0; i<n; i++)
			scanf("%d", &(num[i]));
		
		town = 0;
		complex = n-1;
		do {
			pivot = num[town];
			i = town;
			j = complex;
			while(i <= j) {
				while( i<= complex && num[i] <= pivot)
					i++;
				while( j > town && num[j] >= pivot)
					j--;
				if( i < j) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
			num[town] = num[j];
			num[j] = pivot;
			if(j< n /2)
				town =j+1;
			else
				complex = j -1;
		} while (j != n/2);
		sum_distance = 0;
		
		for(i=0; i<j; i++)
			sum_distance +=(pivot - num[i]);
		for( i= j+1; i<n; i++)
			sum_distance += (num[i] - pivot);
		printf("%d\n", sum_distance);
	}
}
