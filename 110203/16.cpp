#include <iostream>
#include <set>
#include <string>

using namespace std;

int main() {
	set<int> s;
	int result[1000] = {0, };
	bool casecount = false;
	bool days = false;
	bool partycount = false;
	string line;
	int t, n, p;
	int k =0;
	int i = 0;
	int hartal[100] = {0, };
	while(getline(cin,line)){
		if(casecount == false){
			t = stoi(line);
			casecount = true;
		}
		else{
			if(days == false){
				n = stoi(line);
				days = true;
			}
			else{
				if(partycount ==false){
					p=stoi(line);
					partycount = true;
				}
				else{
					if(i<p){
						hartal[i] = stoi(line);
						for(int j = 1;hartal[i]*j<=n;j++){
							s.insert(hartal[i]*j);
						}
						i++;
					}
					if(i==p){
						s.erase(6);
						for(int j = 1;7*j<=n;j++){
							s.erase(7*j);
						}
						for(int j = 1;7*j+6<=n;j++){
							s.erase(7*j+6);
						}
						result[k]=s.size();
						k++;
						days=false;
						partycount=false;
						i=0;
						s.clear();
					}
				}
			}
		}
	}
	for(int p=0;p<k;p++){
		cout<<result[p]<<endl;
	}
	return 0;
}