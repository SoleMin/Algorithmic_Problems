#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define MAX 100

static int n, len, sum, max, top;
static int dpmap[MAX*100+1][2], from[MAX*2+1][MAX*100+1][2], stack[MAX*2];

void dp(int num) {
	int i;

	for (i=n; i>=len; i--) {
		if (dpmap[i-len][0]!=-1 && sum-i+len<=n && dpmap[i][0]<num) {
			dpmap[i][0] = num;
			dpmap[i][1] = sum-i+len;
			from[num][i][0] = dpmap[i-len][0];
			from[num][i][1] = len;
			if (dpmap[max][0]<dpmap[i][0] || (dpmap[max][0]==dpmap[i][0] && abs(max-dpmap[max][1])>abs(i-dpmap[i][1]))) {
				max=i;
			}
		}
	}
}

int main() {
	int t, i;
	scanf("%d", &t);
	while(t--) {
		scanf("%d", &n);
		n *= 100;
		for (i=0; i<=n; i++) {
			dpmap[i][0] = -1;
			dpmap[i][1] = 0;
		}
		dpmap[0][0] = 0;
		sum = max = 0;
		for (i = 0; scanf("%d", &len), len!=0; i++) {
			if (sum<=2*n) {
				dp(i+1);
				sum += len;
			}
		}
		printf("%d\n", dpmap[max][0]);
		if (t>0) {
			printf("\n");
		}
	}
}