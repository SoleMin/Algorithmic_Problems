#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main() {
	char key[81] = {"the quick brown fox jumps over the lazy dog"};
	char n_key[81] = {"xnm ceuob lrtzv ita hegfd tsmr xnm ypwq ktj"};
	char u_key[81];
	int key_len = strlen(key);
	int test_case;
	char alpabet[26];
	char u_alpabet[26] = {"abcdefghijklmnopqrstuvwxyz"};
	char line[100][81];
	int i, j, k, t, cnt, tmp;
	scanf("%d", &test_case);
	fgets(line[0], 81, stdin);
	fgets(line[0], 81, stdin);
	while(test_case--){
		t = 0;
		for(i = 0;i < 26;i++) alpabet[i] = 0;
 		for(i = 0;i < 100;i++)
			for(j = 0;j < 81;j++)
				line[i][j] = 0;
		while(fgets(line[t], 81, stdin)){
			if(line[t][0] == '\n') break;
			t++;
		}
		cnt = 0;
		for(i = 0;i < t;i++){
			for(j = 0;j < key_len;j++){
				if(line[i][j] == ' ' && key[j] == ' ')
					cnt++;
			}	
			if(cnt == 8){
				break;
			}
			cnt = 0;
		}
		if(strncmp(line[i], key, key_len) != 0 && strncmp(line[i], n_key, key_len) != 0){
			cnt = 0;
			for(i = t - 1;i >= 0;i--){
				for(j = 0;j < key_len;j++){
					if(line[i][j] == ' ' && key[j] == ' ')
						cnt++;
				}	
				if(cnt == 8){
					break;
				}
				cnt = 0;
			}
		}
		strncpy(u_key, line[i], key_len);
		for(i = 0;i < key_len;i++){
			if(u_key[i] >= 97 && u_key[i] <= 122){
				alpabet[key[i] - 97] = u_key[i];
			}
		}
		for(i = 0;i < t;i++){
			for(j = 0;j < strlen(line[i]);j++){
				for(k = 0;k < 26;k++){
					if(line[i][j] == alpabet[k]) {line[i][j] = u_alpabet[k]; break;}
				}
			}
		}
		tmp = 0;
		for(i = 0;i < t;i++){
			if(strncmp(line[i], key, key_len) == 0) tmp++;
		}
		if(tmp == 0) printf("No solution.\n");
		else 
			for(i = 0;i < t;i++)
				printf("%s", line[i]);
		printf("\n");
	}
	return 0;
}
