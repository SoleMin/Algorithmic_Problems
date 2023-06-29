# include <iostream>
# include <algorithm>
# include <string>
# include <vector>
# include <queue>
# include <map>

/*
* 음...
* Node에 각 도시이름과 갈 수 있는 목록을 넣으면 되려나
* 목록을 탐방하면서 탑승할 수 있는 건 다 탄다.
* 도착지에 도달하지 못하는 경우는 쳐내기.
* 같은 도시, 여러 루트, 유효하면 다 태운다.
* 불가능한 표는 입력 처리에서 다 컷
* que에 들어갈 정보, <현재 도시 위치, 지금까지 필요한 피, 시각>
* 현재 도시 위치를 기준으로 방문가능한 + 방문 안 한 도시들 체크
* 시각을 기준으로 그 이후의 출발하는 표들을 태움
* 
* map써서 값 및 노선 관리
* 
*/

using namespace std;

typedef struct Route {
    string destination;
    int departure_time;
    int arrival_time;    
};

typedef struct Status {
    string city;
    int blood;
    int time;
};

map<string, vector<Route>> m;
map<string, int> is_visit;

void init();

bool sort_by_arrival_time(Route r1, Route r2);
void sort_map();

void print_map();

void get_input(int n);

int bfs(string start_point, string end_point);

int main() {

    int test_case = 0;
    cin >> test_case;

    for (int tc = 1; tc <= test_case; tc++) {
        init();

        cout << "Test Case " << tc << '.' << endl;
        int n;
        cin >> n;

        get_input(n);
        sort_map();
        //print_map();

        string start_point, end_point;
        cin >> start_point >> end_point;
        
        int answer = bfs(start_point, end_point);
        if (answer == -1) {
            cout << "There is no route Vladimir can take." << endl;
        }
        else {
            cout << "Vladimir needs " << answer << " litre(s) of blood." << endl;
        }
    }   // EOF (Test Case)

    return 0;
}

void init() {
    m.erase(m.begin(), m.end());
    is_visit.erase(is_visit.begin(), is_visit.end());
}

bool sort_by_arrival_time(Route r1, Route r2) {
    return r1.arrival_time < r2.arrival_time;
}

void sort_map() {
    for (auto iter = m.begin(); iter != m.end(); iter++) {
        sort(iter->second.begin(), iter->second.end(), sort_by_arrival_time);
    }
}
void print_map() {
    for (auto iter = m.begin(); iter != m.end(); iter++) {
        cout << "==========<" << iter->first << ">==========" << endl;
        for (int index = 0; index != iter->second.size(); index++) {
            cout << "Dest : " << iter->second[index].destination << endl;
            cout << "Star : " << iter->second[index].departure_time << endl;
            cout << "Arrv : " << iter->second[index].arrival_time << endl;            
        }
        
    }
}

void get_input(int n) {
    vector<Route> v;
    for (int i = 0; i < n; i++) {
        string origin, destination;
        int departure_time, tour_time, arrival_time;
        cin >> origin >> destination >> departure_time >> tour_time;
        //cout << "Org : " << origin << " || Dest : " << destination << " || Depar : " << departure_time << " || Tour : " << tour_time << endl;
        m.insert({ origin, v });
        is_visit.insert({ origin, 0 });
        if ((departure_time >= 18 && departure_time <= 24) || (departure_time >= 0 && departure_time <= 6)) {
            if (tour_time <= 12) {            
                arrival_time = departure_time + tour_time;
                if ((arrival_time <= 30 && arrival_time > 18)) {
                    m[origin].push_back({ destination, departure_time, arrival_time});                    
                }
                else if ((arrival_time <= 6 && arrival_time > 0)) {
                    m[origin].push_back({ destination, departure_time + 24, arrival_time + 24});
                }
            }
        }
    }
}

int bfs(string start_point, string end_point) {
    queue<Status> que;

    que.push({ start_point, 0, 0 });
    is_visit[start_point] = 1;

    while (!que.empty()) {
        string cur_city = que.front().city;
        int cur_time = que.front().time;
        int cur_blood = que.front().blood;
        que.pop();

        if (cur_city == end_point) {
            return cur_blood;
        }
        
        for (int i = 0; i < m[cur_city].size(); i++) {  //  해당 도시의 노선을 순회
            if (!is_visit[m[cur_city][i].destination]) { // 해당 노선 도착지를 방문한 적이 없으면
                if (m[cur_city][i].departure_time >= cur_time) {    //  그리디하게 접근 도착 시간 순으로 정렬해 놨으므로 출발 시간 맞으면 무조건 출발
                    que.push({ m[cur_city][i].destination, cur_blood, m[cur_city][i].arrival_time });
                    is_visit[m[cur_city][i].destination] = 1;
                }
            }            
        }   // 당일날 출발 하는 경우
        for (int i = 0; i < m[cur_city].size(); i++) {  //  해당 도시의 노선을 다시 순회
            if (!is_visit[m[cur_city][i].destination]) { // 위에서 노선을 찾았으면 이미 출발 했을 것
                que.push({ m[cur_city][i].destination, cur_blood + 1, m[cur_city][i].arrival_time });   // 다음날 가야하니 피 1리터 추가
                is_visit[m[cur_city][i].destination] = 1;                
            }
        }   // 다음날 출발 하는 경우
    }
    
    return -1;
}