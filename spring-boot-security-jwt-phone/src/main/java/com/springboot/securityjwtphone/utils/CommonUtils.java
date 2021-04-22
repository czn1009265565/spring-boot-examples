package com.springboot.securityjwtphone.utils;

import java.util.Random;

/**
 * @author: zenan
 * @date: 2021/4/22
 */
public class CommonUtils {

    /**
     * 生成随机 4位 验证码
     * @return code
     */
    public static String createRandomVerificationCode() {
        StringBuilder sb = new StringBuilder();
        int[] all = new int[] {0,1,2,3,4,5,6,7,8,9};
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            sb.append(all[random.nextInt(all.length)]);
        }
        return sb.toString();
    }
}
