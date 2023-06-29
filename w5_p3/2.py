text = input()
pat = input()

result = []
lst = [0]*len(pat)
start = 0
i = 1

while i < len(pat):
	if pat[i] == pat[start]:
		start += 1
		lst[i] = start
		i += 1
	else:
		if start != 0:
			start = lst[start-1]
		else:
			lst[i] = 0
			i += 1
x = 0
y = 0
while x < len(text):
	if pat[y] == text[x]:
		x += 1
		y += 1
	elif pat[y] != text[x]:
		if y != 0:
			y = lst[y-1]
		else:
			x += 1
			
	if y == len(pat):
		result.append(str(x-y))
		y = lst[y-1]
		
print(len(result))
for q in range(len(result)):
	print(int(result[q])+1,end=' ')




