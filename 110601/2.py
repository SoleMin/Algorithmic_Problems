while True:
	a,b = map(int,input().split())
	if a == 0 and b == 0:
		break
	
	lst = [1,2]
	result = []
	Max = 0
	if a == 1:
		result.append(1)
		result.append(2)
	elif a == 2:
		result.append(2)
	while True:
		if Max > b :
			break
		Sum = lst[-1] + lst[-2]
		lst.append(Sum)
		Max = lst[-1]
		
		if a <= Max <= b:
			result.append(Max)
		
	print(len(result))
		
	
	
