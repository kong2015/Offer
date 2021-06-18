/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
import java.util.HashMap;
public class Offer_50 {
//    public char firstUniqChar(String s) {
//        HashMap<Character,Boolean> map = new HashMap<>();
//        for (Character c: s.toCharArray()){
//            map.put(c,!map.containsKey(c));
//        }
//        for (Character c: s.toCharArray()){
//            if (map.get(c))
//                return c;
//        }
//        return ' ';
//    }
    public char firstUniqChar(String s){
        int[] counts = new int[26];
        for (Character c:s.toCharArray()){
            counts[c - 'a']++;
        }
        for (Character c: s.toCharArray()){
            if (counts[c - 'a'] == 1){
                return c;
            }
        }
        return ' ';
    }
}
