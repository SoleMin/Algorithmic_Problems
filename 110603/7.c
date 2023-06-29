#include <stdio.h>

#define NUMBERLENGTH 10000
#define ONEDIGIT 10000

typedef struct _longlong{
	unsigned int h[NUMBERLENGTH];
} longlong;


static	longlong result[1001]={0};

void assign(longlong *a, unsigned int b){
	int i;
	for(i=0; i<NUMBERLENGTH; i++){
		a -> h[i] = b%ONEDIGIT;
		b /= ONEDIGIT;
	}
}

void add(longlong *c, const longlong *a, const longlong *b){
	int i,carry;
	carry=0;
	for(i=0;i<NUMBERLENGTH;i++){
		c->h[i] = a->h[i] + b->h[i]+carry;
		carry= c->h[i]/ONEDIGIT;
		c->h[i] %= ONEDIGIT;
	}
	
}

void print(const longlong *a){
	int sw =0;
	int i;
	for(i = NUMBERLENGTH-1;i>=0;i--){
		if(!(sw ==0 && a->h[i]==0)){
			if(sw ==0){
				printf("%d", a->h[i]);
				sw=1;
			}
			else
				printf("%04d",a->h[i]);
		}
	}
	if(sw == 0)
		printf("0");
}

int main() {
	int n,i;
	longlong a,b;
	
	assign(&result[1],2);
	assign(&result[2],5);
	assign(&result[3],13);
	for(i=4;i<=1000;i++){
		add(&a,&result[i-1],&result[i-1]);
		
		add(&b,&result[i-2],&result[i-3]);
			add(&result[i],&a,&b);
	
	}
	
	
	while( scanf("%d", &n) != EOF){
		
		print(&result[n]);
		printf("\n");
	}
	return 0;
}
