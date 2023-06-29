while(True):
	try:
		n = int(input())
		total = []
		total.append(1)
		total.append(2)
		total.append(5)
		total.append(13)
		
		for i in range(4,n+1):
			
			total.append((total[i-1]*2) + total[i-2] + total[i-3])
			
		print(total[n])
	except EOFError: 
		break
			