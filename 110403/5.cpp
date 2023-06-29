#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int Bridge(vector<int> time)
{
	int n = time.size();
	int result = 0;
	while (n >= 4)
	{
		int test1 = time[1] + time[0] + time[n - 1] + time[1];
		int test2 = time[n - 1] + time[0] + time[n - 2] + time[0];

		if (test1 < test2)
			result += test1;
		else
			result += test2;

		n = n - 2;
	}

	if (n == 1)
		result += time[0];
	else if (n == 2)
		result += time[1];
	else if (n == 3)
		result += time[0] + time[1] + time[2];

	return result;

}

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
		vector<int> time;
		int result = 0;

		for (int j = 0; j < n; j++)
		{
			cin >> tempt;
			cin.ignore();
			time.push_back(tempt);
		}

		sort(time.begin(), time.end());

		result = Bridge(time);

		cout << result << endl << endl;
	}
}