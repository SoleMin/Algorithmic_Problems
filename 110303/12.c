#include <stdio.h>

int main() {
	
	int i, j, n;
	char str1[1001], str2[1001];
	int c1[128], c2[128];
	
	while(gets(str1) != NULL){
		gets(str2);

		for(i=0;i<128;i++){
			c1[i]=0;
			c2[i]=0;
		}
		
		for(i=0;str1[i];i++)
			c1[str1[i]]++;
		
		for(i=0;str2[i];i++)
			c2[str2[i]]++;
		
		
		for(i=0;i<128;i++)
			for(j=0;j < c1[i] &&  j < c2[i];j++)
				printf("%c",i);
			
		
	
		printf("\n");
		
	}//while
	
    return 0;
	
}//main