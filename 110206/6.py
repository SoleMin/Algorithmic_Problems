# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
Scenario = input()

for x in range(0, int(Scenario)):
	PN = input()
	P = int(PN.split()[0])
	N = int(PN.split()[1])

	author_dict = {}
	author_dict['Erdos, P.'] = 0
	author_count = ['Erdos, P.']

	for i in range(0, P):
		instr = input()
		author_papers = instr.split(':')
		author = author_papers[0].split('., ')

		for j in range(0, len(author)-1):
			author[j] += '.'
		for j in range(0, len(author)):
			author_count.append(author[j])

		for j in range(0, len(author)):
			if (author_count.count(author[j]) == 1):
				author_dict[author[j]] = 'infinity'

		for j in range(0, len(author)):
			if (author[j] != 'Erdos, P.') and ('Erdos, P.' in author):
				author_dict[author[j]] = 1
			elif ('Erdos, P.' not in author) and (author_dict[author[j]] != 'infinity'):
				for k in range(0, len(author)):
					if (author_dict[author[k]] == 'infinity'):
						author_dict[author[k]] = author_dict[author[j]] + 1

	instr = []
	for i in range(0, N):
		instr.append(input().strip())
		instr[i] = instr[i] + ' ' + str(author_dict[instr[i]])
	print('Scenario ' + str(x+1))
	for i in range(0, len(instr)):
		print(instr[i])