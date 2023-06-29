while True:
	try:
		N = int(input())
		start = 2
		lst = [1,2]
		num = 2
		if N == 1:
			print(1)
		
		else:
			while True:
				if start == N:
					break
				start += 1
				if lst[-1] != lst[len(lst)-num]:
					lst.append(lst[-1])
				else:
					num += 1
					lst.append(lst[-1]*2)
			print(sum(lst))
			
		
	except:
		break

