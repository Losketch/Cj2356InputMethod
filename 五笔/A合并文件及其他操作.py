import os

# 定义文件列表
file_list = [
    "CJKRadicalsSupplement.txt",
    "KangxiRadicals.txt",
    "CJKSymbolsandPunctuation.txt",
    "CJKStrokes.txt",
    "CJK.txt",
    "CJK-A.txt",
    "CJKCompatibilityIdeographs.txt",
    "CountingRodNumerals.txt",
    "CJK-B.txt",
    "CJK-C.txt",
    "CJK-D.txt",
    "CJK-E.txt",
    "CJK-F.txt",
    "CJKCompatibilityIdeographsSupplement.txt",
    "CJK-G.txt",
    "CJK-H.txt",
    "CJK-I.txt",
]

# 定义目标文件名
output_filename = "temp.txt"

# 打开目标文件以写入模式
with open(output_filename, 'w', encoding='utf-8') as output_file:
    # 遍历文件列表并将内容写入目标文件
    for filename in file_list:
        filepath = os.path.join(os.getcwd(), filename)

        # 检查文件是否存在
        if os.path.exists(filepath):
            with open(filepath, 'r', encoding='utf-8') as input_file:
                content = input_file.read().strip()  # 去掉首尾空白字符
                output_file.write(content)
                output_file.write('\n')  # 在文件间插入一个换行符
        else:
            print(f"文件 {filename} 不存在。")

print(f"合并完成，结果保存在 {output_filename} 文件中。")



# 去除每行U+内容及其他操作
input_file_path = "temp.txt"
output_file_path = "MacOSX10.5Cangjie-Arthurmcarthur20200719.txt"

with open(input_file_path, 'r', encoding='utf-8') as input_file, open(output_file_path, 'w', encoding='utf-8') as output_file:
    for line in input_file:
        # 如果是以 "U+" 开头并且后面有其他内容的行
        if line.startswith("U+") and len(line.split('\t', 2)) > 1:
            # 获取 "U+" 开头后面＋制表符 后面的内容
            cleaned_line = '\t'.join(line.split('\t', 2)[1:]).strip()
            output_file.write(cleaned_line + '\n')



# 删除temp.txt
file_to_delete = "temp.txt"

try:
    os.remove(file_to_delete)
    print(f"{file_to_delete} 文件已成功删除。")
except FileNotFoundError:
    print(f"{file_to_delete} 文件未找到。")
except Exception as e:
    print(f"删除文件时发生错误: {e}")



# 制表符改二个空格，并反转方向
# 输入文件路径和输出文件路径
input_file_path = 'MacOSX10.5Cangjie-Arthurmcarthur20200719.txt'
output_file_path = 'cj5-MacOSX10.5.txt'

# 打开输入文件并处理
with open(input_file_path, 'r', encoding='utf-8') as input_file:
    # 打开输出文件并逐行处理写入
    with open(output_file_path, 'w', encoding='utf-8') as output_file:
        for line in input_file:
            # 去掉开头有#号的行，并将制表符替换为四个空格，并去掉空行
            if not line.startswith('#') and line.strip():
                parts = line.strip().split('\t')
                if len(parts) == 2:
                    # 调换“汉字”和“码”的位置
                    reversed_line = parts[1] + '  ' + parts[0]
                    output_file.write(reversed_line + '\n')

print(f'处理完成，结果保存在 {output_file_path} 文件中。')
