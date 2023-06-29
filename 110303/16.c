#include <stdio.h>
#include <string.h>
#define compare(x, y) ((x)<(y) ? (x):(y))

int main() {
	unsigned char str1[1000], str2[1000];
	unsigned int i, j;
	unsigned int cnt1[26], cnt2[26];
	while(gets(str1)){
		gets(str2);
		for(i=0; i<26; i++){
			cnt1[i] = cnt2[i] = 0;
		}
		for(i=0; i<strlen(str1); i++){
			cnt1[str1[i]-'a']++;
		}
		for(i=0; i<strlen(str2); i++){
			cnt2[str2[i]-'a']++;
		}
		for(i=0; i<26; i++){
			for(j=0; j<compare(cnt1[i], cnt2[i]); j++){
				if(cnt1[i]!=0 && cnt2[i]!=0){
					putchar((char)i+'a');
				}
			}
		}
		printf("\n");
	}
}
