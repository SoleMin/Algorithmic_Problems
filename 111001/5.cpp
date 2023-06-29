#include<bits/stdc++.h>
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
using namespace std;
using ll = unsigned int;

struct point{
    double x, y;
    point() = default;
    point(double _x, double _y) : x(_x), y(_y) {};
    using p = point;
    friend istream& operator >> (istream& in, p& i){
        in >> i.x >> i.y;
        return in;
    }

    friend double dist(const p& a, const p& b) {
        double ret = pow(a.x - b.x, 2) + pow(b.y - a.y, 2);
        return sqrt(ret);
    }
};

struct info{
    int a, b;
    double k;
    bool operator < (const info& i) const{
        return k < i.k;
    }
};


int par[101];

void find(int now){
    if(now == par[now]) return;
    find(par[now]);
    par[now] = par[par[now]];
}

int main(){
    fastio;
    int t; cin >> t;
    using p = point;
    while(t--){
        int n; cin >> n;
        cout << fixed << setprecision(2);
        vector<p> v(n);
        vector<info> w;
        for(auto& i : v) cin >> i;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                w.push_back({i, j, dist(v[i], v[j])});
            }
        }
        sort(w.begin(), w.end());
        iota(par, par + n, 0);
        double ans = 0;
        for(const auto& [a, b, c] : w){
            find(a);
            find(b);
            if(par[a] == par[b])  continue;
            ans += c;
            par[par[b]] = par[a];
        }
        cout << ans << "\n" << "\n"; 
    }
}