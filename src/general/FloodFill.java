package general;

/**
 * https://mp.weixin.qq.com/s/xYF8BUV144RqW_HWqMeFRA
 */
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1},
        };

        int sr = 1, sc = 1;
        int newColor = 2;
        floodFills f = new floodFills();
        image = f.floodFill(image, sr, sc, newColor);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class floodFills {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int origColor = image[sr][sc];
        fill(image, sr, sc, origColor, newColor);
        return image;
    }

    //x行 y列
    private void fill(int[][] image, int x, int y, int origColor, int newColor) {
        //出界:超出数组范围
        if (!inArea(image, x, y)) return;
        //碰壁:遇到其他颜色区域,超出origColor区域
        if (image[x][y] != origColor) return;
        //已探索过的origColor区域
        if (image[x][y] == -1) return;

        //开始回溯标记choose,以免重复
        image[x][y] = -1; //因为颜色值是0~65535所以,-1在这里可以用作标记
        fill(image, x - 1, y, origColor, newColor);//上移
        fill(image, x + 1, y, origColor, newColor);//下移
        fill(image, x, y - 1, origColor, newColor);//左移
        fill(image, x, y + 1, origColor, newColor);//右移
        //unChoose:将标记替为newColor
        image[x][y] = newColor;
    }

    private boolean inArea(int[][] image, int x, int y) {
        return x >= 0 && x < image.length &&
                y >= 0 && y < image[0].length;
    }
}
