# 전역변수들을 설정해준다.
n = 0; e = 0; ne = 0; start = 0; finish = 0; rechable = False; front = 0; rear = 0;
edges = [[0, 0, 0, 0] for i in range(1000)]
check = [[0, 0] for i in range(1000)] # check[0][0] 첫번째는 각 도시 두번째인덱스에서 0은 혈액량,
city = [0 for i in range(100)]
queue = [0 for i in range(10000)]

# breadth first search를 진행한다.
def bfs():
	global front, rear, rechable

	now = [0, 0, 0] # 앞쪽, 지금, 뒷쪽
	front = 0
	rear = 0
	rechable = False
	for i in range(n):
		check[i][0] = 10000

	queue[rear] = start
	check[start][0] = 0 # 시작 도시에서의 필요한혈액량 은 0 또는 여행일
	check[start][1] = 0 # 여기에 도착할 수 있는 제일 빠른 시간 18~6
	rear += 1

	# 계속 탐색을 해준다.
	while(front < rear):
		now[0] = queue[front] # 현재 도시
		now[1] = check[now[0]][0] #현재 도시까지 필요 혈액량
		now[2] = check[now[0]][1] # 다음 도시에서의 도착 시간
		front += 1

		# 지금 있는 곳이 탐색 종료 지점이라면
		if now[0] == finish:
			# 갈 수 있는 곳이므로 rechable을 True로 바꿔준다.
			rechable = True
			continue

		# 갈 수 있는 시간의 경로들 중에서 확인
		for i in range(ne):
			# 지금 있는 곳이 탐색해야 하는 곳과 다르다면 지나간다.
			if edges[i][0] != now[0]:
				continue
			# 1. 설정된 다음 위치와 갈 수 있는 위치가 다르다.
			# 2. 지금 있는 곳에서 갈 수 있는 곳이 지금 있는 곳과 다르거나
			# 3. 다음에 갈 곳이 지금 있는 곳이거나
			# 4. 지금 갔던 루트보다 더 짧은 경로를 발견했다면
			# 지금 위치에서 갈 수 있는 다음 곳을 찾는다.
			if now[2] <= edges[i][2] and (check[edges[i][1]][0] > now[1] or (check[edges[i][1]][0] == now[1] and check[edges[i][1]][1] > edges[i][2] + edges[i][3])):
				
				# 현재 도시에서 다음 도시로의 도착시간이 해당 도착역에 출발 시간보다 작은경우 
				# 그리고 도착 도시에서의 최소 혈액량보다 현재의 혈액량이 작은경우 또는 
				#혈액량이 같지만 도착 도시에서의 도착 시간보다 현재의 도착 시간이 더 빠른 경우
				
				queue[rear] = edges[i][1] # 더 짧은 경로 설정 큐에다가 도시정보를 입력
				check[edges[i][1]][0] = now[1] # 가장 적은 혈액량 업데이터
				check[edges[i][1]][1] = edges[i][2] + edges[i][3] # 가장 이른 도착 시간업데이터
				'''
				코드 작성
				check[edges[i][1]][0] == now[1] # 도시에서 도달하기까지의 누적 혈액량 now[1] 혈액량
				'''
				rear += 1
			# 지금 위치에서 갈 수 있는 곳을 찾는다.
			elif check[edges[i][1]][0] > now[1] + 1 or (check[edges[i][1]][0] == now[1] + 1 and check[edges[i][1]][1] > edges[i][2] + edges[i][3]):
				queue[rear] = edges[i][1]
				check[edges[i][1]][0] = now[1] + 1
				check[edges[i][1]][1] = edges[i][2] + edges[i][3]
				
				'''
				코드 작성
				'''
				rear += 1

# 이미 있는 도시 이름인지 확인한다.
def get_city(name):
	global n
	for i in range(n):
		if name == city[i]:
			return i
	city[n] = name
	n += 1
	return n - 1

# 시작
if __name__ == "__main__":
	T = int(input()) # 테스트 케이스 개수
	for t in range(1, T+1):
		n = 0; ne = 0
		e = int(input())
		for i in range(e):
			city1, city2, r1, r2 = input().split()
			r1 = int(r1)
			r2 = int(r2)
			r1 %= 24 #24 = 0으로 표시
			# 시간이 맞지 않으면 넘긴다.
			if (r1 < 18 and r1 > 6) or ((r1 + r2) % 24 > 6 and (r1 + r2) % 24 < 18):# '''코드 작성''':
				continue
				
			#print(city1, city2, r1, r2)
			edges[ne][0] = get_city(city1)  # 출발지
			edges[ne][1] = get_city(city2)  # 도착지
			edges[ne][2] = (r1 + 12) % 24   # 출발 시간 오후 표기
			edges[ne][3] = r2               # 도착 시간
			ne += 1
		
		city1, city2 = input().split()
		start = get_city(city1)     # 탐색 시작 지점
		finish = get_city(city2)    # 탐색 종료 지점

		# 탐색을 시작한다.
		bfs()

		print(f"Test Case {t}.")

		# 도달할 수 있는지 없는지 확인하고 출력한다.
		if rechable:
			print(f"Vladimir needs {check[finish][0]} litre(s) of blood.")
		else:
			print("There is no route Vladimir can take.")