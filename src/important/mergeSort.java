package important;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 1, 4, 5, 7, 9, 8};
        MQS.mergeSort(arr);
        for (int v : arr)
            System.out.print(v + " ");
    }
}

class MQS {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 1) return;
        mergeSortProcess(arr, 0, arr.length - 1);
    }

    private static void mergeSortProcess(int[] arr, int L, int R) {
        if (L >= R) return;
        int mid = L + (R - L) / 2;
        mergeSortProcess(arr, L, mid);
        mergeSortProcess(arr, mid+1, R);
        if (arr[mid] > arr[mid + 1])
            merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int k = 0;
        int p1 = l, p2 = mid + 1;

        while (p1 <= mid && p2 <= r)
            help[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        while (p1 <= mid)
            help[k++] = arr[p1++];
        while (p2 <= r)
            help[k++] = arr[p2++];

        for (int i = 0; i < help.length; i++)
            arr[i + l] = help[i];

    }

}


