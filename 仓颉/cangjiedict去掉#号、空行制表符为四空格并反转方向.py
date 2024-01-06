# 输入文件路径和输出文件路径
input_file_path = 'cangjiedict.txt'
output_file_path = 'processed_cj5-Jackchows-Cangjie5.txt'

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
                    reversed_line = parts[1] + '    ' + parts[0]
                    output_file.write(reversed_line + '\n')

print(f'处理完成，结果保存在 {output_file_path} 文件中。')
