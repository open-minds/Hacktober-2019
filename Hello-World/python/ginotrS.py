def isodd(x):
    if int(x) % 2 != 0:
        return True
    else:
        return False
def iseven(x):
    if int(x) % 2 == 0:
        return True
    else:
        return False
lst = [x for x in input()]
lowlst=[]
uplst=[]
oddlst=[]
evenlst=[]
for let in lst:
    if let.isupper():
        uplst.append(let)
    elif let.islower():
        lowlst.append(let)
    elif let.isdigit():
        if isodd(let):
            oddlst.append(let)
        else:
            evenlst.append(let)
res=sorted(lowlst)+sorted(uplst)+sorted(oddlst)+sorted(evenlst)
for let in res : print(let,end='')
