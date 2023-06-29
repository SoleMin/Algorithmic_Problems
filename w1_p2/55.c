#include <stdio.h>
int main() {
	char a[100];
	
	while(scanf("%s",&a) == 1)
	{
	  if(a[0] == '0' && a[1] == 'x' )
		{
			int hex=0;
			
			sscanf(a+2,"%x",&hex);
			printf("%d\n",hex);
			
		}	
		else
		{
			int dec=0;
			
			sscanf(a,"%d",&dec);
			printf("0x%X\n",dec);
			
		}
		
	}
	

	return 0;
}
