import java.util.Arrays;
import java.util.Random;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 */
public class Offer_45 {
}
//class Solution {
//    public String minNumber(int[] nums) {
//        String[] datas = new String[nums.length];
//        for (int i = 0; i < nums.length; i++){
//            datas[i] = String.valueOf(nums[i]);
//        }
//        Arrays.sort(datas, (x, y) -> (x + y).compareTo(y + x));
//        StringBuffer res = new StringBuffer();
//        for (String data:datas){
//            res.append(data);
//        }
//        return res.toString();
//    }
//}
class Solution {
    public String minNumber(int[] nums) {
        String[] datas = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            datas[i] = String.valueOf(nums[i]);
        }
        StringBuffer res = new StringBuffer();
        quickSort(datas, 0, datas.length - 1);
        for (String data : datas){
            res.append(data);
        }
        return res.toString();
    }
    private void quickSort(String[] arr, int l, int r){
        if (l >= r)//等于的时候也返回,因为i和j如果指向同一个元素，代表其相等。
            return;
        int p = partition(arr, l , r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }
    private int partition(String[] arr, int l, int r){//这里操作的是String数组。
        Random rnd = new Random();
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, p, l);
        int i = l + 1, j = r;
        while (true){
            while (i <= j && (arr[i] + arr[l]).compareTo(arr[l] + arr[i]) <= 0)//这里比较可以取到等号，因为快速排序法希望将相等的元素也进行交换，使得其出现在数组中间位置。
                i++;
            while (i <= j && (arr[j] + arr[l]).compareTo(arr[l] + arr[j]) >= 0)
                j--;
            if (i > j)
                break;//因为当j<i时，循环应该退出，而不应该继续执行下面的交换。
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }
    private void swap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
