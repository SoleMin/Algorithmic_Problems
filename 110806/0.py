# 식별자, 상태들의 리스트, 목표상태
def reachable(identifier, state, cell):
	state_list = [] # 상태들을 저장할 list
	state_list.append(state)

	cell_temp = ''  # 만들어진 상태를 저장할 변수

	while True:
		for i in range(len(state)):

			# 양 옆의 값으로 현재상태를 예측
			temp = '0b'+str(state[i-1]+state[i]+state[(i+1)%len(state)])
			temp = int(temp, 2)

			# 예측한 상태를 cell_temp에 저장
			# identifier의 길이보다 길면, 0을 append
			if temp >= len(identifier):
				cell_temp += '0'
			else:
				cell_temp += identifier[temp]

		# 목표하는 상태와 도달한 상태가 같으면 True를 반환
		if cell_temp == cell:
			return True

		# 현재 만든 state가 저장한 state에 없다면, list에 저장
		# list에 있다면, cell에 도달할 수 없음을 의미하기에 False를 반환
		if cell_temp not in state_list:
			state_list.append(cell_temp)
		else:
			return False

		cell_temp = ''

# 셀의 길이만큼 모든 state의 길이를 맞춰줌
def make_same_length(state, num):
	while len(state) < num:
		state = '0' + state
	return state

# 검사할 코드가 담긴 배열, 백트래킹 현재 깊이, 주어진 코드의 길이(목표 깊이), 식별자, 최종 상태, 최종 상태에 도달 가능한 지를 저장
def back_traking(state, depth, num, identifier, cell, is_reachable):
	# 종료 조건
	#print('state, is_reachable :',state,is_reachable)
	global x
	if x:
		return x
	
	# 종료조건에 충족하지 않으면 계속 진행
	# 최종 길이와 현재 길이가 같으면 state를 완성한 것이니 rechable인지 확인
	if depth == num:
		if reachable(identifier, state, cell):
			x = True
			return x
		
	
	else:
		for i in range(2):
			back_traking(state + str(i), depth+1, num, identifier, cell, is_reachable)
			if x:
				break
	
	return x
	# 최종 길이와 현재 길이가 같지 않으면 deepth를 증가시키고 backtracking을 진행



try:
	while True:
		x = False
		identifier, num, cell = input().split() # 식별자, 셀의 개수, 상태
		num = int(num)

		# 식별자를 셀의 개수에 맞게 바꿔줌
		identifier = bin(int(identifier))[2:]
		identifier = make_same_length(identifier, num)
		#print('id : ',identifier)
		is_reachable = False

		# 서로다른 오토마타들을 만들어내고, Reachable인지 확인함

		is_reachable = back_traking('', 0, num, identifier[::-1], cell, is_reachable)
		#print('is_reachable : ',is_reachable)
		if is_reachable:
			print("REACHABLE")
		else:
			print("GARDEN OF EDEN")

except EOFError:
    exit()