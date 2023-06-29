#include <stdio.h>
#include <string.h>
#define MAX 1000

void findMin(int a_count[], int b_count[], int ab_min[]){
	int min = 0;
	for(int i = 'a'; i <= 'z'; i++){
		if(a_count[i] <= b_count[i])
			min = a_count[i];
		else
			min = b_count[i];
		ab_min[i] = min;
	}
}
int main() {
	char  a[MAX+1];
	char  b[MAX+1];
	int len;
	while(fgets(a,sizeof(a),stdin)!= NULL){
		fgets(b,sizeof(b),stdin);
		int a_count[256] = {0};
		int b_count[256] = {0};
		int ab_min[256] = {0};
		len = strlen(a);
		for(int i = 0; i < len; i++){
			a_count[a[i]]++;
		}
		len = strlen(b);
		for(int i = 0; i < len; i++){
			b_count[b[i]]++;
		}
		findMin(a_count,b_count,ab_min);
		for(int i = 'a'; i <= 'z'; i++){
			for(int j = 0; j < ab_min[i]; j++)
				printf("%c",i);
		}
		putchar('\n');
	}

}
