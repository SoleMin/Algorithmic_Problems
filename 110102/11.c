#include <stdio.h>
int f[100][100];
int nl=100;
int nc=100;
void clear(){
	int i,j;
	for(i=0;i<nl;i++)
	{
		
	for(j=0;j<nc;j++){
		f[i][j]=0;
		}
		
	}
	}
void setb(int i,int j){
	nl=i;
	nc=j;
}
int isIn(int l,int c){
	return l>=0&&l<nl&&c>=0&&c<nc;
}
void incre(int l,int c){
	if(isIn(l,c)&&f[l][c]!=-1){
		++f[l][c];
	}
	
}

void setM(int j,int k){
	f[j][k]=-1;
	int i,a;
	for(i=-1;i<=1;i++){
		for( a=-1;a<=1;a++){
			incre(j+i,k+a);
		}
	}
}
void print(int  field){
	printf("Field #%d:\n",field);
	int i,j;
	for( i=0;i<nl;i++){
		for( j=0;j<nc;j++){
			int a=f[i][j];
			if(a==-1){
				printf("*");
				
			}else{
				printf("%d",a);
			}
		}
		printf("\n");
	}
}
int main() {
	int a,b;
		 int field=1;
	while(scanf("%d %d",&a,&b)){
	if(a==0&&b==0)
		break;
	
	setb(a,b);
	clear();
		int i,j;
	for(i=0;i<a;i++){
		char l[b+1];
		scanf("%s",l);
		for ( j=0;j<b;j++){
			char current=l[j];
			if(current =='*'){
				setM(i,j);
			}
		}
	}
	if(field>1){
		printf("\n");
	}
		print(field);
		++field;
	}	

	
		return 0;


}
