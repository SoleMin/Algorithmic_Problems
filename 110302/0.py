# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

n = int(input())

for _ in range(n):
	l = input()
	n, m = map(int, input().split())
	l = []
	for _ in range(n):
		l.append(input().upper())
	
	for _ in range(int(input())):
		u = input().upper()
		res = []

		for i in range(n):
			for j in range(m):
				h=0
				if l[i][j] == u[0]:
					x = len(u)	
					res_list = [l[i][j]] * 8

					if j+x <= m:
						if j+x == m:
							res_list[0] += l[i][j+1:]
						else:
							res_list[0] += l[i][j+1:j+x]
					
					if j-x > -2:
						res_list[4] += l[i][j-x+1:j][::-1]

					for k in range(1,len(u)):
						if i+k < n:
							res_list[2] += l[i+k][j]
							if j+k < m:
								res_list[1] += l[i+k][j+k]
							if j-k > -1:
								res_list[3] += l[i+k][j-k]
						
						if i-k > -1:
							res_list[6] += l[i-k][j]
							if j+k < m:
								res_list[7] += l[i-k][j+k]
							if j-k > -1:
								res_list[5] += l[i-k][j-k]


					if u in res_list:
						print(i+1,j+1)
						h = 1
				
				if h == 1:
					break
			if h == 1:
				break

	print()
	