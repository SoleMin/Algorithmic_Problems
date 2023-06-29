#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

static int n, k, board;
static bool* tracked;
static long res, sum;

void bt(int point, int k_num) {
	int i, black, white, temp;
	if (point==board) {
		if (k_num!=0) {
			return;
		}
		sum = 1;
		black = white = 0;
		for (i=0; i<board; ++i) {
			if (tracked[i]) {
				temp = i >> 1;
				sum *= temp+1-(temp%2==1 ? black++ : white++);
			}
		}
		res += sum;
	}
	else {
		tracked[point] = true;
		bt(point+1, k_num-1);
		tracked[point] = false;
		bt(point+1, k_num);
	}
}

int main() {
	while (true) {
		scanf("%d %d", &n, &k);
		if (n==0 && k==0) {
			break;
		}
		board = (n<<1)-1;
		tracked = (bool*)malloc(sizeof(bool)*board);
		res = 0;
		bt(0, k);
		printf("%ld\n", res);
	}
	free(tracked);
}