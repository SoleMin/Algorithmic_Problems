#include <iostream>
#include<algorithm>
#include<string>
using namespace std;
int main() {
	string a;
	string b;
	string count;

	while(getline(cin,a)){
		getline(cin,b);
		count="";
		
			for(int i=0;i<a.size();i++)
				for(int j=0;j<b.size();j++)
					if(a[i]==b[j])
						count+=a[i],a[i]='2',b[j]='1';
				
		sort(count.begin(),count.end());
		cout<<count<<endl;
		
	}
	return 0;
}