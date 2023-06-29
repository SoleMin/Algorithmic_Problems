#include <stdio.h>
void main() {
	int T, N, p, temp, min;
	int h[101] = {0,};
	
	scanf("%d", &T);
	for(int i=0; i<T; i++){
		int hoilday = 0;
		scanf("%d", &N);
		scanf("%d", &p);
		for(int j=0; j<p; j++){
			scanf("%d", &h[j]);
		}
		for(int j=0; j<p-1; j++){
			min = j;
			for(int k =1; k<p-j; k++){
				if(h[min]>h[k]){
					temp = h[min];
					h[min] = h[k];
					h[k] = temp;
				}
			}
		}
		for(int k=1; k<=N; k++){
			if((k % 7) == 6 || ( k % 7) ==0)
				continue;
			else
				for(int j =0;j<p;j++){
					if((k % h[j]) == 0){
						hoilday++;
						break;
					}
				}
		}
		printf("%d\n",hoilday);
	}
	
}
