#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>
#include <vector>
#include <sstream>
#include <algorithm>
using namespace std;

string fib[500]={"0","1"};

int compare(string a, string b){
	int alen=a.length(), blen=b.length();
	if(alen > blen) return 1;
	else if(alen < blen) return -1;
	
	for(int i=0;i<alen;i++){
		if(a[i] > b[i]) return 1;
		else if(a[i] < b[i]) return -1;
	}
	return 0;
}
//fib[i]=fib[i-2] + fib[i-1]인데 수가 얼마나 커질지 모르므로,
//fib[i-2], fib[i-1]을 각 자릿수에 대해 계속 덧셈을 한다.
void calcul(int i, string a, string b){
	int carry=0, len=0;
	int alen=a.length(), blen=b.length();
	int sum;
	fib[i]="";
	//두 피보나치 수의 합.
 	
 	reverse(a.begin(),a.end()); reverse(b.begin(),b.end());
	while((len < alen) || (len < blen)){
		if(len >= alen) a+='0';
		else if(len >= blen) b+='0';
		
		sum=(a[len]-48)+(b[len]-48)+carry; //alen-1,blen-1이 일의 자릿수이므로.
		if(sum>=10)carry=1;
		else carry=0;
		sum=sum%10;
  		fib[i]+=(sum+48); //일의 자릿수부터 쌓인다.
		
		++len;
	}
	if(carry) fib[i]+=(carry+48);
 	reverse(fib[i].begin(),fib[i].end()); //일의 자릿수~ 끝자릿수
 	//cout<<"fib[i]: "<<fib[i]<<endl;

}

void solv(){
	for(int i=2;i<500;i++)
		calcul(i,fib[i-2],fib[i-1]);
}


int main() {
	string input, a, b;
	int alen, blen;
	
	while(!cin.eof()){
		getline(cin,input);
		if(input=="") break;
		istringstream ss(input);
		ss>>a>>b;
		if(a=="0" && b=="0") return 0;

		alen=a.length(); blen=b.length();
		//reverse(a.begin(),a.end()); reverse(b.begin(), b.end());
		solv();
		
		int cnt=0;
		for(int i=2;i<500;i++){
			if(compare(fib[i],a)>=0 && compare(fib[i],b)<=0)++cnt;
		}
		printf("%d\n",cnt);
	}
}