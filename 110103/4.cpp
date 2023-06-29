#include <iostream>
using namespace std;

double floor(double n){
	double m;
	m = (int)n-((n>0) ? 0:1);
	return m;
}

int main() {
	int person = 0;
	double sum, solution, aver = 0;
	while(cin >> person){
		if(person == 0)
			break;
		sum=0;
		solution = 0;
		double* money = new double[person]();
		for(int i=0; i<person; i++){
			cin >> money[i];
			sum+=money[i];
		}
		aver=sum/person;
		
		for(int i =0; i<person; i++){
			if(money[i] -aver>0){
				solution += floor( ( money[i] - aver ) * 100 ) / 100;
			}
		}
		cout.setf(ios::fixed);
		cout.precision(2);
		cout << "$" << solution <<endl;
	}
	
	return 0;
}