#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <vector>
#include <map>
#include <cmath>
#include <sstream>
#include <algorithm>
#include <cstdlib>
using namespace std;
/*
	나가는 시각은 왜 있을지
*/
int cent[24];

class solution{
	public:
		int enter, exit, t, km;
		void init(){
			enter=exit=t=km=0;
		}

		void input(string time, string s, int k){
			//enter 혹은 exit가 2연속 나온 경우에 어쩔건데?
			//배열로 해결.
			if(s == "enter"){ enter=1; t=atoi(time.c_str()); km=k;}
			else if(s == "exit"){ exit=1; t=atoi(time.c_str()); km=k; }
		}
};

int cmp(solution& a, solution& b){
	return a.t < b.t;
}

int main() {
	int t; string info;
	string name,date,set,time; int km;
	solution a;

	scanf(" %d",&t);
	getline(cin,info);//공백처리
	while(t--){
		map<string, vector<solution>> record;
		for(int i=0;i<24;i++) scanf("%d",&cent[i]);
		getchar();
		while(!cin.eof()){
			getline(cin,info);
			if(info == "") break;
			istringstream input(info);
			input>>name>>date>>set>>km;
			time="";
			if(date[3]!='0')time+=date[3];
			time+=date[4]; time+=date[6]; time+=date[7]; time+=date[9]; time+=date[10];
			//cout<<"hour:"<<hour<<endl;
			/*cout<<"name: "<<name<<endl;
			cout<<"date: "<<date<<endl;
			cout<<"set: "<<set<<endl;
			printf("km: %d\n",km);*/
			a.init();
			a.input(time, set, km); //정보를 알려주고
			record[name].push_back(a); //map에 넣으면 enter와 exit의 횟수를 한번에 파악이 가능함.
		}

		for(auto it: record){ //각 키값에 접근해서.
			//각 value에 하나씩 접근해서 enter와 exit를 확인.
			//enter == exit이면 아닌 경우의 값을 구할 수 없음.

			int dist=0, cnt=0, len=it.second.size();
			double result=0;
			/*int enter=0, exit=0;
			vector<int> entered;
			vector<int> exited;*/
			if(len == 1) continue;
			sort(it.second.begin(), it.second.end(),cmp); //vector를 정렬. d를 기준으로 -> t를 기준으로
			for(int i=0;i<len;i++){
				/*cout<<"name: "<<it.first<<endl;
				printf("time: %d\n",it.second[i].t);
				printf("open: %d\n",it.second[i].enter);
				printf("exit: %d\n",it.second[i+1].exit);*/
				if(i+1 == len) continue;
				if(it.second[i].enter == 1 && it.second[i+1].exit == 1){
					//cout<<"name: "<<it.first<<endl;
					//printf("enter: %d | exit: %d\n",it.second[i].enter,it.second[i+1].exit);
					++cnt;
					//printf("exitkm: %d, openkm: %d\n",it.second[i+1].km, it.second[i].km);
					dist=abs(it.second[i+1].km - it.second[i].km);
					//printf("시간: %d, %d, %d\n",it.second[i].t,(it.second[i].t%1000), (it.second[i].t%1000)/100);
					result+=(dist*cent[(it.second[i].t%1000)/100]);
				}
			}

			if(cnt == 0) continue;
			result+=(cnt*100)+200;
			cout<<it.first; printf(" $%.2lf\n",result*0.01);
		}
		printf("\n");
	}
}
