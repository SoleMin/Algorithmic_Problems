#include <cstdio>
#include <cstdlib>

int main() {
	int n=1, m=1; //행 열
	int chr, i,j, number=1;
	char field[100][100]={0};
	
	while(1){
		scanf("%d %d",&n, &m);
		if(!n && !m) break;
		while(getchar() == '\n') break;
		for(i=0;i<n;i++){
			for(j=0;j<m;j++) field[i][j]='0';
		}
		
		for(i=0;i<n;i++){
			j=0;
			while((chr=fgetc(stdin)) != (int)'\n'){
				if(chr == (int)'*'){
					for(int updown=i+1; updown>=i-1; updown--){
						if(updown<0 || updown>=100) continue;
						for(int lr=j+1;lr>=j-1;lr--){
							if((lr<0 || lr>=100) || field[updown][lr] == '*') continue;
							++field[updown][lr];
						}
					}
					field[i][j]='*';
				}
				++j;
			}
		}
		
		printf("Field #%d:\n",number++);
		for(i=0;i<n;i++){
			for(j=0;j<m;j++){
				printf("%c",field[i][j]);
				field[i][j]='0';
			}
			printf("\n");
		}
		printf("\n");
	}
}