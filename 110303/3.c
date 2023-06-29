#include <stdio.h>
#include <string.h>

int main() {
	char arr1[1001] = {0};
	char arr2[1001] = {0};
	char tmp_arr[1001] = {0};
	char tmp_arr2[1001] = {0};
	int check2[1001] = {0};
	int cnt = 0;
	int len1,len2,t_len;
	char tmp;
	while (gets(arr1))
	{
		gets(arr2);
		for(int i=0;i<1001;i++)
		{
			tmp_arr[i] = '\0';
		}
		len1 = strlen(arr1);
		len2 = strlen(arr2);
		cnt = 0;
		for(int i=0;i<len2;i++)
			check2[i] = 0;
		for(int i=0;i<len1;i++)
		{
			for(int j=0;j<len2;j++)
			{
				if(arr1[i] == arr2[j] && check2[j] == 0)
				{
					check2[j]++;
					tmp_arr[cnt++] = arr1[i];					
					break;
				}
			}
		}

		
		t_len = strlen(tmp_arr);
		for(int i=0;i<t_len;i++)
			for(int j=0;j<t_len-i-1;j++)
				if(tmp_arr[j]>tmp_arr[j+1]){
					tmp = tmp_arr[j];
					tmp_arr[j] = tmp_arr[j+1];
					tmp_arr[j+1] = tmp;
				}			
				
		printf("%s\n",tmp_arr);
	}	
	printf("\n");
	return 0;
}
