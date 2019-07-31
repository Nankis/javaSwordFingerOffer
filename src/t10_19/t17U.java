package t10_19;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 */
public class t17U {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        solution17.print1ToMaxOfNDigits(1);
    }
}

class Solution17 {
    //由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
    //使用回溯法得到所有的数。
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);  //如果
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');  //将0~9的int数字强转存入char中备用 注意  5+'0' == char类型的5  而不是 '50' 如果是String则是"50"
            print1ToMaxOfNDigits(number, digit + 1);  //开始生成下一个数字 number[1]  ...一直到number[n]  即数字n
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}