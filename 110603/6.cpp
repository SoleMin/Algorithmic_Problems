#include <iostream>
using namespace std;
typedef struct _longlong {
	unsigned int n[101];
} longlong;
int cnt, input;
longlong num[10001], zero, one;

void assign(longlong* a, unsigned int b) {
	for (int i = 0; i < 101; i++) {
		a->n[i] = b % 10000;
		b /= 10000;
	}
}
void add(longlong* c, const longlong* a, const longlong* b) {
	int carry = 0;
	for (int i = 0; i < 101; i++) {
		c->n[i] = a->n[i] + b->n[i] + carry;
		carry = c->n[i] / 10000;
		c->n[i] %= 10000;
	}
}
void print(const longlong* a) {
	int sw = 0;
	for (int i = 100; i >= 0; i--) {
		if (!(sw == 0 && a->n[i] == 0)) {
			if (sw == 0) {
				printf("%d", a->n[i]);
				sw = 1;
			}
			else {
				printf("%04d", a->n[i]);
			}
		}
	}
	if (sw == 0)
		printf("0");
}
void counting(int n) {
	for (; cnt <= n; cnt++) {
		add(&num[cnt], &num[cnt - 1], &num[cnt - 1]);
		add(&num[cnt], &num[cnt], &num[cnt - 2]);
		add(&num[cnt], &num[cnt], &num[cnt - 3]);
	}
}

int main() {
	assign(&num[1], 2);
	assign(&num[2], 5);
	assign(&num[3], 13);
	cnt = 4;
	while(scanf("%d", &input) != EOF) {
		counting(input);
		print(&num[input]);
		printf("\n");
	}
} 