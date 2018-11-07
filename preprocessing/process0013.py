s = 'List('
with open('in0013.txt') as f:
    lines = f.readlines()
    for line in lines:
        s += '\tBigInt("'
        s += line.strip() + '"),\n'

    s += ')'
with open('out0013.txt', 'w') as f:
    f.write(s)


