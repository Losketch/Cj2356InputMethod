# -*- coding: utf-8 -*-

with open('UnicodeLosketchBlocks.txt', 'r', encoding='utf-8') as file:
    lines = file.readlines()

modified_lines = []
for line in lines:
    line = line.replace('..', ' ')
    line = line.replace('; ', ' ')
    line = line.split('|')[0] + '\n'
    modified_lines.append(line)

with open('modified_UnicodeLosketchBlocks.txt', 'w', encoding='utf-8') as file:
    file.writelines(modified_lines)

print("File modified successfully!")