#include <stdio.h>
#include <stdlib.h>

#define  MAX_NUM 1000
#define EVEN 3 // index의 짝수 홀수 결정이므로 4 - 1
#define ODD  4 // index의 짝수 홀수 결정이므로 5 - 1

int time;
void b_sort(int group[], int n);
void bridge(int group[], int key, int n);



int main(void) {
	int group[MAX_NUM] = { 0 };
	
	int cas;
	int num;
	int i, j;
	
	scanf("%d", &cas);
	while(cas--) {
		time = 0;
		scanf("%d", &num);
		for(i = 0; i < num; i++) {
			scanf("%d", group + i);
		}
		b_sort(group, num);
		bridge(group, EVEN, num);
		
		printf("\n");
	}
	
	return 0;
}

void b_sort(int group[], int n) {
	int i, j;
	int tmp;
	
	for(i = 0; i < n; i++) {
		for(j = 0; j < n - i - 1; j++) {
			if(group[j] > group[j + 1]) {
				tmp = group[j];
				group[j] = group[j + 1];
				group[j + 1] = tmp;
			}
		}
	}
}

void bridge(int group[], int key, int n) {
	int total = 0;
	int i;
	int cas1;
	int cas2;
	while(1) {
		if(n == 1) {
			total += group[0];
			break;
		} else if(n == 2) {
			total += group[1];
			break;
		} else if(n == 3) {
			total += group[0] + group[1] + group[2];
			break;
		}
		cas1 = group[0] + 2 * group[1] + group[n - 1];
		cas2 = 2 * group[0] + group[n - 1] + group[n - 2];
		if(cas1 > cas2) {
			//printf("cas1\n");
			total += group[0] + group[n - 1];
			n--;
		} else {
			//printf("cas2\n");
			total += cas1;
			n -= 2;
		}
			
	}
	
	
	printf("%d\n", total);
	
	
}



