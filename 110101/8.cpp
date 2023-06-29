#include <iostream>
using namespace std;
int main() {
	long a,b,min,max,len,max_len,x;
  while(cin>>a>>b){
		if (a<b)
			min=a, max=b;
		else
			min=b, max = a;
		max_len = 0;
		for(int i = min; i <= max; i++){
			len = 1;
			x = i;
			while(x!=1){
				if(x&1){
					x = x*3+1;
					len++;
				}
				if(!(x&1)){
					x>>=1;
					len++;
				}
			}
			if(len>max_len)
				max_len=len;
		}
		cout<<a<<' '<<b<<' '<<max_len<<endl;
	}	
	return 0;
}