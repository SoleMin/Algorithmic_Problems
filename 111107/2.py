INF = 99999

def find(sticks, kits):
	#'''코드 작성 # 오름차순으로 입력된걸 내림차순으로 바꿔준다.
	sticks.sort(reverse=True)
	#'''
	
	bad = [0 for _ in range(len(sticks) + 3)] # 0으로 초기화해준다

	# 젓가락 개수만큼 반복
	# A-B의 값이 가장 작으려면 이미 정렬된 상태로 들어온 젓가락의 길이를 이용하면 된다
	# 현재 젓가락의 옆에 있는걸 짝으로 하면 된다.
	for i in range(1, len(sticks)):
		#'''		코드 작성
		bad[i+1] = (sticks[i-1] - sticks[i]) ** 2
		#'''
	#print('bad : ',bad)
	
	# 탐색할 젓가락
	prev = [0 for _ in range(len(sticks) + 1)] # 0~40
	current = [-1 for _ in range(len(sticks) + 1)] # 0~40

	# 사람의 수 만큼 반복
	for k in range(1, kits + 1): # 1~9 kits=9
		# 일단 inf로 초기화 한다
		current[3 * k - 1] = INF # 2
		
		# 한 사람이 쓸 젓가락 개수는 3개, 남은 젓가락의 수 * 2 + 1 만큼 탐색
		for s in range(3 * k, len(sticks) - abs(k - kits) * 2 + 1): # 3 24 6 27 9 28 12 30       27 40
			# 지금의 젓가락이 이전꺼와 bad의 합보다 작다면
			# 유지한다.
			# 작다면 바꿔준다.
			#'''			코드 작성
			if current[s-1] > prev[s-2] + bad[s]:
				current[s] = prev[s-2] + bad[s]
			else:
				current[s] = current[s-1]

			#'''
				
		
		
		prev, current = current, prev
		#print('prev    : ',prev)
		#print('current : ',current)

	return prev[len(sticks)]

# 테스트케이스 개수 입력
T = int(input())
# 테스트케이스 개수만큼 반복
for _ in range(T):
	K, N = map(int, input().split())
	chops = list(map(int, input().split()))
	# 최적의 값을 찾아낸다.
	print(find(chops, K+8))