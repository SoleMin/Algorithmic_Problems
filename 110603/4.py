cnt=0
lst= [2,5,13]
while True:
	if cnt >1000:
		break
	Gubo = lst[-1]+lst[-1] + lst[-2] + lst[-3]
	lst.append(Gubo)
	cnt+=1
while True:
	try:
		a=int(input())
		print(lst[a-1])
	except:
		break