#include <stdio.h>
#include <string.h>
int main(void) {
	
	char a[1000];
	char b[1000];
	
	int alphabet[26];
	int arr1[26];
	int arr2[26];
	int arr3[26];
	
	char result[1000];
 	int i,j,k;

	
	while(scanf("%s",a) == 1){
 		scanf("%s",b);
		
		
		for(i=0;i<26;i++)
			arr1[i]=0;
		for(i=0;i<26;i++)
			arr2[i]=0;
		for(i=0;i<26;i++)
			arr3[i]=0;
		for(i=0;i<1000;i++)
			result[i]=0;
		
		for(i=0;i<26;i++)
			alphabet[i]=97+i;
		
	for(i=0;i<strlen(a);i++){
		for(j=0;j<26;j++){
			if(a[i] == alphabet[j])
				arr1[j]++;
		}
	}
	
	for(i=0;i<strlen(b);i++){
		for(j=0;j<26;j++){
			if(b[i] == alphabet[j])
				arr2[j]++;
		}
	}		

	for(i=0;i<26;i++){
		if(arr1[i] !=0 && arr2[i] !=0){
			if(arr1[i] > arr2[i])
				arr3[i] = arr2[i];
			else if(arr1[i] < arr2[i])
				arr3[i] = arr1[i];
			else
				arr3[i] = arr1[i];
		}
	}
	
		k=0;
	for(i=0;i<26;i++){
		for(j=0;j<arr3[i];j++){
			result[k] = alphabet[i];
			k++;
		}
	}

		puts(result);
		}
	
	return 0;
}
