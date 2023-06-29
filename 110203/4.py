T = int(input())

for i in range(T):
	N = int(input())
	P = int(input())
	lst = []
	cnt = 0
	
	for j in range(P):
		lst.append(int(input()))
	
	for x in range(1,N+1):
		if x % 7 != 0 and x % 7 != 6:
			for j in range(P):
				if x % lst[j] == 0:
					cnt += 1
					break
	
	print(cnt)
	
	

