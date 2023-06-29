#include <iostream>
#include <cstdlib>
#include <cstring>

#define MAXN 1000
#define NUMBERLENGTH 3000
#define ONEDIGIT 10000
using namespace std;

typedef struct _longlong {
	unsigned int h[NUMBERLENGTH];
}longlong;

static int n;
static longlong cou[MAXN+1];

void assign(longlong *a, unsigned int b){
	int i;
	// 배열 한자리에 4자리씩 저장
	for(i=0;i<NUMBERLENGTH;i++){
		a->h[i] = b%ONEDIGIT;
		b = b/ONEDIGIT;
	}
}
// 더하기
void add(longlong *c, longlong *a, longlong *b){
	int i, carry=0;
	for(i=0;i<NUMBERLENGTH;i++){
		c->h[i] = a->h[i] + b->h[i] + carry;
		carry = c->h[i] / ONEDIGIT;
		c->h[i] = c->h[i] % ONEDIGIT;
	}
}
/*
// 배열 한칸당 4자리씩 들어가 있으니 거기서 크기 비교해서 누가 더 긴지 반환
int compare(const longlong *a, const longlong *b){
	int i;
	for(i=NUMBERLENGTH-1;i>=0;i--){
		if(a->h[i]>b->h[i]){
			return 1;
		}
		else if(a->h[i]<b->h[i])
			return -1;
	}
	return 0;
}
*/

// 4자리씩 출력
void print(const longlong *a){
	int i, sw = 0;
	for(i=NUMBERLENGTH-1;i>=0;i--){
		if(!(sw==0 && a->h[i] == 0)){
			if(sw == 0){
				cout << a->h[i];
				sw = 1;
			}
			else{
				cout.width(4);
				cout.fill('0');
				cout << a->h[i];
			}
		}
	}
	if(sw == 0){ cout << 0;}
}

void solve(int num){
	for(;n<=num;n++){
		add(&cou[n], &cou[n-1], &cou[n-1]);
		add(&cou[n], &cou[n], &cou[n-2]);
		add(&cou[n], &cou[n], &cou[n-3]);
	}
}

using namespace std;
int main() {
	char input[5];
	int a;
	n=4;
	assign(&cou[1], 2);
	assign(&cou[2], 5);
	assign(&cou[3], 13);
	for(;cin.getline(input, 5);){
		a = atoi(input);
		solve(a);
		print(&cou[a]);
		cout << endl;
	}
	return 0;
}