#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
	char c[101];
	int i,j,m,n,a,b;
	char num[13][7] ={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	char shape[4][10]={"Clubs","Diamonds","Hearts","Spades"};
	int arr[100][55];
	int arr1[55];
	int arr2[55];

	while(scanf("%d", &m)==1)
	while(m--){
		scanf("%d",&n);
		for(i = 1;i<=n;i++){
			for(j=1;j<=52;j++){
				scanf("%d", &arr[i][j]);
			}
		}
		for(i=1;i<=52;i++){
			arr1[i] = i;
		}
		getchar();
		while(gets(c)&&c[0]){
			sscanf(c,"%d",&a);
			for(i = 1; i<=52;i++){
				arr2[i] = arr1[arr[a][i]];
			}
			for(i=1;i<=52;i++){
				arr1[i] = arr2[i];
			}
		}
		for(i =1;i<=52;i++){
			b=arr1[i]-1;
			printf("%s of %s\n", num[b%13],shape[b/13]);
		}
		if(m){
			puts("");
		}
	}
	return 0;
}

