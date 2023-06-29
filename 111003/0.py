# 최단경로 알고리즘을 이용해서 현재 있는 소방서로부터 최단 경로가 가장 긴 곳이 가장 짧은 곳에 소방서 설치
import numpy as np

cross = []
visit = []
dist = []

# 방문하지 않은 노드 중 시작 노드와 최단거리를 가지는 노드 반환
def get_min():
	min_len = float('inf')
	index = 0
	n = len(cross)
	for i in range(1, n):
		# 방문하지 않은 교차로 중에서 현재에서 갈 수 있는 가장 적은 거리를 가지는 교차로를 찾는다.
		#''' 코드 작성
		if visit[i] == False and dist[i] <= min_len: # dist = [inf, 10, 0, 10, inf, inf]
			min_len = dist[i]
			index = i
		#'''
	return index

# start 교차로에서 모든 교차로까지 최단 거리를 찾는다.
def find(start):
	global visit, cross, dist
	visit = [False for _ in range(i + 1)]       # 모두 방문하지 않았다
	dist = [float('inf') for _ in range(i + 1)] # 최단거리는 일단 무한대
	visit[start] = True     # 시작 교차로 방문 체크
	dist = cross[start].copy()  # 시작 교차로에서 갈 수 있는 교차로들의 거리를 가져온다.
	dist[start] = 0         # 시작 교차로에서 시작 교차로까지는 거리가 0 
	#print('dist : ',dist)
	
	# 시작 교차로, 0번 교차로를 제외한 만큼 for문을 실행한다.
	for _ in range(len(cross)-2):
		node = get_min()    # 가장 짧은 교차로를 받아온다.
		visit[node] = True  # 방문 체크
		#print(node)
		# node 교차로에서 갈 수 있는 교차로들 까지의 거리를 계산한다.
		for j in range(len(cross[node])):
			# 현재 저장된 거리보다 더 짧은 거리가 있다면 저장
			#''' 코드 작성
			dist[node] = min(dist[j] + cross[j][node],  dist[node])
			dist[j] = min(dist[node] + cross[node][j],  dist[j])
			#'''
			
	# 0번 교차로를 빼고 나머지들을 반환한다.
	#''' 코드 작성
	return dist[1:]
	#'''

T = int(input()) # 테스트 케이스 개수
# 테스트 케이스 개수만큼 반복
for _ in range(T):
	_ = input()
	# 소방서 수와 교차로 수 입력
	f, i = map(int, input().split())
	# 일단 교차로들간의 거리를 무한대로 초기화해준다.
	# 교차로 수는 1번부터 시작이므로 i+1 크기의 배열로 만들어준다.
	cross = [[float('inf') for _ in range(i+1)] for _ in range(i+1)] # 0~7
	firestation = []    # 소방서가 위치한 교차로 번호
	# 소방서와 교차로 간 거리 입력
	for _ in range(f):
		firestation.append(int(input()))
	for _ in range(i):
		c1, c2, d = map(int, input().split())
		cross[c1][c2] = d
		cross[c2][c1] = d
	
	#print('cross : ',cross)
	# 설치된 소방서가 없다면 1번 교차로에 만든다.
	if f == 0:
		print(1)
	# 설치된 소방서가 있다면 거리 계산 시작
	else:
		dist_array = [] # 설치될 소방서로부터의 거리
		fire_dist = []  # 설치된 소방서로부터의 거리 
		
		# 일단 지금 있는 소방서에서 각 교차로까지의 거리를 구한다.
		for fi in firestation:
			fire_dist.append(find(fi))
		#print('fire_dist : ',fire_dist)
		fire_dist = np.min(fire_dist, axis=0)
		#print('fire_dist : ',fire_dist) # [10 0 10 20 30 20]
		
		# 만약에 새로운 곳에 소방서를 놓는다면 새로 지어진 곳과의 거리
		for fi in range(1, i+1): # 1 ~ 6 i : 교차로의 수 6
			#''' 코드 작성
			t = [find(fi)]
			t.append(list(fire_dist))
			#print('t : ',t)
			dist_array.append(list(np.min(t , axis=0)))
			
			#'''
		#print('dist_array : ',dist_array)
		min_dist = []
		
		# 새로운 소방서가 지어진다면 교차로와 소방서들과의 가장 짧은 거리를 계산해서 넣어준다.
		for di in range(len(dist_array)):
			#'''코드 작성
			min_dist.append(max(dist_array[di]))
			#'''
		#print(min_dist) # 0 10 10 20 10 10
		# 가장 짧은 거리가 가장 긴 곳을 찾아준다.
		#'''코드 작성
		for i in range(len(min_dist)):
			if min_dist[i] == min(min_dist):
				x = i
				break
		#'''
		
		#'''
		print(x+1)
		#'''
	print()