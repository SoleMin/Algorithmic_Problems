try:
	global Field_num
	Field_num=1
	while True:
		M=0
		minefield=[]
		n,m=map(int,input().split())
		starpoint=[]
		A=[[0 for _ in range(m)]for __ in range(n)]
		if m==0:
			break
		
		for _ in range(n):
			line=input()
			minefield.append(line)
		#n이 1일때는 line이 하나!
		if n==1 and m>1:
			for i in range(m):
				if minefield[0][i]=='*':
					starpoint.append(i)
					if i==0:
						A[0][i+1]+=1
					elif i==m-1:
						A[0][i-1]+=1
					else:
						A[0][i-1]+=1
						A[0][i+1]+=1
			for i in starpoint:
				A[0][i]='*'
		# 둘다 1이면 뭐안해도 그냥 별만 찍어도됨
		elif n==1 and m==1:
			if minefield[0][0]=='*':
				A[0][0]='*'
		elif n>1 and m==1:
			for i in range(n):
				if minefield[i][0]=='*':
					starpoint.append(i)
					if i==0:
						A[i+1][0]+=1
					elif i==n-1:
						A[i-1][0]+=1
					else:
						A[i+1][0]+=1
						A[i-1][0]+=1
			for i in starpoint:
				A[i][0]='*'
		else:
			for i in range(n):
				for j in range(m):
					if (minefield[i][j]=='*'):
						starpoint.append((i,j))
						if i==0:
							if j==0:
								A[i][j+1]+=1
								A[i+1][j]+=1
								A[i+1][j+1]+=1
							elif j==m-1:
								A[i][j-1]+=1
								A[i+1][j-1]+=1
								A[i+1][j]+=1
							else:
								A[i][j-1]+=1
								A[i][j+1]+=1
								A[i+1][j-1]+=1
								A[i+1][j]+=1
								A[i+1][j+1]+=1
						elif i==n-1:
							if j==0:
								A[i-1][j]+=1
								A[i-1][j+1]+=1
								A[i][j+1]+=1
							elif j==m-1:
								A[i-1][j]+=1
								A[i-1][j-1]+=1
								A[i][j-1]+=1
							else:
								A[i-1][j-1]+=1
								A[i-1][j]+=1
								A[i-1][j+1]+=1
								A[i][j-1]+=1
								A[i][j+1]+=1
						else:
							if j==0:
								A[i-1][j]+=1
								A[i-1][j+1]+=1
								A[i][j+1]+=1
								A[i+1][j+1]+=1
								A[i+1][j]+=1
							elif j==m-1:
								A[i-1][j]+=1
								A[i-1][j-1]+=1
								A[i][j-1]+=1
								A[i+1][j-1]+=1
								A[i+1][j]+=1
							else:
								A[i-1][j-1]+=1
								A[i-1][j]+=1
								A[i-1][j+1]+=1
								A[i][j-1]+=1
								A[i][j+1]+=1
								A[i+1][j-1]+=1
								A[i+1][j]+=1
								A[i+1][j+1]+=1

			for i,j in starpoint:
				A[i][j]='*'
			
		print(f'Field #{Field_num}:')
		Field_num+=1
		if M==1:
			for i in range(n-1,-1,-1):
				print(*A[i],sep='')
		else:
			for i in range(n):
				print(*A[i],sep='')
			print()
					
except EOFError:
	print('Eof')
# except:
# 	print()