while True:
	try:
		A = str(input())
		B = str(input())
		A = list(A)
		B = list(B)

		lst = []

		for i in range(len(A)):
			for j in range(len(B)):
				if A[i] == B[j]:
					x = A[i]
					A_cnt = A.count(x)
					B_cnt = B.count(x)
					lst_cnt = lst.count(x)
					if A_cnt > lst_cnt and B_cnt > lst_cnt:
						lst.append(x)
						
		lst.sort()
		print(''.join(lst))
	
	except:
		break
	

