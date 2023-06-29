#include <stdio.h>

int main() {
	int t;
	scanf("%d", &t);
	for(int i=0; i<t; i++){
		int n, p, cnt=0;
		int h[100], d[3651]={0};
		scanf("%d", &n);
		scanf("%d", &p);
		for(int j=0; j<p; j++){
			scanf("%d", &h[j]);
			for(int k=1; k<=n; k++){
				if(k%h[j]==0 && k%7!=0 && k%7!=6)
					d[k] = 1;
			}
		}
		for(int k=1; k<=n; k++){
			if(d[k])
				cnt++;
		}
		printf("%d\n", cnt);
	}
	
	return 0;
}
