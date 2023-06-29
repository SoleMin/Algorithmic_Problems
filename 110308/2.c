#include <stdio.h>
#include <string.h>
char temp[100][10000] = { 0,};
char copy[100][10000] = { 0,};
char all[1000000] = { 0,};
int main() {
	char line[100];
	int all_len;
	int i, j, t, cnt;
	int k;
	int pass[100] = { 0,};
	while(fgets(line, 100, stdin)){
		all_len = strlen(all);
		strcat(all, line);
	}
	all_len = strlen(all);
	for(i = 0;i < all_len;i++){
		if(all[i] == '\n' && all[i + 1] == '\n'){
			i++;
		}
		else if(all[i] == '\n' && all[i + 1] != '\n')
			all[i] = ' ';
	}
	t = 0;
	cnt = 0;
	for(i = 0;i < all_len;i++){
		if(all[i] == '\n') { t++; cnt = 0; i++;}
		else{
			temp[t][cnt] = all[i];
			cnt++;
		}
	}
	k = 0;
	for(i = 0;i <= t;i++) {
		if(strlen(temp[i]) <= 72) { strcpy(copy[k], temp[i]); k++; }
		else{
			cnt = 0;
			for(j = 0;j < strlen(temp[i]);j++){
				copy[k][cnt] = temp[i][j];
				cnt++;
				sscanf(temp[i] + j, "%s", line);
				if(strlen(line) >= 72){
					if(cnt > 1){
						k++;
						strcpy(copy[k], line);
						cnt = 0;
						j += strlen(line);
						k++;
					}
					else{
						strcpy(copy[k], line);
						k++;
						cnt = 0;
						j += strlen(line);
					}
				}
				else if(cnt == 73){
					if(temp[i][j] == ' ') { k++; cnt = 0;}
					else {
						for(j = j - 1; j > 0;j--){
							cnt--;
							if(temp[i][j] == ' '){
								copy[k][cnt - 1] = '\0';
								k++;
								cnt = 0;
								break;
							}
						}
					}
				}
			}
			k++;
		}
		if(k > 0) pass[k - 1]++;
	}
	for(i = 0;i <= k;i++){ 
		printf("%s\n", copy[i]);
		if(pass[i] == 1) printf("\n");
	}
	printf("\n");
	return 0;
}

