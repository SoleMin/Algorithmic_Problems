import sys
T = int(sys.stdin.readline())
sys.stdin.readline()
idx = 0
while(idx < T):
	board = []
	while(1):
		row = sys.stdin.readline()
		if (len(row) == 0):
			break
		if (row == "\n"):
			break
		board.append(row.split())
	

	
	dic = {}
	solved = [[0] * 10 for _ in range(101)] 
	penalty = [[0] * 10 for _ in range(101)]
	for scores in board:
		if (scores[3] == "C"):
			if scores[0] not in dic:
					dic[scores[0]] = [1, int(scores[2])]
					solved[int(scores[0])][int(scores[1])] = 1
					dic[scores[0]][1] += penalty[int(scores[0])][int(scores[1])]
			else:
				if(solved[int(scores[0])][int(scores[1])] == 0):
					dic[scores[0]][0] += 1
					dic[scores[0]][1] += int(scores[2]) + penalty[int(scores[0])][int(scores[1])]
					solved[int(scores[0])][int(scores[1])] = 1
		elif(scores[3] == "I"):
			if scores[0] not in dic:
				dic[scores[0]] = [0,0]
			penalty[int(scores[0])][int(scores[1])] += 20
		else:
			if scores[0] not in dic:
				dic[scores[0]] = [0,0]
	answer = []
	for item in dic:
		answer.append([int(item)] + dic[item])

	answer.sort(key = lambda x: (-x[1], x[2], x[0]))
	
	print("\n".join([' '.join([str(i) for i in row]) for row in answer]) +"\n")
	idx += 1