num=int(input())
k=0
while k<num:
	N=int(input())
	P=int(input())
	h=[]
	for _ in range(P):
		h.append(int(input()))
	frisat=[6,7]
	#6 7의 배수이면 빼주어야함.
	simulation=[0 for _ in range(N)]
	
	for p in range(P):
		for i in range(1,N+1):
			if h[p]*i>N:
				break
			else:
				simulation[h[p]*i-1]=1
				
	for t in frisat:
		for i in range(N):
			if t+7*i-1>=N:
				break
			else:
				simulation[(t+7*i)-1]=0
				
	count=0
	for c in simulation:
		if c==1:
			count+=1
	print(count)
	k+=1