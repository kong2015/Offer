import java.util.Stack;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 *
 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 (若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class Offer_9 {

}
class CQueue {
//    [null,-1,null,null,2,5]
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        if (stack1.isEmpty()){
            return -1;
        }
        while (!stack1.isEmpty()){
            Integer pop = stack1.pop();
            stack2.push(pop);
        }
        return stack2.pop();
    }

//    private Stack<Integer>stack1;
//    private Stack<Integer>stack2;
//
//    public CQueue() {
//        stack1 = new Stack<>();
//        stack2 = new Stack<>();
//
//    }
//
//    public void appendTail(int value) {
//        stack1.push(value);
//    }
//
//    public int deleteHead() {
//        if (stack2.isEmpty()) {
//            while (!stack1.isEmpty())
//                stack2.push(stack1.pop());
//        }
//        if (stack2.isEmpty())
//            return -1;
//        else return stack2.pop();
//    }
}