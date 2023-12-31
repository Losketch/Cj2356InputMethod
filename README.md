
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
## 首先
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
## 然后

先把jdk在你的电脑上配置好，配置好在cmd或终端中输入javac并回车提示：
``` java
>javac
用法: javac <options> <source files>
其中, 可能的选项包括:
  @<filename>                  从文件读取选项和文件名
  -Akey[=value]                传递给注释处理程序的选项
  --add-modules <模块>(,<模块>)*
        除了初始模块之外要解析的根模块; 如果 <module>
                为 ALL-MODULE-PATH, 则为模块路径中的所有模块。
  ...
  -verbose                     输出有关编译器正在执行的操作的消息
  --version, -version          版本信息
  -Werror                      出现警告时终止编译
>
```
就成功了

把生成完的文件放到你下载的源代码压缩包解压后的 `myweb-develop/myweb/src/java/cangjie/mb/cjmb/` 文件夹中

并删除 `cj5-Jackchows-Cangjie5.txt` 文件，然后把它重命名为 `cj5-Jackchows-Cangjie5.txt` 

到 `myweb-develop/myweb/src/java/cangjie/java/` 目录下就行下一步

## 接着

你要修改 `Cj01SQLiteTest.java` 文件以达到你想要的结果，只要修改 `true` 和 `false` 的字样就行，其他代码不要动

修改完 `Cj01SQLiteTest.java` 文件运行以下代码：

此代码需要修改成你解压源代码的目录！！！

``` javac
javac.exe -encoding UTF-8 -cp .;C:\你的目录\myweb-develop\myweb\src\java;C:\你的目录\myweb-develop\myweb\src\java\cangjie;C:\你的目录\myweb-develop\myweb\src\java\cangjie\java;C:\你的目录\myweb-develop\myweb\src\java\cangjie\java\util Cj00AllInOneTest.java
```
```
javac.exe -encoding UTF-8 -cp .;C:\你的目录\myweb-develop\myweb\src\java\cangjie\java\util\IOUtils.java;C:\你的目录\myweb-develop\myweb\src\java -Xlint:unchecked Cj01SQLiteTest.java
```
```
cd C:\你的目录\myweb-develop\myweb
```
```
java.exe -cp .;C:\你的目录\myweb-develop\myweb\src\J2EE\APP-INF\lib\sqlite-jdbc-3.15.1.jar;C:\你的目录\myweb-develop\myweb\src\java cangjie.java.Cj01SQLiteTest
```

