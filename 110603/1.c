#include <stdio.h>
#define MAXN 1100
#define NUMBERLENGTH 1000
#define ONEDIGIT 10000

typedef struct _longlong {
	unsigned int h[NUMBERLENGTH];
} longlong;

static int n, hn;
static longlong num[MAXN+1];

void assign(longlong *a, unsigned int b)
{
	int i;
	for (i = 0; i < NUMBERLENGTH; i++) {
		a->h[i] = b%ONEDIGIT;
		b /= ONEDIGIT;
	}
}

void add(longlong *c, const longlong *a, const longlong *b)
{
	int i, carry;
	carry = 0;
	for (i = 0; i < NUMBERLENGTH; i++){
		c->h[i] = a->h[i] + b->h[i] + carry;
		carry = c->h[i]/ONEDIGIT;
		c->h[i] %= ONEDIGIT;
	}
}

int compare(const longlong *a, const longlong *b)
{
	int i;
	for (i = NUMBERLENGTH - 1; i >= 0; i--)
	{
	if (a->h[i] < b->h[i])
		return -1;
	if (a->h[i] > b->h[i])
		return 1;
	}
	return 0;
}

void print(const longlong *a)
{
	int sw = 0;
	int i;
	for (i = NUMBERLENGTH - 1; i >= 0; i--) {
		if (!(sw == 0 && a->h[i] == 0)) {
			if (sw == 0) {
				printf("%d", a->h[i]);
				sw = 1;
			}
			else {
				printf("%04d", a->h[i]);
				}
			}
		}
		if (sw == 0)
			printf("0");
}

void calc(int n)
{
	for(; hn <= n; hn++)
	{
		add(&num[hn], &num[hn-1], &num[hn-1]);
		add(&num[hn], &num[hn], &num[hn-2]);
		add(&num[hn], &num[hn], &num[hn-3]);
	}
}

int calc2(int n)
{
	int result = 0;
	if(n == 0)
		return 1;

	if(n >= 3)
		result += calc2(n-3);
	if(n >= 2)
		result += calc2(n-2);
	if(n >= 1)
		result += 2*calc2(n-1);

    return result;
}



int main()
{
	assign(&num[1], 2);
	assign(&num[2], 5);
	assign(&num[3], 13);
	hn =4;
	while (scanf("%d", &n) != EOF)
	{
		if(n>3)
			calc(n);
		print(&num[n]);
		printf("\n");
	}
}