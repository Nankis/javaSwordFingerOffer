package test;

import java.util.*;

public class u3dt2 {

    public static void main(String[] args) {
        int[] arr = {9, 5, 6, 1, 10, 0};
        System.out.println(test(arr));
    }

    /**
     * 从右向左遍历数组，并维护一个排好序的数组。新数到来之后插入这个数组。插入以后可以直接得到有多少个比他大。
     * 这样以一来，总的复杂度是nlgn
     * 就是说从右向左扫描这个数组A[0,...,n-1]，假定后x个数，也即A[n-x,n-x+1,...,n-1]已经排好序
     * 那么想问对A[n-x-1]来说，后面的数有多少个比他大
     */

    public static ArrayList<Integer> test(int[] nums) { //9 5 6 1
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> sortList = new ArrayList<>(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(0, addArray(sortList, nums[i]));
        }
        return res;
    }

    public static int addArray(List<Integer> sortArray, int num) { //向有序数组插入数,并返回比它小的数的个数
        sortArray.add(num);
        Collections.sort(sortArray);
        return sortArray.indexOf(num);
    }

}


//class TreeArray {
//    //树状数组的最大值
//    static final int MAXN = 100010;
//
//    static int[] tree = new int[MAXN];
//
//    //a[index] += k
//    static void add(int index, int k) {
//        while (index < MAXN) {
//            tree[index] += k;
//            index += index & -index;
//        }
//    }
//
//    //查询sum(a[0]..a[index])
//    static int query(int index) {
//        int sum = 0;
//        while (index > 0) {
//            sum += tree[index];
//            index -= index & -index;
//        }
//        return sum;
//    }
//
//    static int[] solution(int[] a) {
//        //去重
//        Set<Integer> set = new TreeSet<>();
//        for (int i = 0; i < a.length; i++) {
//            set.add(a[i]);
//        }
//        //离散化
//        Map<Integer, Integer> idxMap = new HashMap<>();
//        int size = 1;
//        for (Integer integer : set) {
//            idxMap.put(integer, size++);
//        }
//
//        //开始求
//        int[] ret = new int[a.length];
//        for (int i = a.length - 1; i >= 0; i--) {
//            int x = a[i];
//            //取出x的下标
//            int idx = idxMap.get(x);
//            //计算比x小的数的个数
//            ret[i] = query(idx - 1);
//            add(idx, 1);
//        }
//        return ret;
//    }
//
//    public static void main(String[] args) {
//        int[] ret = solution(new int[]{9, 5, 6, 1});
//        System.out.println(Arrays.toString(ret));
//    }
//
//}
//










