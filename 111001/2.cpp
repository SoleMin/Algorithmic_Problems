#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

class freckles{
	private:
		vector<pair<double, double>> node;
		int n;
		double total = 0;
		double** dis;
	
	
	public:
		freckles(int a){
			double x, y;
			n = a;
			dis = new double*[n];
			for(int i = 0; i<n;i++) dis[i] = new double[n];
			
			for(int i = 0; i<n;i++){
				cin >> x >> y;
				node.push_back(make_pair(x, y));
			}
			for(int i = 0; i<n;i++){
				for(int j = 0; j<n;j++){
					dis[i][j] = distance(node[i].first, node[i].second, node[j].first, node[j].second);
				}
			}
		}
		
		~freckles(){
			for(int i = 0; i<n;i++) delete[] dis[i];
			
			delete[] dis;
		}
	
		void run(){
			draw();
			cout << fixed;
			cout.precision(2);
			cout << total << endl;
			//print_dis();
			//print_node();
		}
	
		double distance(double x1, double y1, double x2, double y2){
			return sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		}
	
		void draw(){
			double min;
			int min_idx;
			int* nearest = new int[n];
			double* distan = new double[n];
			
			for(int i = 1 ; i<n ; i++){
				nearest[i] = 0;
				distan[i] = dis[0][i];
			}
			nearest[0] = 0;
			distan[0] = -1;
			
			for(int i = 0 ; i<n-1 ; i++){
				min = 9999999999;
				for(int j = 1; j<n; j++){
					if(distan[j]>=0 && min>distan[j]){
						min = distan[j];
						min_idx = j;
					}
				}
				total += min;
				distan[min_idx] = -1;
				for(int j = 1; j<n; j++){
					if(distan[j]>=0 && distan[j]>dis[min_idx][j]){
						distan[j] = dis[min_idx][j];
						nearest[j] = min_idx;
					}
				}
			}
		}
		

		// test
		void print_node(){
			for(int i=0;i<n;i++){
				cout << node[i].first << " " << node[i].second << endl;
			}
		}
	
		void print_dis(){
			for(int i = 0; i<n;i++){
				for(int j = 0; j<n;j++){
					cout << dis[i][j] << " ";
				}
				cout << endl;
			}
		}
};


int main() {
	int t, n;
	cin >> t;
	for(int i=0;i<t;i++){
		cin >> n;
		freckles a(n);
		a.run();
		cout << endl;
	}
	return 0;
}