#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>
using namespace std;

// class Node {
// public:
//     string destinationCity;
//     int departureTime;
//     int durationTime;

// public:
//     Node(string destinationCity, int departureTime, int durationTime)
//         : destinationCity(destinationCity)
//         , departureTime(departureTime)
//         , durationTime(durationTime)
//     {
//     }
// };

class GraphInfo {
public:
    int a, b, c;

public:
    GraphInfo(int a, int b, int c)
    {
        this->a = a;
        this->b = b;
        this->c = c;
    }
};

vector<int> BFS(vector<vector<GraphInfo>>& graph, unordered_map<string, int>& node, vector<string>& city, string start, string end)
{
    vector<int> result;
    int minValue = INT32_MAX;
    queue<GraphInfo> q; // a : startLocation, b : NowTime, c : Blood
    vector<int> dp(101, INT32_MAX);
    q.push(GraphInfo(node[start], 18, 0));

    while (!q.empty()) {
        int nowCity = q.front().a;
        int nowTime = q.front().b;
        int nowBlood = q.front().c;
        q.pop();

        if (nowBlood > 1000) {
            continue;
        }
        if (dp[nowCity] < nowBlood) {
            continue;
        }

        if (nowCity == node[end]) {
            result.push_back(nowBlood);
        }

        for (int i = 0; i < graph[nowCity].size(); i++) {
            int nextCity = graph[nowCity][i].a;
            int nextStartTime = graph[nowCity][i].b;
            int nextDuringTime = graph[nowCity][i].c;
            int time = nextStartTime + nextDuringTime;

            if (nowTime > nextStartTime) {
                if (dp[nextCity] > nowBlood + 1) {
                    q.push(GraphInfo(nextCity, time, nowBlood + 1));
                    dp[nextCity] = nowBlood + 1;
                }

            } else {
                if (dp[nextCity] > nowBlood) {
                    q.push(GraphInfo(nextCity, time, nowBlood));
                    dp[nextCity] = nowBlood;
                }
            }
        }
    }

    return result;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int testCase = 0;
    int tCase = 0;
    cin >> testCase;

    while (testCase--) {
        unordered_map<string, int> node;
        vector<string> city;
        vector<vector<GraphInfo>> graph(101);

        int num;
        cin >> num;

        int index = 0;
        for (int i = 0; i < num; i++) {
            string startLocation, endLocation;
            int startTime, duringTime;

            cin >> startLocation >> endLocation >> startTime >> duringTime;

            startTime = startTime % 24;

            if (startTime >= 6 && startTime < 18)
                continue;

            if (duringTime > 12)
                continue;

            if (((startTime + duringTime) % 24) > 6 && ((startTime + duringTime) % 24) < 18)
                continue;

            // ADD GRAPH!

            if (!node.count(startLocation)) {
                node.insert(make_pair(startLocation, index++));
                city.push_back(startLocation);
            }
            if (!node.count(endLocation)) {
                node.insert(make_pair(endLocation, index++));
                city.push_back(endLocation);
            }

            if (startTime < 6) {
                startTime += 24;
            }
            GraphInfo tmp(node[endLocation], startTime, duringTime);
            graph[node[startLocation]].push_back(tmp);
        }
        string start, end;
        cin >> start >> end;

        if (!node.count(start)) {
            node.insert(make_pair(start, index++));
            city.push_back(start);
        }
        if (!node.count(end)) {
            node.insert(make_pair(end, index++));
            city.push_back(end);
        }

        // BFS?

        vector<int> result = BFS(graph, node, city, start, end);

        // int abc = 0;
        // for (auto& i : graph) {
        //     if (abc < city.size()) {
        //         cout << abc << ":";
        //         cout << city[abc++] << " : ";
        //         for (auto& j : i) {
        //             cout << j.a << " " << j.b << " " << j.c << " ";
        //         }
        //         cout << "\n";
        //     }
        // }

        cout << "Test Case " << ++tCase << ".\n";
        if (result.empty()) {
            cout << "There is no route Vladimir can take.\n";
        } else {
            int minValue = INT32_MAX;
            for (int i = 0; i < result.size(); i++) {
                if (minValue > result[i]) {
                    minValue = result[i];
                }
            }
            cout << "Vladimir needs " << minValue << " litre(s) of blood.\n";
        }
    }
}