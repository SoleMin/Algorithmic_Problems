#include <stdio.h>
#include <string.h>

int main() {
	char Dic[25143][16];
	char word[2][16];
	char result1[25143][16];  
	int graph[1100][1100];
	int i,j,k;
	int cmp1,cmp2;
	int result;
	int cnt=0;
	char line;
	int temp=0,temp1=0,temp2=0,temp3;
	char compare[16];
	char compare1[16];
	char temp4[16];
	int temp5;
	int temp6=0;
	int temp7 =0;
	
	for(i=0;i<25143;i++){
		for(j=0;j<16;j++){
			scanf("%c", &Dic[i][j]);
			if(Dic[i][j] == '\n'){
				Dic[i][j] = '\0';
				cnt = i;
				break;
			}
		}
		if(Dic[i][0] == '\0'){
			
			break;
		}
	}
	while(scanf("%c", &line)==1){
		for(i=0;i<2;i++){
			for(j=0;j<16;j++){
				if(i==0 && j==0)
					word[0][0] = line;
				else
					scanf("%c", &word[i][j]);
				if(word[i][j] == ' ' || word[i][j] == '\n'){
					word[i][j] = '\0';
					break;
				}
			}
		}
		
		
		if(strlen(word[0])==strlen(word[1]))
			result = 1;
		else{
			result = 0;
			printf("No solution.\n\n");
		}
		if(result == 1){
			for(i=0;i<cnt;i++){
				if(strcmp(Dic[i],word[0])==0){
					cmp1 = i;
					temp6 = 0;
					break;
				}
				else
					temp6 =1;
			}
			for(i=0;i<cnt;i++){
				if(strcmp(Dic[i],word[1])==0){
					cmp2 = i;
					temp7=0;
				break;
			}
				else
					temp7 = 1;
			}
			if(temp6 == 0 && temp7 ==0){
				if(strcmp(word[0],word[1]) == 0){
					temp6 =2;
				}
			}
			if(strlen(word[0]) == 1 && strlen(word[1])==1){
				printf("%s\n", word[0]);
				printf("%s\n\n", word[1]);
				break;
		 }
			if(cmp1>cmp2){
				temp2 = cmp1;
				cmp1 = cmp2;
				cmp2 = temp2;
				temp5 = 1;
			}
			if(cmp1 !=0){
				strcpy(temp4,Dic[cmp1]);
				strcpy(Dic[cmp1],Dic[0]);
				strcpy(Dic[0],temp4);
			}
			if(cmp2 != cnt-1){
				strcpy(temp4,Dic[cmp2]);
				strcpy(Dic[cmp2],Dic[cnt-1]);
				strcpy(Dic[cnt-1],temp4);
			}
			for(i=0;i<cnt;i++){
				for(k=0;k<cnt;k++){
					for(j=0;j<16;j++){
						if(Dic[i][j] == '\0' || Dic[k][j] == '\0')
							break;
						if(Dic[i][j] != Dic[k][j])
							temp++;
					}
					if(temp == 1)
						graph[i][k] = 1;
					else
						graph[i][k] = 1000;
					if(i==k)
						graph[i][k] = 0;
					temp = 0;
				}
			
			
			}
			temp = 0;
			int A[cnt][cnt]; 
			for(i=0; i<cnt; i++)
				for(j=0;j<cnt;j++)
						A[i][j]=graph[i][j];
				for(k=0; k<cnt; k++){ 
					for(i=0; i<cnt; i++)
							 for(j=0; j<cnt; j++)
									if (A[i][k]+A[k][j] < A[i][j]) {
										 A[i][j] = A[i][k]+A[k][j];
									}
				}
			temp = 1;
			temp3 = 0;
			strcpy(result1[0],Dic[0]);
			for(i=0;i<cnt;i++){
				for(j=0;j<cnt;j++){
					if(A[temp3][j] == 1){
						if(A[temp3][cnt-1] == 1){
							strcpy(result1[temp],Dic[cnt-1]);
							temp++;
						}	
						else{
							if(A[temp3][cnt-1] > A[j][cnt-1]){
								strcpy(result1[temp],Dic[j]);
								temp++;
								temp3 = j;
							}
						}	
					}
					
				}
				if(temp == 1){
						temp6 = 1;
						break;
					}
			}
			temp3 = 0;
			for(i=0;i<cnt-1;i++){
				if(A[i][cnt-1] == 1000)
					temp3++;
			}
			if(temp6 == 2)
				printf("%s\n\n", word[1]);
			else if(temp3 == cnt-1 || temp6 == 1 || temp7==1)
				printf("No solution.\n\n");
			else{
				if(temp5 !=1){
					for(i=0;i<=*A[cnt-1];i++){
						printf("%s\n", result1[i]);
					}
					printf("\n");
				}
				else{
					for(i=*A[cnt-1];i>=0;i--){
						printf("%s\n", result1[i]);
					}
					printf("\n");
				}
			}
		for(i=0;i<25000;i++){
			for(j=0;j<16;j++){
				result1[i][j] = '\0';
			}
		}
		for(i=0;i<2;i++){
			for(j=0;j<16;j++){
				word[i][j] = '\0';
			}
		}
		temp = 0;
		temp1 = 0;
		temp2 = 0;
		temp3 = 0;
	  temp5 = 0;
		temp6 = 0;
		temp7 = 0;
	}

}
}
	
	

	