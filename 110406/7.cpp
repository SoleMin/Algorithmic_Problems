#include <algorithm>
#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

vector<string> split(string s1, char d)
{
    vector<string> result;
    string tmp;

    for (size_t i = 0; i < s1.size(); i++) {
        if (s1[i] == d) {
            result.push_back(tmp);
            tmp.clear();
        } else {
            tmp.push_back(s1[i]);
        }
    }
    if (!tmp.empty())
        result.push_back(tmp);

    return result;
}

int cmp(vector<string> s1, vector<string> s2)
{
    vector<string> diff = split(s1[1], ':');
    vector<string> diff2 = split(s2[1], ':');

    if (diff[0] == diff2[0]) {
        if (diff[1] == diff2[1]) {
            if (diff[2] == diff2[2]) {
                return diff[3] < diff2[3];
            }
            return diff[2] < diff2[2];
        }
        return diff[1] < diff2[1];
    }
    return diff[0] < diff2[0];
}

int main(void)
{
    int tCase = 0;
    cin >> tCase;

    while (tCase--) {
        map<string, vector<vector<string>>> m;
        map<string, int> m2;
        int fee[25] = {
            0,
        };
        for (int i = 0; i < 24; i++) {
            cin >> fee[i];
        }
        cin.ignore();
        string s;
        getline(cin, s);
        while (s != "") {
            vector<string> tmp = split(s, ' ');
            if (m.count(tmp[0])) {
                m[tmp[0]].push_back(tmp);
            } else {
                m.insert(make_pair(tmp[0], vector<vector<string>>()));
                m[tmp[0]].push_back(tmp);
            }
            getline(cin, s);

            if (cin.eof()) {
                break;
            }
        }

        for (auto iter = m.begin(); iter != m.end(); iter++) {
            int money = 200;
            string prevDay = "0";

            sort(iter->second.begin(), iter->second.end(), cmp);
            // cout << iter->first << ": ";
            // for (auto& i : iter->second) {
            //     for (auto& j : i) {
            //         cout << j << " ";
            //     }
            //     cout << "\n";
            // }

            for (size_t i = 1; i < iter->second.size(); i++) {
                if ((iter->second)[i][2] == "exit" && (iter->second)[i - 1][2] == "enter") {
                    vector<string> timeline = split(iter->second[i - 1][1], ':');

                    int time = stoi(timeline[2]);
                    int dinstance = stoi(iter->second[i][3]) - stoi(iter->second[i - 1][3]);
                    if (dinstance < 0) {
                        dinstance = -dinstance;
                    }
                    if (timeline[1] != prevDay) {
                        prevDay = timeline[1];
                        money += 100;
                    }

                    money += fee[time] * dinstance;
                    if (m2.count(iter->first)) {
                        m2[iter->first] = money;
                    } else {
                        m2.insert(make_pair(iter->first, money));
                    }
                }
            }
        }

        for (auto iter = m2.begin(); iter != m2.end(); iter++) {
            cout << iter->first << " $";
            cout << iter->second / 100;
            cout << ".";
            cout.width(2);
            cout.fill('0');
            cout << iter->second % 100 << "\n";
        }

        if (tCase != 0) {
            cout << "\n";
        }
    }

    return 0;
}