import java.util.Stack;
import java.util.stream.StreamSupport;

public class Offer_30 {
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
class MinStack {
    private Stack<Integer>stack1,stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= stack1.peek())
            stack2.push(x);
    }
//如果最小值出栈A则也应该出栈B。此时如果上push函数中不使用等号则会出现错误。比如5、7、5、1入栈A应该是1、5、7、5.入栈B应该是1、5、5。而不应是1、5。
    public void pop() {
        if (stack1.pop().equals(stack2.peek()))
            stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}