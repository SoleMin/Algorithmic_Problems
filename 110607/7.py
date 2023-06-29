Inputlist=[]
try:
	while True:
		A=int(input())
		Inputlist.append(A)
except:
	#  1 2,3
	for Input in Inputlist:	
		i=3
		f=[1,2,2]
		while True:
			Out=False
			a=f[i-1]
			for _ in range(a):
				f.append(i)
				if len(f)-1>Input:
					Out=True
					break
			if Out:
				break
			i+=1
		if Input==0:
			print()
		else:
			print(f[Input-1])