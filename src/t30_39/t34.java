package t30_39;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * 参考:
 * https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/%E5%89%91%E6%8C%87Offer/%E5%89%91%E6%8C%87Offer%20-%2024%20-%20%E4%BA%8C%E5%8F%89%E6%A0%91%E4%B8%AD%E5%92%8C%E4%B8%BA%E6%9F%90%E4%B8%80%E5%80%BC%E7%9A%84%E8%B7%AF%E5%BE%84.md
 */
public class t34 {
}

class Solution34 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backTracking(root, target, new ArrayList<>());
        //考虑数组长度的放前面
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return res;
    }

    private void backTracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) return;
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null)
            res.add(new ArrayList<>(path));//注意:res.add(path)表示当前共享的路径加入res,是不对的,要单独new一个已经匹配成功的path
        else {
            backTracking(node.left, target, path);
            backTracking(node.right, target, path);
        }
        // 等价于 target+=node.val
        path.remove(path.size() - 1);
    }
}

class S34 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        traceBack(root, target, new ArrayList<>());
        Collections.sort(res, (List l1, List l2) -> l2.size() - l1.size());
        return res;
    }

    private void traceBack(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            traceBack(root.left, target, path);
            traceBack(root.right, target, path);
        }

        path.remove(path.size() - 1);
    }
}