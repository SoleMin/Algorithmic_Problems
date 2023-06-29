#include <stdio.h>
#include <map>
#include <set>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void print_cameras_city(set<string> &camera_locations);
void read_route_names(int N);
void make_adj_list(int M);
int depth_first_search(int node, int dep, int p, int root) ;

#define MAX 105
vector<int> adjacency_list[MAX];
map<string, int> routes;
set<string> camera_locations;

//To track the depth first search 
int visited_nodes[MAX], depth[MAX];

char buf[MAX], name[MAX][MAX];

int main() {
    int N, M, i, cases = 0;
    while( (scanf("%d", &N) > 0)  && (N != 0) ) {
        routes.clear();
        camera_locations.clear();

		  read_route_names(N);

        scanf("%d", &M);

		  make_adj_list(M);

        for(i = 0; i < N; i++) {
            if(visited_nodes[i] == 0) {
                depth_first_search(i, 1, -1, i);
            }
        }

        if(cases)   puts("");
        printf("City map #%d: %lu camera(s) found\n", ++cases, camera_locations.size());
		  print_cameras_city(camera_locations);
    }
    return 0;
}

void print_cameras_city(set<string> &camera_locations){
        for(set<string>::iterator it = camera_locations.begin();it != camera_locations.end(); it++)
            cout << *it << endl;
}

void read_route_names(int N){
int i;
        for(i = 0; i < N; i++) {
            scanf("%s",name[i]);
            routes[name[i]] = i;
            adjacency_list[i].clear();
            visited_nodes[i] = depth[i] = 0;
        }
}


void make_adj_list(int M){
	int x, y;
        while(M--) {
            scanf("%s", buf);
            x = routes[buf];
            scanf("%s", buf);
            y = routes[buf];
            adjacency_list[x].push_back(y);
            adjacency_list[y].push_back(x);
        }
}

int depth_first_search(int node, int dep, int p, int root) {
    depth[node] = dep;
    visited_nodes[node] = 1;
    size_t i;
	 int back = 0xFFFF, temp, child = 0;
    bool articulation_point = false;

    for(i = 0; i < adjacency_list[node].size(); i++) {
        if(visited_nodes[adjacency_list[node][i]] == 0) {
            temp = depth_first_search(adjacency_list[node][i], dep+1, node, root);
            if(temp >= dep)  articulation_point = true;
            child++;
            back = min(back, temp);
        } else {
            if(adjacency_list[node][i] != p)
                back = min(back, depth[adjacency_list[node][i]]);
        }
    }
    if((node == root && child > 1) || (node != root && articulation_point)) {
        camera_locations.insert(name[node]);
    }
    return back;
}