package com.xzsd.app.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>密码工具类</p>
 * <p>创建日期：2018-01-11</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class PasswordUtils {

    /**
     * 生成加密后的密码
     *
     * @param rawPassword 原密码
     * @return 加密后的密码
     */
    public static String generatePassword(String rawPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(rawPassword);
    }
    /**
     * 校验两个密码是否相同
     * @param rawPassword
     * @param nowPassword
     * @return
     */
    public static boolean Password(String rawPassword , String nowPassword){
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        return encode.matches(rawPassword,nowPassword);
    }
}
