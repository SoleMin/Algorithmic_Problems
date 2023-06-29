#include <stdio.h>
#include <string.h>
#define MAXN 10000
#define NUMBERLENGTH 1000
#define ONEDIGIT 10000
typedef struct _longlong {
	unsigned int h[NUMBERLENGTH];
} longlong;
static int n, hn, h4n;
static longlong a[MAXN + 1];
void assign(longlong *a, unsigned int b){
	int i;
	for(i = 0; i < NUMBERLENGTH; i++){
		a->h[i] = b%ONEDIGIT;
		b /= ONEDIGIT;
	}
}
void add(longlong *c, const longlong *a, const longlong *b){
	int i, carry;
	carry = 0;
	for(i = 0; i < NUMBERLENGTH; i++){
		c->h[i] = a->h[i] + b->h[i] + carry;
		carry = c->h[i]/ONEDIGIT;
		c->h[i] %= ONEDIGIT;
	}
}
void print(const longlong *a){
	int sw = 0;
	int i;
	for(i = NUMBERLENGTH - 1; i >= 0; i--) {
		if(!(sw == 0 && a->h[i] == 0)) {
			if(sw == 0) {
				printf("%d", a->h[i]);
				sw = 1;
			}
			else {
				printf("%04d", a->h[i]);
			}
		}
	}
}
void count(int n){
	for(;hn <= n;hn++){
		add(&a[hn], &a[hn - 1], &a[hn-1]);
		add(&a[hn], &a[hn], &a[hn-2]);
		add(&a[hn], &a[hn], &a[hn-3]);
	}
}
int main() {
	
	while(scanf("%d", &n) != EOF){
		assign(&a[1], 2);
		assign(&a[2], 5);
		assign(&a[3], 13);
		hn = 4;
		if(n >= 4)
			count(n);
		print(&a[n]);
		printf("\n");
	}
	return 0;
}
