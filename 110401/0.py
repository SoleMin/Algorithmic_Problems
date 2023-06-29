n = int(input())

for _ in range(n):
	l = list(map(int,input().split()))
	r = l[0]
	s = l[1:]
	s.sort()
	d = []
	for i in range(1,r):
		d.append(s[i] - s[i-1])
	
	#print('d : ',d)
	distance = [0] * r
	for i in range(r):
		plus = 0
		for j in range(1, max(r - i, i+1)): #i : 0, j 1 
			if i+j+1 == r:
				plus += sum(d[i:])
			else:
				plus +=	sum(d[i:i+j])
			
			if i-j < 0:
				continue
			else:
				plus += sum(d[i-j:i])
		
		
		distance[i] = plus
	
	print(min(distance))
