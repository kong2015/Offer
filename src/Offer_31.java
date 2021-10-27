import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class Offer_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int push : pushed) {
            stack.push(push);
            while (!stack.isEmpty() && stack.peek().equals(popped[i])){
                i++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack<Integer> stack = new Stack<>();
//        int popedIndex = 0;
//        for (int push : pushed){
//            stack.push(push);
//            while (!stack.isEmpty() && stack.peek().equals(popped[popedIndex])){
//                stack.pop();
//                popedIndex++;
//            }
//        }
////        while(!stack.isEmpty()){
//////            if (!stack.pop().equals(popped[popedIndex++]))
//////                return false;
//////        }
//////        return true;
////        上面的代码多此一举，因为如果一哥序列的入栈顺序是出栈顺序，那么执行完模拟栈的流程后，stack应该为空。
//        return stack.isEmpty();
//    }
//
//    public static void main(String[] args) {
//        int[] push = {2,1,0};
//        int[] pop = {1,2,0};
//        System.out.println(validateStackSequences(push,pop));
//    }




















    public static boolean validateStackSequences(int[] pushed, int[] popped) {

    }
}
