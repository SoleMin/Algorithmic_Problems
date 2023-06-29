#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class work
{
public:
	int number = 0;
	int t = 0;
	int p = 0;
	work() {};
};

int main()
{
	int t = 0;
	cin >> t;

	for (int i = 0; i < t; i++)
	{
		int n = 0;
		work work1[1000];
		work tempt;

		cin >> n;

		for (int j = 0; j < n; j++)
		{
			cin >> work1[j].t >> work1[j].p;
			work1[j].number = j+1;
		}

		for (int j = 0; j < n-1; j++)
		{
			for (int k = n-1; k > j; k--)
			{
				if (work1[k].p * work1[k - 1].t > work1[k - 1].p * work1[k].t)
				{
					tempt = work1[k];
					work1[k] = work1[k - 1];
					work1[k - 1] = tempt;
				}
			}
		}

		for (int j = 0; j < n - 1; j++)
			cout << work1[j].number << " ";
		cout << work1[n - 1].number << endl << endl;

	}



}