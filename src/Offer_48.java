import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Offer_48 {
    public int lengthOfLongestSubstring(String s) {
        int i;
        int j = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(map.get(s.charAt(i)) + 1, j);//这里j已经指到j，说明j之前的已经遍历结束。取最大值是为了防止j回到已经遍历的点。
            }
            map.put(s.charAt(i), i);
            max = Math.max(i - j + 1, max);
        }
        return max;
    }
}
