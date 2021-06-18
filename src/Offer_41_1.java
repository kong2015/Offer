import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Offer_41_1 {
}

class MedianFinder {
    private PriorityQueue<Integer>maxHeap;
    private PriorityQueue<Integer>minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());//最大堆每次存放当前数据流中较小的一般元素
        minHeap = new PriorityQueue<>();//最小堆每次存放当前数据流中较大的一半元素
    }

    public void addNum(int num) {
        if (maxHeap.size() != minHeap.size()){
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }else {
            return (double) minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
