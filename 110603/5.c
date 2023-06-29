#include <stdio.h>

#define MAXN 1000
#define NUMBERLENGTH 100
#define ONEDIGIT 10000

typedef struct _longlong {
	unsigned int h[NUMBERLENGTH];
}longlong;

static longlong arr[MAXN + 1];

void assign(longlong* a, unsigned int b) {
	int i;
	for (i = 0; i < NUMBERLENGTH; i++) {
		a->h[i] = b % ONEDIGIT;
		b /= ONEDIGIT;
	}
}
void add(longlong* c, const longlong* a, const longlong* b) {
	int i, carry;
	carry = 0;
	for (i = 0; i < NUMBERLENGTH; i++) {
		c->h[i] = a->h[i] + b->h[i] + carry;
		carry = c->h[i] / ONEDIGIT;
		c->h[i] %= ONEDIGIT;
	}
}
void print(const longlong* a) {
	int sw = 0;
	int i;
	for (i = NUMBERLENGTH - 1; i >= 0; i--) {
		if (!(sw == 0 && a->h[i] == 0)) {
			if (sw == 0) {
				printf("%d", a->h[i]);
				sw = 1;
			}
			else
				printf("%04d", a->h[i]);
		}
	}
	if (sw == 0)
		printf("0");
}

int main() {
	int n, result, i;
	
	assign(&arr[1], 2);
	assign(&arr[2], 5);
	assign(&arr[3], 13);
	for (i = 4; i <= 1000; i++) {
			add(&arr[i], &arr[i-1], &arr[i-1]);
			add(&arr[i], &arr[i], &arr[i-2]);
			add(&arr[i], &arr[i], &arr[i-3]);
	}
	
	while (scanf("%d", &n) != EOF) {
		print(&arr[n]);
		printf("\n");
	}
	return 0;
}