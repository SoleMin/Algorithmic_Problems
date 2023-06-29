#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define MAXD 10000
#define MAXLEN 100
#define NUMLEN 26

typedef struct _longlong {
	unsigned int num[NUMLEN];
}longlong;

static int len1, len2;
static longlong dpmap[2][MAXD], z, o;
static char s1[MAXD + 1], s2[MAXLEN + 1];

void assign(longlong* x, unsigned int y) {
	int i;
	for (i=0; i<NUMLEN; i++) {
		x->num[i] = y%MAXD;
		y /= MAXD;
	}
}

void addition(longlong* sum, const longlong* x, const longlong* y) {
	int i, cr;
	cr = 0;
	for (i=0; i<NUMLEN; i++) {
		sum->num[i] = x->num[i]+y->num[i]+cr;
		cr = sum->num[i]/MAXD;
		sum->num[i] %= MAXD;
	}
}

void printout(const longlong* x) {
	int i, p;
	p = 0;
	for (i=NUMLEN-1; i>=0; i--) {
		if (!(p==0 && x->num[i]==0)) {
			if (p==0) {
				printf("%d", x->num[i]);
				p = 1;
			}
			else {
				printf("%04d", x->num[i]);
			}
		}
	}
	if (p==0) {
		printf("0");
	}
}

int main() {
	int n, t, i, j, k;

	assign(&z, 0);
	assign(&o, 1);

	scanf("%d", &n);
	for (t=0; t<n; t++) {
		scanf("%s", s1);
		len1 = strlen(s1);
		scanf("%s", s2);
		len2 = strlen(s2);
		
		k = 0;
		if (s1[0]==s2[0]) {
			assign(&dpmap[0][0], 1);
		}
		else {
			assign(&dpmap[0][0], 0);
		}
		for (i=1; i<len1; i++) {
			addition(&dpmap[0][i], &dpmap[0][i-1], &z);
			if (s1[i]==s2[0]) {
				addition(&dpmap[0][i], &dpmap[0][i], &o);
			}
		}
		for (i=1; i<len2; i++) {
			for (j=0; j<i; j++) {
				assign(&dpmap[i%2][j], 0);
			}
			for (j=i; j<len1; j++) {
				addition(&dpmap[i%2][j], &dpmap[i%2][j-1], &z);
				if (s1[j]==s2[i]) {
					addition(&dpmap[i%2][j], &dpmap[i%2][j], &dpmap[(i-1)%2][j-1]);
				}
			}
		}
		
		printout(&dpmap[(len2-1)%2][len1-1]);
		printf("\n");
	}
}