package baseSort;

public class maopao {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 1, 4, 5, 7, 9, 8};

        MP2.maoPao(arr);
        for (int v : arr)
            System.out.print(v + " ");
    }
}

//未优化版
class MP1 {
    //升序  两层循环，外层冒泡轮数，里层依次比较
    public static void maoPao(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//优化
class MP2 {
    public static void maoPao(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    MP1.swap(arr, j, j + 1);
                    isSort = false;
                }
            }
            if (isSort) break;
        }
    }


}