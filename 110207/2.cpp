#include<cstring>
#include <cstdio>
#include<iostream>
//#include<set>
#include<algorithm>
#include<cstdlib>
#include<vector>
#include<sstream>
//#define abs(x) ((x)<0?(-(x)):(x))
using namespace std;
typedef vector<int> v;
int sol[101][10],pen[101][10];
inline bool sor(int x,int y){
	int isol=0,ii=0,jsol=0,jj=0;
	for(int i=0;i<10;i++)
		if (sol[x][i]){
			ii+=pen[x][i];
			isol++;
}
		for(int i=0;i<10;i++)if(sol[y][i]){
			jj+=pen[y][i];
			jsol++;
		}
		if(isol>jsol )return true;
		else if(isol<jsol)return false;
		else{
			if(ii<jj)return true;
			else if(ii>jj)return false;
			else{
				x<y;
			}
		}
	}

int n,b,c,d;
	char l;
	v part;
	int main(){
		ios_base::sync_with_stdio(false);
		cin.tie(NULL);
		cin>>d;
		string a;
getline(cin,a);
		getline(cin,a);
		while(d--){
			memset(sol,0,sizeof(int )*101*10);
			memset(pen,0,sizeof(int)*101*10);
			part.clear();
			while(getline(cin,a),a.size()>0){
				stringstream iss(a);
				iss>>n>>b>>c>>l;
				if(l=='I'&&!sol[n][b]) pen[n][b]+=20;
				else if(l=='C'){
					if(!sol[n][b])pen[n][b]+=c;
					sol[n][b]=1;
				}
				if(find(part.begin(),part.end(),n)==part.end())
					part.push_back(n);
			}
			sort(part.begin(),part.end(),sor);
			for(int j:part){
				int e=0,f=0;
				for(int k=0;k<10;k++)
					if(sol[j][k]){
						f+=pen[j][k];
						e++;
					}
				printf("%d %d %d\n",j,e,f);
					
				}
			if(d>0)
				printf("\n");
			
			}
		return 0;
		}
	