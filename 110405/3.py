T = int(input())

for _ in range(T):
	blank = input()
	N = int(input())
	lst = []
	for i in range(N):
		lst.append(input().split())
		
	sub_lst = lst
	stack = []
	for i in range(len(lst)):
		stack.append(i+1)
	
	for i in range(len(lst)):
		if i < len(lst)-1:
			for j in range(len(lst)-1): 
				if int(lst[j][0]) * int(lst[j+1][1]) > int(lst[j][1]) * int(lst[j+1][0]):
					lst[j], lst[j+1] = lst[j+1], lst[j]
					stack[j], stack[j+1] = stack[j+1], stack[j]
	
	for i in range(len(stack)):
		stack[i] = str(stack[i])
	print(' '.join(stack))
	print("")
	

