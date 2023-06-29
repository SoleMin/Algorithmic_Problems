#include <stdio.h>
#define MAX 500

void main(void) {
	int a[MAX];
	int testcase, n;
	int left, right, i, j, pivot, temp, sum;
	
	scanf("%d", &testcase);
	while(testcase --> 0){
		scanf("%d", &n);
		for(i = 0; i < n; i++)
			scanf("%d", &(a[i]));
		
		left = 0;
		right = n-1;
		
		do{
			pivot = a[left];
			i = left;
			j = right;
			while(i <= j){
				while(i <= right && a[i] <= pivot)
					i++;
				while(j > left && a[j] >= pivot)
					j--;
				if(i < j){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			a[left] = a[j];
			a[j] = pivot;
			if(j < n/2)
				left = j+1;
			else
				right = j-1;
		}
		while(j != n/2);
		
		sum = 0;
		for(i = 0; i < j; i++)
			sum += (pivot - a[i]);
		for(i = j+1; i < n; i++)
			sum += (a[i] - pivot);
		printf("%d\n", sum);
	}
}
