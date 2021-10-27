import java.util.HashMap;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class Offer_50 {
    public char firstUniqChar(String s){
        int[] nums = new int[26];
        for (Character c : s.toCharArray()){
            nums[c - 'a'] += 1;
        }
        for (Character c : s.toCharArray()){
            if (nums[c - 'a'] == 1){
                return c;
            }
        }
        return ' ';
    }
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



    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()){
            if (!map.containsKey(c)){
                map.put(c, 1);
            }else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (Character e : s.toCharArray()){
            if (map.get(e) == 1){
                return e;
            }
        }
        return ' ';
    }

}
