#include <iostream>
#include <map>
#include <queue>
#include <stack>
#include <vector>

using namespace std;

string str[251343];
bool flag[25143];
int parent[25143];
vector<int>v[25143];

int main() {
	map<string,int> m1;
	map<int, string>m2;
	queue <int>q;
	stack<int>s;
	int num,begin,count;
	string word1,word2;
	int index;
	int i,j,k;
	int size;
	num=0;
	while(getline(cin,str[num])&&str[num].size()>0){
		m1[str[num]]=num;
		m2[num]=str[num];
		++num;
	}
	for ( i=0;i<num;i++){
		for(j=+1;j<num;j++){
			size=str[i].size();
			if(size==str[j].size()){
				count=0;
				for( k=0; k<size;k++){
					if(str[i][k]!=str[j][k])
						++count;
				}
				if(count==1){
					v[m1[str[i]]].push_back(m1[str[j]]);
					v[m1[str[j]]].push_back(m1[str[i]]);
				}
			}
		}
	}
	index=0;
	while(cin >> word1 >> word2){
		if(index++>0){
			cout<< endl;
		}
		if(word1.size()!=word2.size())
			cout << "No solution." << endl;
		else{
			for(i=0;i<num;i++){
				flag[i]=true;
				parent[i]=-1;
			}
			q.push(m1[word1]);
			flag[m1[word1]]=false;
			while(q.size()>0){
				begin=q.front();
				q.pop();
				for(auto iter:v[begin]){
					if(flag[iter]){
						flag[iter]=false;
						parent[iter]=begin;
						q.push(iter);
					}
				}
			}
			if(parent[m1[word2]]!=-1){
				begin=parent[m1[word2]];
				while(begin!=m1[word1]){
					s.push(begin);
					begin=parent[begin];
				}
				cout<<word1<<endl;
				while(!s.empty())
				{
					cout<<m2[s.top()]<<endl;
					s.pop();
				}
				cout<<word2<<endl;
			}
			else cout<<"No solution."<<endl;
			while(!q.empty())
				q.pop();
			
		}
	}
	m1.clear();
	m2.clear();
	for(i=0;i<num;i++)
		v[i].clear();
	return 0;
}