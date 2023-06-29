#include <bits/stdc++.h>
#define fastio cin.tie(nullptr) -> sync_with_stdio(false);
using namespace std;
using pii = pair<int, int>;

char moveB[4] = { 'U', 'R', 'D', 'L' };
int moveStack[51], top = 0;
int board[4][4];
bool vis[4][4];
bool flag;

inline int ManDist(){
    int ret = 0;
    for(int i = 0; i < 4; i++){
        for(int j = 0; j < 4; j++){
            if(board[i][j] == 0)continue;
            ret += abs(((board[i][j] - 1)/ 4) - i) + abs(((board[i][j] - 1)) % 4 - j);
        }
    }
    return ret;
}

void back(int k, int r, int c){
    auto tmp = ManDist();
    if(tmp == 0){
        flag = 1;
        return;
    }
    if(tmp + k > 50) return;
    for(int i = 0; i < 4; i++){
        if(top > 0 && (moveStack[top - 1] + 2) % 4 == i) continue;
        int nx = r + "0121"[i] - '1';
        int ny = c + "1210"[i] - '1';
        if(nx >= 4 || ny >= 4 || nx < 0 || ny < 0) continue;
        if(vis[nx][ny]) continue;
        vis[nx][ny] = 1;
        swap(board[r][c], board[nx][ny]);
        moveStack[top++] = i;
        back(k + 1, nx, ny);
        if(flag) return;
        top--;
        vis[nx][ny] = 0;
        swap(board[r][c], board[nx][ny]);
    }
}

void solve(){
    int s, e;
    for(int i = 0; i < 4; i++) for(int j = 0; j < 4; j++) {
        cin >> board[i][j];
        if(board[i][j] == 0) s = i, e = j;
    }
    int i, j, k, l, value, x, y;
    value = 0;
    for (i = 0; i < 4; i++) {
        for (j = 0; j < 4; j++) {
            if (board[i][j] == 0) {
                value += i;
                x = i;
                y = j;
            }
            for (k = i; k < 4; k++) {
                if (k == i)
                    l = j + 1;
                else
                    l = 0;
                for (; l < 4; l++) {
                    if (board[k][l] != 0 && board[i][j] > board[k][l])
                        value++;
                }
            }
        }
    }
    if (value % 2 == 0)
        return;

    for(int i = ManDist(); !flag && i <= 50; i+= 2){
        back(0, s, e);
    }
}


int main() {
    fastio;
    int t; cin >> t;
    while(t--){
        memset(moveStack, 0, sizeof moveStack);
        memset(vis, 0, sizeof vis); 
        flag = 0;
        top = 0;
        solve();
        if(flag) {
            for (int i = 0; i < top; i++)
                cout << moveB[moveStack[i]];
            cout << "\n";
        }else{
            cout << "This puzzle is not solvable." << "\n";
        }
    }
}
