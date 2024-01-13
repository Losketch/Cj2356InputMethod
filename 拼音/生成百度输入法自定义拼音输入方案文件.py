import re
import os
from collections import OrderedDict

# 打开 Unihan_Readings.txt 文件
with open("Unihan_Readings.txt", "r", encoding="utf-8") as f:
    # 读取文件内容
    lines = f.readlines()

# 去掉开头有 # 号的行
lines = [line for line in lines if not line.startswith("#")]

# 去掉含有 kCantonese kDefinition kHangul kJapanese kJapaneseKun kJapaneseOn kKorean kSMSZD2003Readings kTang kTGHZ2013 kVietnamese kXHC1983 的行
lines = [line for line in lines if not re.search(r"kCantonese", line)]
lines = [line for line in lines if not re.search(r"kDefinition", line)]
lines = [line for line in lines if not re.search(r"kHangul", line)]
lines = [line for line in lines if not re.search(r"kJapanese", line)]
lines = [line for line in lines if not re.search(r"kJapaneseKun", line)]
lines = [line for line in lines if not re.search(r"kJapaneseOn", line)]
lines = [line for line in lines if not re.search(r"kKorean", line)]
lines = [line for line in lines if not re.search(r"kSMSZD2003Readings", line)]
lines = [line for line in lines if not re.search(r"kTang", line)]
lines = [line for line in lines if not re.search(r"kTGHZ2013", line)]
lines = [line for line in lines if not re.search(r"kVietnamese", line)]
lines = [line for line in lines if not re.search(r"kXHC1983", line)]

# 写入新文件
with open("temp1.txt", "w", encoding="utf-8") as f:
    for line in lines:
        f.write(line)


# B部分代码

# 打开 temp_Unihan_Readings.txt 文件
with open("temp1.txt", "r", encoding="utf-8") as f:
    # 读取文件内容
    lines = f.readlines()

# 将每行的空格替换为逗号
lines = [line.replace(' ', ',') for line in lines]

# 将每行的特殊声调替换为正常声调
lines = [line.replace('ê̄', 'ē') for line in lines]
lines = [line.replace('ế', 'é') for line in lines]
lines = [line.replace('ê̌', 'ě') for line in lines]
lines = [line.replace('ề', 'è') for line in lines]

# 一步处理包含kHanyuPinlu的行
lines = [re.sub(r'kHanyuPinlu.*?\t', '', re.sub(r'\(.*?\)', '', line.replace(' ', ','))) for line in lines]

# 去掉包含kHanyuPinyin的行中的kHanyuPinyin和:号以及它们之间的内容
lines = [re.sub(r'kHanyuPinyin.*?:', '', line) for line in lines]

# 去掉包含kMandarin的行中的kMandarin和制表符
lines = [line.replace('\tkMandarin', '') for line in lines]

# 修改部分：在包含 5个阿拉伯数字.3个阿拉伯数字: 的行中去掉这部分数据
lines = [re.sub(r'[0-9]{5}\.[0-9]{3}:', '', line) for line in lines]

# 写入新文件
with open("temp2.txt", "w", encoding="utf-8") as f:
    for line in lines:
        f.write(line)


# C部分代码

# 处理有,符号的行，把它分开并删除新的行
def process_comma_lines(input_file, output_file):
    with open(input_file, 'r', encoding='utf-8') as infile:
        lines = infile.readlines()

    new_lines = []
    for line in lines:
        if ',' in line:
            # Check if there is a tab character before attempting to split
            if '\t' in line:
                code_point, readings = line.split('\t')
                readings = readings.split(',')
                for reading in readings:
                    new_lines.append(f"{code_point}\t{reading.strip()}\n")
            else:
                # Handle the case where there is no tab character in the line
                # You may want to log or handle this differently based on your requirements
                print(f"Warning: Line without tab character: {line}")
        else:
            new_lines.append(line)

    with open(output_file, 'w', encoding='utf-8') as outfile:
        outfile.writelines(new_lines)

if __name__ == "__main__":
    input_filename = "temp2.txt"
    output_filename = "temp3.txt"
    
    process_comma_lines(input_filename, output_filename)
    print(f"文件已处理，并保存为 {output_filename}。")


# D部分代码

def remove_duplicate_lines(input_file, output_file):
    unique_lines = OrderedDict()

    with open(input_file, 'r', encoding='utf-8') as infile:
        for line in infile:
            unique_lines[line] = None

    with open(output_file, 'w', encoding='utf-8') as outfile:
        outfile.writelines(unique_lines.keys())

if __name__ == "__main__":
    input_filename = "temp3.txt"
    output_filename = "temp4.txt"
    
    remove_duplicate_lines(input_filename, output_filename)
    print(f"重复行已从文件中移除，并保存为 {output_filename}。")


# E部分代码

# 打开 temp4_Unihan_Readings.txt 文件
with open("temp4.txt", "r", encoding="utf-8") as f:
    # 读取文件内容
    lines = f.readlines()

# 定义字符替换和后缀的字典
replace_dict = {
    'ā': ('', 'a'),
    'á': ('', 'a'),
    'ǎ': ('', 'a'),
    'à': ('', 'a'),
    'ē': ('', 'e'),
    'é': ('', 'e'),
    'ě': ('', 'e'),
    'è': ('', 'e'),
    'ī': ('', 'i'),
    'í': ('', 'i'),
    'ǐ': ('', 'i'),
    'ì': ('', 'i'),
    'ō': ('', 'o'),
    'ó': ('', 'o'),
    'ǒ': ('', 'o'),
    'ò': ('', 'o'),
    'ń': ('', 'n'),
    'ň': ('', 'n'),
    'ǹ': ('', 'n'),
    'ḿ': ('', 'm'),
    'm̀': ('', 'm'),
    'ū': ('', 'u'),
    'ú': ('', 'u'),
    'ǔ': ('', 'u'),
    'ù': ('', 'u'),
    'ü': ('', 'u'),
    'ǘ': ('', 'u'),
    'ǚ': ('', 'u'),
    'ǜ': ('', 'u'),
}

# 处理每一行
for i in range(len(lines)):
    line = lines[i]
    
    # 遍历字典，进行字符替换和后缀添加
    for char, (suffix, replace_char) in replace_dict.items():
        if char == 'ü' and 'ǘ' in line:
            # 避免提前替换，等到处理 'ǘ' 时再替换 'ü'
            continue
        
        if char in line:
            line = line.rstrip() + suffix + '\n'  # 在行末添加后缀和回车符
            line = line.replace(char, replace_char)  # 替换字符
    
    # 替换 'ü'，确保在 'ǘ' 之后替换
    line = line.replace('ü', 'u')
    
    # 更新行内容
    lines[i] = line

# 写入新文件
with open("temp5.txt", "w", encoding="utf-8") as f:
    for line in lines:
        f.write(line)


# F部分代码

# 打开 temp5_Unihan_Readings.txt 文件
with open("temp5.txt", "r", encoding="utf-8") as f:
    # 读取文件内容
    lines = f.readlines()

# 处理每一行
for i in range(len(lines)):
    line = lines[i].strip().split('\t')  # 去除首尾空白并按制表符分割
    
    if len(line) == 2 and line[0].startswith("U+"):
        unicode_char = chr(int(line[0][2:], 16))  # 将U+xxxx的内容转换为字符
        
        # 更新行内容
        lines[i] = f"{unicode_char}\t{line[1]}\n"

# 写入新文件
with open("temp6.txt", "w", encoding="utf-8") as f:
    for line in lines:
        f.write(line)


# 去掉#号、空行制表符为一空格并反转方向

# 输入文件路径和输出文件路径
input_file_path = 'temp6.txt'
output_file_path = 'temp7.txt'

# 打开输入文件并处理
with open(input_file_path, 'r', encoding='utf-8') as input_file:
    # 打开输出文件并逐行处理写入
    with open(output_file_path, 'w', encoding='utf-8') as output_file:
        for line in input_file:
            # 去掉开头有#号的行，并将制表符替换为一个空格，并去掉空行
            if not line.startswith('#') and line.strip():
                parts = line.strip().split('\t')
                if len(parts) == 2:
                    # 调换“汉字”和“码”的位置
                    reversed_line = parts[1] + ' ' + parts[0]
                    output_file.write(reversed_line + '\n')

print(f'处理完成，结果保存在 {output_file_path} 文件中。')


# 排序部分

# 打开 temp7_Unihan_Readings.txt 文件
with open("temp7.txt", "r", encoding="utf-8") as f:
    # 读取文件内容
    lines = f.readlines()

# 按照a~z的顺序对每行进行排序
sorted_lines = sorted(lines, key=lambda x: x.strip().split('\t')[1] if len(x.strip().split('\t')) > 1 else x.strip())

# 写入新文件
with open("temp8.txt", "w", encoding="utf-8") as f:
    for line in sorted_lines:
        f.write(line)


def remove_duplicate_lines(input_file, output_file):
    unique_lines = OrderedDict()

    with open(input_file, 'r', encoding='utf-8') as infile:
        for line in infile:
            unique_lines[line] = None

    with open(output_file, 'w', encoding='utf-8') as outfile:
        outfile.writelines(unique_lines.keys())

if __name__ == "__main__":
    input_filename = "temp8.txt"
    output_filename = "pinyin.txt"
    
    remove_duplicate_lines(input_filename, output_filename)
    print(f"重复行已从文件中移除，并保存为 {output_filename}。")

# 删除文件部分
# 要删除的文件列表
files_to_delete = ["temp1.txt", "temp2.txt", "temp3.txt", "temp4.txt", "temp5.txt", "temp6.txt", "temp7.txt", "temp8.txt"]

for file_to_delete in files_to_delete:
    try:
        os.remove(file_to_delete)
        print(f"{file_to_delete} 文件已成功删除。")
    except FileNotFoundError:
        print(f"{file_to_delete} 文件未找到。")
    except Exception as e:
        print(f"删除文件时发生错误: {e}")
