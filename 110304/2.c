#include <stdio.h>
#include <string.h>
int main() {
	char password[100][80];
	char *key ="the quick brown fox jumps over the lazy dog";
	char key1[43];
	int num,len,len1;
	int i,j,k;
	char line;
	int temp=0;
	scanf("%d", &num);
	scanf("%c", &line);
	scanf("%c", &line);
	while(num!=0){
		for(i=0;i<100;i++){
			for(j=0;j<80;j++){
				scanf("%c", &password[i][j]);
				if(password[i][j] == '\n'){
						password[i][j] = '\0';
						break;
				}
			}
			if(password[i][0] == '\0')
				break;
		}
		for(i=0;i<100;i++){
			if(password[i][0] == '\0')
				break;
			len = strlen(password[i]);
			len1 = strlen(key);
			if(len == len1){
				for(j=0;j<44;j++){
					if(password[i][j] == ' ' && key[j] != ' ')
						break;
					if(password[i][j] == '\0' && key[j] == '\0'){
						for(k=0;k<44;k++){
							key1[k] = password[i][k];
							temp=1;
						}
					}
				}
			}
		}
	 for(i=0;i<100;i++){
		 if(password[i][0] == '\0')
			 break;
		 for(j=0;j<80;j++){
			 if(password[i][j] == '\0'){
				 break;
			 }
			 for(k=0;k<=43;k++){
				 if(password[i][j] == key1[k]){
					 password[i][j] = key[k];
					 break;
				 }
			 }
		 }
	 }
		for(i=0;i<100;i++){
			if(password[i][0] == '\0')
				break;
			len = strlen(password[i]);
			len1 = strlen(key);
			if(len == len1){
				for(j=0;j<44;j++){
					if(password[i][j] == key[j]){
						temp = 1;
					}
					else if(password[i][j] != key[j]){
						if(temp == 0)
							break;
						else{
							temp =0;
							break;
						}
					}
				}
			}
		}
		if(temp == 0){
			printf("No solution.\n");
		}
		else{
			for(i=0;i<100;i++){
				if(password[i][0] == '\0')
					break;
				for(j=0;j<80;j++){
					if(password[i][j] == '\0')
						break;
					printf("%c", password[i][j]);
				}
				printf("\n");
			}
		}
		printf("\n");
		num--;
		temp = 0;
		for(i=0;i<100;i++){
			for(j=0;j<80;j++){
				password[i][j] = '\0';
			}
		}
		for(i=0;i<43;i++){
			key1[i] = '\0';
		}
	}
	
}
