#include <stdio.h>

void swap(int *a, int *b){
	int temp;
	temp = a;
	a = b;
	b = temp;;
}

int main() {

	int t, n, i, j, pivot, left, right, temp, sum_dist;
	int a[500];
	int num_cases;
	
	
	scanf("%d",&num_cases);
	while(num_cases-- > 0){
		scanf("%d",&n);
		for(i=0;i<n;i++)
			scanf("%d",&(a[i]));
		
		left = 0;
		right = n - 1;
		do{
			pivot = a[left];
			i = left;
			j = right;
			while(i <= j) {
				while (i<=right && a[i] <= pivot)
					i++;
				while (j > left && a[j] >= pivot)
					j--;
				if(i<j){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp; 
				}
			}//while
				a[left] = a[j];
				a[j] = pivot;
				if (j < n / 2)
					left = j + 1;
				else
					right = j - 1;
		} while(j != n / 2);//do
		
		sum_dist = 0;
		for (i = 0; i < j; i++)
			sum_dist += (pivot - a[i]);
		for(i=j+1;i<n;i++)
			sum_dist += (a[i] - pivot);
		printf("%d\n",sum_dist);
	}
	
	return 0;
}
