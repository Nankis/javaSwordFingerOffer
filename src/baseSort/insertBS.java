package baseSort;

public class insertBS {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 1, 4, 5, 7, 9, 8};

        insertSortBS.insertSBS(arr);
        for (int v : arr)
            System.out.print(v + " ");
    }
}

//普通插入排序
class insertSort {
    public void insertS(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j; //    3 2 1  |  2 3 1
            for (j = i - 1; j >= 0 && key < arr[j]; j--)
                arr[j + 1] = arr[j];//中间的元素往后面移动
            arr[j + 1] = key; //将key插入到合适的位置
        }
    }
}

class insertSortSwap {
    public void insertSSwap(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--)
                swap(arr, j, j - 1);
        }
    }

    private void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class insertSortBS {
    public static void insertSBS(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int L = 0, R = i - 1;
            while (L <= R) {
                int mid = L + (R - L) / 2;
                if (arr[mid] > key) R = mid - 1;
                else L = mid + 1;
            }
            //二分结束之后,L的位置-->L = 刚好大于key(不是等于)的那个位置
            //L之后的元素向后移,一直到覆盖上一次key的位置
            for (int j = i - 1; j >= L; j--) arr[j + 1] = arr[j];
            arr[L] = key;
        }
    }
}
