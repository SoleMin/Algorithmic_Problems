#include <stdio.h>

void main() {
	
	int test;
	int i, j, k, n;
	char line[500];
	
	scanf("%d", &test);
	
	for(i = 0; i < test; i++) {
		gets(line);
		scanf("%d", &n);
		
		int count = n;
		
		int hu[n];
		int t1, t2;
		int time = 0;
		int temp, index;
		int min, max;
		
		for(j = 0; j < n; j++) {
			scanf("%d", &hu[j]);
		}
		
		for(j = 0; j < n; j++) 
			for(k = j+1; k < n; k++) 
				if(hu[j] > hu[k]) {
					temp = hu[j];
					hu[j] = hu[k];
					hu[k] = temp;
				}
		
		
		int f1 = hu[0];
		int f2 = hu[1];
		for(j = count; count >= 4; j -= 2) {
			int s1 = hu[j-2];
			int s2 = hu[j-1];
			
			t1 = 2*f1 + s1 + s2;
			t2 = f1 + 2*f2 + s2;
			
			if(t1 < t2)
				time += t1;
			else
				time += t2;
			
			count -= 2;
		}
		
		int f3 = hu[2];
		if(count == 3) 
			time += f1 + f2 + f3;
		else if(count == 2)
			time += f2;
		else
			time += f1;
		
		printf("%d\n\n", time);
		
	}
	
}
