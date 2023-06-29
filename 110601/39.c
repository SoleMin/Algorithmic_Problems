#include <stdio.h>
#include <string.h>

#define MAX 100

static char a[MAX + 1], b[MAX + 1];
static char fib[3][MAX + 1];
static int lena, lenb, length[3];
static int result;

int input(void){
	int i;
	char tempa[MAX + 1], tempb[MAX + 1];
	
	scanf("%s", tempa);
	scanf("%s", tempb);
	
	if(tempa[0] == '0' && tempb[0] == '0')
		return 0;
	
	lena = strlen(tempa);
	lenb = strlen(tempb);
	
	for(i = 0; i < lena; i++)
		a[i] = tempa[lena - i - 1] - '0';
	
	for(i = 0; i < lenb; i++)
		b[i] = tempb[lenb - i - 1] - '0';
	
	return 1;
}

int compare(int fi, char *numb, int len){
	int i;
	
	if(length[fi] < len) return -1;
	if(length[fi] > len) return 1;
	
	for(i = len - 1; i >= 0; i--){
		if(fib[fi][i] < numb[i]) return -1;
		if(fib[fi][i] > numb[i]) return 1;
	}
		return 0;
 	}
	
	void plus(int target, int a, int b){
		int len = 0;
		int carry = 0;
		
		for(; len < length[a] && len < length[b]; len++){
			fib[target][len] = (fib[a][len] + fib[b][len] + carry);
			if(fib[target][len] >= 10)
				carry = 1;
			else
				carry = 0;
			fib[target][len] %= 10;
		}
		
		if(len < length[a]){
			for(; len < length[a]; len++){
				fib[target][len] = (fib[a][len] + carry);
				if(fib[target][len] >= 10)
					carry = 1;
				else
					carry = 0;
				fib[target][len] %= 10;
			}
		}
		else{
			for(; len < length[b]; len++){
				fib[target][len] = (fib[b][len] + carry);
				if(fib[target][len] >= 10)
					carry = 1;
				else
					carry = 0;
				fib[target][len] %= 10;
			}
		}
		if(carry)
			fib[target][len++] = 1;
		
		length[target] = len;
	}


int main() {
	
	int i;
	while(input()){
		length[0] = length[1] = 1;
		fib[0][0] = fib[1][0] = 1;
		
		for(i = 1; compare(i%3, a, lena) < 0; i++)
			plus((i + 1)%3, i%3, (i-1)%3);
		
		result = i;
		for(; compare(i%3, b, lenb) <= 0; i++)
			plus((i + 1)%3, i%3, (i-1)%3);
		
		result = i - result;
		printf("%d\n", result);
	}
}
