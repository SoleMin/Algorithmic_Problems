#include <stdio.h>
#include <string.h>

#define N 100

char a[N + 1], b[N + 1];
char fib[3][N + 1];
int lengtha, lengthb, length[3];
int result;

int input(void) {
	char tempa[N + 1], tempb[N + 1];
	scanf("%s", tempa);
	scanf("%s", tempb);
	
	if (tempa[0] == '0' && tempb[0] == '0')
		return 0;
	
	lengtha = strlen(tempa);
	lengthb = strlen(tempb);
	
	for (int i = 0; i < lengtha; i++)
		a[i] = tempa[lengtha - i - 1] - '0'; //MSD goes to end
	for (int i = 0; i < lengthb; i++)
		b[i] = tempb[lengthb - i - 1] - '0';
	
	return 1;
}

int compare(int fi, char* numb, int len) {
	if (length[fi] < len)
		return -1;
	if (length[fi] > len)
		return 1;
	
	for (int i = len - 1; i >= 0; i--) {
		if (fib[fi][i] < numb[i])
			return -1;
		if (fib[fi][i] > numb[i])
			return 1;
	}
	
	return 0;
}

void plus(int target, int a, int b) {
	int len = 0, carry = 0;
	for (; len < length[a] && len < length[b]; len++) {
		fib[target][len] = (fib[a][len] + fib[b][len] + carry);
		if (fib[target][len] >= 10)
			carry = 1;
		else
			carry = 0;
		fib[target][len] %= 10;
	}
	if (len < length[a]) {
		for (; len < length[a]; len++) {
			fib[target][len] = (fib[a][len] + carry);
			if (fib[target][len] >= 10)
				carry = 1;
			else
				carry = 0;
			fib[target][len] %= 10;
		}
	}
	else {
		for (; len < length[b]; len++) {
			fib[target][len] = (fib[b][len] + carry);
			if (fib[target][len] >= 10)
				carry = 1;
			else
				carry = 0;
			fib[target][len] %= 10;
		}
	}
	if (carry)
		fib[target][len++] = 1;
	
	length[target] = len;
}

int main(void) {
	int i;
	while (input()) {
		length[0] = length[1] = 1;
		fib[0][0] = fib[1][0] = 1;
		
		for (i = 1; compare(i % 3, a, lengtha) < 0; i++)
			plus((i + 1) % 3, i % 3, (i - 1) % 3);
		result = i;
		for (; compare(i % 3, b, lengthb) <= 0; i++)
			plus((i + 1) % 3, i % 3, (i - 1) % 3);
		
		result = i - result;
		printf("%d\n", result);
	}
}