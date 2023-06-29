#include <iostream>
#define MAX 10000
#define NUMLEN 12

using namespace std;

typedef struct {
	unsigned int h[NUMLEN];
}longlong;

int n, hn, h4n;
longlong hanoi[MAX+1], hanoi4[MAX+1], z, one;

void split(longlong *a, unsigned int b){
	for(int i=0; i<NUMLEN; i++){
		a->h[i] = b%MAX;
		b /= MAX;
	}
}

void add(longlong *c, longlong* a, longlong *b){
	int carry = 0;
	for(int i=0; i<NUMLEN; i++){
		c->h[i] = a->h[i] + b->h[i] + carry;
		carry = c->h[i]/MAX;
		c->h[i] %= MAX; 
	}
}

void addhanoi(int n){
	for(; hn<=n; hn++){
		add(&hanoi[hn], &hanoi[hn-1], &hanoi[hn-1]);
		add(&hanoi[hn], &hanoi[hn], &one);
	}
}

int compare(longlong *a, longlong *b){
	for(int i=NUMLEN-1; i>=0; i--){
		if(a->h[i] < b->h[i])
			return 0;
		if(a->h[i] > b->h[i])
			return 1;
	}
	return 0;
}

int main() {
	split(&z, 0);
	split(&one, 1);
	split(&hanoi[1], 1);
	split(&hanoi4[0], 0);
	split(&hanoi4[1], 1);
	hn = h4n = 2;
	while(cin >> n){
		longlong temp;
		for(; h4n<=n; h4n++){
			add(&hanoi4[h4n], &hanoi4[h4n-1], &hanoi4[h4n-1]);
			add(&hanoi4[h4n], &hanoi4[h4n], &hanoi[1]);
			for(int k=h4n-2; k>0; k--){
				addhanoi(h4n-k);
				add(&temp, &hanoi4[k], &hanoi4[k]);
				add(&temp, &temp, &hanoi[h4n-k]);
				if(compare(&hanoi4[h4n], &temp))
					add(&hanoi4[h4n], &temp, &z);
				else
					break;
			}
		}
		
		int check = 0;
		for(int i=NUMLEN-1; i>=0; i--){
			if(check != 0 || hanoi4[n].h[i] != 0){
				if(check == 0){
					cout << hanoi4[n].h[i];
					check = 1;
				}
				else{
					cout.width(4);
					cout.fill('0');
					cout << hanoi4[n].h[i];
				}
			}
		}
		if(check == 0)
			cout << 0;
		cout << endl;
	}
	return 0;
}