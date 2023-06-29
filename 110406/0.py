import sys

x = int(input())

s = input()
for _ in range(x):
	
	fee = list(map(int,input().split())) #들어가는 구간 센트 78 *10 + 2
	
	l = {}
	res = {}
	pop = []
	
	while True:
		a = sys.stdin.readline().rstrip('\n').split()
		
		if a == []:
			break
			
		if a[0] not in l.keys():
			l[a[0]] = [a[1:]]
		else:
			l[a[0]] += [a[1:]]
	
	for i in l.keys():
		res[i] = 0
		l[i] = sorted(l[i], key = lambda x : x[0])
		
		if len(l[i]) > 1:
			h = 0
			if l[i][0][1] == 'exit':
				l[i] = l[i][1:]
			
			if l[i][-1][1] == 'enter':
				l[i] = l[i][:-1]

		if len(l[i]) <= 1:
			pop.append(i)
			
	for i in pop:
		del l[i]
		del res[i]
	
	########################################################################################
	for i in res.keys():
		m = [False] * 13
		for j in range(0,len(l[i]),2):
			res[i] += (abs( int(l[i][j+1][2]) - int(l[i][j][2]) ) * 0.01 * fee[int(l[i][j][0][6:8])]) + 1
			
			if m[int(l[i][j][0][:2])] == False: #	
				m[int(l[i][j][0][:2])] = True
				res[i] += 2

	#########################################################################################
	res = dict(sorted(res.items(), key=lambda x : x[0]))
	
	for i in res.items():
		print('{0} ${1:.2f}'.format(i[0], i[1]))
	print()