package baseSort;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 1, 4, 5, 7, 9, 8};
        Sort.MergeSort(arr);
        for (int v : arr)
            System.out.print(v + " ");
    }
}


class Sort {
    public static void MergeSort(int[] arr) {
        if (arr == null || arr.length < 1) return;
        mergeSortProcess(arr, 0, arr.length - 1);
    }

    private static void mergeSortProcess(int[] arr, int L, int R) {
        if (L >= R) return; //递归终止条件
        int mid = L + (R - L) / 2;
        mergeSortProcess(arr, 0, mid);//T(n/2),注意不是mid-1
        mergeSortProcess(arr, mid + 1, R);//T(n/2)
        if (arr[mid] > arr[mid + 1]) /*这个是一个优化，因为arr[L,mid]和arr[mid+1,R]已经有序，所以如果满足这个条件，就不要排序了,防止一开始数组有序*/
            merge(arr, L, mid, R);//归并过程需要3个指针 所以需要传入mid
        //整个的表达式  T(n) = 2*T(n/2) + O(n) 使用master公式求出  N*logN
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1]; //都想象成某一种具体情况(如初始R-L+1是R-0+1)
        int k = 0;
        int p1 = l, p2 = mid + 1;

        while (p1 <= mid && p2 <= r)
            help[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];//只有被赋值的一方才有资格后移,所以是?后面的p才会++,左右两边相等的话，就先拷贝左边的(实现稳定性)
        while (p1 <= mid) //左边剩余的
            help[k++] = arr[p1++];
        while (p2 <= r) //如果有,则是右边剩余的
            help[k++] = arr[p2++];
        for (int i = 0; i < help.length; i++)
            arr[i + l] = help[i]; //拷贝回原来的数组,之所+l是考回原来数组的位置
    }

}

class S {
    public void mergeS(int[] arr) {
        if (arr == null || arr.length < 1) return;
        mergeSProcess(arr, 0, arr.length - 1);
    }

    private void mergeSProcess(int[] arr, int L, int R) {
        if (L >= R) return;
        int mid = L + (R - L) / 2;
        mergeSProcess(arr, L, mid);//快排需要得到p
        mergeSProcess(arr, mid + 1, R);
        if (arr[mid] > arr[mid + 1])
            merge(arr, L, mid, R);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int k = 0;
        int p1 = l, p2 = mid + 1;
        while (p1 <= mid && p2 <= r)
            help[k] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        while (p1 <= mid)
            help[k++] = arr[p1++];
        while (p2 <= r)
            help[k ++] = arr[p2++];
        for (int i = 0; i < help.length; i++)
            arr[i + l] = help[i];
    }

}