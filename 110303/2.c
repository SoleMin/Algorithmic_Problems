#include <stdio.h>
#include <string.h>
int main() {
	char *alpha = "abcdefghijklmnopqrstuvwxyz";
	int alpha1[26] = {0,};
	int alpha2[26] = {0,};
	char result[1000];
	char temp[1000];
	char temp1[1000];
	int i,j,k,l;
	int len,len1;
	int Cmp;
	while(gets(temp)){
		gets(temp1);
		len = strlen(temp);
		len1 = strlen(temp1);
		for(i=0;i<len;i++){
			for(j=0;j<26;j++){
				if(temp[i] == alpha[j])
					alpha1[j]++;
			}
		}
		for(i=0;i<len1;i++){
			for(j=0;j<26;j++){
				if(temp1[i] == alpha[j])
					alpha2[j]++;
			}
		}
		k=0;
		l=0;
		for(i=0;i<26;i++){
			if(alpha1[i] > 0 && alpha2[i]>0){
				if((alpha1[i] > 1 && alpha2[i] >1)){
					if(alpha1[i] < alpha2[i])
						Cmp = alpha1[i];
					else if(alpha1[i] == alpha2[i])
						Cmp = alpha1[i];
					else
						Cmp = alpha2[i];
					while(l!=Cmp){
						result[k] = alpha[i];
						k++;
						l++;
					}
					l=0;
				}
				else{
					result[k] = alpha[i];
					k++;
				}
			}
		}
		for(i=0;i<k;i++){
			printf("%c", result[i]);
		}
		printf("\n");
		for(i=0;i<26;i++){
			alpha1[i] = 0;
			alpha2[i] = 0;
		}
		for(i=0;i<1000;i++){
			result[i] = '\0';
		}
		for(i=0;i<1000;i++){
			temp[i] = '\0';
			temp1[i] = '\0';
		}
		
	}
}
