#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main(void)
{
    int tCase = 0;
    cin >> tCase;

    while (tCase--) {
        int count = 0;
        cin >> count;

        vector<int> fam(count, 0);

        for (size_t i = 0; i < count; i++) {
            cin >> fam[i];
        }

        sort(fam.begin(), fam.end());

        int find = fam[((count + 1) / 2) - 1];

        int result = 0;

        for (auto& item : fam) {
            result += (find - item > 0 ? find - item : item - find);
        }

        cout << result << "\n";
    }

    return 0;
}