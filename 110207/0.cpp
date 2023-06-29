#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <map>
#include <vector>
#include <algorithm>
#include <sstream>
using namespace std;

class info{
	public:
		int problem[9];
		int solve, score;
		char issolve;
	
		info(){memset(problem,0,sizeof(problem)); score=solve=issolve=0;}
		void init(){memset(problem,0,sizeof(problem)); score=solve=issolve=0;}
	
		void put_info(int pnum, int time, char issolve){
			if(problem[pnum] <0) return;
			
			if(issolve == 'I') ++problem[pnum];
			else if(issolve == 'C'){
				++solve;
				score+=time+(20*problem[pnum]);
				problem[pnum]=-1;
			}
		}
};

bool cmp(pair<int,info>& a, pair<int,info>& b){
	if(a.second.solve != b.second.solve) return a.second.solve > b.second.solve;
	if(a.second.score != b.second.score) return a.second.score < b.second.score;
	return a.first < b.first;
}

int main() {
	map<int,info> player;
	int n,k,quiz,spend;
	string set; char ch;
	
	scanf("%d",&n);
	getline(cin,set);
	getline(cin,set);
	while(n--){
		while(getline(cin,set)){
			if(set=="") break;
			istringstream ext(set);
			ext>>k>>quiz>>spend>>ch;
			switch(ch){
				case 'C': player[k].put_info(quiz-1,spend,ch); break;
				case 'I': player[k].put_info(quiz-1,20,ch); break;
				default: player[k].put_info(quiz-1,0,ch); break;
			}
		}
	
		vector<pair<int,info>> sortedMap;
		sortedMap.clear();
		
		for(auto it: player) sortedMap.push_back(it);
		sort(sortedMap.begin(),sortedMap.end(),cmp);
		for(auto it: sortedMap) printf("%d %d %d\n",it.first,it.second.solve,it.second.score);
		player.clear();
		if(n>0) printf("\n");
	}
}