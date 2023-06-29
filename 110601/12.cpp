#include <iostream>
#include <string>
#define MAXDIGIT 100

using namespace std;

static char a[MAXDIGIT+1], b[MAXDIGIT+1];
static char fib[3][MAXDIGIT+1];
static int lengtha, lengthb, length[3];
static int result;

int compare(int fi, char* numb, int len){
	int i;
	if(length[fi]<len) return -1;
	if(length[fi]>len) return 1;
	for(i=len-1;i>=0;i--){
		if(fib[fi][i]<numb[i]) return -1;
		if(fib[fi][i]>numb[i]) return 1;
	}
	return 0;
}
void add(int target, int a, int b){
	int len=0, carry =0;
	for(;len<length[a]&&len<length[b];len++){
		fib[target][len] = (fib[a][len]+fib[b][len]+carry);
		if(fib[target][len]>=10)
			carry = 1;
		else
			carry = 0;
		fib[target][len]%=10;
	}
	if(len<length[a]){
		for(;len<length[a];len++){
			fib[target][len] = (fib[a][len]+carry);
			if(fib[target][len]>=10)
				carry=1;
			else
				carry=0;
			fib[target][len]%=10;
		}
	}
	else
		for(;len<length[b];len++){
			fib[target][len]=(fib[b][len]+carry);
			if(fib[target][len]>=10)
				carry=1;
			else
				carry=0;
			fib[target][len]%=10;
		}
	if(carry)
		fib[target][len++]=1;
	length[target]=len;
}
int main() {
	string line;
	int i;
	while(getline(cin,line)){
		if(line=="0 0") break;
		int space= 0;
		for(int j=0;j<line.length();j++){
			if(line[j]==' ') break;
			else space++;
		}
		string tempa = line.substr(0,space);
		space++;
		string tempb = line.substr(space, line.length());
		lengtha = tempa.length();
		lengthb = tempb.length();
		for(int i=0;i<lengtha;i++)
			a[i]=tempa[lengtha-i-1]-'0';
		for(int i=0;i<lengthb;i++)
			b[i] = tempb[lengthb-i-1]-'0';
		length[0]=length[1]=1;
		fib[0][0] = fib[1][0] = 1;
		for(i=1;compare(i%3,a,lengtha)<0;i++)
			add((i+1)%3,i%3,(i-1)%3);
		result=i;
		for(;compare(i%3,b,lengthb)<=0;i++)
			add((i+1)%3,i%3,(i-1)%3);
		result=i-result;
		cout<<result<<endl;
	}
	return 0;
}