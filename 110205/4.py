import sys
idx = 0
T = int(sys.stdin.readline())
sys.stdin.readline()
while(idx < T):
	n = int(sys.stdin.readline())
	lst = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
	
	kList = []
	while(1):
		k = sys.stdin.readline().rstrip()
		if (len(k) == 0):
			break
		kList.append(int(k))
	
	cards = []
	
	def addCard(pattern):
		for i in range(2, 15):
			if (i <= 10):
				cards.append(str(i)+" of " + pattern )
			elif (i == 11):
				cards.append("Jack of " + pattern)
			elif (i == 12):
				cards.append("Queen of " + pattern)
			elif( i == 13):
				cards.append("King of " + pattern)
			elif (i == 14):
				cards.append("Ace of " + pattern)
	addCard("Clubs")
	addCard("Diamonds")
	addCard("Hearts")
	addCard("Spades")
	
	
	
	for i in kList:
		newCards = []
		for j in range(len(lst[i-1])):
			newCards.append(cards[lst[i-1][j] - 1])
		cards = newCards
	print("\n".join(cards) + "\n")
	
	idx += 1