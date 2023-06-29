T = int(input())
input()

num = [2,3,4,5,6,7,8,9,10,'Jack','Queen','King','Ace']
shape = ['Clubs', 'Diamonds', 'Hearts', 'Spades']

for _ in range(T):
	deck = [n for n in range(1, 53)]
	n = int(input())
	shuffle = []
	for __ in range(n):
		lst = list(map(int, input().split()))
		change = []
		for i, j in zip(lst, deck):
			if i != j:
				change.append([lst.index(i), lst.index(j)])
		shuffle.append([change[n] for n in range(0, len(change), 2)])
	
	while True:
		try:
			case = input()
			if case == "":
				break
			case = int(case) - 1
			for i, j in shuffle[case]:
				temp = deck[i]
				deck[i] = deck[j]
				deck[j] = temp
		except EOFError:
			break
	for n in deck:
		print(f'{num[(n-1) % 13]} of {shape[(n-1) // 13]}')
	print()
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
