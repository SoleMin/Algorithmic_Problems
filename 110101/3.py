try:
	while True:
		I,J=map(int,input().split())
		change=0
		if I>J:
			tmp=I
			I=J
			J=tmp
			change=1
		Max=0
		for n in range(I,J+1):
			count=1
			while n!=1:
				if n%2==0:
					n=n//2
				else:
					n=3*n+1
				count+=1
			if count>Max:
				Max=count
		if change==1:
			tmp=I
			I=J
			J=tmp
		print(I,J,Max)
except:
	print()
