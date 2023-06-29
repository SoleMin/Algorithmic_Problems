# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
contents = []
while True:
	try:
		line = input()
	except EOFError:
		break
	contents.append(line)

def count(value):
	word_len = len(value.split())
	count_letters = len(value) - value.count(' ') - value.count('\t')
	print(count_letters, word_len)

	
for idx, value in enumerate(contents):
	count(value)

	
