import sys
txt = []
buffer = ""
txt = sys.stdin.read().splitlines()

for line in txt:
	if buffer:
		buffer += " "
	if line == "":
		print(buffer.rstrip())
		print()
		buffer = ""
	else:
		remainder = line
		space = " "
		while space == " ":
			word, space, remainder = remainder.partition(" ")
			if len(buffer + word) > 72:
				if buffer:
					print(buffer.rstrip())
					buffer = ""
				else:
					print(word)
					continue
			elif len(buffer) == 72:
				print(buffer.rstrip())
				buffer = ""
			buffer += (word + space)
print(buffer.rstrip())
			