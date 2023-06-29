#include <iostream>
#include <vector>
#include <math.h>
using namespace std;
int main() {
	int Testcase;
	do{
		cin >> Testcase;
		float result = 0;
		float tmp = 0;
		vector<float> v(Testcase, 0);
		
		if(Testcase == 0)
			return 0;
		
		for(int i =0; i<v.size(); i++)
		{
			cin >> v[i];
			tmp+= v[i];
		}
		tmp /= Testcase;
		
		for(int i = 0; i < v.size(); i++)
			if(v[i] > tmp)
				result+= floorf((v[i]-tmp) * 100) / 100;
		
		printf("$%.2f\n", result);

		}while(1);
	
	return 0;
}