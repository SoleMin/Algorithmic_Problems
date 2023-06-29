#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int t = 0;
	int n = 0;
	int tempt = 0;
	cin >> t;
	cin.ignore();

	for (int i = 0; i < t; i++)
	{
		cin >> n;
		cin.ignore();
		vector<int> addr;
		for (int j = 0; j < n; j++)
		{
			cin >> tempt;
			addr.push_back(tempt);
			cin.ignore();
		}

		sort(addr.begin(), addr.end());

		int index = addr.size() / 2;
		int distance = 0;

		for (int j = 0; j < addr.size(); j++)
		{
			tempt = addr[j] - addr[index];
			if (tempt < 0)
				tempt = -tempt;
			distance += tempt;
		}

		cout << distance << endl;
	}
}