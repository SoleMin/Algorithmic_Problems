#include <stdio.h>
#define MAX_N 10005
int main(void) {
	int a, b, c, d;
	int start, end, cas;
	int ban[MAX_N] = { };
	int i, j, n;
	int temp, tn;
	int q[MAX_N] = { }, used[MAX_N] = { }, step[MAX_N] = { }, qt;
	
	
	scanf("%d", &cas);
	
	while(cas--) {
		reset_arr(ban);
		reset_arr(q);
		reset_arr(used);
		reset_arr(step);
		scanf("%d %d %d %d", &a, &b, &c, &d);
		start = a * 1000 + b * 100 + c * 10 + d;
		scanf("%d %d %d %d", &a, &b, &c, &d);
		end = a * 1000 + b * 100 + c * 10 + d;
		scanf("%d", &n);
		
		while(n--) {
			scanf("%d %d %d %d", &a, &b, &c, &d);
			tn = a * 1000 + b * 100 + c * 10 + d;
			ban[tn] = 1;
		}
		qt = 0;
		q[qt] = start, used[start] = 1, step[start] = 1;
		
		for(i = 0; i <= qt; i++) {
			/*ㅡㅡ 금지 규칙 확인 구간 ㅡㅡ*/
			tn = q[i];
			a = tn / 1000, b = tn % 1000 / 100, c = tn % 100 / 10, d = tn % 10;
			temp = (a + 1) % 10 * 1000 + b * 100 + c * 10 + d;
			if(used[temp] == 0 && ban[temp] == 0) {
				used[temp] = 1;
				step[temp] = step[tn] + 1;
				q[++qt] = temp;
			}
			
			temp = (a + 9) % 10 * 1000 + b * 100 + c * 10 + d;
			if(used[temp] == 0 && ban[temp] == 0) {
				used[temp] = 1;
				step[temp] = step[tn] + 1;
				q[++qt] = temp;
			}
			
			temp = a * 1000 + (b + 1) % 10 * 100 + c * 10 + d;
			if(used[temp] == 0 && ban[temp] == 0) {
				used[temp] = 1;
				step[temp] = step[tn] + 1;
				q[++qt] = temp;
			}
			
			temp = a * 1000 + (b + 9) % 10 * 100 + c * 10 + d;
			if(used[temp] == 0 && ban[temp] == 0) {
				used[temp] = 1;
				step[temp] = step[tn] + 1;
				q[++qt] = temp;
			}
			
			temp = a * 1000 + b * 100 + (c + 1) % 10 * 10 + d;
			if(used[temp] == 0 && ban[temp] == 0) {
				used[temp] = 1;
				step[temp] = step[tn] + 1;
				q[++qt] = temp;
			}
			
			temp = a * 1000 + b * 100 + (c + 9) % 10 * 10 + d;
			if(used[temp] == 0 && ban[temp] == 0) {
				used[temp] = 1;
				step[temp] = step[tn] + 1;
				q[++qt] = temp;
			}
			
			temp = a * 1000 + b * 100 + c * 10 + (d + 1) % 10;
			if(used[temp] == 0 && ban[temp] == 0) {
				used[temp] = 1;
				step[temp] = step[tn] + 1;
				q[++qt] = temp;
			}
			
			temp = a * 1000 + b * 100 + c * 10 + (d + 9) % 10;
			if(used[temp] == 0 && ban[temp] == 0) {
				used[temp] = 1;
				step[temp] = step[tn] + 1;
				q[++qt] = temp;
			}
			if(used[end])
				break;
		}
		if(used[end])
			printf("%d\n", step[end] - 1);
		else
			printf("-1\n");
		
	}
	
	return 0;
}

void reset_arr(int arr[]) {
	int i;
	for(i = 0; i < MAX_N; i++) {
		arr[i] = 0;
	}
}