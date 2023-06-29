while True:
	a,b=map(int,input().split())
	if a==0 and b==0:
		break
	
	lst =[1,2]
	cnt=0
	Fibo=0
	if a==1:
		cnt +=2
	elif a==2:
		cnt+=1
	while True:
		if Fibo > b:
			break
		Fibo = lst[-1] + lst[-2]
		lst.append(Fibo)
		if a<=Fibo and b>=Fibo:
			cnt +=1
	print(cnt)
		
	