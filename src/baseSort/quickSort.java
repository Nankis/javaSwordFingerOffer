package baseSort;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 1, 4, 5, 7, 9, 8};

        QS.quickSort(arr);
        for (int v : arr)
            System.out.print(v + " ");
    }
}


class QS {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 1) return;
        quickProcess(arr, 0, arr.length - 1);
    }

    private static void quickProcess(int[] arr, int L, int R) {
        if (L >= R) return;
//        swap(arr, L, L + (int) (Math.random() * (R - L + 1))); //随机选取一个pivot  优化方案
        int p = partition(arr, L, R);
        quickProcess(arr, L, p - 1);
        quickProcess(arr, p + 1, R);
    }

    /**
     * 对arr[l...r]部分进行partition操作
     * 返回p, 使得arr[L...p-1] < arr[p] ; arr[p+1...R] > arr[p]
     */
    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int p = l;
        for (int i = l + 1; i <= r; i++) {//因为一开始传入的就是length-1 所以是可以i<=r的
            if (arr[i] < v) swap(arr, i, ++p);
        }
        swap(arr, l, p);
        return p;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class TS {
    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 1) return;

        quickSortProcess(arr, 0, arr.length - 1);
    }

    private void quickSortProcess(int[] arr, int L, int R) {
        if (L >= R) return;
        int p = partition(arr, L, R);
        quickSortProcess(arr, L, p - 1);
        quickSortProcess(arr, p + 1, R);

    }

    private int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int p = l;
        for (int i = 0; i <= r; i++) {
            if (arr[i] < v) swap(arr, ++p, i);
        }
        swap(arr, l, p);
        return p;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}