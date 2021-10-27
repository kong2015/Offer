/**
 * 空格替换
 */
public class Offer_5 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Character c : s.toCharArray()){
            if (c == ' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

//    public String replaceSpace(String s) {
//        StringBuffer sb = new StringBuffer();
//        sb.append(s);
//        for (int i = 0; i < s.length(); i++){
//            if (s.charAt(i) == ' ')
//                sb.append("12");
//        }
//        int p1 = s.length() - 1, p2 = sb.length() - 1;
//        while (p1 < p2 && p1 >= 0){
//            Character c = sb.charAt(p1--);
//            if (c == ' '){
//                sb.setCharAt(p2--, '0');
//                sb.setCharAt(p2--, '2');
//                sb.setCharAt(p2--, '%');
//            }else {
//                sb.setCharAt(p2--, c);
//            }
//        }
//        return sb.toString();
//    }
}
//class Solution {
//    public String replaceSpace(String s) {
//        StringBuilder res = new StringBuilder();
//        for(Character c : s.toCharArray())
//        {
//            if(c == ' ') res.append("%20");
//            else res.append(c);
//        }
//        return res.toString();
//    }
//}
//
//class Solution {
//    public String replaceSpace(String s) {
//        StringBuffer res = new StringBuffer();
//        for (Character c : s.toCharArray()){
//            if (c == ' ')
//                res.append("%20");
//            else res.append(c);
//        }
//        return res.toString();
//    }
//}