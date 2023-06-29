#include <stdio.h>
int main() {
	int num;
	int date;
	int Jungdang[100];
	int JD,i,j,k=0;
	int cnt = 0;
	scanf("%d",&num);
	
	while(k!=num){
		cnt=0;
		scanf("%d", &date);
		scanf("%d", &JD);
		for(i=0;i<JD;i++){
			scanf("%d", &Jungdang[i]);
		}
		
		for(i=1;i<=date;i++){
			if(i%7!=0 && i%7!=6){
				for(j=0;j<JD;j++){
					if(i%Jungdang[j]==0){
						cnt++;
						break;
					}
				}
			}
		}
		
		printf("%d\n", cnt);
		
		k++;
	}
	
}
