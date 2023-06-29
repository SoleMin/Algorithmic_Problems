import sys

def printNumber(num):
	if num == 9:
		print("Jack", end=" ")
	elif num == 10:
		print("Queen", end=" ")
	elif num == 11:
		print("King", end=" ")
	elif num == 12:
		print("Ace", end=" ")
	else:
		print(f"{num + 2}", end=" ")

def printSuit(suit):
	if suit == 0:
		print("Clubs")
	elif suit == 1:
		print("Diamonds")
	elif suit == 2:
		print("Hearts")
	elif suit == 3:
		print("Spades")

a = 0
testcase = int(input())
new_line = input()
if new_line == '':
	pass

while a < testcase:
	try:
		n = input()
		if n == '':
			continue
		else:
			n = int(n)
		
		card = []
		for i in range(n):
			suffle_method = list(map(int, sys.stdin.readline().split()))
			card.append(suffle_method)
		
		deck = [None] * 53
		for i in range(1,53):
			deck[i] = i
		oldDeck = [None] * 53
		
		while True:
			try:
				method = input()
				if method == '':
					break
				for k in range(0,53):
					oldDeck[k] = deck[k]
				for j in range(0,52):
					deck[j+1] = oldDeck[card[int(method)-1][j]]
			except EOFError or ValueError:
				break
		
		for i in range(1,53):
			num = (deck[i] - 1) % 13
			suit = int((deck[i] - 1) /13)
			printNumber(num)
			print("of", end=" ")
			printSuit(suit)
		
		a+=1
		if a < testcase:
			print()
		else:
			pass
	except EOFError:
		break
	