#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define MAX 5000

static int pn, sn, pos, bad, diff;
static int sticks[MAX], prev[MAX+1], now[MAX+1];

void dp() {
	int i, j;

	for (i=0; i<=sn; i++) {
		prev[i] = 0;
	}
	for (i=0; i<pn; i++) {
		pos = sn-3*(pn-1-i)-1;
		now[0] = now[1] = -1;
		for (j=2; j<=pos; j++) {
			if (prev[j-2]>-1) {
				diff = sticks[j-1] - sticks[j-2];
				bad = prev[j-2]+diff*diff;
				if (now[j-1]>bad || now[j-1]==-1) {
					now[j] = bad;
				}
				else {
					now[j] = now[j-1];
				}
			}
			else {
				now[j] = -1;
			}
		}
		now[pos+1] = now[pos];
		for (j=0; j<=pos+1; j++) {
			prev[j] = now[j];
		}
	}
}

int main() {
	int t, i;
	
	scanf("%d", &t);
	while(t--) {
		pn = sn = 0;
		scanf("%d %d", &pn, &sn);
		for (i=0; i<sn; i++) {
			scanf("%d", &sticks[i]);
		}
		pn += 8;
		dp();
		printf("%d\n", prev[sn-1]);
	}
}