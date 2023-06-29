#include <stdio.h>
#define Max 1000
static int n, ti[Max], si[Max], result[Max];
void input(void){
	int j;
	scanf("%d", &n);
		for(j = 0;j < n;j++)
			scanf("%d %d", &ti[j], &si[j]);
}
void solve(void){
	int i, j, tmp;
	for(i = 0;i < n;i++)
		result[i] = i;
	for(i = 1; i < n;i++){
		for(j = 0;j < n - i;j++){
			if(ti[result[j]] * si[result[j + 1]] > ti[result[j + 1]] * si[result[j]]){
				tmp = result[j];
				result[j] = result[j + 1];
				result[j + 1] = tmp;
			}
		}
	}
}
int main() {
	int i, j, test_case;
	scanf("%d", &test_case);
	for(i = 0;i < test_case;i++){
		scanf("%d", &n);
		for(j = 0;j < n;j++)
			scanf("%d %d", &ti[j], &si[j]);
		solve();
		if(i > 0) printf("\n");
		for(j = 0;j < n;j++)
			printf("%d ", result[j] + 1);
		printf("\n");
	}
	
	return 0;
}
