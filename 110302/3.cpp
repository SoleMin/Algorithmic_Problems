#include <iostream>
#include<cstdio>
#include<cstdlib>
#include<cstring>
using namespace std;
char grid[50][50];
string words;
int n,m;
int l;
int b[8][2]={{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
void set(){
	cin>>n>>m;
	for(int j=0;j<n;j++){
		for(int k=0;k<m;k++){
			cin>>grid[j][k];
			grid[j][k]=tolower(grid[j][k]);
		}
	}
}

void depthsearch(){
	int index,ii,jj,kk,xx,yy;
	for(ii=0;ii<n;ii++){
		for(jj=0;jj<m;jj++){
			for(kk=0;kk<8;kk++){
				xx=ii,yy=jj,index=0;
				while(grid[xx][yy]==words[index]){
					xx+=b[kk][0],yy+=b[kk][1];
					index++;
					if(words[index]=='\0'){
						cout<<ii+1<<" "<<jj+1<<endl;
						return;
					}
					if(xx<0||yy<0||xx>=n||yy>=m)
						break;
				}
			}
		}
	}
}


void sol(){
	int num;
	cin>>num;
//	string words;
	num=num+1;
	while(num--){
		//cin.get();
		//fflush(stdin);
		getline(cin,words);
		l=words.length();
		//cout<<l;
		for(int j=0;j<l;j++)
			words[j]=tolower(words[j]);
		//cout<<words;
	  depthsearch();
	}
}
int main() {
	int test;
	cin>>test;
	getchar();
getchar();
	while(test--){
		set();
		sol();
		if(test>0) cout<<endl;
	}
	return 0;
}