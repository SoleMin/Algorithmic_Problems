#include <stdio.h>
#define MAX 10000
#define MAXLEN 12

typedef struct _longlong{
	unsigned int num[MAXLEN];
} longlong;

static int n, hn, hn4;
static longlong hanoi[MAX+1], hanoi4[MAX+1], z, o;

void assign(longlong* a, unsigned int x){
	int i;
	for(i=0; i<MAXLEN; i++){
		a->num[i] = x%MAX;
		x /= MAX;
	}
}

void add(longlong* z, const longlong* x, const longlong* y){
	int i, cr;
	cr = 0;
	for(i=0; i<MAXLEN; i++){
		z->num[i] = x->num[i]+y->num[i]+cr;
		cr = z->num[i]/MAX;
		z->num[i] %= MAX;
	}
}

int compare(const longlong* x, const longlong* y){
	int i;
	for(i=MAXLEN-1; i>=0; i--){
		if(x->num[i] < y->num[i]){
			return -1;
		}
		if(x->num[i] > y->num[i]){
			return 1;
		}
	}
	return 0;
}

void chanoi(int n){
	for(; hn<=n; hn++){
		add(&hanoi[hn], &hanoi[hn-1], &hanoi[hn-1]);
		add(&hanoi[hn], &hanoi[hn], &o);
	}
}

void chanoi4(int n){
	int k;
	longlong temp;
	for(; hn4<=n; hn4++){
		add(&hanoi4[hn4], &hanoi4[hn4-1], &hanoi4[hn4-1]);
		add(&hanoi4[hn4], &hanoi4[hn4], &hanoi[1]);
		for(k=hn4-2; k>0; k--){
			chanoi(hn4-k);
			add(&temp, &hanoi4[k], &hanoi4[k]);
			add(&temp, &temp, &hanoi[hn4-k]);
			if(compare(&hanoi4[hn4], &temp)==1){
				add(&hanoi4[hn4], &temp, &z);
			}
			else{
				break;
			}
		}
	}
}

void print(const longlong* x){
	int i, sw;
	sw = 0;
	for(i=MAXLEN-1; i>=0; i--){
		if(!(sw==0 && x->num[i]==0)){
			if(sw==0){
				printf("%d", x->num[i]);
				sw = 1;
			}
			else{
				printf("%04d", x->num[i]);
			}
		}
	}
	if(sw==0){
		printf("0");
	}
}

int main() {
	assign(&z, 0);
	assign(&o, 1);
	assign(&hanoi[1], 1);
	assign(&hanoi4[0], 0);
	assign(&hanoi4[1], 1);
	hn = hn4 = 2;
	while(scanf("%d", &n)!=EOF){
		chanoi4(n);
		print(&hanoi4[n]);
		printf("\n");
	}
}
