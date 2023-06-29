#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class chop{
	private :
		int pe, ch;
		int sum = 0;
		int* chs;
		int** dp;
		int temp;
	
	public:
		chop(int a, int b){
			pe = a+8;
			ch = b;
			chs = new int[ch+1];
			dp = new int*[pe+1];
			for(int j=0;j<=pe;j++){
				dp[j] = new int[ch+1];
			}
			for(int j=0;j<=pe;j++){
				for(int k=0;k<=ch;k++){
					dp[j][k] = 0;
				}
			}
			for(int j=ch;j>0;j--){
				cin >> chs[j];
			}
		}
	
		~chop(){
			for(int j=0;j<=pe;j++){
				delete[] dp[j];
			}
			delete[] dp;
			delete[] chs;
		}
	
		void run(){
			for(int j=1;j<=pe;j++){
				for(int k=1;k<=ch;k++){
					if(k<3*j)
						dp[j][k] = 99999999999;
					else{
						temp = (chs[k]-chs[k-1])*(chs[k]-chs[k-1]);
						dp[j][k] = (dp[j-1][k-2]+temp < dp[j][k-1])? dp[j-1][k-2]+temp : dp[j][k-1];
					}
				}
			}
			
			cout << dp[pe][ch] << endl;
		}
};

int main() {
	int input;
	cin >> input;
	for(int i=0;i<input;i++){
		int a, b;
		cin >> a >> b;
		chop t(a, b);
		t.run();
	}
	return 0;
}
