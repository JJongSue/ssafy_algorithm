import sys

def calc(i, j, cmd):
    if cmd == '+':
        return i+j
    if cmd == '-':
        return i-j
    if cmd == '/':
        return i/j
    return i*j


calcs = sys.stdin.readline().split(' ')

num1 = calc(int(calc(int(calcs[0]),int(calcs[2]),calcs[1])), int(calcs[4]), calcs[3])
num2 = calc(int(calcs[0]), int(calc(int(calcs[2]), int(calcs[4]), calcs[3])), calcs[1])
if num1 < num2:
    print(int(num1))
    print(int(num2))
else:
    print(int(num2))
    print(int(num1))


