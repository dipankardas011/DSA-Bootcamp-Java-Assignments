def makeLargestSpecial(s:str) -> str:
    count = i = 0

    res=[]

    for j,v in enumerate(s):
        count = count+1 if v == '1' else count-1

        if count == 0:
            res.append('1' + makeLargestSpecial(s[i+1:j]) + '0')
            i=j+1
    return ''.join(sorted(res)[::-1])


print(makeLargestSpecial("11011000"))