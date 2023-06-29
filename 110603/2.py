while True:
	try:
		cnt = 0
		n = int(input())
		zero = n - 3
		lst = [2,5,13]
		
		if n == 1:
			cnt = 2
		elif n == 2:
			cnt = 5
		elif n == 3:
			cnt = 13
		else:
			while True:
				if zero == 0:
					break
				last = 2 * lst[-1] + lst[-2] + lst[-3]
				lst.append(last)
				cnt = lst[-1]
				zero -= 1
		
		
		print(cnt)
	except:
		break

