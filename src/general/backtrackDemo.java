package general;

import java.util.ArrayList;
import java.util.List;

/**
 * https://mp.weixin.qq.com/s/awdWQ75dD8N4dxrn9tAZyg
 * 输入1 2 3
 * 输出全排列
 * //PS: 剑指offer t34 回溯
 */
public class backtrackDemo {
    public static void main(String[] args) {
        backtracks backtracks = new backtracks();
        int[] a = {1, 2, 3};
        String[] strings = {"a", "b", "c"};
//        System.out.println(backtracks.permute(a));
        System.out.println(bt.permute(strings));
    }
}


class backtracks {
    List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track, res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track, List<List<Integer>> res) {
        if (track.size() == nums.length)//选择列表中的待选项已被选完
            res.add(new ArrayList<>(track)); //存储已完成的排列
        else {
            for (int i = 0; i < nums.length; i++) {
                //决策路径中存在的元素不能再选择了
                if (track.contains(nums[i])) continue;
                /*choose过程*/
                track.add(nums[i]);//加到最后
                /*进入下一步决策*/
                backtrack(nums, track, res); //向下继续从剩余的列表中选择
                /*unChoose过程*/
                track.remove(track.size() - 1); //是track移除 而不是res 返回 回溯
            }
        }
    }
}

class bt {
    static List<List<String>> res = new ArrayList<>();

    static List<List<String>> permute(String[] strArray) {
        backT(strArray, new ArrayList<String>());
        return res;
    }

    static private void backT(String[] strArray, ArrayList<String> path) {
        if (strArray.length == path.size()) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < strArray.length; i++) {
                if (path.contains(strArray[i])) continue;
                path.add(strArray[i]);
                backT(strArray, path);
                path.remove(path.size() - 1);
            }
        }
    }
}




