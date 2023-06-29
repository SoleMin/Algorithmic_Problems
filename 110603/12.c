#include <stdio.h>
#define Nmax 200
unsigned long long table[1001][Nmax];
void ctable(){
	int carry=0;
	int overflow=0;
	table[1][0]=2;
	table[2][0]=5;
	table[3][0]=13;
	for(int i=4; i<1001; i++){
		for(int j=0; j<Nmax; j++){
			table[i][j]=table[i-1][j]*2+table[i-2][j]+table[i-3][j]+carry;
			if(table[i][j]>100000){
				overflow=table[i][j]/100000;
				table[i][j]%=100000;
				carry=overflow;
			}
			else
				carry=0;
		}
	}
}
void solve(int x){
int count=0;
	for(int i=0; i<Nmax; i++){
		int y=Nmax-1-i;
		if(table[x][y]!=0&&count==0){
			count=1;
		}
		if(count==1){
			count++;
			printf("%Iu",table[x][y]);
		}
		else if(count==2)
			printf("%I05u",table[x][y]);
	}
}
int main() {
	int value;
	ctable();
	while(scanf("%d",&value)!=EOF){
		solve(value);
		printf("\n");
	}
	return 0;
}
