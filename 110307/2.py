import sys

def getDictionary():
	temp = []
	while True:
		word = sys.stdin.readline().strip()
		if word =='':
			break
		temp.append(word)
	return temp

def get_two_word():
	words = []
	while True:
		two_word = sys.stdin.readline().split()
		if not two_word:
			break
		words.append(two_word)
	return words

def similar_words(word, dictionary):
	temp = []
	
	for idx in range(len(word)):
		for alphabet in "abcdefghijklmnopqrstuvwxyz":
			new_word = word[:idx] + alphabet + word[(idx + 1):]
			if new_word in dictionary and new_word != word:
				temp.append(new_word)
	return temp

def solution(start, end, dict_):
	if start == end:
		return [start, end]
	
	d = {}
	doublets = [start]
	
	while doublets:
		word = doublets.pop(0)
		
		if word == end:
			break
		
		for new_word in similar_words(word, dict_):
			if new_word not in d:
				d[new_word] = word
				doublets.append(new_word)
		
	if word != end:
		return False
	
	p = [word]
	while True:
		if d[word] == start:
			break
		p.insert(0, d[word])
		word = d[word]
	p.insert(0, start)
	
	return p


dict_ = getDictionary()
find_word = get_two_word()

while True:
	if len(find_word) == 0:
		break
	start, end = find_word.pop(0)
	
	result = solution(start, end, dict_)
	if result:
		for i in result:
			print(i)
	else:
		print("No solution.")
		
	if find_word:
		print()





			
		















