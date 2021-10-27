import java.nio.charset.CharsetEncoder;
import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Offer_48 {
    /**
     * 滑动窗口的变形，可以把各个值和下标记录到字典里，如果右指针的值在字典里出现过了，那么left需要为 最后一次右指针出现的下标+1
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //双指针
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int max= 0;
        StringBuffer res = new StringBuffer();
        for (char c : s.toCharArray()){
            if (res.indexOf(String.valueOf(c)) != -1) {
                res = new StringBuffer(res.substring(res.indexOf(String.valueOf(c)) + 1, res.length()));
            }
            res.append(c);
            max = Math.max(max, res.length());
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(map.get(s.charAt(i)) + 1, j);//这里j已经指到j，说明j之前的已经遍历结束。取最大值是为了防止j回到已经遍历的点。
                // "abba" 不然可能会回到未及时更新的第一个a
            }
            map.put(s.charAt(i), i);
            max = Math.max(i - j + 1, max);
        }
        return max;
    }
}