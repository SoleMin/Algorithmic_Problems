#include <stdio.h>
int main() {
	int test, n, p, h[100];
	scanf("%d", &test);
	
	while (test > 0) {
		int d = 0;
		scanf("%d", &n);
		scanf("%d", &p);
		for(int i = 0; i < p; i++)
			scanf("%d", &h[i]);
		for(int i = 1; i <= n; i++)
			if(i % 7 != 0 && i % 7 != 6)
				for(int j = 0; j < p; j++)
					if(i % h[j] == 0)
					{
						d++;
						break;
					}
		test--;
		printf("%d\n", d);
	}
}
