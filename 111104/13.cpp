#include <bits/stdc++.h>
using namespace std;

class Sol
{
public:
	Sol()
	{
		ios::sync_with_stdio(false);
		cin.tie(nullptr);
		cout.tie(nullptr);
	}

	int ca(vector<pair<int, int>> &data)
	{
		const int INF = 100000000;

		sort(data.begin(), data.end(), [](const pair<int, int> &lhs, const pair<int, int> &rhs) 
		{
			if (lhs.second < rhs.second)
				return true;
			else if (lhs.second == rhs.second)
				return lhs.first < rhs.first;

			return false;
		});

		vector<int> dp(data.size() + 1, INF);

		dp[0] = 0;

		int i, k;

		for (i = 0; i < data.size(); ++i)
			for (k = dp.size() - 1; k >= 1; --k)
			{
				if (dp[k - 1] + data[i].first <= data[i].second)
					dp[k] = min(dp[k], dp[k - 1] + data[i].first);
			}

		for (i = 1; i < dp.size(); ++i)
			if (dp[i] == INF)
				break;

		return i - 1;
	}
};

int main(void)
{
	Sol s;

	vector<pair<int, int>> data;

	data.reserve(5607);

	int z, a;

	while (cin >> z)
	{
		cin >> a;

		data.emplace_back(z, a);
	}

	auto ans = s.ca(data);

	cout << ans << endl;


	return 0;
}