#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>
#include <vector>
#include <sstream>
#include <algorithm>
using namespace std;
/*
	1. 구스탑은 1,2,3,4를 알지만 1과 4가 같은건줄 안다.
	2. n을 파일이 끝날때까지(EOF) 읽어나간다.
	3. 4가지 수에 대해 서로 집합으로 붙어있으면, 그 집합안의 개수만큼이 곧 n인줄 안다.
	4. 즉 n은 집합의 개수를 말하고, 이걸 중복포함 무작위로 가능한 수를 다 뽑아라.
	5. 순서를 신경쓰지않고, 중복을 허용한다.
	배운대로면 문자열이라고 하는, 중복조합.. nHr = n+r-1Cr 이다.
	(1,4),2,3 으로 알고있다고 보면 됨. 특히 숫자가 1000이면 2^1000도 가능하다.
	3 111 114 141 411 ... 21 24 도 가능한듯. 그래서 15
	4면.. 2^4, 22, 13, 43, 31, 34 112 142 412 442 121... = 16+12+5=33
	1 2^1 + 0 = 2
	2 2^2 + 1 = 5
	3 2^3 + 5 = 13
	4 2^4 + 17 = 33
	5. 2^5 + ... = 84
	33-13=20
	F(n)=(F(n-3)*F(n-2))*2 + F(n-1) (n>=4)
	84-33=51-26=15..
	84-66=18 5+13
	33=26+7
	F(n)=F(n-1)*2 + F(n-2) + F(n-3) (n>=4)
*/
string dp[1001];
class solution{
	string num;
	int n;
	vector<string> result;

	public:
		
		void solv(){
			string tmp;
			for(int i=4;i<=1000;i++){
				dp[i]=calcul(i,dp[i-1],dp[i-1]);
				tmp=calcul(i,dp[i-2],dp[i-3]);
				dp[i]=calcul(i,dp[i],tmp);
			}
		}
		string calcul(int i, string a, string b){
			int carry=0, len=0;
			int alen=a.length(), blen=b.length();
			int sum; string result="";

		 	reverse(a.begin(),a.end()); reverse(b.begin(),b.end());
			while((len < alen) || (len < blen)){
				if(len >= alen) a+='0';
				else if(len >= blen) b+='0';

				sum=(a[len]-48)+(b[len]-48)+carry; //alen-1,blen-1이 일의 자릿수이므로.
				if(sum>=10)carry=1;
				else carry=0;
				sum=sum%10;
		  		result+=(sum+48); //일의 자릿수부터 쌓인다.
				++len;
			}
			if(carry) result+=(carry+48);
			reverse(result.begin(),result.end());
			return result;
		}
		
		void input(){
			dp[0]="0"; dp[1]="2"; dp[2]="5"; dp[3]="13";
			solv();
			while(!cin.eof()){
				getline(cin,num);
				if(num=="") break;
				istringstream ss(num);
				ss>>n;

				//printf("dp[%d]=%d\n",n,dp[n]);
				result.push_back(dp[n]);
			}
			int len=result.size();
			for(int i=0;i<len;i++) cout<<result[i]<<endl;
		}
};
int main() {
	solution a;
	a.input();
}