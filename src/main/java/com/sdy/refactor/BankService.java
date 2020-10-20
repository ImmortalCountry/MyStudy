package com.sdy.refactor;

import org.springframework.util.DigestUtils;

import java.util.Arrays;

/**
 * @author: sundy
 * @date: 2020/10/16 16:32
 * @description:
 */
public class BankService {
    /**
     * 创建用户
     *
     * @return
     */
    public static String createUser(String name, String identity, String mobile, int age) {
        StringBuilder sb = new StringBuilder();
        // 字符串靠左，多余的地方填充_
        sb.append(String.format("%-10s", name).replace(' ', '_'));
        // 字符串靠左，多余的地方填充_
        sb.append(String.format("%-18s", identity).replace(' ', '_'));
        // 数字靠右，多余的地方用 0 填充
        sb.append(String.format("%05d", age));
        // 字符串靠左，多余的地方用_填充
        sb.append(String.format("%-11s", mobile).replace(' ', '_'));
        return "ok";
    }
}
