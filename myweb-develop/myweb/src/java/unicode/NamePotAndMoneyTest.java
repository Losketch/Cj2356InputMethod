package unicode;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NamePotAndMoneyTest {
    public static void main(String[] args) {
        // http://www.chinanews.com/sh/2016/01-27/7736202.shtml
        // 姓名中的點00B7
        String pot1 = "·";
        String pot2 = "•";
        System.out.println("\u00B7");
        System.out.println("\u00B7".equals(pot1));
        System.out.println("\u00B7".equals(pot2));

        // https://www.jianshu.com/p/3c13d7d8485a
        // ¥是人民幣和日元的符号，半角字符。 U+000A5
        // ￥是全角字符 U+0FFE5
        // Ұ ұ是一個哈薩克语西里爾字母。

        // money
        System.out.println('\u20BF');
        System.out.println('\u060B');
        System.out.println('\u17DB');
        System.out.println('\uFDFC');

        List<String> list = UnicodeSimUtil.getSuperSubScriptListString();
        String temp = "ᵃ ᵇ ᶜ ᵈ ᵉ ᶠ ᵍ ʰ ⁱ ꜞ ʲ ᵏ ˡ ᵐ ⁿ ᵒ ᵖ ᵒ⃒ ʳ ˢ ᵗ ᵘ ᵛ ʷ ˣ ʸ ᙆ  ᴬ ᴮ ᒼ ᴰ ᴱ ˡ ̄̄ ᴳ ᴴ ᴵ ᴶ ᴷ ᴸ ᴹ ᴺ ᴼ ᴾ ᴼ̴ ᴿ ˢ ᵀ ᵁ ᵂ ˣ ᵞ ᙆ  ᵄ ᵅ ᵆ ꝰ ˀ ˁ ˤ ꟸ ꭛ ꭜ ʱ ꭝ ꭞ ʴ ʵ ʶ ꭟ ˠ ꟹ ᴭ ᴯ ᴲ ᴻ ᴽ ᵊ ᵋ ᵌ ᵑ ᵓ ᵚ ᵝ ᵞ ᵟ ᵠ ᵡ ᵎ ᵔ ᵕ ᵙ ᵜ ᶛ ᶜ ᶝ ᶞ ᶟ ᶡ ᶣ ᶤ ᶥ ᶦ ᶧ ᶨ ᶩ ᶪ ᶫ ᶬ ᶭ ᶮ ᶯ ᶰ ᶱ ᶲ ᶳ ᶴ ᶵ ⸆ ⸇ ᶶ ᶷ ᶸ ᶹ ᶺ ᶼ ᶽ ᶾ ᶿ ꚜ ꚝ  ᒃ ᕻ ᑦ ᒄ ᕪ ᑋ ᑊ ᔿ ᐢ ᐤ ᣖ ᣴ ᣗ ᔆ ᙚ ᐡ ᘁ ᐜ ᕽ ᙆ  ᐞ ᒼ ᓫ ᣳ ᒢ ᒻ ᔿ ᐤ ᣖ ᣵ ᐪ ᓑ ᘁ ᐜ ᕽ ᙆ ᕻ ᑉ ᕝ ᒽ ᔈ ᒡ ᕐ ᣘ ᔅ ᔋ ᙚ ᖮ ᣔ ᙇ ꒣ ꒙ ꒪ ꒡ ꒷ ꒳ ꒵ ཋ ང ཇ ར ༨ ྊ ས བ འ པ ཡ ཛ ཟ ཕ   ꯧ ˟ ჼ ᗮ ᐝ ᐟ ᐠ ᐣ ᐥ ᐦ ᐨ ᐩ ᒾ ᓐ ᓒ ᓪ ᔇ ᔉ ᔊ ᔾ ᕑ ᕯ ᖅ ᖕ ᖖ ᖟ ᖦ ᙾ ᙿ ᣙ ᣚ ᣛ ᣜ ᣝ ⸀ ⸁ ⸂ ⸃ ⸄ ⸅ ⸈ ⸉ ⸊ ⸋ ⸌ ⸍ ꙳ ꜗ ꜘ ꜙ ꜚ ꜛ ꜜ ꜝ ꜞ ꒫ ꒴ ꒶ ᐤ ᐞ ⸋   ิ  ྀ  ᵃ ᵇ ᶜ ᵈ ᵉ ᵍ ʰ ⁱ ʲ ᵏ ˡ ᵐ ⁿ ᵒ ᵖ ᵒ⃒ ʳ ˢ ᵗ ᵘ ᵛ ʷ ˣ ʸ ᙆ ᴬ ᴮ ᒼ ᴰ ᴱ ᴳ ᴴ ᴵ ᴶ ᴷ ᴸ ᴹ ᴺ ᴼ ᴾ ᴼ̴ ᴿ ˢ ᵀ ᵁ ᵂ ˣ ᵞ ᙆ ₐ ꜀ ₑ ₕ ᵢ ⱼ ₖ ₗ ₘ ₙ ₒ ₚ ᵣ ₛ ₜ ᵤ ᵥ  ₓ ᙮ ᵤ  ᵦ ꜀ ₗ ˪ ៳ ៷ ₒ ᵨ ₛ ៴ ᵤ ᵪ ᵧ ";
        Set<String> sims = new LinkedHashSet<String>(Arrays.asList(temp.split(" +")));
        for (String one : sims) {
            if (!list.contains(one)) {
                System.out.print(" " + one);
            }
        }
    }
}
