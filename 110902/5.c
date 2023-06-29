#include <stdio.h>
#include <stdbool.h>

int S, T;
int n;
int dist[10000];
int queue[10000];
int used[10000];
int just[8][4] = {{0, 0, 0, 1},
									{0, 0, 0, -1},
									{0, 0, 1, 0},
									{0, 0, -1, 0},
									{0, 1, 0, 0},
									{0, -1, 0, 0},
									{1, 0, 0, 0},
									{-1, 0, 0, 0}};

void input(void) {
	S = 0;
	T = 0;
	int temp;
	for (int i = 0; i < 4; i++) {
		scanf("%d", &temp);
		S = S * 10 + temp;
	}
	for (int i = 0; i < 4; i++) {
		scanf("%d", &temp);
		T = T * 10 + temp;
	}
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		int f_temp = 0;
		for (int j = 0; j < 4; j++) {
			scanf("%d", &temp);
			f_temp = f_temp * 10 + temp;
		}
		used[f_temp] = 1;
	}
}

int help_me(int x, int i) {
  int god[4];
  for (int i = 3; i >= 0; i--) {
    god[i] = x % 10;
    x /= 10;
  }
  
}

int bfs(void) {
	used[S] = 1;
  dist[S] = 0;
  int saved_node = 0;
  queue[saved_node++] = S;
  int now = 0;
  while (now < saved_node) {
    int cur_node = queue[now];
    int god[4];
    for (int i = 0; i < 4; i++) {
      god[3 - i] = cur_node % 10;
      cur_node /= 10;
    }
    int help[4];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 4; j++) {
				help[j] = god[j] + just[i][j];
        if (help[j] < 0)
          help[j] = 9;
        if (help[j] > 9)
          help[j] = 0;
      }
      int next = help[0] * 1000 + help[1] * 100 + help[2] * 10 + help[3];
			//printf("%d\n", next);
      if (next == T)
        return dist[queue[now]] + 1;
      if (!used[next]) {
        dist[next] = dist[queue[now]] + 1;
        used[next] = 1;
        queue[saved_node++] = next;
      }
    }
    now++;
  }
  return -1;
}

int main(void) {
	int t;
	scanf("%d", &t);
	for (int i = 0; i < t; i++) {
    for (int i = 0; i < 10000; i++) {
      dist[i] = queue[i] = used[i] = 0;
    }
		input();
		int result = bfs();
		printf("%d\n", result);
	}
}