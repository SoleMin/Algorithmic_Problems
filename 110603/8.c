#include <stdio.h>
#include <stdbool.h>
#define MAXLEN 1000
#define D 10000

typedef struct _longlong{
	unsigned int num[MAXLEN];
}longlong;

static int n;
static longlong z[MAXLEN+1], res;

void init(longlong* x, unsigned int a){
	int i;
	for(i=0; i<MAXLEN; i++){
		x->num[i] = a%D;
		a /= D;
	}
}

void add(longlong* z, const longlong* x, const longlong* y){
	int i, cr;
	cr = 0;
	for(i=0; i<MAXLEN; i++){
		z->num[i] = x->num[i]+y->num[i]+cr;
		cr = z->num[i]/D;
		z->num[i] %= D;
	}
}

void print(const longlong* x){
	int i;
	bool b = true;
	for(i=MAXLEN-1; i>=0; i--){
		if(!(b==true && x->num[i]==0)){
			if(b==true){
				printf("%d", x->num[i]);
				b = false;
			}
			else{
				printf("%04d", x->num[i]);
			}
		}
	}
	if(b==true){
		printf("0");
	}
}

int main() {
	long i;
	longlong x, y;
	init(&z[1], 2);
	init(&z[2], 5);
	init(&z[3], 13);
	for(i=4; i<=1000; i++){
		init(&x, 0);
		init(&y, 0);
		add(&x, &z[i-2], &z[i-3]);
		add(&y, &x, &z[i-1]);
		add(&z[i], &y, &z[i-1]);
	}
	while(scanf("%d", &n)!=EOF){
		res = z[n];
		print(&z[n]);
		printf("\n");
	}
}