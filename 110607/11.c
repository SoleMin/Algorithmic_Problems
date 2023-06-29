#include <stdio.h>

#define MAXN 1000000

int main() {
	
	int num;
	
	while(1) {
		scanf("%d", &num);
		if(num == 0)
			break;
		int seq[MAXN];
		int index = 1;
		int now = 1;
		
		seq[1] = 1;
		
		while (now < num) {
			index++;
			seq[index] = 1 + seq[index - seq[seq[index - 1]]];
			now += seq[index];
		}
		
		printf("%d\n", index);
	}
}
