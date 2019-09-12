package important;

public class QuickSort {
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
        quickSortProcess(arr, 0, arr.length - 1);
    }

    private static void quickSortProcess(int[] arr, int L, int R) {
        if (L >= R) return;
        int p = partition(arr, L, R);
        quickSortProcess(arr, L, p - 1);
        quickSortProcess(arr, p + 1, R);
    }

    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int p = l;
        for (int i = l + 1; i <= r; i++)
            if (arr[i] < v) swap(arr, i, ++p);

        swap(arr, l, p);
        return p;

    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
