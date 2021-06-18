import java.util.Arrays;
import java.util.Random;

public class Offer_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0)
            return new int[0];
        Random rnd = new Random();
        selectK(arr, 0, arr.length - 1, k-1, rnd);//注意这里是k-1
        return Arrays.copyOf(arr, k);//0到k-1
    }
    private int selectK(int[] arr, int l, int r, int k, Random rnd){
        int p = partition(arr, l, r, rnd);
        if (p == k){
            return k;
        }else if (p < k){
            return selectK(arr,p+1,r,k,rnd);
        }else {
           return selectK(arr,l,p-1,k,rnd);
        }
    }
    private int partition(int[] arr, int l, int r,Random rnd){
        int index = l + rnd.nextInt(r-l+1);
        swap(arr,index,l);
        int i = l + 1, j = r;
        while (true){
            while (i <= j && arr[i] < arr[l]){//不能等于，为了使得相等的元素置于中间
                i++;
            }
            while (i<=j && arr[j] > arr[l]){
                j--;
            }
            if (i >= j)
                break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }
    private void swap (int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
