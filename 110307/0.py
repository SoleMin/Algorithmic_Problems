import sys

l = []
while True:
	x = sys.stdin.readline().rstrip('\n')
	if x == '':
		break

	l.append(x)

def fuc(p, n, b):
	g = 0
	if p[-1] == b:
		if len(p[-1]) == len(p[-2]):
			f = 0
			for i in range(len(p[-2])):
				if p[-2][i] != p[-1][i]:
					f += 1
			if f == 1:
				res_n.append(n)
				res.append(p)
				return
			else:
				g = 1
		else:
			g = 1
		
		if g == 1:
			res_n.append(9999)
			res.append(p)
			return
			
	
	
	
	
	
	q = []
	for i in l:
		if (i in p) and (i != b):
			continue
		else:
			if len(i) == len(p[-1]):
				h = 0
				for j in range(len(i)):
					if i[j] != p[-1][j]:
						h += 1
				if h == 1:
					q.append(i)
	
	if q == []:
		fuc(p + [b], n + 1, b)
	
	else:
		for i in q:
			fuc(p + [i], n + 1, b)
					
				
				
while True:
	x = sys.stdin.readline().rstrip('\n')
	
	if x == '':
		break
	
	a, b = x.split()
	
	res_n = []
	res = []
	
	p = [a]
	fuc(p, 1, b)
	t = 0
	
	if min(res_n) <= 2:
		if min(res_n) < 2:
			print('No solution.')
			t = 1
			continue

		for i in range(len(res_n)):
			if res_n[i] == 2:
				u = i
				break

		if len(res[u][0]) != len(res[u][1]):
			print('No solution.')
			t = 1
		else:
			z = 0
			for i in range(len(res[u][0])):
				if res[u][0][i] != res[u][1][i]:
					z += 1

			if z == 1:
				print(res[u][0])
				print(res[u][1])
				t = 1
				
			else:
				print('No solution.')
				t = 1
	elif min(res_n) == 9999:
		print('No solution.')
		t=1
	
	
	else:
		h = 0
		for i in range(len(res_n)):
			if res_n[i] == min(res_n):
				h = i
				break
	
	if t == 0:
		for i in res[h]:
			print(i)
			
	
	#print('res_n : ', res_n)
	#print('res : ',res)

	print()