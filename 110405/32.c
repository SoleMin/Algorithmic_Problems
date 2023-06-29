#include <stdio.h>
#define MAX 1000

static int n, ti[MAX], si[MAX];
static int result[MAX];

int main(void){
	int i, j, t;
	
	scanf("%d", &t);
	for(i = 0; i < t; i++){
		input();
		solve();
		if(i > 0)
			printf("\n");
		for(j = 0; j < n-1; j++)
			printf("%d ", result[j] + 1);
		printf("%d\n", result[n-1] + 1);
	}
}
void input(void){
	int i;
	scanf("%d", &n);
	for(i = 0; i < n; i++)
		scanf("%d %d", &ti[i], &si[i]);
}
void solve(void){
	int i, j, temp;
	for(i = 0; i < n; i++)
		result[i] = i;
	
	for(i = 1; i < n; i++){
		for(j = 0; j < n-i; j++){
			if(ti[result[j]]*si[result[j+1]] > ti[result[j+1]]*si[result[j]]){
				temp = result[j];
				result[j] = result[j+1];
				result[j+1] = temp;
			}
		}
	}
}