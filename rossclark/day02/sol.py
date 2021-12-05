with open("data.txt") as f:
	entries = [line.strip().split() for line in f.readlines()]

def sol3():
	hor, dep = 0, 0
	for entry in entries:
		direction, x = entry[0], int(entry[1])
		if direction == 'forward':
			hor += x
		elif direction == 'down':
			dep += x
		elif direction == 'up':
			dep -= x
	return hor * dep

def sol4():
	hor, dep, aim = 0, 0, 0
	for entry in entries:
		direction, x = entry[0], int(entry[1])
		if direction == 'forward':
			hor += x
			dep += aim * x
		elif direction == 'down':
			aim += x
		elif direction == 'up':
			aim -= x
	return hor * dep

print(sol3())
print(sol4())