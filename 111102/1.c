#include <stdio.h>
#include <string.h>

#define MAXL1 10000
#define MAXL2 100
#define NUMLEN 26
#define ONEDIGIT 10000

typedef struct _ll {
	unsigned int h[NUMLEN];
}ll;

static int l1, l2;
static ll dynamic [2][MAXL1], ZERO, ONE;
static char string1[MAXL1 + 1],string2[MAXL2 + 1];

void assign(ll *a,unsigned int b)
{
	int i;
	for(i = 0; i<NUMLEN; i++)
	{
		a->h[i] = b%ONEDIGIT;
		b /= ONEDIGIT;
	}
}


void plus(ll *c, const ll *a, const ll *b)
{
	int i, carry;
	carry = 0;
	for(i=0; i<NUMLEN; i++)
	{
		c->h[i] = a->h[i] + b->h[i]+carry;
		carry = c->h[i] / ONEDIGIT;
		c->h[i] %= ONEDIGIT;
	}
}

void print(const ll *a)
{
	int sw;
	int i;
	sw = 0;
	for(i = NUMLEN -1; i >= 0; i--)
	{
		if(!(sw == 0 && a -> h[i] == 0))
		{
			if(sw == 0)
			{
				printf("%d", a -> h[i]);
				sw = 1;
			}
			else{
				printf("%04d", a -> h[i]);
			}
		}
	}
	if(sw == 0)
		printf("0");
}

void solve(void)
{
	int i, j, k;
	
	k = 0;
	if(string1[0] == string2[0])
		assign(&dynamic[0][0], 1);
	else
		assign(&dynamic[0][0], 0);
	
	for(i=1; i < l1; i++)
	{
		plus(&dynamic[0][i],&dynamic[0][i-1], &ZERO);
		if(string1[i] == string2[0])
			plus(&dynamic[0][i],&dynamic[0][i], &ONE);
	}
	
	for(i=1; i < l2; i++)
	{
		for(j=1; j < i; j++)
			assign(&dynamic[i%2][j], 0);
		for(j=i; j < l1; j++)
		{
			plus(&dynamic[i%2][j],&dynamic[i%2][j-1], &ZERO);
			if(string1[j] == string2[i])
				plus(&dynamic[i%2][j],&dynamic[i%2][j], &dynamic[(i-1)%2][j-1]);
		}
	}
}


void main(void) {
	int i, n;
	
	assign(&ZERO, 0);
	assign(&ONE, 1);
	
	scanf("%d", &n);
	for(i = 0; i < n; i++)
	{
		scanf("%s", string1);
		scanf("%s", string2);
		l1 = strlen(string1);
		l2 = strlen(string2);
		
		solve();
		
		print(&dynamic[(l2-1)%2][l1-1]);
		printf("\n");
	}
}
