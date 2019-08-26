package t60_68;


/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
 * <p>
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class t61 {
    public static void main(String[] args) {
        Solution61 s = new Solution61();
        int[] a = {0, 0, 0, 0, 0};
        System.out.println(s.isContinuous(a));
    }
}

/**
 * max 记录最大值 初始值-1
 * min 记录最小值 初始值14
 * min,max 都不记录0
 * 满足条件:
 * *     1.max-min<5
 * *     2.除0外,没有其他重复的数(牌)
 * *     3.数组长度为 5
 */
class Solution61 {
    public boolean isContinuous(int[] numbers) {
        int len = numbers.length;
        if (len != 5) return false;
        int[] recordNum = new int[14];//0~13
        int max = -1;
        int min = 14;

        for (int i = 0; i < len; i++) {
            recordNum[numbers[i]]++; //记录重复出现的数字
            if (numbers[i] == 0) continue;  //关键语句,不记录0,也包括不判断0的次数,因为有数组长度限制了
            if (recordNum[numbers[i]] > 1) return false;
            if (numbers[i] > max) max = numbers[i];
            if (numbers[i] < min) min = numbers[i];
        }

        if (max - min < 5) return true;

        return false;
    }
}

//class Solution61_ {
//    public class Solution {
//        /*
//        max 记录 最大值
//        min 记录  最小值
//        min ,max 都不记0
//        满足条件 :
//            1. max - min <5
//            2. 除0外没有重复的数字(牌)
//            3. 数组长度为 5
//        */
//        public boolean isContinuous(int[] numbers) {
//            int len = numbers.length;
//            if (len != 5) return false;  //数组长度为 5
//            //记录出现的数字
//            int[] recordNumber = new int[14];
//
//            //recordNumber[0]是拿来防止大小王数量影响判断是否有其余对子的
//            recordNumber[0] = -5;
//            int min = 14;
//            int max = -1;
//            for (int i = 0; i < len; i++) {
//                recordNumber[numbers[i]]++; //记录重复出现的数字
//                if (numbers[i] == 0) continue; //min,max 都不记0
//
//                if (recordNumber[numbers[i]] > 1)  //除0外没有重复的数字(牌)
//                    return false;
//
//                if (numbers[i] > max) max = numbers[i];
//
//                if (numbers[i] < min) min = numbers[i];
//
//            }
//            if (max - min < 5) return true;
//            return false;
//        }
//    }
//}