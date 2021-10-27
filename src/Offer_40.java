import java.util.*;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Offer_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());//默认是最小堆
//        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; i++){
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++){
            if (!queue.isEmpty() && queue.peek() > arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0)
            return new int[0];
        selectk(arr, 0, arr.length - 1, k - 1);
        return Arrays.copyOfRange(arr, 0, k);
//        return Arrays.copyOf(arr, k);
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = arr[i];
//        }
//        return res;
    }
    public int selectk(int[] arr, int left, int right, int k){
        int p = partition(arr, left, right);
        if (p < k){
            return selectk(arr, p + 1, right, k);
        }else if (p > k){
            return selectk(arr, left, p - 1, k);
        }else {
            return p;
        }
    }

    public int partition(int[] arr, int left, int right){
        int r = right;
        int l = left + 1;
        while (true){
            while (l <= r && arr[l] < arr[left]){
                l++;
            }
            while (l <= r && arr[r] > arr[left]){
                r--;
            }
            if (l > r){
                break;
            }
            swap(arr, l, r);
            l++;
            r--;
        }
        swap(arr, left, r);
        return r;
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }




//
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (k == 0)
//            return new int[0];
//        Random rnd = new Random();
//        selectK(arr, 0, arr.length - 1, k-1, rnd);//注意这里是k-1
//        return Arrays.copyOf(arr, k);//0到k-1
//    }
//    private int selectK(int[] arr, int l, int r, int k, Random rnd){
//        int p = partition(arr, l, r, rnd);
//        if (p == k){
//            return k;
//        }else if (p < k){
//            return selectK(arr,p+1,r,k,rnd);
//        }else {
//           return selectK(arr,l,p-1,k,rnd);
//        }
//    }
//    private int partition(int[] arr, int l, int r, Random rnd){
//        int index = l + rnd.nextInt(r-l+1);
//        swap(arr,index,l);
//        int i = l + 1, j = r;
//        while (true){
//            while (i <= j && arr[i] < arr[l]){//不能等于，为了使得相等的元素置于中间
//                i++;
//            }
//            while (i<=j && arr[j] > arr[l]){
//                j--;
//            }
//            if (i >= j)
//                break;
//            swap(arr,i,j);
//            i++;
//            j--;
//        }
//        swap(arr,l,j);
//        return j;
//    }
//    private void swap (int[]arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
}