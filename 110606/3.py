

while True:
	try:
		t = int(input())
		sumAll = 1
		n = 2
		count = 1
		while True:
			sumAll += pow(2, n-1) * n
			count += n
			if count == t:
				break
			elif count > t:
				sumAll -= pow(2, n-1 ) * (count - t)
				break
			n+=1
		print(sumAll)
	except EOFError:
		break