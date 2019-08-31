package baseSort;

public class select {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 1, 4, 5, 7, 9, 8};
        selectSort.selSort(arr);
        for (int v : arr)
            System.out.print(v + " ");
    }
}

class selectSort {
    public static void selSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            swap(arr, i, min);

        }
    }

    private static void swap(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}
