#include <stdio.h>
#include <stdlib.h>
int compare(const void* a, const void* b) {
	int num1 = *(int*)a;
	int num2 = *(int*)b;

	if (num1 == num2) return 0;
	else
		return ((num1 > num2) ? 1 : -1);
}
int main() {
	int nCase;
	int nMan,man;
	int time[1001];
	scanf("%d\n", &nCase);
	for (int i = 0; i < nCase; i++) {
		printf("\n");
		scanf("%d", &nMan);
		man = nMan;
		int sum_time = 0, j, k;
		for (j = 1; j <= nMan; j++)
			scanf("%d", &time[j]);
		qsort((void*)time, (size_t)nMan+1, sizeof(int), compare);
		while(nMan>3) {
			int t1, t2, t3, t4;
			t1 = time[1];
			t2 = time[2];
			int temp;
			for (j = man; j > 0; j--)
				if (time[j] != 0) {
					t4 = time[j], temp = j, time[j] = 0;
					break;
				}
			for (j = temp - 1; j > 0; j--)
				if (time[j] != 0) {
					t3 = time[j], time[j] = 0;
					break;
				}
			if ((2 * t2) < (t1 + t3)) {
				sum_time += 2 * t2 + t1 + t4;
			}
			else
				sum_time += 2 * t1 + t3 + t4;
			nMan -= 2;
			
		}
		if (nMan == 3) {
			for (j = man; j>0; j--)
				if(time[j] != 0 )
					break;
			sum_time += time[j]+time[1];
			time[j] = 0;
			nMan--;
		}
		for (j = man; j>0; j--)
			if(time[j] != 0){
				sum_time += time[j];
				break;
			}
		
		printf("%d\n", sum_time);
	}
	
	return 0;
}
