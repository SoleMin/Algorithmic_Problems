#include <iostream>
#include <functional>
#include <vector>
#include <algorithm>

using namespace std;

class Elephant {
public:
    int number;
    int weight;
    int iq;
    Elephant(int number, int weight, int iq) : number(number), weight(weight), iq(iq) {}
};

bool campare(Elephant a, Elephant b)
{
    return a.iq > b.iq;
}

bool campareTwo(vector<int> a, vector<int> b)
{
    for (int i = 0; i < a.size(); i++) {
        if (a[i] != b[i]) {
            return a[i] < b[i];
        }
    }

    return false;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    vector<Elephant> elephants;

    int w, iq, index = 1;
    while (cin >> w >> iq) {
        elephants.push_back(Elephant(index++, w, iq));
    }

    sort(elephants.begin(), elephants.end(), campare);

    vector<int> dp(elephants.size(), 0);
    vector<vector<int>> sequences(elephants.size());
    int largestLength = 0;

    dp[0] = 1;
    sequences[0].push_back(elephants[0].number);

    for (int i = 1; i < elephants.size(); i++) {
        for (int j = 0; j < i; j++) {
            if (elephants[i].weight <= elephants[j].weight || elephants[i].iq >= elephants[j].iq) {
                continue;
            }

            if (dp[i] < dp[j]) {
                dp[i] = dp[j];

                sequences[i] = sequences[j];
                sequences[i].push_back(elephants[i].number);
            }

            if (dp[i] == dp[j] && *(sequences[i].end() - 2) > elephants[j].number) {
                sequences[i] = sequences[j];
                sequences[i].push_back(elephants[i].number);
            }
        }

        if (dp[i] == 0) {
            sequences[i].push_back(elephants[i].number);
        }

        dp[i]++;
        largestLength = max(largestLength, dp[i]);
    }

    cout << largestLength << "\n";

    // for (int i = 0; i < elephants.size(); i++) {
    //     if (dp[i] == largestLength) {
    //         for (int j = 0; j < sequences[i].size(); j++) {
    //             cout << sequences[i][j] << "\n";
    //         }

    //         break;
    //     }
    // }

    vector<vector<int>> candidates;

    for (int i = 0; i < elephants.size(); i++) {
        if (dp[i] == largestLength) {
            candidates.push_back(sequences[i]);
        }
    }

    sort(candidates.begin(), candidates.end(), campareTwo);

    for (int i = 0; i < candidates[0].size(); i++) {
        cout << candidates[0][i] << "\n";
    }

    return 0;
}
