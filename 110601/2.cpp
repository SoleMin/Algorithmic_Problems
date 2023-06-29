#include <iostream>
#include <cstring>
using namespace std;

#define MAXDIGIT 100

static char a[MAXDIGIT + 1], b[MAXDIGIT + 1];
static char fib[3][MAXDIGIT+1]; // a나 b까지의 최근 계산한 피보나치 숫자가 들어갈 예정
static int lengtha, lengthb, length[3];  // length는 최근 계산한 피보나치수 3개의 길이가 들어감
static int result;

int input(){
	int i;
	char tempa[MAXDIGIT+1], tempb[MAXDIGIT+1];	
	cin >> tempa >> tempb;
	if(tempa[0] == '0' && tempb[0] == '0')
		return 0;
	lengtha = strlen(tempa);
	lengthb = strlen(tempb);
	for(i=0; i < lengtha; i++){
		a[i] = tempa[lengtha-1-i] - '0';
	}
	for(i=0; i < lengthb; i++){
		b[i] = tempb[lengthb-1-i] - '0';
	}
	return 1;
}
int compare(int fi, char *numb, int len){
	int i;
	if(length[fi] < len) return -1;
	if(length[fi] > len) return 1;
	
	for(i=len-1; i>=0;i--){
		if(fib[fi][i] < numb[i]) return -1;
		if(fib[fi][i] > numb[i]) return 1;
	}
	return 0;
}
void plus_fib(int target, int a, int b){
	int len = 0, carry = 0;
	// 일단 a, b 둘중 누가 크던지 간에 자리수 넘지않는 선까지 자리수끼리 더해줘서 10넘어가면 carry로 다음 자리수에 더해줌
	for(;len<length[a]&&len<length[b];len++){
		fib[target][len] = fib[a][len] + fib[b][len] + carry;
		if(fib[target][len]>=10){
			carry = 1;
		}
		else{
			carry = 0;
		}
		fib[target][len] = fib[target][len] % 10;
	}
	//그리고 a가 더 클 경우 나머지 부분 더해줘야됨
	if(len<length[a]){
		for(;len<length[a];len++){
			fib[target][len] = fib[a][len] + carry;
			if(fib[target][len]>=10){
				carry = 1;
			}
			else{
				carry = 0;
			}
			fib[target][len] = fib[target][len] % 10;
		}
	}
	// b가 더 클 경우도 동일
	else{
		for(;len<length[b];len++){
			fib[target][len] = fib[b][len] + carry;
			if(fib[target][len]>=10){
				carry = 1;
			}
			else{
				carry = 0;
			}
			fib[target][len] = fib[target][len] % 10;
		}
	}
	//마지막으로 캐리가 있을경우 한자리수 업해줌
	if(carry){
		fib[target][len++] = 1;
	}
	//그리고 새로 생긴 target의 길이를 갱신해줘야됨
	length[target] = len;
}

int main() {
	int i;
	for(;input();){
		length[0] = length[1] = 1;
		fib[0][0] = fib[1][0] = 1;
		for(i=1; compare(i%3, a, lengtha)<0;i++){
			plus_fib((i+1)%3, i%3, (i-1)%3);
		}
		
		result = i;
		
		for(; compare(i%3, b, lengthb)<=0;i++){
			plus_fib((i+1)%3, i%3, (i-1)%3);
		}
		result = i - result;
		cout << result << endl;
	}
	
	return 0;
}