#include <stdio.h>
#include <ctype.h>
#include <string.h>
int main() {
	char a[1000];
	int a_cnt[26];
	char b[1000];
	int b_cnt[26];
	int a_len, b_len;
	int i, j;
	char tmp[1000];
	while(scanf("%s %s", a, b) == 2){
		for(i = 0;i < 26;i++){
			a_cnt[i] = 0;
			b_cnt[i] = 0;
		}
		a_len = strlen(a);
		b_len = strlen(b);
		for(i = 0;i < a_len;i++){
			a_cnt[a[i] - 97]++;
		}
		for(i = 0;i < b_len;i++){
			b_cnt[b[i] - 97]++;
		}
		for(i = 0;i < 26;i++){
			if(a_cnt[i] > 0 && b_cnt[i] > 0){
				if(a_cnt[i] <= b_cnt[i]){
					for(j = 0;j < a_cnt[i];j++)
						printf("%c", 'a' + i);
				}
				else{
					for(j = 0;j < b_cnt[i];j++)
						printf("%c", 'a' + i);
				}
			}	
		}
		printf("\n");
	}
	return 0;
}
