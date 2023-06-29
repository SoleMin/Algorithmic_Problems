#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	bool l1=false;
	string line;
	int position, cur_position=0;
	int testcase, casenum,casec=0,testc=0;
	int value[100][500] = {0,};
	int num[100]={0,};
	int result[100]={0,};
	int n=0, temp;
	string separator=" ";
	while(getline(cin,line)){
		if(l1==false){
			l1=true;
			testcase=stoi(line);
		}
		else{
			while((position=line.find(separator,cur_position))!=string::npos){
				int len = position - cur_position;
				value[testc][casec] = stoi(line.substr(cur_position,len));
				casec++;
				cur_position = position +1;
			}
			value[testc][casec] = stoi(line.substr(cur_position));
			cur_position = 0;
			casec++;
			num[testc] = casec;
			casec = 0;
			casenum = 0;
			testc++;
		}
	}
	while(testc>n){
		num[n]--;
		value[n][0] = value[n][num[n]];
		value[n][num[n]]=0;
		n++;
	}
	n=0;
	for(int i=0;i<testc;i++){
		sort(value[i],value[i]+num[i]);
	}
	for(int i=0;i<testc;i++){
		temp=value[i][num[i]/2];
		for(int j=0;j<num[i]/2;j++){
			result[i]+=temp-value[i][j];
		}
		for(int j=num[i]/2+1;j<num[i];j++){
			result[i]+=value[i][j] - temp;
		}
	}
	for(int i=0;i<testc;i++){
		cout<<result[i]<<endl;
	}
	return 0;
}