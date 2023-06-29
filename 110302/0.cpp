#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <cctype>
#include <vector>	
using namespace std;
/*
	이거... 소문자 대문자 구분이 없어서
	효율상 그냥 직접 해주자.
*/
int way[8][2]={{-1,-1}, {-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
int m,n,k, idx;
	
		/*
			어떻게 찾느냐?
			첫 글자 발견 -> 8방향 탐색(맨왼쪽위부터 맨오른쪽아래로 가면 무조건 최상위 탐색임)
			-> 다음 글자 찾으면 마저 가봐
			-> 가도 되면 이동하고..
		*/
		bool where(vector<string> greed, vector<string> word, int i, int j, int idx, int ch){
			/*
				8방향이면........ 그려봐야겠다
				(-1,-1),  (-1,0),  (-1,1)
				(0,-1)       나    (0,1)
				(1,-1),   (1,0),   (1,1)
				근데.. 아 반드시 존재하는구나.
			*/
			for(int direc=0;direc<8;direc++){
				int starti=i, startj=j;
				int alph=ch;
				
				while(starti<m && startj<n){
					if(greed[starti][startj] == word[idx][alph]){
						++alph;
						starti+=way[direc][0];
						startj+=way[direc][1];
						if(starti<0 || startj<0) break;
					}
					else break;
				}
				if(word[idx][alph] == '\0'){
					printf("%d %d\n",i+1,j+1);
					return 1;
				}
			}
			return 0;
	}
int main() {
	int t;
	int len, ch=0;
	string a;
	scanf("%d",&t); getchar();
	while(t--){
		getline(cin,a);
		scanf("%d %d",&m,&n); scanf("%*c");
		vector<string> greed(m);
		for(int i=0;i<m;i++){
			getline(cin,greed[i]);
			for(int j=0;j<n;j++) greed[i][j]=tolower(greed[i][j]);
		}
		
		scanf("%d",&k); scanf("%*c");
		vector<string> word(k);
		for(int i=0;i<k;i++){
			getline(cin,word[i]);
			len=word[i].size();
			for(int j=0;j<len;j++) word[i][j]=tolower(word[i][j]);
		}
		
		for(int idx=0;idx<k;idx++)
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++)
					if(greed[i][j] == word[idx][0]){
						if(where(greed,word,i,j,idx,0)) j=i=m+n;
					}
		printf("\n");
	}
}