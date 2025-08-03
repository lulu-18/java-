// CodeUtil.java
package puzzlepractice.ui;

import java.util.Random;

public class CodeUtil {
    public static String getCode() {
        Random rand = new Random();
        return String.format("%04d", rand.nextInt(10000));  // 生成4位数字验证码
    }
}
