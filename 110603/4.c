#include <stdio.h>

#define NUMBERLENGTH 10000
#define ONEDIGIT 10000
//3번문제처럼 점화식을 사용하는거같아서 힌트를 복사합니다
typedef struct _longlong{
	unsigned int h[NUMBERLENGTH];
}longlong;

static long n;
static longlong c[1001];

void assign(longlong *a, unsigned int b){
	for(int i = 0; i < NUMBERLENGTH; i++){
		a->h[i] = b%ONEDIGIT;
		b /= ONEDIGIT;
	}
}
void add(longlong *c, const longlong *a, const longlong *b)
{
	int i, carry;
	carry = 0;
	for(i = 0; i < NUMBERLENGTH; i++){
		c->h[i] = a->h[i] + b->h[i] + carry;
		carry = c ->h[i]/ONEDIGIT;
		c->h[i] %= ONEDIGIT;
	}
}
void print(const longlong *a){
	int sw;
	sw = 0;
	for(int i = NUMBERLENGTH -1; i >= 0; i--){
		if(!(sw == 0 && a->h[i] ==0))
		{
			if(sw == 0)
			{
				printf("%d", a->h[i]);
				sw=1;
			}
			else
				printf("%04d", a->h[i]);
		}
	}
	if(sw==0)
		printf("0");
}
void solve(void){
	long i;
	longlong a,b;

	for(int i = 4; i <=1000; i++){//점화식은 c[n] = 2*c[n-1]+c[n-2]+c[n-3]이므로
		assign(&a,0);//따로 0으로 초기화한 a,b longlong  구조체 생성
		assign(&b,0);
		add(&a,&c[i-2],&c[i-3]); //a구조체안에 c[n-2]+c[n-3] 넣어준다
		add(&b,&a,&c[i-1]);// a구조체와 c[n-1]을 넣어준다
		add(&c[i],&b,&c[i-1]);// 결국 c[n]에는 2*c[n-1]+c[n-2]+c[n-3]이 들어간다.
	}
}
int main() {
	assign(&c[1], 2);
	assign(&c[2], 5);
	assign(&c[3], 13);//점화식 초기값을 넣는다.
	solve();// 바로 c에 4~1000까지 값을 다 넣는다.
	
	while(scanf("%d", &n)!= EOF)
	{
		print(&c[n]);
		printf("\n");
	}
}
