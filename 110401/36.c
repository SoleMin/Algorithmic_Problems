#include <stdio.h>
#define MAX 500
int main() {
	
	int a[MAX];
	int left, right, i, j ,pivot, temp, sum_dist;
	
	int num_case, n;
	scanf("%d", &num_case);
	while(num_case --> 0)
	{
		scanf("%d", &n);
		for(i=0; i<n; i++)
			scanf("%d", &(a[i]));
		
		left = 0;
		right = n-1;
		do
		{
			pivot = a[left];
			i = left;
			j = right;
			while(i<=j)
			{
				while((i <= right) && (a[i] <= pivot)) i++;
				while((j > left) && (a[i] >= pivot)) j--;
				if(i < j)
				{
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			a[left] = a[j];
			a[j] = pivot;
			if(j < n/2) left = j+1;
			else
				right = j-1;
		} while(j!= n/2);
		
		sum_dist = 0;
		for(i=0; i<j; i++) 
			sum_dist += (pivot-a[i]);
		for(i=j; i<n; i++)
			sum_dist += (a[i]-pivot);
		printf("%d\n", sum_dist);
		
	}
	
	return 0;
}
