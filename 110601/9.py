while(True):
	try:
		size = list(map(int,input().split()))
		
		if(size[0]==0 and size[1] == 0):
			break
		
		total = [0,1,2]
		n = 2
		t= 0
		while(total[n]<=size[1]):
			total.append(total[n]+total[n-1])

			n =  n+1
		for i in range(n):
			if(total[i]>=size[0]):
				t = t+1
		print(t)
	except EOFError:
		break