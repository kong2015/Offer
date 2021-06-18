import java.util.HashMap;
import java.util.Map;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
//确定有限状态自动机：如果从当前状态到下一个读入的字符之间没有定义好的转移规则，则拒绝。
// 拒绝的时候可以转移到一个特殊的状态，一旦进入这个状态立刻返回false。
//一个自动机，总能够回答某种形式的「对于给定的输入字符串 S，判断其是否满足条件 P」的问题。在本题中，条件 P 即为「构成合法的表示数值的字符串」
//最长的数值字符串可能的一种形式："  -3.14e+8  "
public class Offer_20 {
    public boolean isNumber(String s) {
        //数值字符串中可能包含的十个字符，map下标为0-9. 每一个下标表示当前字符可能对应的下一个字符是哪几种
        HashMap [] states = {new HashMap<>(){{put(' ', 0); put('s', 1); put('d', 2); put('.', 3);}},//0代表空格
                new HashMap<>(){{put('d', 2); put('.', 3);}},//1代表正负号
                new HashMap<>(){{put('d', 2); put('.', 4); put('e', 6); put(' ', 9);}},//2代表小数点前的数字
                new HashMap<>() {{put('d', 5);}},//3表示左边没有整数的小数点（.9）
                new HashMap<>() {{put('d', 5); put('e', 6); put(' ', 9);}},//4表示左边有整数的小数点（3.）
                new HashMap<>(){{put('d', 5); put('e', 6); put(' ', 9);}},//5代表小数点后的数字
                new HashMap<>(){{put('s', 7); put('d', 8);}},//6代表e
                new HashMap<>(){{put('d', 8);}},//7代表e后的正负号
                new HashMap<>(){{put('d', 8); put(' ', 9);}},//8代表e后的整数
                new HashMap<>(){{put(' ', 9);}}//9代表最后的空格
        };
        char temp;
        int p = 0;
        for (char c : s.toCharArray()){
            if (c == ' ') temp = ' ';
            else if (c == '+' || c == '-') temp = 's';
            else if (c == '.') temp = '.';
            else if (c <= '9' && c >= '0') temp = 'd';
            else if (c == 'e' || c == 'E') temp = 'e';
            else temp = '?';

            if (!states[p].containsKey(temp)) return false;
            p = (int) states[p].get(temp);
        }
        return p == 2 || p == 4 || p == 5 || p == 8 || p == 9;
    }
}

