import sys

f = [False] * (1000)
f[1] = 1
f[2] = 2

for i in range(3,1000):
	f[i] = f[i-1] + f[i-2]
	




#1 2 3 5 8 13 21 33 54 87 141

while True:
	a, b = map(int, input().split())
	
	if a == 0 and b == 0:
		break
	
	res = 0
	for i in range(1,1000):
		if f[i] >= a:
			if f[i] <= b:
				res += 1
			else:
				break
				
	print(res)
	 

