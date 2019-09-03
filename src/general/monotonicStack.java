package general;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://endlesslethe.com/monotone-queue-and-stack-tutorial.html?tdsourcetag=s_pcqq_aiomsg  单调队列总结
 * https://blog.csdn.net/liujian20150808/article/details/50752861?tdsourcetag=s_pcqq_aiomsg  单调栈总结
 * 补充单调队列:
 * https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/LintCode/TwoPointer/LintCode%20-%20362.%20Sliding%20Window%20Maximum%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E7%9A%84%E6%9C%80%E5%A4%A7%E5%80%BC.md
 * <p>
 * https://mp.weixin.qq.com/s/X0kf4rB88oS-VOcI7OR6OA
 * 单调栈的使用
 * 题1:
 * 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。
 * 解释：第一个 2 后面比 2 大的数是 4; 1 后面比 1 大的数是 2；
 * 第二个 2 后面比 2 大的数是 4; 4 后面没有比 4 大的数，填 -1；3 后面没有比 3 大的数，填 -1。
 * <p>
 * 题2:
 * 给你一个数组 T = [73, 74, 75, 71, 69, 72, 76, 73]，这个数组存放的是近几天的天气气温（这气温是铁板烧？不是的，这里用的华氏度）。
 * 你返回一个数组，计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0 。
 * 举例：给你 T = [73, 74, 75, 71, 69, 72, 76, 73]，你返回 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 解释：第一天 73 华氏度，第二天 74 华氏度，比 73 大，所以对于第一天，只要等一天就能等到一个更暖和的气温。后面的同理。
 * <p>
 * 题3:
 * 如何处理「循环数组」
 * 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,4]。拥有了环形属性，最后一个元素 3 绕了一圈后找到了比自己大的元素 4 。
 */
public class monotonicStack {
    public static void main(String[] args) {
        monoStack1 m = new monoStack1();
        monoStack2 m2 = new monoStack2();
        monoStack3 m3 = new monoStack3();
        int[] arr = {2, 1, 2, 4, 3};
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] r = m.nextGreaterElement(arr);
        int[] r3 = m3.nextGreaterElement(arr);
        for (int v : r) {
//            System.out.print(v + " ");
        }

        int[] r2 = m2.dailyTemperatures(T);
//        for (int v : r2)
//            System.out.print(v + " ");
        for (int v : r3)
            System.out.print(v + " ");

    }
}


class monoStack1 {
    int[] nextGreaterElement(int[] nums) {
//        ArrayList<Integer> res = new ArrayList<>(nums.length);//存放答案的数组
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        //倒着往栈里存放 for循环要从后往前扫描元素，因为我们借助的是栈的结构，倒着入栈，其实是正着出栈
        //{2, 1, 2, 4, 3}
        //while 循环是把两个“高个”元素之间的元素排除，因为他们的存在没有意义，前面挡着个“更高”的元素，
        // 所以他们不可能被作为后续进来的元素的 Next Great Number 了。
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]) {  //判定个子高矮  用while  而不是if if只判断一次
                s.pop(); //矮的离开,反正也被挡着了
            }
            res[i] = s.empty() ? -1 : s.peek();//i这个元素身后第一个高的元素
            s.push(nums[i]);//进栈,接受之后的身高判定
        }
        return res;
    }

}


class monoStack2 {
    int[] dailyTemperatures(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>(); // 这里放元素索引，而不是元素
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) //这里存的是索引,所以用取索引来判断
                s.pop();

            res[i] = s.isEmpty() ? 0 : (s.peek() - i); //得到索引间距
            s.push(i); //加入索引
        }
        return res;
    }

}

class monoStack3 {
    int[] nextGreaterElement(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> s = new Stack<>();
        // 假装这个数组长度翻倍了
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i % len])
                s.pop();
            res[i % len] = s.empty() ? -1 : s.peek();
            s.push(nums[i % len]);
        }
        return res;
    }
}