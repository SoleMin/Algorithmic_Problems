#include<stdio.h>

#define NUMBERLENGTH 5
#define ONEDIGIT 10000

typedef struct _longlong{
	int h[NUMBERLENGTH];
} longlong;

int n , k , bk[17] , selected[17] ,  mm[17], dap[8][64];
longlong sol , st , s1 , s2 , s3 , s4;
 
void assign(longlong *a, int b)
{
 for(int i=0; i < NUMBERLENGTH; i++)
 {
	 a->h[i] = b % ONEDIGIT;
	 b /= ONEDIGIT;
 }
}

void add(longlong *c, const longlong *a, const longlong *b)
{
	int i , carry;
	carry = 0;
	for(i=0; i < NUMBERLENGTH; i++)
	{
		c->h[i] = a->h[i] + b->h[i] + carry;
		carry = c->h[i]/ONEDIGIT;
		c->h[i] %= ONEDIGIT;
	}
}

void mul(longlong *c, const longlong *a, const longlong *b)
{
	int i , j, carry;
	unsigned int temp;
	int in, jn;
	longlong d;
 
	for(i=0; i < NUMBERLENGTH; i++)	d.h[i] = 0;
	in = jn = NUMBERLENGTH -1;
 
	while(a->h[in] ==0) in--;
	in++;
	while(b->h[jn] == 0)jn--;
	jn++;
	
	for(i=0;i < in+1; i++)
	{
		carry =0;
		for(j=0; j < jn+1; j++)
		{
			if(i+j < NUMBERLENGTH)
			{
				temp = (d.h[i+j] + a->h[i] * b->h[j] + carry) % ONEDIGIT;
				carry = (d.h[i+j] + a->h[i]* b->h[j] + carry) / ONEDIGIT;
				d.h[i+j] = temp;
			}
		}
	}
	for(i=0; i < NUMBERLENGTH; i++) c->h[i] = d.h[i];
}

void back(int a, int b)
{
	int i,j,l;
	if(a == -1 && b == -1)
	{
		j=0;
		for(i=0; i <= n*2; i++)
		{
			if(bk[i] == 1)
			{
				selected[j] = i;
				if(i < n) mm[j] = i+1;
				else mm[j] = n*2 - i -1;
				j++;
			}
		}
		i = 0;
		j = k - 1;
		while(i <=j)
		{
			if((n-1) - selected[i] > selected[j] - (n-1))
			{
				for( l = i +1; l <=j; l++)
				{
					if(selected[i] %2 == selected[l] %2) mm[l]--;
				}
				i++;
			}
			else
			{
				for(l=i; l < j; l++)
				{
					if(selected[j] %2 == selected[l]%2)mm[l]--;
				}
				j--;
			}
		}
		assign(&s3, 1);
		for(i=0;i <k; i++)
		{
			assign(&s1, mm[i]);
			mul(&s2, &s1, &s3);
			s3 = s2;
		}
		add(&s4, &sol, &s3);
		sol = s4; 
	}
	else
	{
		if(a >b)
		{
			bk[a] = 0;
			back(a-1, b);
		}
		bk[a] = 1;
		if(b >=0) back(a - 1, b -1);
	} 
}

void main()
{
	int size , shop;
	while(scanf("%d %d", &size, &shop) !=EOF)
	{
		if(size == 0 && shop == 0) return 0;  // 0 0 을 입력시 프로그램 종료
		for(n =1; n <= size; n++)
		{
			for(k = 1; k <=shop; k++)
			{
				assign(&sol, 0);
				if(k <= n*2) back(n*2-2, k-1); // 비숍의개수가 k일때 사이즈(n)*2 와 같거나 작을때만 연산수행 그이외는 0이기때문이다.
				dap[n-1][k-1] = (int) sol.h[1] * ONEDIGIT + (int)sol.h[0];
			}
		}
		if(size == 1 && shop ==1) printf("1\n"); // k <= n*2 조건의 예외이므로 따로 예외처리를 함
		else printf("%d\n", dap[size-1][shop-1]); // 찾고자 하는 값을 출력
	}
}