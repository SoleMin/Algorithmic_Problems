#include <stdio.h>

char check(char c);
int exit(int i, int j, int x, int y);

int main() {

	char input[100], tmp[100][100], number[4];
	int x, y, i, j, num;
	x=1,y=1,num=0;
	
	while(x!=0||y!=0){
	scanf("%d",&x);
  scanf("%d",&y);
		

	if(x==0 || y==0){
		return 0;
		break;
	}
	else {
		

	for (i = 0; i < x; i++){
			scanf("%s", input);
			sscanf(input, "%s", tmp[i]);
		}
		
			num++;
			printf("Field #%d:\n", num);
		
		for (i=0 ; i<x ; i++){
			for (j=0; j<y ; j++){
				if (tmp[i][j]=='.')
					tmp[i][j] = '0';
			}
		}//초기화
		
		for (i=0; i<x ; i++){
			for (j=0; j<y; j++){
				
				if (tmp[i][j] == '*'){
					
					if (tmp[i-1][j-1] != '*' && exit(i-1, j-1, x, y) == 1)
						tmp[i-1][j-1] = check(tmp[i-1][j-1]);
					
					if (tmp[i-1][j] != '*' && exit(i-1, j, x, y) == 1)
						tmp[i-1][j] = check(tmp[i-1][j]);
					
					if (tmp[i-1][j+1] != '*' && exit(i-1, j+1, x, y) == 1)
						tmp[i-1][j+1] = check(tmp[i-1][j+1]); // i-1
					
					if (tmp[i][j-1] != '*' && exit(i, j-1, x, y) == 1)
						tmp[i][j-1] = check(tmp[i][j-1]); 
					
					if (tmp[i][j+1] != '*' && exit(i, j+1, x, y) == 1)
						tmp[i][j+1] = check(tmp[i][j+1]); // i
					
					if (tmp[i+1][j-1] != '*' && exit(i+1, j-1, x, y) == 1)
						tmp[i+1][j-1] = check(tmp[i+1][j-1]);
					
					if (tmp[i+1][j] != '*' && exit(i+1, j, x, y) == 1)
						tmp[i+1][j] = check(tmp[i+1][j]);
					
					if (tmp[i+1][j+1] != '*' && exit(i+1, j+1, x, y) == 1)
						tmp[i+1][j+1] = check(tmp[i+1][j+1]); // i+1
					
				}//if
				
			}
			
		}

			for(i=0 ; i<x ; i++){
				printf("%s\n",tmp[i]);
			}
		printf("\n");
		}
		
	}// while
	
	return 0;
}

char check(char c){
	
		if(c == '0')
			c='1';
			
		else if(c == '1')
			c='2';
	
		else if(c == '2')
			c='3';
	
		else if(c == '3')
			c='4';
	
		else if(c == '4')
			c='5';
	
		else if(c == '5')
			c='6';
	
		else if(c =='6')
			c='7';
	
		else if(c == '7')
			c='8';
	
	return c;
} //check

int exit(int i, int j, int x, int y){
	if (i<0 || i >= x || j<0 || j >= y)
		return 0; //거짓
	return 1; //참
}
	
	
	
	
	
	
	
	
	
