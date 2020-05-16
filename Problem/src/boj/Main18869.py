M, N = map(int, input().split())

ans = 0

strdict = {}
for i in range(M):
    ii = input().split()
    # print(ii)
    a = list(map(int, ii))
    b = list(map(int, ii))
    # print(a)
    b.sort()
    post = b[0]
    dicts = {b[0]: 1}
    inputs = 2
    for j in b:
        if j != post:
            dicts[j] = inputs
            inputs = inputs+1
    # print(dicts)
    string = ""
    for j in range(len(a)):
        # print(j, a[j], dicts[a[j]])
        string = string + str(dicts[a[j]])
        # a[j] = dicts[a[j]]
    if strdict.get(string) == None:
        # print(1)
        strdict[string] = 1
    else:
        # print(2)
        # if strdict[string] == 1:
            # ans = ans+1
        ans = ans + strdict[string]
        strdict[string] = strdict[string]+1
    # print(string)
print(ans)
# print(M - len(ans))
# print(len(ans))