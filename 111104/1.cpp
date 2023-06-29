#include <bits/stdc++.h>
#define INF 999999
using namespace std;
//체력이 돼야 체중을 받친다.
//따라서 일단 체력순으로 정렬한다. 
//거북이들 체력 > +체중 
class info{ public: int kg, hp; };
bool cmp(info& a, info& b){
	if(a.hp == b.hp) return a.kg < b.kg;
	else return a.hp < b.hp;
}
class solution{
	int len;
	vector<info> turtles;
	vector<vector<int>> dp;
	public:
		void input(){
			string inst; info tmp;
			while(!cin.eof()){
				getline(cin,inst);
				if(inst=="") break;
				istringstream ss(inst);
				ss>>tmp.kg>>tmp.hp;
				turtles.push_back(tmp);
			}
			sort(turtles.begin(),turtles.end(),cmp); //체력순 정렬 
			len=turtles.size();
			//printf("len: %d\n",len);
			//for(int i=0;i<len;i++) printf("%d %d\n",turtles[i].kg, turtles[i].hp);
			dp.resize(len,vector<int>(len,INF));
			dp[0][1]=turtles[0].kg; //0 to 1 
			dp[0][0]=0; //아무것도 쌓지않으면 필요없잖아  
			for(int i=1;i<len;i++){
				dp[i][0]=0; //마찬가지 
				for(int j=1;j<len;j++){
					//이전결과+체력이 충분히 받쳐주면 최소체중을 측정
					//dp[i][j]가 없다는게 이전결과가 없으면.. 
					//printf("dp[%d][%d]: %d\n",i,j,dp[i][j]);
					if(dp[i-1][j-1]==INF) continue; //case1
					if(dp[i-1][j-1] + turtles[i].kg <= turtles[i].hp) 
						dp[i][j]=min(dp[i-1][j-1]+turtles[i].kg, dp[i-1][j]);
					else dp[i][j]=dp[i-1][j]; //otherwise
				}
			}
			/*for(int i=0;i<len;i++){
				for(int j=0;j<len;j++)
					printf("%d ",dp[i][j]);
				printf("\n");
			}*/
			int maxn=0, midx=0;
			for(int j=0;j<len;j++){
				if(dp[len-1][j]!=INF && maxn < dp[len-1][j]){
					maxn=max(maxn,dp[len-1][j]);
					midx=j;
				}
			}
			printf("%d\n",midx);
		}
};
int main(){
	solution sol;
	sol.input();
}