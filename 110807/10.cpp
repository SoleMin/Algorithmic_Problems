# include <iostream>
# include <map>

using namespace std;

/*
    백트레킹 머리 빠게지겠네...
    왜 안돼냐....
    걍 BFS 쓰고 만다
*/

map<string, string> m;
string answer;

string rotation1 (string s);
string rotation2 (string s);
string rotation3 (string s);
string rotation4 (string s);

void first_bfs(int previous_rotation, int count, string puzzle_state, string rotation_history);
void second_bfs(int previous_rotation, int count, string puzzle_state, string rotation_history);

void print_map();

int main()
{
    int n;
    cin >> n;

    first_bfs(0, 0, "034305650121078709a90121", "");
    //print_map();

    while(n-- > 0) {
        /* 퍼즐 입력 처리 */
        string puzzle_input = "";
        for (int i = 0; i < 24; i++)
        {
            int input;
            cin >> input;

            if (input == 10) {
                puzzle_input += 'a';
            }                
            else {
                puzzle_input += '0' + input;
            }                
        }
        /* 퍼즐 입력 처리 */

        //cout << "Input => "<< puzzle_input << endl;

        /* 이미 풀린 경우 핸들링 */
        if (puzzle_input == "034305650121078709a90121") {
            cout << "PUZZLE ALREADY SOLVED" << endl;
            continue;
        }
        /* 이미 풀린 경우 핸들링 */

        else {
            answer = "x";
            second_bfs(0, 0, puzzle_input, "");
            //cout << "Answer => "<< answer << endl;
            if (answer != "x") {
                cout << answer << endl;
            }                
            else {
                cout << "NO SOLUTION WAS FOUND IN 16 STEPS" << endl;
            }                
        }

    }   // EOW (Case)

    return 0;
}

void first_bfs(int previous_rotation, int count, string puzzle_state, string rotation_history) {
    if (count == 9) {   // 양방향 BFS여서 9만해도 최대 Step인 16만족 하고도 남음
        return;
    }
    
    /* key 갱신 */
    if (m.find(puzzle_state) == m.end() || m[puzzle_state].size() > rotation_history.size() || (m[puzzle_state].size() == rotation_history.size() && m[puzzle_state] > rotation_history)) {
        //cout << "Rotation Hisotry => " << rotation_history << endl;
        m[puzzle_state] = rotation_history;
    }
    /* key 갱신 */

    /* 정답 상태에서 회전 정보를 역으로 기록 */
    if (previous_rotation != 1) {
        first_bfs(3, count + 1, rotation3(puzzle_state), '1' + rotation_history);
    }
        
    if (previous_rotation != 2) {
        first_bfs(4, count + 1, rotation4(puzzle_state), '2' + rotation_history);
    }
        
    if (previous_rotation != 3) {
        first_bfs(1, count + 1, rotation1(puzzle_state), '3' + rotation_history);
    }
        
    if (previous_rotation != 4) {
        first_bfs(2, count + 1, rotation2(puzzle_state), '4' + rotation_history);
    }     
    /* 정답 상태에서 회전 정보를 역으로 기록 */
}

void second_bfs(int previous_rotation, int count, string puzzle_state, string rotation_history) {
    if (count == 9)
        return;

    /* 정답 갱신 */
    if (m.find(puzzle_state) != m.end()) {
        if (answer == "x" || answer.size() > rotation_history.size() + m[puzzle_state].size() || (m[puzzle_state].size() == rotation_history.size() + m[puzzle_state].size() && m[puzzle_state] > rotation_history)) {
            answer = rotation_history + m[puzzle_state];
            //cout << "Cur Ans => " << answer << endl;
        }
    }
    /* 정답 갱신 */

    /* 입력 받은 상태로부터 순방향 BFS 진행 */
    if (previous_rotation != 3) {
        second_bfs(1, count + 1, rotation1(puzzle_state), rotation_history + '1');
    }
        
    if (previous_rotation != 4) {
        second_bfs(2, count + 1, rotation2(puzzle_state), rotation_history + '2');
    }
        
    if (previous_rotation != 1) {
        second_bfs(3, count + 1, rotation3(puzzle_state), rotation_history + '3');
    }
        
    if (previous_rotation != 2) {
        second_bfs(4, count + 1, rotation4(puzzle_state), rotation_history + '4');
    }        
    /* 입력 받은 상태로부터 순방향 BFS 진행 */
}

void print_map() {
    for (auto itr = m.begin(); itr != m.end(); itr++) {
        cout << "Key : " << itr->first << '\t' << "Value : " << itr->second << endl;
    }
}

string rotation1(string s) {
    char temp1, temp2;
    
    temp1 = s[10];
    temp2 = s[11];
    for (int i = 11; i >= 2; i--)
        s[i] = s[i - 2];
    s[0] = temp1;
    s[1] = temp2;

    s[21] = s[9];
    s[22] = s[10];
    s[23] = s[11];
    return s;
}

string rotation2(string s) {
    char temp1, temp2;

    temp1 = s[12];
    temp2 = s[13];
    for (int i = 14; i <= 23; i++)
        s[i - 2] = s[i];
    s[22] = temp1;
    s[23] = temp2;

    s[9] = s[21];
    s[10] = s[22];
    s[11] = s[23];
    return s;
}

string rotation3(string s) {
    char temp1, temp2;

    temp1 = s[0];
    temp2 = s[1];
    for (int i = 2; i <= 11; i++)
        s[i - 2] = s[i];
    s[10] = temp1;
    s[11] = temp2;

    s[21] = s[9];
    s[22] = s[10];
    s[23] = s[11];
    return s;
}

string rotation4(string s) {
    char temp1, temp2;

    temp1 = s[22];
    temp2 = s[23];
    for (int i = 23; i >= 14; i--)
        s[i] = s[i - 2];
    s[12] = temp1;
    s[13] = temp2;

    s[9] = s[21];
    s[10] = s[22];
    s[11] = s[23];
    return s;
}