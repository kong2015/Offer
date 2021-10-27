/**
 *
 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class Offer_58_2 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }


//    public String reverseLeftWords(String s, int n) {
//        if (n <= 0 || n >= s.length())
//            return s;
//        int i = n, j = s.length() - 1;
//        StringBuffer res = new StringBuffer();
//        res.append(s.substring(n, j + 1));
//        res.append(s.substring(0, n));
//        return res.toString();
//    }
    public String reverseLeftWords(String s, int n)
    {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

}
