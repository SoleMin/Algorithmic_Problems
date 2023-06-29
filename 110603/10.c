#include <stdio.h>
#define MAXN 1000
#define NUMBERLENGTH 1000
#define ONEDIGIT 10000

typedef struct _longlong{
	unsigned int h[NUMBERLENGTH];
}longlong;

static long n;
static longlong c[MAXN+1],ct;

void assign(longlong *a,unsigned int b){
	int i;
	for(i=0;i<NUMBERLENGTH;i++){
		a->h[i]=b%ONEDIGIT;
		b/=ONEDIGIT;
	}
}
void add(longlong *c,const longlong *a,const longlong *b){
	int i,carry;
	carry=0;
	for(i=0;i<NUMBERLENGTH;i++){
		c->h[i]=a->h[i]+b->h[i]+carry;
		carry=c->h[i]/ONEDIGIT;
		c->h[i]%=ONEDIGIT;
	}
}
void print(const longlong*a){
	int sw=0;
	int i;
	for(i=NUMBERLENGTH-1;i>=0;i--){
		if(!(sw==0&&a->h[i]==0)){
			if(sw==0){
				printf("%d",a->h[i]);
				sw=1;
			}else{
				printf("%04d",a->h[i]);
			}
		}
	}
	if(sw==0)
		printf("0");
}
void counting(void){
	long i;
	longlong a,b;
	for(i=4;i<=MAXN;i++){
		assign(&a,0);
		assign(&b,0);
		add(&a,&c[i-1],&c[i-1]);
		add(&b,&c[i-2],&c[i-3]);
		add(&c[i],&a,&b);
	}
}
int main(void) {
	assign(&c[1],2);
	assign(&c[2],5);
	assign(&c[3],13);		
	while(scanf("%d",&n)!=EOF){
		counting();
		print(&c[n]);
		printf("\n");
	}
}
