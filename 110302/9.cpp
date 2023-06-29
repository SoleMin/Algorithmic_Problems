#include <iostream>
#include <string>
using namespace std;
int main() {
	int x,y,re,find,count,y_corr,x_corr;
	string word;
	char table[50][50]={};
	int y_d[8]={-1,-1,-1,0,0,1,1,1};
	int x_d[8]={-1,0,1,-1,1,-1,0,1};
	cin>>re;
	while(re--){
		
		cin>>y>>x;
		
		for(int i=0;i<y;i++){
			for(int j=0; j<x;j++){
				cin>>table[i][j];
				if(table[i][j]<'a')
					table[i][j]+=('a'-'A');
			}
		}
		
		cin>>find;
		while(find--){
			cin>>word;
			y_corr=0;
			x_corr=0;
			count=0;
			for(int i=0; i<word.length(); i++){
				if(word[i]<'a')
					word[i] +=('a'-'A');
			}
			for(int i=0;i<y;i++){
				for(int j = 0; j<x;j++){
					if(table[i][j] == word[0]){
						for(int k=0; k<8; k++){
							int a= word.length();
							for(int l=1; l<a;l++){
								if(i+y_d[k]*l<0||i+y_d[k]*l>49||j+x_d[k]*l<0||j+x_d[k]*l>49)
									break;
								if(table[i+y_d[k]*l][j+x_d[k]*l] !=word[l])
									break;
								if(l==a-1){
									y_corr = i+1;
									x_corr = j+1;
									count++;
									i=y;
									j=x;
									k=8;
									l=a;
								}
							}
						}
					}
				}
			}
			
			
		
		cout<<y_corr<<" "<<x_corr<<endl;
		}
		cout<<endl;
	}
	return 0;
}