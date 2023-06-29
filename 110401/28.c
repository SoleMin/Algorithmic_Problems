#include <stdio.h>
int main() {
	int r[500];
	int t, n, left, right, x, y, pivot, temp;
	scanf("%d", &t);
	while(t > 0) {
		scanf("%d", &n);
		for(int i = 0; i < n; i++)
			scanf("%d", &(r[i]));
		left = 0;
		right = n - 1;
		do {
			pivot = r[left];
			x = left;
			y = right;
			while (x <= y) {
				while (x <= right && r[x] <= pivot)
					x++;
				while(y > left && r[y] >= pivot)
					y--;
				if(x < y) {
					temp = r[x];
					r[x] = r[y];
					r[y] = temp;
				}
			}
			r[left] = r[y];
			r[y] = pivot;
			if (y < n / 2)
				left = y + 1;
			else
				right = y - 1;
		} while (y != n / 2);
		int sum = 0;
		for (int i = 0; i < y; i++)
			sum += (pivot - r[i]);
		for (int i = y + 1; i < n; i++)
			sum += (r[i] - pivot);
		printf("%d\n", sum);
		t--;
	}
	return 0;
}
