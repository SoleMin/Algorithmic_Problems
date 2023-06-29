#include <iostream>
#include <queue>
#include <stack>

#define MAXV 200
#define MAXDEGREE 200

using namespace std;

class graph {
private:
	int can_num[10][10][10][10];
	int start[4];
	int answer[4];
	int ans;

public:
	graph(){
		for(int a=0;a<10;a++)
			for(int b=0;b<10;b++)
				for(int c=0;c<10;c++)
					for(int d=0;d<10;d++)
						can_num[a][b][c][d] = 0;
	}

	// 스타트
	void run() {
		int a, b;
		init();
		bfs();
		print_ans();
		//print_();
	}

	// 시작값넣기
	void init() {
		int n, a, b, c, d;
		for(int i=0;i<4;i++)
			cin >> start[i];
		for(int i=0;i<4;i++)
			cin >> answer[i];
		cin >> n;
		for(int i=0;i<n;i++){
			cin >> a >> b >> c >> d;
			can_num[a][b][c][d] = -1;
		}
	}
	void bfs() {
		int a[4];
		int al[4];
		int ar[4];
		int temp, temp1, temp2;
		queue<int> q;
		
		temp = make_num(start[0], start[1], start[2], start[3]);
		q.push(temp);
		can_num[start[0]][start[1]][start[2]][start[3]] = 1;
		
		for(;!q.empty() && can_num[answer[0]][answer[1]][answer[2]][answer[3]] == 0;){
			temp = q.front();
			q.pop();
			de_num(a, temp);
			temp1 = can_num[a[0]][a[1]][a[2]][a[3]];
			
			//cout << a[0]<< " " << a[1]<< " " << a[2]<< " " << a[3] << endl;
			
			for(int i=0;i<4;i++){
				al[i] = a[i] - 1;
				if(al[i] == -1) al[i] = 9;
				ar[i] = (a[i] + 1)%10;
			}
			
			if(can_num[al[0]][a[1]][a[2]][a[3]] == 0){
				can_num[al[0]][a[1]][a[2]][a[3]] = temp1 + 1;
				temp2 = make_num(al[0], a[1], a[2], a[3]);
				q.push(temp2);
			}
			if(can_num[ar[0]][a[1]][a[2]][a[3]] == 0){
				can_num[ar[0]][a[1]][a[2]][a[3]] = temp1 + 1;
				temp2 = make_num(ar[0], a[1], a[2], a[3]);
				q.push(temp2);
			}
			
			if(can_num[a[0]][al[1]][a[2]][a[3]] == 0){
				can_num[a[0]][al[1]][a[2]][a[3]] = temp1 + 1;
				temp2 = make_num(a[0], al[1], a[2], a[3]);
				q.push(temp2);
			}
			if(can_num[a[0]][ar[1]][a[2]][a[3]] == 0){
				can_num[a[0]][ar[1]][a[2]][a[3]] = temp1 + 1;
				temp2 = make_num(a[0], ar[1], a[2], a[3]);
				q.push(temp2);
			}
			
			if(can_num[a[0]][a[1]][al[2]][a[3]] == 0){
				can_num[a[0]][a[1]][al[2]][a[3]] = temp1 + 1;
				temp2 = make_num(a[0], a[1], al[2], a[3]);
				q.push(temp2);
			}
			if(can_num[a[0]][a[1]][ar[2]][a[3]] == 0){
				can_num[a[0]][a[1]][ar[2]][a[3]] = temp1 + 1;
				temp2 = make_num(a[0], a[1], ar[2], a[3]);
				q.push(temp2);
			}
			
			if(can_num[a[0]][a[1]][a[2]][al[3]] == 0){
				can_num[a[0]][a[1]][a[2]][al[3]] = temp1 + 1;
				temp2 = make_num(a[0], a[1], a[2], al[3]);
				q.push(temp2);
			}
			if(can_num[a[0]][a[1]][a[2]][ar[3]] == 0){
				can_num[a[0]][a[1]][a[2]][ar[3]] = temp1 + 1;
				temp2 = make_num(a[0], a[1], a[2], ar[3]);
				q.push(temp2);
			}
		}
		ans = can_num[answer[0]][answer[1]][answer[2]][answer[3]];
	}
	int make_num(int a1, int a2, int a3, int a4){
		return a1*1000 + a2*100 + a3*10 + a4;
	}
	void de_num(int* a, int num){
		a[0] = num/1000;
		a[1] = (num%1000)/100;
		a[2] = (num%100)/10;
		a[3] = num%10;
	}

	void print_ans() {
		cout << ans - 1 << endl;
	}
	
};


int main() {
	int n, l;
	cin >> n;
	for (int i=0;i<n;i++){
		graph a;
		a.run();
	}
}