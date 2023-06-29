#include<iostream>
#include<strings.h>
#include<vector>
#define MAX 500

using namespace std;



class BigNum{
 public: 

  BigNum(int num=0){
     marker = 0;
	  bzero(digits,MAX);
	  assignment(num);
     /*for(int i=0; i < MAX ; i++){
	     digits[i] = '0';
	  }
     for(; num !=0; num/=10, marker++){
	     digits[marker] = '0' + (num % 10);
	  }*/
  }


  void assignment(int num){
     marker = 0;
     for(int i=0; i < MAX ; i++){
	     digits[i] = '0';
	  }
     for(; num !=0; num/=10, marker++){
	     digits[marker] = '0' + (num % 10);
	  }
  }

  BigNum(const BigNum &other){
     marker = other.marker;
	  bzero(digits,MAX);
     for(int i=marker;i >=0 ;i--){
	    digits[i] = other.digits[i];
	  }
  }

  BigNum operator+(const BigNum &other){
     BigNum temp;
	  int carry =0;
	  int sum   =0;
	  int max = marker < other.marker ? other.marker : marker;
	  int i;

	  //cout << "MARKER =" << marker << endl;
	  //cout << "OTHER.MARKER =" << other.marker << endl;

	 // cout << "MAX = " << max  << endl;

	  for(i=0; i < max ; i++) {
	    sum = 0;
	    sum = (digits[i]-'0' ) + (other.digits[i] - '0') + carry ;
		 //cout << "SUM=" << sum << endl;
		 temp.digits[i] = '0' + (sum % 10);
		 sum /= 10;
		 carry = sum %10;
	  }

	  if(carry > 0){
	     temp.digits[i] = carry + '0';
		  max+=1;
	  }

	  temp.marker = max;
	  return temp;
  }


  void print(){
     //cout <<  "NUM=" ;
     for(int i=marker-1;i >=0 ;i--){
	    cout << digits[i];
	  }
	  cout << endl;
  }


  private:
  char digits[MAX];
  int marker ;
};

int main(){
   /*BigNum b1(1);
   BigNum b2(999);
	b1.print();
	b2.print();
	BigNum b3;
	b3 = b1 + b2;
	b3.print();*/
	int a;
	//vector<int> vec;

	BigNum dp[1001];
	dp[1] = 2;
	dp[2] = 5;
	dp[3] = 13;

	for(int i=4;i<1001;i++){
		//dp[i]=2*dp[i-1]+dp[i-2]+dp[i-3];
		dp[i]= dp[i-1]+ dp[i-1] + dp[i-2]+ dp[i-3];
	}

   while (cin>>a){
		//cin >> a;
		dp[a].print();
		//cout<<endl;
	}

	//cout << vec.size() << endl;
}