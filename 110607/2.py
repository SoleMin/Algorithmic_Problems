while True:
	N = int(input())
	lst = [1,2]
	result = 2
	cnt = 3
	s = 3
	
	if N == 0:
		break
	elif N == 1:
		result = 1
	elif N == 2:
		result = 2
	elif N == 3:
		result = 2
	else:
		x = 2
		while True:
			result += 1
			lst.append(x)
			s += x
			if s >= N:
				break
			
			if result == cnt:
				x += 1
				cnt += lst[x-1]
				
			
			
	print(result)
	
	