while True:
	try:
		seq = list(map(int, input().split()))
		n = seq[0]
		if (n <= 0) or (n > 3000):
			break
		del seq[0]
		jol = []
		no_jol = 0
		if n == 1:
			print("Jolly")
			continue
		else:
			i = 0
			while i < n-1:
				jol.append(abs(seq[i]-seq[i+1]))
				i += 1
				if i == n:
					break
			for j in range(0, n-1):
				if jol[j] in range(1, n):
					if jol.count(jol[j]) == 1:
						no_jol += 0
					else: no_jol += 1
				else: no_jol += 1
		if no_jol == 0:
			print("Jolly")
		else: print("Not jolly")
	except EOFError:
		break