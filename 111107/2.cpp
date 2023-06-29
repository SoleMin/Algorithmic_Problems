#include <bits/stdc++.h>
#define INF 9999
using namespace std;
//A,B,C에 대해 직각삼각형. K+8명의 손님=K+8짝
//입력 손님(K) 젓가락 n개
//젓가락짝을 최대한 맞게끔하는 경우.
//3(K+8)씩, 즉 젓가락은 3개씩 짝이 됨 
class solution{
	int t, k, n;
	vector<int> L;
	vector<int> set;
	vector<vector<int>> dp; //i젓가락까지에
	public:
		void input(){
			scanf("%d ",&t);
			while(t--){
				scanf(" %d %d",&k,&n); k+=8;
				L.resize(n+1,0); dp.resize(n+1,vector<int>(k+1,0));
				for(int i=n;i>=1;i--) scanf("%d",&L[i]);
				//3번째거는 아무거나 제일길면 되므로 set[i+1]을 사용하기로. 
				//즉... set[i-1] > set[i]
				
				for(int i=1;i<=n;i++){
					//3번째꺼 i면 2는 i-1, 1은 i-2. 
					for(int j=1;j<=k;j++) dp[i][j]=INF;
					for(int j=1;j<=k;j++){
						if(j*3 > i) continue; //3(K+8)
						int pow=(L[i]-L[i-1])*(L[i]-L[i-1]);
						dp[i][j]=min(dp[i][j],dp[i-1][j]);
						dp[i][j]=min(dp[i][j],dp[i-2][j-1]+pow);
					}
				}
				printf("%d\n",dp[n][k]);
			}
		}
};
int main() {
	solution sol;
	sol.input();
}