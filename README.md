
# Cj2356InputMethod

 此版本是 [原版](https://github.com/fszhouzzOrgOne/CangJieIM2356) 的寿命延长版

其中`.apk/`中的`classes.dex` `resources.arsc` `res/%all.xml` 均已简体中文化

`.apk/`的`assets/version/log.txt` 也简体中文化

其中`.apk/assets/fonts/KaiXinSong3B_B2G.ttf` 全部修改为黑体（*其实只是把 **[Misans L3](https://hyperos.mi.com/font/rare-word)** 的中日韩统一汉字扩展B部分和 **[思源黑体](https://github.com/adobe-fonts/source-han-sans)** 部分字 与 **[遍黑体](https://github.com/Fitzgerald-Porthmouth-Koenigsegg/Plangothic-Project)** 的 中日韩统一汉字扩展C、D、E、F、I区 的字合并在一起*）
### 注意 由于一个字体文件`65535`个字的上线，字体无法支持显示扩展G、H区的字，如果系统本身显示不了那打出“□”、“〿”、“�”、“　”等属于正常现象
`.apk/`的`assets/database/cjmbdb.db` 是使用本项目下的 myweb 项目的cangjie.java.Cj01SQLiteTest生成
