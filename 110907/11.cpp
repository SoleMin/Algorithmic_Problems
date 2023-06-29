#include<bits/stdc++.h>

using namespace std;
#define fastio cin.tie(nullptr)->sync_with_stdio(false)

constexpr int mn = 1001;

int main() {
    fastio;
    int t;
    cin >> t;
    for(int q = 1; q <= t; q++) {
        int n;
        cin >> n;
        int cnt = 1, tmp = 1, edges[mn][4], check[mn];
        memset(check, 0x3f, sizeof check);
        string name[mn];
        map<string, int> M;
        for (int i = 0; i < n; i++) {
            string s, e;
            int st, en;
            cin >> s >> e >> st >> en;
            st %= 24;
            if ((st >= 6 && st < 18) || (6 > st && st + en > 6) || (18 <= st && st + en > 30)) continue;
            if (M[s] == 0) {
                name[cnt] = s;
                M[s] = cnt++;
            }
            if (M[e] == 0) {
                name[cnt] = e;
                M[e] = cnt++;
            }
            edges[tmp][0] = M[s];
            edges[tmp][1] = M[e];
            edges[tmp][2] = (st + 6) % 24;
            edges[tmp][3] = (st + 6) % 24 + en;
            tmp++;
        }
        string a, b;
        cin >> a >> b;
        if (M[a] == 0) {
            name[cnt] = a;
            M[a] = cnt++;
        }
        if (M[b] == 0) {
            name[cnt] = b;
            M[b] = cnt++;
        }
        int ret = 1000;
        auto solve = [&](int now, int num, int time, auto&& solve) -> void {
            if(num > 1000) return;
            if(check[now] > num) check[now] = num;
            else return; 
            if(M[b] == now) {
                ret = num;
                return;
            }
            for(int i =1; i < tmp; i++){
                if(edges[i][0] != now)continue;
                if(edges[i][2] >= time) solve(edges[i][1], num, edges[i][3], solve);
                else solve(edges[i][1], num + 1, edges[i][3], solve);
            }
        };
        solve(M[a], 0, 0, solve);
        if(ret == 1000){
            cout << "Test Case " << q << ".\n" << "There is no route Vladimir can take." << "\n";
        }
        else{
            cout << "Test Case " << q << ".\n" << "Vladimir needs " << ret << " litre(s) of blood." << "\n";
        }
    }
}