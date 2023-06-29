#include <cstdio>
#include <iostream>
#include <string>
#include <cstring>
#include <map>
#include <vector>
#include <queue>
#include <cstdlib>
#include <algorithm>
#define INF 9999
using namespace std;
/*
	n m이 입력되면,
	n개의 논문제목을 보여주고, m개의 이름을 보여준다.
	그때 m개의 이름들 각각이 가지는 에르되시 수를 출력해라.
	일단 집합은 못쓰겠고.. 하나씩 차례로 담기는 그림이구만.
	한 명이 여러개의... 이름을 가지는 식이겠구만.
	일단 각 사람마다 사전으로 에르되시 값을 가지고 있으면 되겠고,
	
*/
map<string, int> dict;
int matrix[5000][5000]={0};
int erdos_num[5000]={0};
int uniq=0, maxs=0;

void input_title(string title){
	string name="";
	int len=title.length();
	int save[5000]={0};
	int idx=0;
	for(int i=0;i<len;i++){
		name+=title[i];
		if((title[i] == '.' && title[i+1]==',') || (title[i] == '.' && title[i+1]==':')){
			if(dict.find(name) == dict.end()){
				dict.insert(make_pair(name,uniq));
				save[idx++]=uniq++;
				++maxs;
			}
			else save[idx++]=dict.find(name)->second;
			
			i=i+2; name="";
		}
		if(title[i-2] == ':') break;
	}
			 
	for(int i=0;i<idx;i++)
			 for(int j=0;j<idx;j++){
				 if(save[i] != save[j])
					 matrix[save[i]][save[j]]=matrix[save[j]][save[i]]=1;
			 }
}
			 
void BFS(){
	queue<int> que;
	int visited[5000]={0};
	int erdos=dict["Erdos, P."];
	
	for(int i=0;i<maxs;i++) erdos_num[i]=-1;
	erdos_num[erdos]=0;
	que.push(erdos);
	
	while(!que.empty()){
		int start=que.front(); que.pop();
		visited[start]=1;
		for(int i=0;i<maxs;i++){
			if(matrix[start][i] == 1 && !visited[i]){
				visited[i]=1;
				erdos_num[i]=erdos_num[start]+1;
				que.push(i);
			}
		}
	}
}

int main(){
	int k,n,m;
	string title, writer;
	vector<string> ans;
	
	//dict.insert(make_pair("Erdos, P.",0));
	scanf("%d",&k);
	for(int s=1;s<=k;s++){
		scanf("%d %d",&n, &m); getchar();
		for(int i=0;i<n;i++){
			getline(cin,title);
			input_title(title);
		}
		if(dict.count("Erdos, P.") == 0){
			for(int i=0;i<maxs;i++)
				for(int j=0;j<maxs;j++) matrix[i][j]=0;
		}
		BFS();
		for(int i=0;i<m;i++){
			getline(cin,writer);
			ans.push_back(writer);
		}
		printf("Scenario %d\n",s);
		for(auto it: ans){
			cout<<it<<' ';
			if(it == "Erdos, P.") printf("0\n");
			else if(erdos_num[dict[it]] <=0 || dict.find(it) == dict.end()) printf("infinity\n");
			else printf("%d\n",erdos_num[dict[it]]);
		}
		
		dict.clear();
		ans.clear();
		for(int i=0;i<maxs;i++){
			for(int j=0;j<maxs;j++) matrix[i][j]=0;
			erdos_num[i]=0;
		}
		uniq=maxs=0;
	}//for 종료
}