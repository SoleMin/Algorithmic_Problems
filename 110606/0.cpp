#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>
#include <vector>
#include <sstream>
#include <algorithm>
using namespace std;
/*
    하노이탑은 재귀를 하기 때문에..
    (A B C)에 대해
    (left, mid, right)와 같고
    (left에서 mid로 이동)
    (left에서 right로 이동) (left,right,mid)
    (mid에서 right로 이동) (mid,left,right)
    였다는 걸 생각하면.
    4개에서 4개짜리를 생각하는게 빠르겠지.
    (A B C D)에 대해
    맨위 원반을 다른 침으로 하나 옮기고,
    나머지 3개에 대해서는 평소와 똑같은 하노이탑을 시행하고,
    마지막에 원반을 옮기면 된다.
    즉.. 기존 하노이탑+1 을 하면 되는 것 같다.
    그런데 재귀를 하진 않을거고, dp를 쓸거니까, 점화식이 필요하다.
    a(n)=2a(n-1) + 1이고
    4개에 대해선
	k개를 다른데에 옮겨두고, n-k를 목적지에 올리고, k개를 목적지에 올리는 순서.
	즉 k개는 2번 이동하고, n-k는 한번 이동하잖아?
	n개의 원반에 대한 횟수가 a(n)이니까
	점화식이 a(n)=2a(k)+a(n-k) 가 된다.
    즉 a(n-k)는 k개가 꽂힌 침을 제외한 침 3개에 대한 수행을 할것이고.
    이후 a(k)를 옮겨주면 된다.


*/
string dp4[10001];
string dp3[10001];

class solution{
	string num;
	int n;
	vector<string> result;

	public:
		int compare(string a, string b){
			int alen=a.length(), blen=b.length();
			if(alen > blen) return 1;
			else if(alen < blen) return -1;

			for(int i=alen-1;i>=0;i--){
				if(a[i] > b[i]) return 1;
				else if(a[i] < b[i]) return -1;
			}
			return 0;
		}
		void pin3hanoi(int n){ //전형적인 3기둥 하노이 a(n)=2a(n-1)+1
			if(!dp3[n].empty()) return; //겹치므로 시간낭비
			for(int i=2;i<=n;i++){
				dp3[i]=calcul(3,dp3[i-1],dp3[i-1]);
				dp3[i]=calcul(3,dp3[i],"1");
			}
		}

		void pin4hanoi(int n){ //4기둥 하노이 a(n)=2a(k)+a(n-k)
			string tmp;
			for(int i=2;i<=n;i++){ //i가 곧 n.
				dp4[i]=calcul(41,dp4[i-1],dp4[i-1]); //n개에 대한 점화식.
				//cout<<"dp4["<<i<<"] : "<<dp4[i]<<endl;
				dp4[i]=calcul(41,dp4[i],"1");
				//cout<<"dp4["<<i<<"]+1 : "<<dp4[i]<<endl;
				//k는 맨위에서 아래로 확장해나갈거고.
				for(int k=i-2;k>0;k--){ //임의 k개에 대해 4침이동 실시
					pin3hanoi(i-k); //a(n-k)만큼은 어차피 3침이동 해야한다.
					//이제 n개에 대한 4침 점화식을 전개한다.
					tmp=calcul(42,dp4[k],dp4[k]); //2a(k)
					tmp=calcul(42,tmp,dp3[i-k]); //+a(n-k)
					//따라서 a(n)=2a(k)+a(n-k) 완성.
					if(compare(dp4[i],tmp) == 1)
						dp4[i]=tmp;
					else break;
				}

			}
		}
		//일의자리 ~ 끝자리 로 값을 받자. 
		string calcul(int x, string a, string b){
			int carry=0, len=0;
			int alen=a.length(), blen=b.length();
			int sum; string result="";
			
		 	//reverse(a.begin(),a.end()); reverse(b.begin(),b.end());
		 	
		 	int diff=(alen>blen ? alen-blen : blen-alen);
		 	if(alen>blen) for(int i=0;i<diff;i++) b+='0';
			else if(alen<blen) for(int i=0;i<diff;i++) a+='0';
		 	len=(alen>=blen ? alen : blen);
			int j;
		 	for(int i=0;i<len;i++){
				sum=(a[i]-48)+(b[i]-48)+carry; //alen-1,blen-1이 일의 자릿수이므로.
				//printf("a[i]=%d, b[i]=%d\n",a[i]-48,b[i]-48);
				if(sum>=10)carry=1;
				else carry=0;
				sum=sum%10;
		  		result+=(sum+48); //일의 자릿수부터 쌓인다.
			}
			
			if(carry==1) result+="1";
			//cout<<"result: "<<result<<endl;
			return result;
		}

		void input(){
			dp3[0]=dp4[0]="0"; dp3[1]=dp4[1]="1";
			while(!cin.eof()){
				getline(cin,num);
				if(num=="") break;
				istringstream ss(num);
				ss>>n;
				pin4hanoi(n);
				reverse(dp4[n].begin(),dp4[n].end());
				result.push_back(dp4[n]);
				//cout<<"값: "<<dp4[n]<<endl; 
			}
			int len=result.size();
			for(int i=0;i<len;i++) cout<<result[i]<<endl;
		}
};
int main() {
	solution a;
	a.input();
}