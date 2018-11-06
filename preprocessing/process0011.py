s = 'Array(\n'
with open('in0011.txt') as f:
    lines = f.readlines()
    for line in lines:
        s += '\tArray('
        s += ', '.join(line.split())
        s += '),\n'

    s += ')'
with open('out0011.txt', 'w') as f:
    f.write(s)


