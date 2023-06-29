#include <iostream>
#include <string>
#include <vector>
#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;
int main() {
	string a,b;
	vector<char> x;
	char temp;
	while(getline(cin,a)){
		x.clear();
		getline(cin,b);
		for(int i=0;i<a.size();i++){
			for(int j=0;j<b.size();j++){
				if(a[i]==b[j]){
					x.push_back(a[i]);
					b.erase(j,1);//중복출력
					break;
				}
			}
		}
		if(x.size()>=2){
			for(int i=0;i<x.size();i++){
				for(int j=i;j<x.size();j++){
					if(x[i]>x[j]){
						temp=x[i];
						x[i]=x[j];
						x[j]=temp;
					}
				}
			}
		}
		for(int i=0;i<x.size();i++){
			cout<<x[i];
		}
	cout << endl;
	}
	return 0;
}