#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <vector>
#include <map>
using namespace std;
/*
	문제 설명이 너무 이상함.
	1. 하루만에 n개의 작업을 받아버렸다.
	2. 이론상으론 하루만에 모든 n개의 작업을 처리해야한다.
	3. 그런데 작업마다 소요일수가 다르다.
	4. 즉 지체될 수 밖에 없다. 이때 다른 작업이 시작돼야하는데 밀린 일 수가 당연히 생긴다. (점점 쌓임)
	5. 그래서 밀린 일 수당 S센트를 지불하기로 했다.
	6. 이 지불금액을 최소화시키기 위한 작업의 순서를 결정해라.
*/
class solution{
	int n, tmp, tmpt, tmps;
	string a;
	
	public:
		void solv(){
			getline(cin,a);
			scanf(" %d",&n);
			vector<vector<int>> work(n,vector<int>(3,0)); //work[0][0]=작업명 work[0][1]=t, work[0][2]=s.
			vector<int> result(n,0);
			
			for(int i=0;i<n;i++){
				work[i][0]=i;
				scanf("%d %d",&work[i][1], &work[i][2]);
			}
			
			for(int i=n-1;i>0;i--)
				for(int j=0;j<i;j++){
					if(work[j][1]*work[j+1][2] > work[j+1][1]*work[j][2]){
						tmp=work[j][0]; tmpt=work[j][1]; tmps=work[j][2];
						work[j][0]=work[j+1][0]; work[j][1]=work[j+1][1]; work[j][2]=work[j+1][2];
						work[j+1][0]=tmp; work[j+1][1]=tmpt; work[j+1][2]=tmps;
					}
				}
			
			for(int i=0;i<n;i++) printf("%d ",work[i][0]+1);
			printf("\n");
			printf("\n");
		}
	
};
int main() {
	int t;
	solution a;
	scanf("%d",&t);
	while(t--){
		a.solv();
	}
}