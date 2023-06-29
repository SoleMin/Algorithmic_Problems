#include <iostream>
#include <map>
#include <queue>

using namespace std;

class Tourist_Guide{
	private:
		map<string, int> city;
		int road_num;
		int city_num;
		int** road;
		int* degree;
		int* check;
		int* camera;
	
	public:
		Tourist_Guide(int n){
			string temp1, temp2;
			int x, y;
			road = new int*[n];
			degree = new int[n];
			camera = new int[n];
			check = new int[n];
			city_num = n;
			for(int i=0;i<n;i++){
				cin>>temp1;
				city.insert(make_pair(temp1, i));
				degree[i] = 0;
				camera[i] = 0;
				check[i] = 0;
			}
			cin >> road_num;
			for(int i=0;i<city_num;i++)
				road[i] = new int[road_num];
			
			for(int i=0;i<road_num;i++){
				cin>>temp1>>temp2;
				x = find_city_num(temp1);
				y = find_city_num(temp2);
				
				road[x][degree[x]] = y;
				road[y][degree[y]] = x;
				degree[x]++;
				degree[y]++;
			}
		}
	
		~Tourist_Guide(){
			for(int i=0;i<city_num;i++)
				delete[] road[i];
			
			delete[] road;
			delete[] degree;
			delete[] camera;
			delete[] check;
		}
	
		void run(int sharf){
			int count;
			int re=0;
			//bfs(0);
			for(int i=0;i<city_num;i++){
				for(int j=0;j<city_num;j++)
					check[j] = 0;
				count = bfs(i);
				if(count != city_num-1){
					camera[i] = 1;
					re++;
				}
			}
			
			print_ans(sharf, re);
		}
	
		int bfs(int erase_city){
			queue<int> q;
			int temp1, count = 0;
			
			check[erase_city] = 1;
			if(erase_city == 0){
				q.push(1);
				check[1] = 1;
			}
			else{
				q.push(0);
				check[0] = 1;
			}
			
			for(;!q.empty();){
				temp1 = q.front();
				//cout << temp1 << endl;
				q.pop();
				if(temp1 == erase_city) continue;
				count++;
				for(int i=0;i<degree[temp1];i++){
					if(road[temp1][i]!=erase_city && check[road[temp1][i]] == 0){
						q.push(road[temp1][i]);
						check[road[temp1][i]] = 1;
					}
				}
			}
			//cout << erase_city << " : " << count << endl;
			return count;
		}
	
		void print_ans(int a, int b){
			map<string, int> ans;
			int c_n = 0;
			cout << "City map #"<< a <<": " << b << " camera(s) found" << endl;
			for(int i=0;i<city_num;i++){
				if(camera[i] == 1)
					ans.insert(make_pair(find_city(i), i));
			}
			for(auto k = ans.begin(); k != ans.end();k++)
				cout << k->first << endl;
		}
		int find_city_num(string ct){
			int re = city.find(ct)->second;
			return re;
		}
		
		string find_city(int val){
			for(auto i = city.begin();i != city.end();i++){
				if(i->second == val)
					return i->first;
			}
			return "error";
		}
	
	//test
		void print_(){
			for(int i=0;i<city_num;i++){
				for(int j=0;j<degree[i];j++){
					cout<< road[i][j] << " ";
				}	
				cout<< endl;
			}
			cout << "degree" << endl;
			for(int i=0;i<city_num;i++){
				cout << degree[i] << " ";
			}
			cout << endl;
		}
};

int main() {
	int n;
	for(int i = 1;cin>>n && n!=0;i++){
		Tourist_Guide tg(n);
		tg.run(i);
		//tg.print_();
		cout << endl;
	}
	return 0;
}