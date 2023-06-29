#include <iostream>
#include <string>
using namespace std;
int main() {
	int a,b,c=1;
	while(cin>>a>>b){
		if(a==0 && b==0)
			break;
		char mine[a][b];
		char ans[a][b];
		for(int i = 0; i<a; i++){
			string s;
			cin >> s;
			for(int j = 0; j<b; j++){
				mine[i][j] = s[j];
				ans[i][j]=0;
			}			
		}
		cout<<"Field #"<<c<<":"<<endl;
		for(int k = 0; k<a; k++){
			for(int l = 0; l<b; l++){
				if(mine[k][l]=='*'){
					ans[k][l]='*'; //지뢰 표시
				}
				else{
					char count = '0';
					for(int m = -1; m<= 1; m++){
						for(int n = -1; n<= 1; n++){
							if(k+m<0 || k+m>a-1 || l+n<0 || l+n>b-1)
								continue;
							if(mine[k+m][l+n]=='*')
								count++;
						}
					}
					ans[k][l]=count;
				}
			}
		}
		for(int o = 0; o<a; o++){
			for(int p = 0; p<b; p++){
				cout<<ans[o][p];
			}
			cout<<endl;	
		}
		c++;
		cout<<endl;
	}
	return 0;
}