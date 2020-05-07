str = input()

arr = []

for i in range(len(str)):
    # print(i)
    arr.append(str[i:])
    # print(arr[i-1])
arr.sort()

for s in arr:
    print(s)