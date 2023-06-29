while(1):
	lst=list()
	lst.append(int(1))
	lst.append(int(2))
	count=0
	
	a,b=input().split()
	a=int(a)
	b=int(b)
	
	if a==0 and b==0:
		break
	
	for i in range(2,500):
		lst.append(int(lst[i-2]+lst[i-1]))
	
	for i in range(500):
		if lst[i]>=a and lst[i]<=b:
			count+=1
	
	print(count)
	
