#include <iostream>
#include <cstdlib>
#include <cstring>

#define MAXN 10000
#define NUMBERLENGTH 12
#define ONEDIGIT 10000
using namespace std;

typedef struct _longlong {
	unsigned int h[NUMBERLENGTH];
}longlong;

static int n, hn, h4n;
static longlong hanoi[MAXN+1], hanoi4[MAXN+1], zero, one;

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
// 3개짜리 하노이탑 계산
void calchanoi(int n){
	for(;hn <= n;hn++){
		add(&hanoi[hn], &hanoi[hn-1], &hanoi[hn-1]); //
		add(&hanoi[hn], &hanoi[hn], &one);
	}
}
// 4개짜리 -> n개 중에서 k개를 hanoi4로 옮기고 n-k개를 hanoi로 옮기고 다시 k개를 hanoi4로 옮김
// 이 값이 최솟값이 나오는 k를 찾기 위해 k=h4n-2 부터 1까지 --하면서 찾음
void solve(int n){
	int k;
	longlong temp;
	for(; h4n <= n; h4n++){
		add(&hanoi4[h4n], &hanoi4[h4n-1], &hanoi4[h4n-1]);
		add(&hanoi4[h4n], &hanoi4[h4n], &hanoi[1]);
		for(k= h4n-2;k>0;k--){
			calchanoi(h4n-k);
			add(&temp, &hanoi4[k], &hanoi4[k]);
			add(&temp, &temp, &hanoi[h4n-k]);
			if(compare(&hanoi4[h4n], &temp) == 1)
				add(&hanoi4[h4n], &temp, &zero);
			else
				break;
		}
	}
}

int main() {
	char num[6];
	assign(&zero, 0);
	assign(&one, 1);
	assign(&hanoi[1], 1);
	assign(&hanoi4[0], 0);
	assign(&hanoi4[1], 1);
	hn = h4n = 2;
	for(;cin.getline(num, 6) && num[0] != EOF;){
		n = atoi(num);
		solve(n);
		
		print(&hanoi4[n]);
		cout << endl;
	}
	
	return 0;
}