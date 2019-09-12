package myUtils;

public class strToNum {
    //根据空格转
    public static int[] strToNum(String str) {
        String[] nums = str.split(" ");
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i].trim());
        }
        return arr;
    }
}
