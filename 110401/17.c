#include <stdio.h>
void main() {
	int testcase; //테스트케이스
	int r[500]; //친척집 개수
	int s[500][2000]; //친척집 번지수
	int middle[500]; //중간값
	int dis[500]; //결과
	int i,j,k,temp;
	
	scanf("%d", &testcase);
	for(i=0;i<testcase;i++){
		scanf("%d", &r[i]);
		for(j=0;j<r[i];j++){
			scanf("%d", &s[i][j]);
		}
	}
	
	//친척집 번지수 정렬하기
	for(i=0;i<testcase;i++){
		for(j=0;j<r[i];j++){
			for(k=0;k<r[i]-1;k++){
				if(s[i][k]>s[i][k+1]){
					temp=s[i][k];
					s[i][k]=s[i][k+1];
					s[i][k+1]=temp;
				}
			}
		}
	}
	
	//중간값 찾기
	for(i=0;i<testcase;i++){
		if((r[i]%2)!=0){
			temp=(r[i]+1)/2;
			middle[i]=s[i][temp-1];
		}else{
			temp=r[i]/2;
			middle[i]=s[i][temp-1];
		}
		
		for(j=0;j<r[i];j++){
			if(middle[i]>s[i][j]){
				temp=middle[i]-s[i][j];
			}else{
				temp=s[i][j]-middle[i];
			}
			dis[i]+=temp;
		}
	}
	
	for(i=0;i<testcase;i++){
		printf("%d\n", dis[i]);
	}
}
