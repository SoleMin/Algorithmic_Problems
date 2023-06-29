# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
cn=1
while True:
	try:
		n,m=map(int,input().split())
		if n==0 and m==0: break
		
		bomb=[]
		print(f'Field #{cn}:')
		cn+=1
	
	except EOFError: break

	else:
		for i in range(n):
			bomb.append(list(input()))
			
		for i in range(n):
			for j in range(m):
				cnt=0
				if bomb[i][j]=='*':
					print('*',end='')
					continue
				
				if i-1>=0:
					if bomb[i-1][j]=='*':
						cnt+=1
					if j>0:
						if bomb[i-1][j-1]=='*':
							cnt+=1
					if j<m-1:
						if bomb[i-1][j+1]=='*':
							cnt+=1
					
				if i<n-1:
					if bomb[i+1][j]=='*':
						cnt+=1
					if j>0:
						if bomb[i+1][j-1]=='*':
							cnt+=1
					if j<m-1:
						if bomb[i+1][j+1]=='*':
							cnt+=1
							
				if j-1>=0:
					if bomb[i][j-1]=='*':
						cnt+=1
				if j<m-1:
					if bomb[i][j+1]=='*':
						cnt+=1
	
				print(cnt,end='')
			print ()
		print()
		
		