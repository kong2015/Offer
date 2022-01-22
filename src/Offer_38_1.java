/**
 * @author dingxudong
 * @create 2021-08-01 10:24
 * @Description
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Offer_38_1 {
    /**
     该题类似于 全排列2，本题使用set来去除重复元素
     除了使用set去重外，还可以对数组进行排序，使用visited数组进行剪枝！
     */
    HashSet<String>set = new HashSet<>();
    StringBuffer sb = new StringBuffer();
//    public String[] permutation(String s) {
//        boolean[] visited = new boolean[s.length()];
//        dfs(s,visited);
//        return set.toArray(new String[0]);
//    }
//    private void dfs(String s, boolean[] visited){
//        if (s.length() == sb.length()){
//            set.add(sb.toString());
//            return;
//        }
//        for (int i = 0; i < s.length(); i++){
//            if (visited[i])
//                continue;
//            visited[i] = true;
//            sb.append(s.charAt(i));
//            dfs(s, visited);
//            sb.deleteCharAt(sb.length() - 1);
//            visited[i] = false;
//        }
//    }


    Set<String> res = new HashSet();
    public String[] permutation(String s) {

        backtrack(s.toCharArray(),new StringBuilder(), new boolean[s.length()]);
        return res.toArray(new String[res.size()]);

    }

    // 回溯函数
    public void backtrack(char[] ch,StringBuilder sb, boolean[] visitid){
        // 终止条件
        if(sb.length() == ch.length){
            res.add(sb.toString());
            return;
        }
        // 选择列表
        for(int i = 0; i < ch.length; i++){
            // 剪枝，如果当前位置的元素已经使用过，则跳过进入下一个位置
            if(visitid[i]) continue;
            // 做出选择
            sb.append(ch[i]);
            // 更新标记
            visitid[i] = true;
            // 进入下层回溯
            backtrack(ch,sb,visitid);
            // 撤销选择
            sb.deleteCharAt(sb.length()-1);
            visitid[i] = false;
        }
    }
}
