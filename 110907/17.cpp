#include <iostream>
#include <map>
#include <vector>
#include <string>
#include <queue>
#include <utility>
#define INF 100000
using namespace std;

struct path {
   string s, e;
   int s_t, hour;
};
int t, n, s_t, hour;
string s, e, start, dest;
vector<path> paths;
map<string, pair<int, int>> m;

//최단 경로 찾았으면 날 수 반환, 못 찾았으면 -1 반환
int bfs(string start, string dest) {
   queue<string> q;
   q.push(start);
   m[start].first = 0;
   m[start].second = 0;
   int day, hour;
	
   while (!q.empty()) {
      string city = q.front();
      q.pop();
      
      for (auto it = paths.begin(); it != paths.end(); it++) {
         path p = *it;
         if (p.s == city) {
            //현재 도시에서 해당 도시까지 이동하면 날과 시간이 어떻게 바뀌는지
            day = m[city].first;
            hour = p.s_t + p.hour;

            //오늘 못 가고 내일 갈 수 있으면
            if (m[city].second > p.s_t) {
               day++;
            }

            //이 경로로 가는게 더 빠르면 최솟값 갱신하고 큐에 넣기
            if (day < m[p.e].first) {
               m[p.e].first = day;
               m[p.e].second = hour;
               q.push(p.e);
            }
            else if (day == m[p.e].first && hour < m[p.e].second) {
               m[p.e].second = hour;
               q.push(p.e);
            }
         }
      }
   }
   if (m[dest].first == INF) return -1;
   else return m[dest].first;
}

int main() {
   cin >> t;
   for (int i = 0; i < t; i++) {
      cin >> n;
      paths.clear();
      m.clear();
      for (int j = 0; j < n; j++) {
         cin >> s >> e >> s_t >> hour;
         if ((s_t >= 18 && s_t + hour <= 30) || s_t <= 6 && s_t + hour <= 6) {
            paths.push_back(path{ s, e, (s_t + 6) % 24, hour });
            if (m.find(s) == m.end()) m.insert(make_pair(s, make_pair(INF, 0)));
            if (m.find(e) == m.end()) m.insert(make_pair(e, make_pair(INF, 0)));
         }
      }
      cin >> start >> dest;
      
      cout << "Test Case " << i + 1 << "." << endl;
      if (m.find(start) != m.end() && m.find(dest) != m.end()) {
         int day = bfs(start, dest);
         if (day != -1) cout << "Vladimir needs " << day << " litre(s) of blood." << endl;
         else cout << "There is no route Vladimir can take." << endl;
      }
      else {
         cout << "There is no route Vladimir can take." << endl;
      }
   }
   return 0;
}