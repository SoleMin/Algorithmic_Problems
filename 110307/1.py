def check(A, B):
	if len(B) != len(A):
		return False
	cnt = 0
	for a,b in zip(A,B):
		if a != b:
			cnt += 1
	if cnt == 1:
		return True
	return False


def bfs(G, start, end):
	q = [start]
	if start not in G or end not in G:
		return []
	road = {}
	node = ""
	while q:
		node = q.pop(0)
		if node == end:
			break
		for n in G[node]:
			if n in road:
				continue
			road[n] = node
			q.append(n)
	answer = [end]
	node = end
	while True:
		answer.append(road[node])
		node = road[node]
		if node == start:
			break
	answer.reverse()
	return answer

	
graph = {}
dic=[]
while True:
	word = input()
	if word == "":
		break
	if word in dic:
		continue
	dic.append(word)
for di in dic:
	for d in dic:
		if check(di,d):
			graph[di] = graph.get(di, []) +[d]
			
while True:
	try:
		start, end = input().split()
		if start not in dic or end not in dic:
			print("No solution.")
		else:
			lst = bfs(graph, start, end)
			if lst:
				for l in lst:
					print(l)
			else:
				print("No solution.")
		print()
	except EOFError:
		break
			
			
			
			
			
			
			
			
			
			
			