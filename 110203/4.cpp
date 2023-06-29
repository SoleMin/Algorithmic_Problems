#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char* arv[]) 
{
	int testcaseCount;
	cin >> testcaseCount;
	while (0 != testcaseCount--)
	{
		int dayCount, partyCount;
		cin >> dayCount >> partyCount;
		vector<bool> daysVector(dayCount + 1);
		fill(daysVector.begin(), daysVector.end(), false);
		int hartalParameter;
		while (0 != partyCount--)
		{
			cin>> hartalParameter;
			for (int i = hartalParameter; i < dayCount + 1; i += hartalParameter)  daysVector.at(i) = true;			
		}
		for (int i = 6; i < dayCount + 1; i += 7) daysVector.at(i) = false;
		for (int i = 7; i < dayCount + 1; i += 7) daysVector.at(i) = false;
		cout << count(daysVector.begin(), daysVector.end(), true) << endl;
	}
	return 0;
}