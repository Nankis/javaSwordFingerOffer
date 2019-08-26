package test2;

import java.util.Base64;
import java.util.Scanner;

/**
 * import java.util.Base64;
 * 对于标准的Base64：
 * 加密为字符串使用Base64.getEncoder().encodeToString();
 * 加密为字节数组使用Base64.getEncoder().encode();
 * 解密使用Base64.getDecoder().decode();
 * 对于URL安全或MIME的Base64，只需将上述getEncoder()getDecoder()更换为getUrlEncoder()getUrlDecoder()
 * 或getMimeEncoder()和getMimeDecoder()即可。
 */
public class hd1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            byte[] by = str.getBytes();

            System.out.println(Base64.getEncoder().encodeToString(by));
        }

    }

}


