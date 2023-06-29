#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;

int main(){
	string a,b;

	while(getline (cin,a)){
		getline (cin,b);
		int aa=a.size();
		int bb=b.size();
		sort(a.begin(), a.end());
		sort(b.begin(), b.end());
		if (a == b){
			cout << a << endl;
			continue;
		}
		string k="";
		for(int i=0, j=0;i<aa && j<bb;){
			if(a[i]==b[j]){
				k+= a[i];
				i++;
				j++;
			}else{
				while (a[i] < b[j]){
					++i;
			    if (i == aa)
						break;
				}
				while (b[j] < a[i]){
					++j;
					if (j == bb)
						break;
				}
			}
		}
		cout<<k<<endl; 
	}
	return 0;
}
