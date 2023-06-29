#include <stdio.h>
int main() {
	int n;
	int i, j, k;
	int days, party;
	int cnt;
	int p[100];
	scanf("%d", &n);
	for(i = 0;i < n;i++){
		scanf("%d", &days);
		scanf("%d", &party);
		for(j = 0;j < party;j++)
			scanf("%d", &p[j]);
		cnt = 0;
		for(j = 1;j <= days;j++)
			if((j - 1) % 7 < 5)
				for(k = 0;k < party;k++)
					if(j % p[k] == 0){
						cnt++;
						break;
					}
		printf("%d\n", cnt);
	}
	return 0;
}
