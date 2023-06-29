#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int BM_StringMatcher(char t[], char p[]){
	int t_len = strlen(t);
	int p_len = strlen(p);
	int badchar[256] = { -1, };
	int i, j;
	int cnt = 0;
	int s = 0;
	int save[100] = { 0,};
	for(i = 0;i < p_len;i++)
		badchar[p[i]] = i;  
	while(s < t_len - p_len){
		j = p_len - 1;
		while(j >= 0 && t[s+j] == p[j])
			j--; 
		if(j < 0){
			save[cnt] = s + 1;
			cnt++;
			if(s < t_len - p_len) s += p_len - badchar[t[s + p_len]];
			else s += 1;
		}
		else{
			if(1 > j - badchar[t[s+j]]) s += 1;
			else s += j - badchar[t[s+j]];
		}
	}
	printf("%d\n", cnt);
	for(i = 0;i < cnt;i++) printf("%d ", save[i]);
}
int main() {
	char line[1000000];
	char word[1000000];
	int line_len, word_len;
	fgets(line, 1000000, stdin);
	line_len = strlen(line);
	line[line_len] = '\0';
	fgets(word, 1000000, stdin);
	word_len = strlen(word);
	word[word_len - 1] = '\0';
	
	BM_StringMatcher(line, word);
	return 0;
}
