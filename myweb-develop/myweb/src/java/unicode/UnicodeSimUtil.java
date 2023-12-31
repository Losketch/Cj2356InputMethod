package unicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 統一碼符號
 * 
 * @author fszhouzz@qq.com
 * @time 2018年10月17日 下午7:17:36
 */
public class UnicodeSimUtil {
    private static List<String> biaoqingList = new ArrayList<String>(
            Arrays.asList(":-)", ":-D", "XD", ":->", ":-p", ";-)", ":-O", ":-(",
                    ":-<", ":-*", ":-×", "Orz", "orz", "(^_^)", "(^-^)",
                    "(^ ^)", "(^.^)", "(^o^)", "(^q^)", "(^ɜ^)", "(>_<)",
                    "(>c<)", "(>﹏<)", "(>ɛ<)", "(´- へ -、)", "(ˉ﹁ˉ)", "(ˉˇˉ)",
                    "(ˉ.ˉ)", "(ˉ~ˉ)", "(ˉoˉ)", "(ˉʒˉ)", "(ˉ_ˉ)", "(ˉ(∞)ˉ)",
                    "(ˉɜˉ)", "(ˉɛˉ)", "(ˉωˉ)", "(๑‾᷅^‾᷅๑)", "m(_ _)m",
                    "(ﾉ_ _)ﾉ", "(-.-)", "(-_-)", "(ｰ̀εｰ́)", "( ｰ̀дｰ́ )",
                    "(=ɛ=)", "(= =b)", "(= =#)", "(+﹏+)", "(*_*)", "ʕ*̫͡*ʔ",
                    "(×_×)", "(ˋ﹏ˊ)", "٩(´ω`)و", "ﾍ(;´Д｀ﾍ)", "٩(//̀Д/́/)۶",
                    "('﹏')", "٩('ω')و", "(ˋωˊ)", "(ˋ^ˊ)", "(ˇ_ˇ)", "ˋ(• •)ˊ",
                    "(•-•)", "(•̀⌄•́)", "(ง •̀_•́)ง", "(・⊥・)", "(;_;)", "(;o;)",
                    "(˙ɷ˙)", "(˙Ꙫ˙)", "(ఠൠఠ)", "(·ꙫ·)", "^(oo)^", "ก็ʕ•̫͡•ʔก็",
                    "ʕ•̫͡•ʔ", "ʕ•ᴥ•ʔ", "ʕ•ﻌ•ʔ", "ᶘ ᵒᴥᵒᶅ", "ʕ•͓͡•ʔ", "ʕ•֢͠•͠ʔ",
                    "ʕ-̫͡-ʔ", "(˙︿˙)", "(˙ω˙)", "(·ω·)", "(‧  ‧)", "_(:ɜ ˩∠)_",
                    "∠(ᐛ ˩∠)_", "(: )～", "(:◎)≡", "(๑•ั็ω•็ั๑)", "ฅ•ω•ฅ",
                    "(*ฅ́˘ฅ̀*)", "(๑•̀ᄇ•́)و ✧ ", "(•̳ ◡•̳)", "(˘•㉨•˘)",
                    "(´･ω･`)", "(^･ω･^)", "(˙０˙)", "∑(❍ฺд❍ฺlll)", "ʕoܫoʔ",
                    "(oܫo)", "(´ﾟωﾟ｀)", "(=ﾟ･ﾟ=)", "(°ο°)", "(°○°)", "(°△°)",
                    "(°_°)", "(º_º)", "(⁰_⁰)", "(˶˚ ᗨ ˚˶)", "(σﾟ∀ﾟ)σ",
                    "(●°u°●)」", "(ớ ₃ờ)", "(o_o)", "(o_O)", "(⊙_⊙)", "(⊙▲⊙)",
                    "(⊙∀⊙)", "(●_⊙)", "(●_●)", "(●0●)", "(●︿●)", "(●ω●)",
                    "(●▽●)", "(●△●)", "(●^●)", "(●-●)", "(●～●)", "(Ｑ.Ｑ)",
                    "($_$)", "(@_@)", "(~O~)", "(눈_눈)", "(T-T)", "(T T)",
                    "(T_T)", "(ToT)", "(〒_〒)", "(π_π)", "(*꒦ິ⌓꒦ີ)", "(◞_◟)",
                    "(◆⊙◆)", "(?﹏?)", "(?o?)", "(∩ω∩)", "(∩_∩)", "(∪︿∪)",
                    "(╯▽╰)", "(￣▽￣)", "(￣ω￣)", "=￣ω￣=", "(－▽－)", "(≧◇≦)",
                    "(≧︿≦)", "(≥▂≤)", "(≥o≤)", "(︶︿︶)", "(︶O︶)", "(╯︿╰)",
                    "(╯ㅁ╰)", "(╰_╯)", "(→_→)", "=^ ^=", "(=^.^=)",
                    "(⁎⁍̴̛ᴗ⁍̴̛⁎)", "(覀.覀)", "(罒_罒)", "ʚΐɞ", "ε==3"));

    public static void main(String[] args) {

    }

    /**
     * 中文
     * 
     * @author fszhouzz@qq.com
     * @time 2018年9月25日 下午8:19:26
     * @return
     */
    public static List<String> getCnListString() {
        List<String> list = new ArrayList<String>(Arrays.asList("，", "、", "。",
                "？", "！", "：", "；", "…", "‘ ’", "“ ”", "＇＇", "＂＂", "〃〃", "〝〞",
                "❛❜", "❝❞", "❟", "❠", "（）", "〔〕", "〈〉", "《》", "«»", "［］", "｛｝",
                "「」", "『』", "〖〗", "【】", "｟｠", "—"));
        String cnstr = " ＋ － ± × ÷ ＝ ＜ ＞ ～ ｀ ＠ ＃ ¥ ￥ Ұ ұ ＄ ％ ＆ ＊ ｜ ‖ ／ ＼ ˉ ˊ ˇ ˋ ˙ ． · • 々 囍 卍 卐 ࿕ ࿖ ࿗ ࿘ ";
        cnstr += " ︿ ﹀ ︵ ︶ ︹ ︺ ︷ ︸ ︻ ︼ ︽ ︾ ﹁ ﹂ ﹃ ﹄ ⿰ ⿱ ⿲ ⿳ ⿴ ⿵ ⿶ ⿷ ⿸ ⿹ ⿺ ⿻  ";
        cnstr += " ◌  ̄  ́  ̌  ̀  ̇  ";
        list = mergeFaceString2List(list, cnstr);
        return list;
    }

    /**
     * 中文部首
     * 
     * @author fszhouzz@qq.com
     * @time 2018年9月25日 下午8:19:26
     * @return
     */
    public static List<String> getCnPartListString() {
        return getListByString(
                "々丨亅丿乛一乙乚丶八勹匕冫刂儿二匚阝丷卩冂冖凵亻厶亠匸讠廴又艹屮彳巛辶廾彐彑口宀犭彡饣扌氵纟囗忄幺弋尢夂灬歹卝旡耂肀牜爿攴攵礻殳尣爻曰爫癶歺钅疒罒衤疋业艸虍覀糸糹镸辵豸釒靣飠髟鬲黽黹夊禸舛襾釆〇α乁乀巜乂丄丆丅龴丩刄亇丌丬乇卂孒乊卄夨乆龶丰冄兂冘龷丯円龵毌卬卅罓朩匁予戋龸甴氺冎丗仺氶叏丱戉両乑龹朿帇亙丣囪乕幷戼丳栆単眔埀宻豙睂臦");
    }

    /**
     * 获取英文符號
     */
    public static List<String> getEnListString() {
        List<String> list = Arrays.asList(",", ".", "_", "?", "!", ":", ";",
                "'", "' '", "\" \"", "@", "#", "$", "%", "℅", "‰", "‱", "^",
                "&", "~", "̃", "`", "‒", "–", "+", "-", "*", "=", "\\", "/",
                "|", "<", ">", "( )", "[ ]", "{ }", "⁅ ⁆", "¿ ?", "¡ !", "‽",
                "‼", "⁇", "⁈", "⁉", "Tab");
        String str7 = " 🔙 🔚 🔛 🔜 🔝 🔢 🔣 🅰 🆎 🔤 🔠 🔡 🏧 🅱 © 🄫 🄯 🄭 🆑 🆒 🆓 🅊 ℹ 🆔 Ⓜ 🅋 🆕 🆖 🅾 📴 🆗 🅿 🅎 ® 🄬 🄪 🅌 ℠ 🆘 🅍 ℡ ™ 🆙 🆚 🅏 🚾 🄮 ";
        String str3 = " ⒜ ⒝ ⒞ ⒟ ⒠ ⒡ ⒢ ⒣ ⒤ ⒥ ⒦ ⒧ ⒨ ⒩ ⒪ ⒫ ⒬ ⒭ ⒮ ⒯ ⒰ ⒱ ⒲ ⒳ ⒴ ⒵";
        String str8 = " 🄐 🄑 🄒 🄓 🄔 🄕 🄖 🄗 🄘 🄙 🄚 🄛 🄜 🄝 🄞 🄟 🄠 🄡 🄢 🄣 🄤 🄥 🄦 🄧 🄨 🄩 ";
        String str4 = " ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ⓘ ⓙ ⓚ ⓛ ⓜ ⓝ ⓞ ⓟ ⓠ ⓡ ⓢ ⓣ ⓤ ⓥ ⓦ ⓧ ⓨ ⓩ";
        String str5 = " Ⓐ Ⓑ Ⓒ Ⓓ Ⓔ Ⓕ Ⓖ Ⓗ Ⓘ Ⓙ Ⓚ Ⓛ Ⓜ Ⓝ Ⓞ Ⓟ Ⓠ Ⓡ Ⓢ Ⓣ Ⓤ Ⓥ Ⓦ Ⓧ Ⓨ Ⓩ";
        String str2 = "ᴀ ʙ ᴄ ᴅ ᴇ ғ ɢ ʜ ɪ ᴊ ᴋ ʟ ᴍ ɴ ᴏ ᴘ ǫ ʀ s ᴛ ᴜ ᴠ ᴡ x ʏ ᴢ";
        String str22 = " 𝒜 ℬ 𝒞 𝒟 ℰ ℱ 𝒢 ℋ ℐ 𝒥 𝒦 ℒ ℳ 𝒩 𝒪 𝒫 𝒬 ℛ 𝒮 𝒯 𝒰 𝒱 𝒲 𝒳 𝒴 𝒵  ";
        String str23 = " 𝒶 𝒷 𝒸 𝒹 ℯ 𝒻 ℊ 𝒽 𝒾 𝒿 𝓀 𝓁 𝓂 𝓃 ℴ 𝓅 𝓆 𝓇 𝓈 𝓉 𝓊 𝓋 𝓌 𝓍 𝓎 𝓏  ";
        String str24 = " 𝕬 𝕭 𝕮 𝕯 𝕰 𝕱 𝕲 𝕳 𝕴 𝕵 𝕶 𝕷 𝕸 𝕹 𝕺 𝕻 𝕼 𝕽 𝕾 𝕿 𝖀 𝖁 𝖂 𝖃 𝖄 𝖅 ";
        String str25 = " 𝖆 𝖇 𝖈 𝖉 𝖊 𝖋 𝖌 𝖍 𝖎 𝖏 𝖐 𝖑 𝖒 𝖓 𝖔 𝖕 𝖖 𝖗 𝖘 𝖙 𝖚 𝖛 𝖜 𝖝 𝖞 𝖟 ";
        String str6 = " 🇦 🇧 🇨 🇩 🇪 🇫 🇬 🇭 🇮 🇯 🇰 🇱 🇲 🇳 🇴 🇵 🇶 🇷 🇸 🇹 🇺 🇻 🇼 🇽 🇾 🇿";
        list = mergeFaceString2List(list, str7);
        list = mergeFaceString2List(list, str3);
        list = mergeFaceString2List(list, str8);
        list = mergeFaceString2List(list, str4);
        list = mergeFaceString2List(list, str5);
        list = mergeFaceString2List(list, str2 + str22 + str23 + str24 + str25);
        list = mergeFaceString2List(list, str6);
        return list;
    }

    /**
     * 符號列表1 2 3
     */
    public static List<String> getSpecial1ListString() {
        List<String> list = mergeFaceString2List(null,
                " ‼ ⁉ ❓ ❔ ❕ ❗ 💯 ‡ † § № ☆ ★ ♡ ○ ● ◎ ◇ ◆ □ ■ △ ▲ ▽ ▼ ⁜ ⁕ ⁎ ⁑ ⁂ ⁚ ⁖ ⁝ ⁘ ⁛ ⁞ ⁙ 〓 ° ⌘ ⌥ ︴ ﹌ ﹉ ﹊ ￣ ¨ ‥ ― ﹍ ﹎ ﹏ ＿ ◟ ◞ ◜ ◝ 〽 〰 ◌ ҈ ҉ ̶ ⃢  ⃠ ⃣ ◌ ");
        String faces = "🏧 🚮 🚰 ♿ 🚹 🚺 🚻 🚼 🚾 🛂 🛃 🛄 🛅 ⚠ 🚸 ⛔ 🚫 🚳 🚭 🚯 🚱 🚷 📵 🔞 ☢ ☣ ";
        faces += " ⏸ ⏹ ⏺ 🎦 🔅 🔆 📶 📳 📴 ♀ ♂ ⚕ ⚜ 🔱 📛 🔰 ⭕ ✅ ☑ ✔ ✖ ❌ ❎ ➕ ➖ ➗ ➰ ➿ ※ ✳ ✴ ❇ ꧁ ꧂ ▪ ▫ ◻ ◼ ◽ ◾ ⬛ ⬜ 🔶 🔷 🔸 🔹 🔺 🔻 💠 🔘 🔲 🔳 ⚪ ⚫ 🔴 🔵 🏁 🚩 🏴 🏳";
        list = mergeFaceString2List(list, faces);
        return list;
    }

    public static List<String> getSpecial2ListString() {
        String faces = "🌍 🌎 🌏 🌐 🗺 🏔 ⛰ 🌋 🗻 🏕 🏖 🏜 🏝 🏞 🏟 🏛 🏗 🏘 🏙 🏚 🏠 🏡 🏢 🏣 🏤 🏥 🏦 🏨 🏩 🏪 🏫 🏬 🏭 🏰 🗼 🗽 ⛲ ⛺ 🎠 🎡 🎢 💈 🎪 🎭 🖼 🎨 🎰 🚂 🚃 🚄 🚅 🚆 🚇 🚈 🚉 🚊 🚝 🚞 🚋 🚌 🚍 🚎 🚐 🚑 🚒 🚓 🚔 🚕 🚖 🚗 🚘 🚙 🚚 🚛 🚜 🚲 🚏 🛣 🛤 ⛽ 🚨 🚥 🚦 🚧 ⚓ ⛵ 🚤 🛳 ⛴ 🛥 🚢 ✈ 🛩 🛫 🛬 💺 🚁 🚟 🚠 🚡 🛰 🚀 🛎 🚪 🛏 🛋 🚽 🚿 🛁 🎖 🏆 🏅 ⚽ ⚾ 🏀 🏐 🏈 🏉 🎾 🎱 🎳 🏏 🏑 🏒 🏓 🏸 🎯 ⛳ ⛸ 🎣 🎽 🎿 🎮 🕹 🎲 ♠ ♥ ♦ ♣ 🃏 🀄 🎴 🔇 🔈 🔉 🔊 📢 📣 📯 🔔 🔕 ♩ ♪ ♫ ♬ ♭ ♮ ♯ ¶ 🎼 🎵 🎶 🎙 🎚 🎛 🎤 🎧 📻 🎷 🎸 🎹 🎺 🎻 📱 📲 ☎ 📞 📟 📠 🔋 🔌 💻 🖥 🖨 ⌨ 🖱 🖲 💽 💾 💿 📀 🎥 🎞 📽 🎬 📺 📷 📸 📹 📼 🔍 🔎 🔬 🔭 📡 🕯 💡 🔦 🏮 📔 📕 📖 📗 📘 📙 📚 📓 📒 📃 📜 📄 📰 🗞 📑 🔖 🏷 ✉ 📧 📨 📩 📤 📥 📦 〒 📫 📪 📬 📭 📮 🗳 ✏ ✒ 🖋 🖊 🖌 🖍 📝 💼 📁 📂 🗂 📇 📈 📉 📊 📋 📌 📍 📎 🖇 📏 📐 ✂ 🗃 🗄 🗑 🔒 🔓 🔏 🔐 🔑 🗝 🔨 ⛏ ⚒ 🛠 🗡 ⚔ 🔫 🏹 🛡 🔧 🔩 ⚙ 🗜 ⚗ ⚖ 🔗 ⛓ 💉 💊 🚬 ⚰ ⚱ 🗿 🛢 🔮 ";
        List<String> list = mergeFaceString2List(null, faces);
        return list;
    }

    public static List<String> getSpecial3ListString() {
        String faces = "😀 😁 😂 😃 😄 😅 😆 😉 😊 😋 😎 😍 😘 😗 😙 😚 ☺ 🙂 🤗 🤔 😐 😑 😶 🙄 😏 😣 😥 😮 🤐 😯 😪 😫 😴 😌 😛 😜 😝 😒 😓 😔 😕 🙃 🤑 😲 ☹ 🙁 😖 😞 😟 😤 😢 😭 😦 😧 😨 😩 😬 😰 😱 😳 😵 😡 😠 😷 🤒 🤕 😇 🤓 😈 👿 👹 👺 💀 ☠ 👻 👽 👾 🤖 💩 👶 👦 👧 👨 👩 👴 👵 ";
        faces += " 💪 👈 👉 ☝ 👆 🖕 👇 ✌ 🖖 🤘 🖐 ✋ 👌 👍 👎 ✊ 👊 👋 ✍ 👏 👐 🙌 🙏 💅 👂 👃 👣 👀 👁 🗨 👅 👄 💋 💘 ❤ 💓 💔 💕 💖 💗 💙 💚 💛 💜 💝 💞 💟 ❣ 💌 💤 💢 💣 💥 💦 💨 💫 💬 🗯 💭 🕳 ";
        faces += " 👓 🕶 👔 👕 👖 👗 👙 👚 👛 👜 👝 🛍 🎒 👞 👟 👠 👡 👢 👑 👒 🎩 🎓 ⛑ 📿 💄 💍 💎 ";
        faces += " 🐭 🐁 🐀 🐹 🐿 🐮 🐂 🐃 🐄 🐯 🐅 🐆 🦁 🐱 🐈 😺 😸 😹 😻 😼 😽 🙀 😿 😾 🐰 🐇 🐲 🐉 🐍 🐢 🐊 🐸 🐴 🐎 🦄 🐏 🐑 🐐 🐪 🐫 🐵 🐒 🙈 🙉 🙊 🦃 🐔 🐓 🐣 🐤 🐥 🐦 🐧 🕊 🐶 🐕 🐩 🐺 🐷 🐖 🐗 🐽 🐘 🐻 🐨 🐼 🐾 🐳 🐋 🐬 🐟 🐠 🐡 🐙 🐚 🦀 🐌 🐛 🐜 🐝 🐞 🕷 🕸 🦂 ";
        faces += " ⚘ 💐 ❀ ✿ ✾ 🌸 💮 🏵 🌹 🌺 🌻 🌼 🌷 🌱 🌲 🌳 🌴 🌵 🌾 🌿 ☘ 🍀 🍁 🍂 🍃 🍇 🍈 🍉 🍊 🍋 🍌 🍍 🍎 🍏 🍐 🍑 🍒 🍓 🍅 🍆 🌽 🌶 🍄 🌰 ";
        faces += " 🍞 🧀 🍖 🍗 🍔 🍟 🍕 🌭 🌮 🌯 🍳 🍲 🍿 🍱 🍘 🍙 🍚 🍛 🍜 🍝 🍠 🍢 🍣 🍤 🍥 🍡 🍦 🍧 🍨 🍩 🍪 🎂 🍰 🍫 🍬 🍭 🍮 🍯 🍼 ☕ 🍵 🍶 🍾 🍷 🍸 🍹 🍺 🍻 🍽 🍴 🔪 🏺";
        List<String> list = mergeFaceString2List(null, faces);
        return list;
    }

    /**
     * 獲取文字表情
     * 
     * @author fszhouzz@qq.com
     * @time 2018年10月17日 下午7:17:11
     * @return
     */
    public static List<String> getBiaoqingListString() {
        return biaoqingList;
    }

    /**
     * 箭頭
     * 
     * @author fszhouzz@qq.com
     * @time 2018年10月17日 下午11:04:44
     * @return
     */
    public static List<String> getArrowListString() {
        String str = " ← ↑ → ↓ ↔ ↕ ↖ ↗ ↘ ↙ ↚ ↛ ↜ ↝ ↞ ↟ ↠ ↡ ↢ ↣ ↤ ↥ ↦ ↧ ↨ ↩ ↪ ↫ ↬ ↭ ↮ ↯ ↰ ↱ ↲ ↳ ↴ ↵ ↶ ↷ ↸ ↹ ↺ ↻ ↼ ↽ ↾ ↿ ⇀ ⇁ ⇂ ⇃ ⇄ ⇅ ⇆ ⇇ ⇈ ⇉ ⇊ ⇋ ⇌ ⇍ ⇎ ⇏ ⇐ ⇑ ⇒ ⇓ ⇔ ⇕ ⇖ ⇗ ⇘ ⇙ ⇚ ⇛ ⇜ ⇝ ⇞ ⇟ ⇠ ⇡ ⇢ ⇣ ⇤ ⇥ ⇦ ⇧ ⇨ ⇩ ⇪ ⇫ ⇬ ⇭ ⇮ ⇯ ⇰ ⇱ ⇲ ⇳ ⇴ ⇵ ⇶ ⇷ ⇸ ⇹ ⇺ ⇻ ⇼ ⇽ ⇾ ⇿ ";
        str += " 🔙 🔚 🔛 🔜 🔝 ⏎ ⌂ ⎋ ⌫ ⌦ ⬆ ➡ ⬇ ⬅ ⤴ ⤵ 🔃 🔄 🔀 🔁 🔂 ▶ ⏩ ⏭ ⏯ ◀ ⏪ ⏮ 🔼 ⏫ 🔽 ⏬ ⏏ ♻ ";
        return mergeFaceString2List(null, str);
    }

    /**
     * 上下標
     * 
     * @author fszhouzz@qq.com
     * @time 2018年10月18日 上午12:14:17
     * @return
     */
    public static List<String> getSuperSubScriptListString() {
        String str = " ⁰ ¹ ² ᒾ ³ ⁴ ⁵ ⁶ ⁷ ⁸ ⁹ ⁺ ᐩ ⁻ ᐨ ⁼ ᙿ ᙾ ⁽⁾ ᐠ ᐟ ᐥ ᐦ ⸌ ⸍ ꜛ ꜜ ₀ ₁ ₂ ₃ ₄ ₅ ₆ ₇ ₈ ₉ ⏨ ₊ ₋ ₌ ₍₎ ";
        str += " ㆒ ㆓ ㆔ ㆕ ㆖ ㆗ ㆘ ㆙ ㆚ ㆛ ㆜ ㆝ ㆞ ㆟ ";
        str += " ᴬ ᐞ ꒫ ᣔ ᴮ ᒼ ᑦ ᐣ ᴰ ᴱ ᴳ ᴴ ᴵ ᶦ ᴶ ᒢ ᒽ ᓪ ᴷ ᴸ ᣳ ᶫ ᒻ ᔈ ꜚ ᒡ ᣘ ⸀ ⸁ ᔅ ᴹ ᔿ ᴺ ᶰ ꒙ ᴼ ᐤ ꒪ ᴾ ᴼ̴  ᴿ ᵀ ⸆ ⸇ ᐪ ᗮ ᵁ ᶸ ᓑ ꒡ ꒵ ⱽ ꒣ ꒷ ᑉ ᕝ ᕐ ᵂ ꒳ ᓫ ᕑ ";
        str += " ᵃ ᵇ ᒃ ᕻ ᶜ ᵈ ᒄ ᵉ ᕪ ᔉ ᔊ ᶠ ᵍ ʰ ᑋ ⁱ ꜞ ꜝ ᔋ ʲ ᵏ ˡ ᑊ ᵐ ⁿ ᐢ ᵒ ᐝ ᖕ ᵖ ᣖ ᵒ⃒ ʳ ᣴ ᣗ ˢ ᔆ ᙚ ᣵ ᣛ ⸈ ⸉ ⸊ ᖮ ᵗ ᵘ ᐡ ᵛ ᘁ ʷ ᐜ ꒴ ꒶ ˣ ᕽ ˟ ꭛ ʸ ᶻ ᙆ ᙇ ₐ ꜀ ₑ ₕ ᵢ ⱼ ₖ ₗ ˪ ₘ ៳ ₙ ៷ ₒ ₚ ᵣ ₛ ₜ ˫ ᵤ ᵥ ៴ ₓ ᙮ ";
        str += " ₔ ᵦ ᵧ ᵨ ᵩ ᵪ ᵝ ᵞ ᵟ ᶿ ᶥ ᵠ ᵡ ª º ꝰ ꟸ ꟹ ꭜ ꭝ ꭞ ꭟ ʱ ʴ ʵ ʶ ˀ ˁ ˠ ˤ ᴭ ᴯ ᴲ ᴻ ᴽ ᵄ ᵅ ᵆ ᵊ ᵋ ᵌ ᵑ ᵓ ᵚ ᵸ ᵎ ᵔ ᵕ ᵙ ᵜ ᶛ ᶝ ᶞ ᶟ ᶡ ᶢ ᶣ ᶤ ᶧ ᶨ ᶩ ᶪ ᶬ ᶭ ᶮ ᶯ ᶱ ᶲ ᶳ ᶴ ᶵ ᶶ ᶷ ᶹ ᶺ ᶼ ᶽ ᶾ ꚜ ꚝ ჼ ⵯ ";
        str += " © ® ℠ ℡ ™ 🅪 🅫 ᓐ ᓒ ᔇ ᔾ ᕯ ᖅ ᖖ ᖟ ᖦ ᣙ ᣚ ᣜ ᣝ ⸂ ⸃ ⸄ ⸅ ⸋ ꙳ ꜗ ꜘ ꜙ ";
        str += " ◌  ̄  ́  ̌  ̀  ̇    〪 〫 〬 〭    ྀ  ᷊    ิ    ̄ ͣ ͤ ͥ ͦ ͧ ͨ ͩ ͪ ͫ ͬ ͭ ͮ ͯ ᷓ ᷔ ᷕ ᷖ ᷗ ᷘ ᷙ ᷚ ᷛ ᷜ ᷝ ᷞ ᷟ ᷠ ᷡ ᷢ ᷣ ᷤ ᷥ ᷦ ᷧ ᷨ ᷩ ᷪ ᷫ ᷬ ᷭ ᷮ ᷯ ᷰ ᷱ ᷲ ᷳ ᷴ ⷠ ⷡ ⷢ ⷣ ⷤ ⷥ ⷦ ⷧ ⷨ ⷩ ⷪ ⷫ ⷬ ⷭ ⷮ ⷯ ⷰ ⷱ ⷲ ⷳ ⷴ ⷵ ⷶ ⷷ ⷸ ⷹ ⷺ ⷻ ⷼ ⷽ ⷾ ⷿ ꙴ ꙵ ꙶ ꙷ ꙸ ꙹ ꙺ ꙻ ꚞ ꚟ";
        return mergeFaceString2List(null, str);
    }

    /**
     * 數學
     * 
     * @author fszhouzz@qq.com
     * @time 2018年9月25日 下午11:01:44
     * @return
     */
    public static List<String> getMathListByString() {
        // \u8704-8959
        String math1 = " + - * / = < > & | ! ` % ％ ‰ ‱ ＋ － ± × ÷ ＝ ✘ ✔ ＜ ＞ ⌒ ′ ″ º ℃ Ｆ ℉ Å ℓ Ω ";
        math1 += " ∀ ∁ ∂ ∃ ∄ ∅ ∆ ∇ ∈ ∉ ∊ ∋ ∌ ∍ ∎ ∏ ∐ ∑ − ∓ ∔ ∕ ∖ ∗ ∘ ∙ √ ∛ ∜ ∝ ∞ ∟ ∠ ∡ ∢ ∣ ∤ ∥ ∦ ∧ ∨ ∩ ∪ ∫ ∬ ∭ ∮ ∯ ∰ ∱ ∲ ∳ ∴ ∵ ∶ ∷ ∸ ∹ ∺ ∻ ∼ ∽ ∾ ∿ ≀ ≁ ≂ ≃ ≄ ≅ ≆ ≇ ≈ ≉ ≊ ≋ ≌ ≍ ≎ ≏ ≐ ≑ ≒ ≓ ≔ ≕ ≖ ≗ ≘ ≙ ≚ ≛ ≜ ≝ ≞ ≟ ≠ ≡ ≢ ≣ ≤ ≥ ≦ ≧ ≨ ≩ ≪ ≫ ≬ ≭ ≮ ≯ ≰ ≱ ≲ ≳ ≴ ≵ ≶ ≷ ≸ ≹ ≺ ≻ ≼ ≽ ≾ ≿ ⊀ ⊁ ⊂ ⊃ ⊄ ⊅ ⊆ ⊇ ⊈ ⊉ ⊊ ⊋ ⊌ ⊍ ⊎ ⊏ ⊐ ⊑ ⊒ ⊓ ⊔ ⊕ ⊖ ⊗ ⊘ ⊙ ⊚ ⊛ ⊜ ⊝ ⊞ ⊟ ⊠ ⊡ ⊢ ⊣ ⊤ ⊥ ⊦ ⊧ ⊨ ⊩ ⊪ ⊫ ⊬ ⊭ ⊮ ⊯ ⊰ ⊱ ⊲ ⊳ ⊴ ⊵ ⊶ ⊷ ⊸ ⊹ ⊺ ⊻ ⊼ ⊽ ⊾ ⊿ ⋀ ⋁ ⋂ ⋃ ⋄ ⋅ ⋆ ⋇ ⋈ ⋉ ⋊ ⋋ ⋌ ⋍ ⋎ ⋏ ⋐ ⋑ ⋒ ⋓ ⋔ ⋕ ⋖ ⋗ ⋘ ⋙ ⋚ ⋛ ⋜ ⋝ ⋞ ⋟ ⋠ ⋡ ⋢ ⋣ ⋤ ⋥ ⋦ ⋧ ⋨ ⋩ ⋪ ⋫ ⋬ ⋭ ⋮ ⋯ ⋰ ⋱ ⋲ ⋳ ⋴ ⋵ ⋶ ⋷ ⋸ ⋹ ⋺ ⋻ ⋼ ⋽ ⋾ ⋿ ";
        String math2 = " ⅟ ½ ↉ ⅓ ⅔ ¼ ¾ ⅕ ⅖ ⅗ ⅘ ⅙ ⅚ ⅐ ⅛ ⅜ ⅝ ⅞ ⅑ ⅒ ℀ ℁ ℅ ℆ ⅍";
        String math4 = "㏂㏟㍳㍴㏃㎈㏄㏅㏆㎝㎠㎤㏇㍲㏈㎗㍷㍸㍹㋍㋎㎙㏿㎇㎓㎬㏉㏊㋌㏋㍱㎐㏌㍺㎄㎅㎉㎏㎑㏍㎘㎞㎢㎦㏎㏀㎪㏏㎸㎾㏐㏑㏒㋏㏓㎡㎥㎃㏔㎆㎎㎒㏕㎖㎜㎟㎣㏖㏁㎫㎳㎧㎨㎷㎹㎽㎿㎁㎋㎚㎱㎵㎻㍵㎀㎩㍶㎊㏗㏘㏙㏚㎰㉐㎴㎺㎭㎮㎯㏛㏜㎔㎂㎌㎍㎕㎛㎲㎶㎼㏞㏝";
        List<String> list = mergeFaceString2List(null, math1);
        list = mergeFaceString2List(list, math2);
        list.addAll(getListByString(math4));
        return list;
    }

    /**
     * 序號
     * 
     * @author fszhouzz@qq.com
     * @time 2018年10月17日 下午7:26:07
     * @return
     */
    public static List<String> getOrderListByString() {
        StringBuilder sb = new StringBuilder();
        sb.append(
                " ⓪ ① ② ③ ④ ⑤ ⑥ ⑦ ⑧ ⑨ ⑩ ⑪ ⑫ ⑬ ⑭ ⑮ ⑯ ⑰ ⑱ ⑲ ⑳ ㉑ ㉒ ㉓ ㉔ ㉕ ㉖ ㉗ ㉘ ㉙ ㉚ ㉛ ㉜ ㉝ ㉞ ㉟ ㊱ ㊲ ㊳ ㊴ ㊵ ㊶ ㊷ ㊸ ㊹ ㊺ ㊻ ㊼ ㊽ ㊾ ㊿ 🄋 ");
        sb.append(" ⓿ ❶ ❷ ❸ ❹ ❺ ❻ ❼ ❽ ❾ ❿ ⓫ ⓬ ⓭ ⓮ ⓯ ⓰ ⓱ ⓲ ⓳ ⓴ 🄌 ");
        sb.append(" ㉈ ㉉ ㉊ ㉋ ㉌ ㉍ ㉎ ㉏ ");
        sb.append(" １ ２ ３ ４ ５ ６ ７ ８ ９ ０ ");
        sb.append(" 🄀 ⒈ ⒉ ⒊ ⒋ ⒌ ⒍ ⒎ ⒏ ⒐ ⒑ ⒒ ⒓ ⒔ ⒕ ⒖ ⒗ ⒘ ⒙ ⒚ ⒛ ");
        sb.append(" ⑴ ⑵ ⑶ ⑷ ⑸ ⑹ ⑺ ⑻ ⑼ ⑽ ⑾ ⑿ ⒀ ⒁ ⒂ ⒃ ⒄ ⒅ ⒆ ⒇ ");
        sb.append(" 〡 〢 〣 〤 〥 〦 〧 〨 〩 十 ㈠ ㈡ ㈢ ㈣ ㈤ ㈥ ㈦ ㈧ ㈨ ㈩ ");
        sb.append(
                " ㊀ ㊁ ㊂ ㊃ ㊄ ㊅ ㊆ ㊇ ㊈ ㊉ ㊣ 〇 一 二 三 四 五 六 七 八 九 十 零 壹 贰 貳 叁 叄 肆 伍 陆 陸 柒 捌 玖 拾 佰 仟 万 萬 亿 億 吉 太 拍 艾 ");
        sb.append(" ⅰ ⅱ ⅲ ⅳ ⅴ ⅵ ⅶ ⅷ ⅸ ⅹ Ⅰ Ⅱ Ⅲ Ⅳ Ⅴ Ⅵ Ⅶ Ⅷ Ⅸ Ⅹ Ⅺ Ⅻ ");
        return mergeFaceString2List(null, sb.toString());
    }

    /**
     * 貨幣符號<br/>
     * www.runoob.com/charsets/ref-utf-currency.html<br/>
     * unicode-table.com/cn/20B6/
     * 
     * @author fszhouzz@qq.com
     * @time 2018年10月17日 下午11:05:01
     * @return
     */
    public static List<String> getMoneyListString() {
        String faceStr = "圓 圆 元 円 ¥ ￥ Ұ ұ $ ＄ ₳ ฿ ₿ € ₡ ₵ ￠ ¢ ₠ ₢ ₾ ₫ ₯ ￡ £ ₤ ₣ ƒ ₲ ₭ Kčs ₺ ℳ ₥ ₦ ¤ ₱ ₽ ₧ ₨ ₴ ₷ ₮ ₸ ₶ ៛ ￦ ₩ ރ zł ₻ ₼ ֏ ₹ ₰ ₪ ؋ ﷼ ৲ ৳ ૱ ௹ ៛ 💰 💴 💵 💶 💷 💸 💳 💹 💱 💲 🏦 🏧";
        List<String> list = mergeFaceString2List(null, faceStr);
        return list;
    }

    /**
     * 獲取文化符號
     */
    public static List<String> getWenhuaListString() {
        String str1 = "☯⚊⚋⚌⚍⚎⚏☰☷☳☶☲☵☱☴卍卐❂☭☠☤☥☦☧☨☩☪☫☬☮☸☽☾♕♚♛✙✚✛✜✝✞✟✠✡✢";
        List<String> list = getListByString(str1);
        String faceStr = "🛐 ⚛ 🕉 ✡ ☸ ☯ ✝ ☦ ☪ ☮ 🕎 🔯 ♈ ♉ ♊ ♋ ♌ ♍ ♎ ♏ ♐ ♑ ♒ ♓ ⛎ ⛪ 🕌 🕍 ⛩ 🕋 💒";
        list = mergeFaceString2List(list, faceStr);
        return list;
    }

    /**
     * 獲取時節符號
     */
    public static List<String> getTimeEventListString() {
        String str1 = "㋀㋁㋂㋃㋄㋅㋆㋇㋈㋉㋊㋋㏠㏡㏢㏣㏤㏥㏦㏧㏨㏩㏪㏫㏬㏭㏮㏯㏰㏱㏲㏳㏴㏵㏶㏷㏸㏹㏺㏻㏼㏽㏾㍙㍚㍛㍜㍝㍞㍟㍠㍡㍢㍣㍤㍥㍦㍧㍨㍩㍪㍫㍬㍭㍮㍯㍰㍘";
        List<String> list = getListByString(str1);
        String faceStr = " 📅 📆 🗒 🗓 ⌛ ⏳ ⌚ ⏰ ⏱ ⏲ 🕰 🕛 🕧 🕐 🕜 🕑 🕝 🕒 🕞 🕓 🕟 🕔 🕠 🕕 🕡 🕖 🕢 🕗 🕣 🕘 🕤 🕙 🕥 🕚 🕦 🌑 🌒 🌓 🌔 🌕 🌖 🌗 🌘 🌙 🌚 🌛 🌜 🌡 ☀ 🌝 🌞 ⭐ 🌟 🌠 🌁 🌃 🌄 🌅 🌆 🌇 🌉 ♨ 🌌 ☁ ⛅ ⛈ 🌤 🌥 🌦 🌧 🌨 🌩 🌪 🌫 🌬 🌀 🌈 🌂 ☂ ☔ ⛱ ⚡ ❄ ☃ ⛄ ☄ 🔥 💧 🌊 🎃 🎄 🎆 🎇 ✨ 🎈 🎉 🎊 🎋 🎍 🎐 🎑 🎀 🎁 🎗 🎟 🎫";
        list = mergeFaceString2List(list, faceStr);
        return list;
    }

    /**
     * 國際音標符號
     * 
     * @author fszhouzz@qq.com
     * @time 2018年3月20日下午3:22:15
     * @return
     */
    public static List<String> getIpaListString() {
        String faceStr = "a ɐ ɑ ɒ æ ɑ̃ ʌ b ɓ ʙ β c ç ɕ ɔ ɔ̃ d ɗ ɖ ð d͡z d͡ʒ d̠͡ʑ ɖ͡ʐ e ə ɘ ɛ ɛ̃ ɜ ɚ ɝ f ɸ g ɡ ɠ ɢ ʛ ɣ ɤ h ħ ɦ ɧ ʜ ɥ i ĩ ɨ ɪ j ʝ ɟ ʄ k l ɫ ɬ ɭ ʟ ɮ ʎ m ɱ ɯ ɰ n ɲ ŋ ɳ ȵ ɴ o õ ɵ ø ɞ œ œ̃ ɶ ɔ ɔ̃ ʊ ʘ p ɸ p͡f q r ɾ ɼ ɺ ɽ ɹ ɻ ʀ ʁ ɿ ˞ s ʂ ʃ ʄ ʅ t ʈ θ t͡ɕ ʈ͡ʂ t͡ʂ t͡s t͡ʃ u ũ ʉ ʊ v ʋ ѵ ⱱ ʌ w w̃ ʍ ɰ x χ y ʏ ɥ ʎ z ʑ ʐ ʒ ʔ ʡ ʕ ʢ ʘ ǀ ǂ ǁ ǃ ˈ ˌ ː ˑ ̆ || ‖ ‿ x͡y x͡ ͡ . ̋ ˥ ́ ˦ ̄ ˧ ̀ ˨ ̏ ˩ ̌ ̂ ꜜ ꜛ ↗ ↘ ̥ ̬ ʰ ʱ ʲ ʷ ˠ ˁ ̹ ̜ ̟ ̠ ̈ ̽ ̩ ̯ ˞ ̃ ̰ ̝ ̞ ̘ ̙ ̪ ̺ ̻ ⁿ ˡ ̚";
        String[] facesArr = faceStr.split(" ");
        List<String> list = new ArrayList<String>();
        for (String str : facesArr) {
            list.add(str);
        }
        return list;
    }

    /**
     * 注音
     * 
     * @author fszhouzz@qq.com
     * @time 2018年10月17日 下午7:31:41
     * @return
     */
    public static List<String> getPinyinListString() {
        return getListByString(
                "āáǎàōóǒòêēéěèīíǐìūúǔùǖǘǚǜüˉˊˇˋ˙˪˫◌〪〭〫̄́̌̀̇〬ㄅㄆㄇㄈㄉㄊㄋㄌㄍㄎㄏㄐㄑㄒㄓㄔㄕㄖㄗㄘㄙㄚㄛㄜㄝㄞㄟㄠㄡㄢㄣㄤㄥㄦㄧㄨㄩㄪㄫㄬㄭㄮㄯㆠㆡㆢㆣㆤㆥㆦㆧㆨㆩㆪㆫㆬㆭㆮㆯㆰㆱㆲㆳㆴㆵㆶㆷㆸㆹㆺ");
    }

    /**
     * 獲取日文符號
     */
    public static List<String> getJapanListString() {
        // 先按日文符號區內順序
        // 與下面的有褈複
        String str1 = "";
        str1 += "あいうえおぁぃぅぇぉかきくけこがぎぐげごさしすせそざじずぜぞたちつてとっだぢづでどなにぬねのはひふへほばびぶべぼぱぴぷぺぽまみむめもやゆよゃゅょらりるれろわゐゑをゎんゔゕゖゝゞゟ゠";
        str1 += "アイウエオァィゥェォカキクケコガギグゲゴサシスセソザジズゼゾタチツテトッダヂヅデドナニヌネノハヒフヘホバビブベボパピプペポマミムメモヤユヨャュョラリルレロワヰヱヲヮンヴヵヶヽヾヷヸヹヺ・ー゙゚゛゜";

        str1 += "あいうゔえおアイウヴエオぁぃぅぇぉァィゥェォかゕきくけゖこカヵキクケヶコがぎぐげごガギグゲゴさしすせそサシスセソざじずぜぞザジズゼゾたちつってとタチツッテトだぢづでどダヂヅデドなにぬねのナニヌネノはひふへほハヒフヘホばびぶべぼバビブベボぱぴぷぺぽパピプペポまみむめもマミムメモやゆよヤユヨゃゅょャュョらりるれろラリルレロわゎゐゑをワヮヷヰヸヱヹヲヺんンー゠々ゝゞヽヾ〆乄ゟ゚゛゜ヿ・";
        str1 += "ㇰㇱㇲㇳㇴㇵㇶㇷㇸㇹㇺㇻㇼㇽㇾㇿ㈠㈡㈢㈣㈤㈥㈦㈧㈨㈩㈪㈫㈬㈭㈮㈯㈰㈱㈲㈳㈴㈵㈶㈷㈸㈹㈺㈻㈼㈽㈾㈿㉀㉁㉂㉃㉄㉅㉆㉇㊀㊁㊂㊃㊄㊅㊆㊇㊈㊉㊊㊋㊌㊍㊎㊏㊐㊑㊒㊓㊔㊕㊖㊗㊘㊙㊚㊛㊜㊝㊞㊟㊠㊡㊢㊣㊤㊥㊦㊧㊨㊩㊪㊫㊬㊭㊮㊯㊰㋐㋑㋒㋓㋔㋕㋖㋗㋘㋙㋚㋛㋜㋝㋞㋟㋠㋡㋢㋣㋤㋥㋦㋧㋨㋩㋪㋫㋬㋭㋮㋯㋰㋱㋲㋳㋴㋵㋶㋷㋸㋹㋺㋻㋼㋽㋾㌀㌁㌂㌃㌄㌅㌆㌇㌈㌉㌊㌋㌌㌍㌎㌏㌐㌑㌒㌓㌔㌕㌖㌗㌘㌙㌚㌛㌜㌝㌞㌟㌠㌡㌢㌣㌤㌥㌦㌧㌨㌩㌪㌫㌬㌭㌮㌯㌰㌱㌲㌳㌴㌵㌶㌷㌸㌹㌺㌻㌼㌽㌾㌿㍀㍁㍂㍃㍄㍅㍆㍇㍈㍉㍊㍋㍌㍍㍎㍏㍐㍑㍒㍓㍔㍕㍖㍗㍻㍼㍽㍾㍿";
        List<String> list = getListByString(str1);
        String faceStr = "🈁 🈂 🈷 🈶 🈯 🈹 🈚 🈲 🈸 🈴 🈳 🈺 🈵 🀄 🉐 🉑 ㊗ ㊙ ㊣ ㊀ ㊁ ㊂ ㊃ ㊄ ㊅ ㊆ ㊇ ㊈ ㊉ ㊎ ㊍ ㊌ ㊋ ㊏ ㊐ ㊊ ㊚ ㊛ ㊤ ㊥ ㊦ ㊧ ㊨ ㊞ ㊑ ㊒ ㊓ ㊓ ㊔ ㊕ ㊖ ㊗ ㊗ ㊘ ㊜ ㊝ ㊟ ㊠ ㊡ ㊢ ㊩ ㊪ ㊫ ㊬ ㊬ ㊭ ㊮ ㊮ ㊯ ㊰ ㊙ 🎌 🗾 👘 🏣 🏯 🎎 🎏 〒";
        list = mergeFaceString2List(list, faceStr);
        return list;
    }

    /**
     * 諺文符號
     * 
     * @author fszhouzz@qq.com
     * @time 2018年10月17日 下午7:33:10
     * @return
     */
    public static List<String> getKoreaListString() {
        return getListByString(
                "ㅏㅓㅗㅜㅡㅣㅐㅔㅚㅟㅑㅕㅛㅠㅒㅖㅘㅙㅝㅞㅢㄱㄲㅋㄷㄸㅌㅂㅃㅍㅈㅉㅊㅅㅆㅎㄴㅁㅇㄹᅀᄼᄽᄾᄿᅎᅏᅐᅑᅔᅕᅌᄐᆞᆝᆟᆠᆡᆢ㈀㈁㈂㈃㈄㈅㈆㈇㈈㈉㈊㈋㈌㈍㈎㈏㈐㈑㈒㈓㈔㈕㈖㈗㈘㈙㈚㈛㈜㈝㈞㉠㉡㉢㉣㉤㉥㉦㉧㉨㉩㉪㉫㉬㉭㉮㉯㉰㉱㉲㉳㉴㉵㉶㉷㉸㉹㉺㉻㉼㉽㉾㉿");
    }

    /**
     * 拉丁
     * 
     * @author fszhouzz@qq.com
     * @time 2018年10月17日 下午7:34:16
     * @return
     */
    public static List<String> getLatinListString() {
        String str1 = "";
        str1 += "ÄÆĂÅÀÁÂÃĈÇĒĚÈÉÊËÐÌÍÎÏÑŊÖØÒÓÔÕŜȘȚÙÚÛÜŬÝẐẞÞ";
        str1 += "äæăåàáâãĉçēěèéêëðìíîïñŋöøòóôõŝșțùúûüŭýẑßþ";
        return getListByString(str1);
    }

    /**
     * 希臘
     * 
     * @author fszhouzz@qq.com
     * @time 2018年10月17日 下午7:34:55
     * @return
     */
    public static List<String> getGreeKListString() {
        return getListByString(
                "ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩαβγδεζηθικλμνξοπρστυφχψω℩ς");
    }

    /**
     * 俄文
     * 
     * @author fszhouzz@qq.com
     * @time 2020年1月5日 下午12:57:59
     * @return
     */
    public static List<String> getRussiaListString() {
        String str1 = "";
        str1 += "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        str1 += "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        str1 += "ӐӑӘәҐґҒғЃѓҔҕЂђӖӗҼҽҾҿЄєІіЇїӁӂӜӝҖҗӠӡҘҙӞӟЅѕӢӣӤӥЈјҠҡҚқҞҟҜҝЌќЉљЊњҢңӦӧӨөҨҩҦҧҪҫҬҭЋћҰұҮүӮӯӲӳҲҳҴҵҺһӴӵҸҹҶҷЏџӀӏ";
        str1 += "ꙖѤѦѪѨѬѮѰѲѴѸѠѾѢ";
        return getListByString(str1);
    }

    /**
     * 製表
     * 
     * @author fszhouzz@qq.com
     * @time 2018年10月17日 下午7:35:44
     * @return
     */
    public static List<String> getTableListString() {
        String str = " ─ ━ │ ┃ ┄ ┅ ┆ ┇ ┈ ┉ ┊ ┋ ┌ ┍ ┎ ┏ ┐ ┑ ┒ ┓ └ ┕ ┖ ┗ ┘ ┙ ┚ ┛ ├ ┝ ┞ ┟ ┠ ┡ ┢ ┣ ┤ ┥ ┦ ┧ ┨ ┩ ┪ ┫ ┬ ┭ ┮ ┯ ┰ ┱ ┲ ┳ ┴ ┵ ┶ ┷ ┸ ┹ ┺ ┻ ┼ ┽ ┾ ┿ ╀ ╁ ╂ ╃ ╄ ╅ ╆ ╇ ╈ ╉ ╊ ╋ ╌ ╍ ╎ ╏ ═ ║ ╒ ╓ ╔ ╕ ╖ ╗ ╘ ╙ ╚ ╛ ╜ ╝ ╞ ╟ ╠ ╡ ╢ ╣ ╤ ╥ ╦ ╧ ╨ ╩ ╪ ╫ ╬ ╭ ╮ ╯ ╰ ╱ ╲ ╳ ╴ ╵ ╶ ╷ ╸ ╹ ╺ ╻ ╼ ╽ ╾ ╿ ";
        return mergeFaceString2List(null, str);
    }

    /**
     * 表情字符串合并入列表 faceStr 各表情字符用空格分隔
     */
    private static List<String> mergeFaceString2List(List<String> list,
            String faceStr) {
        String[] facesArr = faceStr.trim().split(" +");
        Set<String> set = new LinkedHashSet<String>();
        if (null != list && !list.isEmpty()) {
            set.addAll(list);
        }
        for (String face : facesArr) {
            if (null != face && !"".equals(face) && !set.contains(face)) {
                set.add(face);
            }
        }
        return new ArrayList<String>(set);
    }

    /**
     * 把字符串转成字符串的列表
     * 
     * @author fszhouzz@qq.com
     * @time 2017年12月12日上午10:14:57
     * @param string
     * @return
     */
    private static List<String> getListByString(String keys) {
        Set<String> set = new LinkedHashSet<String>();
        for (int i = 0; i < keys.length(); i++) {
            Character cha = keys.charAt(i);
            if (!set.contains(cha.toString())) {
                set.add(cha.toString());
            }
        }
        return new ArrayList<String>(set);
    }
}
