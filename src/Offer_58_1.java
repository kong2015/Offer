/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class Offer_58_1 {
    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        s = s.trim();
        int i = s.length() - 1, j = i;
        while (i >= 0){
            while (i >= 0 && s.charAt(i) != ' ')
                i--;
            res.append(s.substring(i+1,j+1) + ' ');
            while (i >= 0 && s.charAt(i) == ' ')
                i--;
            j = i;
        }
        return res.toString().trim();
    }

}
