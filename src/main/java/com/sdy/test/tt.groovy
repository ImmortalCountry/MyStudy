package com.sdy.test

import org.apache.commons.codec.digest.Md5Crypt

/**
 * @author: sundy* @date: 2020/9/16 18:34
 * @description:
 */
class tt {
    static void main(String[] args) {
        long aLong = System.currentTimeMillis();

        for (i in 0..<100) {
            System.out.print(System.currentTimeMillis() + "")

        }
//        (aLong + "");

//        ByteArrayOutputStream bao = new ByteArrayOutputStream();
//        DataOutputStream dos = new DataOutputStream(bao);
//        dos.writeLong(aLong);
//        byte[] buf = bao.toByteArray();
//
//        System.out.printf(Md5Crypt.md5Crypt(buf));
    }
}
