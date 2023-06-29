#include <iostream>
#include <vector>
using namespace std;
int main() {
	int t,n,a,b;
	cin>>t;
	while(t--){
		cin>>n;
		vector <int> v1(n);
		vector <int> v2(n);
		vector <int> v3(n);
		for(int i = 0; i<n;i++){
			cin>>a>>b;
			v1[i]=a;
			v2[i]=b;
			v3[i]=i;
		}
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n - 1; j++){
				if (v1[v3[j]] * v2[v3[j + 1]] > v2[v3[j]] * v1[v3[j + 1]])
					swap(v3[j], v3[j + 1]);
				else if (v1[v3[j]] * v2[v3[j + 1]] == v2[v3[j]] * v1[v3[j + 1]] && v3[j] > v3[j + 1])
					swap(v3[j], v3[j + 1]);
				}
		  }
		for(int i = 0;i<n;i++){
			cout<<v3[i]+1<<" ";
		}
		cout<<"\n"<<endl;
		//sort(v1.begin(),v1.end(),cmp)
	}
	return 0;
}