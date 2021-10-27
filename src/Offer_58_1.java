/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * "  hello world!  "
 */
public class Offer_58_1 {
    public String reverseWords(String s) {
        s = s.trim();                    //这个必须在s.length()前面
        int l = s.length() - 1;
        int r = s.length() - 1;
        StringBuffer res = new StringBuffer();
        while (l >= 0){
            while (l >= 0 && s.charAt(l) != ' '){
                l--;
            }
            res.append(s.substring(l + 1, r + 1));//这里不要用++l, 因为会改变l的指向
            res.append(' ');
            while (l >= 0 && s.charAt(l) == ' '){
                l--;
            }
            r = l;
        }
        return res.toString().trim();
    }

    public String reverseWords(String s) {
        int right = s.length() - 1;
        int left = right;
        s = s.trim();
        StringBuffer res = new StringBuffer();
        while (left >= 0){
            while (left >= 0 && s.charAt(left) != ' '){
                left--;
            }
            res.append(s.subSequence(left + 1, right + 1));
            res.append(' ');
            while (left >= 0 && s.charAt(left) == ' '){
                left--;
            }
            right = left;
        }
        return res.toString().trim();
    }

}
