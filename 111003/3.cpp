
#include <iostream>
#include <cstring>

using namespace std;
#define INF 999999999;

class fire_station{
	private:
		int f_c, e_c = 0, n_c;
		int** edge;
		bool* fs;
		int* distance;
	
	public:
		fire_station(int a, int b){
			string line;
			char ch[50];
			char* temp;
			int x, y, val;
			int t;
			
			f_c = a;
			n_c = b;
			fs = new bool[b+1];
			distance = new int[b+1];
			edge = new int*[b+1];
			for(int i=0;i<b+1;i++){
				fs[i] = 0;
				distance[i] = INF;
			}
			for(int i=0;i<a;i++){
				cin >> t;
				fs[t] = 1;
				distance[t] = 0;
			}
			
			for(int i=0;i<b+1;i++)
				edge[i] = new int[b+1];
			
			for(int i=0;i<b+1;i++){
				for(int j=0;j<b+1;j++){
					if(i==j) edge[i][j] = 0;
					else edge[i][j] = INF;
				}
			}
				
			getchar();
			for(;getline(cin, line) && line.size()!=0;){
				e_c++;
				strcpy(ch, line.c_str());
				temp = strtok(ch, " ");
				x = atoi(temp);
				temp = strtok(NULL, " ");
				y = atoi(temp);
				temp = strtok(NULL, " ");
				val = atoi(temp);
				edge[x][y] = val;
				edge[y][x] = val;
			}
			
			/*
			for(int i=1;i<b+1;i++){
				for(int j=1;j<b+1;j++){
					if(edge[i][j] == 999999999)
						cout << "INF" << " ";
					else
						cout << edge[i][j] << " ";
				}
				cout << endl;
			}
			*/
		}
	
		~fire_station(){
			for(int i=0;i<n_c+1;i++)
				delete[] edge[i];
			delete[] edge;
			delete[] fs;
			delete[] distance;
		}
	
	void run(){
		int ans = 1;
		int min = 99999999;
		int temp;
		for(int i=1;i<=n_c;i++){
			if(fs[i]==true){
				set_dis(i, 1);
			}
		}
		/*
					cout << "distance : ";
			for(int j=1 ; j<=n_c;j++)
				cout << distance[j] << " ";
			cout << endl;
		*/
		for(int i=1;i<=n_c;i++){
			//if(fs[i]==false){
				temp = set_dis(i, 0);
				//cout << "temp"<< i << " : " << temp << endl;
				if(temp<min){
					ans = i;
					min = temp;
				}
			//}
		}
		
		cout << ans << endl;
	}
	
	int set_dis(int node, bool mode){
		int* dis;
		int* touch;
		int total = 0;
		int min, min_idx=0, max=0;
		dis = new int[n_c+1];
		touch = new int[n_c+1];
		
		for(int i=0;i<=n_c;i++){
			dis[i] = edge[node][i];
			touch[i] = node;
		}
		
		for(int i=0;i<n_c-1;i++){
			min = INF;
			for(int j=1;j<=n_c;j++){
				if(j==node) continue;
				if(dis[j]>=0 && dis[j]<min && j!=node){
					min = dis[j];
					min_idx = j;
				}
			}
			if(mode == true){
				if(min<distance[min_idx])
					distance[min_idx] = min;
			}
			else{
				if(min<distance[min_idx])
					total = min;
				else
					total = distance[min_idx];
			}
			if(total>max)
				max = total;
			/*
			cout << " testcase " << i << " : ";
			for(int j=1 ; j<=n_c;j++)
				cout << dis[j] << " ";
			cout << endl;
			*/
			for(int j=1;j<=n_c;j++){
				if(dis[min_idx] + edge[min_idx][j] < dis[j] && j!=node){
					dis[j] = dis[min_idx] + edge[min_idx][j];
					touch[j] = min_idx;
				}
			}
			dis[min_idx] = -1;
		}

		
		delete[] dis;
		delete[] touch;
		return max;
	}
};

int main() {
	int n;
	int a, b;
	cin >> n;
	for(int i=0;i<n;i++){
		cin >> a >> b;
		fire_station k(a, b);
		k.run();
		cout << endl;
	}
	return 0;
}