
# Cj2356InputMethod

 此版本是 [原版](https://githubfast.com/fszhouzzOrgOne/CangJieIM2356) 的寿命延长版

其中`.apk/`中的`classes.dex` `resources.arsc` `res/%all.xml` 均已简体中文化

`.apk/`的`assets/version/log.txt` 也简体中文化

其中`.apk/assets/fonts/KaiXinSong3B_B2G.ttf` 全部修改为黑体（*其实只是把 **[Misans L3](https://hyperos.mi.com/font/rare-word)** 的中日韩统一汉字扩展B部分和 **[思源黑体](https://githubfast.com/adobe-fonts/source-han-sans)** 部分字 与 **[遍黑体](https://githubfast.com/Fitzgerald-Porthmouth-Koenigsegg/Plangothic-Project)** 的 中日韩统一汉字扩展C、D、E、F、I区 的字合并在一起*）
### 注意 由于一个字体文件`65535`个字的上线，字体无法支持显示扩展G、H区的字，如果系统本身显示不了那打出“□”、“〿”、“�”、“　”等属于正常现象
`.apk/`的`assets/database/cjmbdb.db` 是使用本项目下的 myweb 项目的`cangjie.java.Cj01SQLiteTest`生成

使用`cangjie.java.Cj01SQLiteTest`项目可以自定义输入方案，本项目默认使用的是 [Fitzgerald-Porthmouth-Koenigsegg](https://githubfast.com/Fitzgerald-Porthmouth-Koenigsegg) 的 [仓颉五代码表究极整合包](https://githubfast.com/Fitzgerald-Porthmouth-Koenigsegg/Cj5Cons) 

当然，你可以自定义其他的输入方案，~~换成五笔也不是不行~~（

# 自定义输入方案
### 首先
你的自定义输入方案要符合 **码点在开头 中间四个空格 后面一个或多个字** 列如：
```
a    日
a    曰
aa    昌
aa    昍
...
inf    ⺭
inlo    ⻂
inno    ⻎
ino    辶
ino    ⻌
inol    ⻂
inv    ⻈
ip    ⼷
...
zxbq    【
zxbr    】
zxbs    ︻
zxbt    ︼
zxbu    《
zxbv    》
zxbw    ︽
zxbx    ︾
...
```

如果你的不是这种形式，可以尝试用python写一个把 `去掉注释和空行，制表符改四空格并反转方向`的脚本，列如：
``` python
# 输入文件路径和输出文件路径
input_file_path = 'cangjiedict.txt'
output_file_path = 'processed_cangjiedict.txt'

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

```
### 然后



