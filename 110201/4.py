while 1:
	try:
		
		N_lst = list(map(int,input().split()))
		first = []

		if N_lst[0] == 1:
			print("Jolly")
		else:
			for i in range(len(N_lst)-2):
				first.append(abs(N_lst[i+1]-N_lst[i+2]))

		first.sort()
	
		if N_lst[0] == 2 and first[0] == 1:
			print("Jolly")
		else:
			for i in range(N_lst[0]-2):
				if first[i] == first[i+1]-1 and first[0] == 1:
					if i == N_lst[0]-3 :
						print("Jolly")
					else:
						continue
				else:
					print("Not jolly")
					break
	except:
		break




