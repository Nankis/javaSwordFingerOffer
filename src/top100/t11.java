package top100;

public class t11 {
    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] array2 = {3, 2, 8, 9};
        System.out.println(maxArea2(array));
    }

    //双指针,不管左移还是右移,底始终减少一,而影响因素最大的是高
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) return -1;
        int p1 = 0, p2 = height.length - 1;
        int max = 0, bottom = 1; //n>=2 所以底最小为1
        int h = 1;
        // 0 1 2 3 4 5
        while (p1 < p2) {
            bottom = p2 - p1;
            h = Math.min(height[p1], height[p2]);
            max = Math.max(h * bottom, max);
            if (height[p1] < height[p2]) {
                ++p1;
            } else {
                --p2;
            }
        }
        return max;
    }

    //优化代码
    public static int maxArea2(int[] height) {
        int p1 = 0, p2 = height.length - 1, res = 0;
        while (p1 < p2) {
            res = height[p1] < height[p2] ?
                    Math.max(res, (p2 - p1) * height[p1++]) :
                    Math.max(res, (p2 - p1) * height[p2--]);
        }
        return res;
    }
}
