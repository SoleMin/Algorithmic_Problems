#include <iostream>
using namespace std;
int main() {
	long lbound, ubound, lbOrg, ubOrg, temp;
	long i, j ,length, max_length;
	
	while(cin >> lbound >> ubound ){
		lbOrg = lbound;
		ubOrg = ubound;
		if(lbound > ubound){
			temp=lbound;
			lbound= ubound;
			ubound= temp;
		}
		max_length = 0;
		for( i = lbound; i<= ubound; i++){
			j=i;
			length =1;
			while (j != 1){
				if(j&1){
					j= j*3+1;
					length++;
				}
				while (!(j&1)){
					j = j/2;
					length++;
				}
			}
			if(length > max_length)
				max_length = length;
		}
		
		cout <<lbOrg << ' ' << ubOrg <<' ' <<max_length << "\n";
	}
	return 0;
}