#include <string>
#include <iostream>
#include <map>
#include <vector>
#include <queue>
using namespace std;

char s[9999];
int main() {
	int t, cases = 0;
	int a, b;
	cin>>t;
	while(t--) {
		cin>>a>>b;
		while(getchar() != '\n');
		map<string, int> name;
		map<string, int>::iterator ite;
		vector<short> g[5000];
		name["Erdos, P."] = 0;
		int buf[5000];
		int size = 0;
		while(a--) 
		{
			cin.getline(s,9999);
			int pre_idx = 0, bidx = 0;
			for(int i = 1; s[i]; i++) {
				if((s[i] == ',' || s[i] == ':') && s[i-1] == '.') {
					char tmp = s[i];
					s[i] = '\0';
					ite = name.find(s+pre_idx);
					if(ite == name.end())
					{
						name[s+pre_idx] = ++size;
						buf[bidx++] = size;
					} else 
					{
						buf[bidx++] = ite->second;
					}
					s[i] = tmp;
					pre_idx = i+2;
					if(s[i] == ':')
						break;
				}
			}
			for(int i = 0; i < bidx; i++) 
			{
				for(int j = i+1; j < bidx; j++) 
				{
					g[buf[i]].push_back(buf[j]);
					g[buf[j]].push_back(buf[i]);
				}
			}
		}
		int used[5005] = {}, dp[5005] = {}, x;
		used[0] = 1, dp[0] = 0;
		queue<int> Q;
		Q.push(0);
		while(!Q.empty()) 
			{
				x = Q.front(), Q.pop();
				for(vector<short>::iterator ite = g[x].begin();ite != g[x].end(); ite++) 
				{
					if(used[*ite] == 0) 
					{
						dp[*ite] = dp[x]+1;
						used[*ite] = 1;
						Q.push(*ite);
					}
				}
			}
			cout<<"Scenario "<<++cases<<endl;
			while(b--) 
			{
				cin.getline(s,10005);
				ite = name.find(s);
				cout<<s<<" ";
				if(ite == name.end())
					cout<<"infinity"<<endl;
				else if(!used[ite->second])
					cout<<"infinity"<<endl;
				else
					cout<<dp[ite->second]<<endl;
			}
		}
	return 0;
}
